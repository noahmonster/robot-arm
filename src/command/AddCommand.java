package command;

import java.util.List;
import java.util.Stack;

/**
 * Add an X to a slot.  Assume that the slot exists.  Don't have time to validate that it does.
 * 
 * @author Noah Solomon
 *
 */
public class AddCommand extends UndoableCommand {

	public AddCommand(String cmd, List<Integer> args) {
		super(cmd, args);
	}

	@Override
	protected void doExecution(Stack<Command> stack, List<List<String>> state) {
		state.get(arguments.get(0) - 1).add("X");
	}

	@Override
	public void undoExecution(Stack<Command> stack, List<List<String>> state) {
		state.get(arguments.get(0) - 1).remove(0);
	}

}
