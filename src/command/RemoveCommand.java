package command;

import java.util.List;
import java.util.Stack;

/**
 * Remove an X from a slot.  Assume this is going to work.  Don't have time to validate arguments.
 * 
 * @author Noah Solomon
 *
 */
public class RemoveCommand extends UndoableCommand{

	public RemoveCommand(String cmd, List<Integer> args) {
		super(cmd, args);
	}

	@Override
	protected void doExecution(Stack<Command> stack, List<List<String>> state) {
		state.get(arguments.get(0) - 1).remove(0);
	}

	@Override
	public void undoExecution(Stack<Command> stack, List<List<String>> state) {
		state.get(arguments.get(0) - 1).add("X");
	}

}
