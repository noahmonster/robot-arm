package command;

import java.util.List;
import java.util.Stack;

/**
 * Another abstract class extending Command.  The reason this class was needed was because I assume that the UNDO and 
 * REPLAY commands cannot be undone and thus should not be added to the stack of Commands.
 * 
 * Note that this class adds itself to the stack after a successful execution.
 * 
 * @author Noah Solomon
 *
 */
public abstract class UndoableCommand extends Command {

	protected UndoableCommand(String cmd, List<Integer> args) {
		super(cmd, args);
	}

	@Override
	/**
	 * Override the Command.execute method to provide the added feature of adding self to the stack for undo purposes.
	 */
	public void execute(Stack<Command> stack, List<List<String>> state) {
		doExecution(stack, state);
		
		//add self to stack
		stack.push(this);
	}
	
	/**
	 * Add an additional method that provides the logic for actually undoing this command.
	 * @param stack
	 * @param state
	 */
	public abstract void undoExecution(Stack<Command> stack, List<List<String>> state);
}
