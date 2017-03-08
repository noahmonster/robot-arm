package command;

import java.util.List;
import java.util.Stack;

/**
 * Undo the last N commands.
 * Assume this cannot be undone.  Would be a fun exercise though.
 * 
 * @author Noah Solomon
 *
 */
public class UndoCommand extends Command {

	public UndoCommand(String cmd, List<Integer> args) {
		super(cmd, args);
	}

	/**
	 * Removes Commands from the stack and undoes them.
	 */
	@Override
	protected void doExecution(Stack<Command> stack, List<List<String>> state) {
		//iterate through last n commands, remove them from the stack and undo them
		for (int i = 0; i < arguments.get(0); i++) {
			UndoableCommand c = (UndoableCommand)stack.pop();
			c.undoExecution(stack, state);
		}
	}

}
