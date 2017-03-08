package command;

import java.util.List;
import java.util.Stack;

/**
 * Move an X from one slot to another.  Assumptions below.
 * 
 * @author Noah Solomon
 *
 */
public class MoveCommand extends UndoableCommand {

	public MoveCommand(String cmd, List<Integer> args) {
		super(cmd, args);
	}

	/**
	 * Assume both commands are going to work.  An invalid command will leave us in a partial state - don't have time for this
	 */
	@Override
	protected void doExecution(Stack<Command> stack, List<List<String>> state) {
		state.get(arguments.get(0) - 1).remove(0);
		state.get(arguments.get(1) - 1).add("X");
	}

	/**
	 * Assume both commands are going to work.  An invalid command will leave us in a partial state - don't have time for this
	 */
	@Override
	public void undoExecution(Stack<Command> stack, List<List<String>> state) {
		state.get(arguments.get(0) - 1).add("X");
		state.get(arguments.get(1) - 1).remove(0);
	}

}
