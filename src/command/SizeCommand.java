package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Change the number of slots to the arguments that were passed to this command.  This command will store the necessary
 * information in it to get back to the previous state if an undo happens.
 * 
 * @author Noah Solomon
 *
 */
public class SizeCommand extends UndoableCommand{
	//state necessary to get back on undo
	private int oldSize;
	private List<List<String>> removedSublist;

	public SizeCommand(String cmd, List<Integer> args) {
		super(cmd, args);
	}

	/**
	 * Change the size of the state List.  Can't just create a new List, have to modify state in place because it's a 
	 * reference to the state.  
	 */
	@Override
	protected void doExecution(Stack<Command> stack, List<List<String>> state) {
		oldSize = state.size();
		
		//iterate through the state object.  Add entries if they don't exist.
		for (int i = state.size(); i < arguments.get(0); i++) {
			state.add(new ArrayList<String>());
		}
		
		//clear this to make sure undo/redo/undo/redo logic works
		removedSublist = null;
		
		//Remove entries if the new size is smaller than the old...
		if (arguments.get(0) < state.size()) {
			List<List<String>> subList = state.subList(arguments.get(0), state.size());
			removedSublist = new ArrayList<List<String>>(subList);
			subList.clear();
		}
		
	}

	/**
	 * Use the stored state to resize to the old size.
	 */
	@Override
	public void undoExecution(Stack<Command> stack, List<List<String>> state) {
		//resize to old size
		if (oldSize > state.size()) {
			state.addAll(removedSublist);
		}
		else if (oldSize < state.size()) {
			//Remove entries if the new size is smaller than the old...
			state.subList(oldSize, state.size()).clear();
		}
	}
	
	
	

}
