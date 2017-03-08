package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Assume this is not Undoable.  Executing this command will execute the last N commands that are on the stack.  Bad
 * things will happen if we pass bad arguments to this command.
 * 
 * @author Noah Solomon
 *
 */
public class ReplayCommand extends Command {

	public ReplayCommand(String cmd, List<Integer> args) {
		super(cmd, args);
	}

	@Override
	protected void doExecution(Stack<Command> stack, List<List<String>> state) {
		List<Command> replay = new ArrayList<>();
		
		//iterate through last n commands so we can copy them
		for (int i = arguments.get(0); i > 0; i--) {
			Command c = stack.elementAt(stack.size() - i);
			Command newCommand = CommandValidator.createCommand(c.getCommand(), c.getArguments());
			replay.add(newCommand);
		}
		
		//execute the commands, they add themselves to the stack
		for (Command c : replay) {
			c.execute(stack, state);
		}
		
	}

}
