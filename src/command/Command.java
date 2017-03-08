package command;

import java.util.List;
import java.util.Stack;

/**
 * An abstract class to provide some common handling for all of the commands.
 * 
 * @author Noah Solomon
 *
 */
public abstract class Command {
	protected String command;
	protected List<Integer> arguments;
	
	public Command(String cmd, List<Integer> args) {
		command = cmd;
		arguments = args;
	}
	
	public void execute(Stack<Command> stack, List<List<String>> state) {
		doExecution(stack, state);
	}
	
	protected abstract void doExecution(Stack<Command> stack, List<List<String>> state);
	
	public String getCommand() {
		return command;
	}

	public List<Integer> getArguments() {
		return arguments;
	}

	@Override
	public String toString() {
		return command + " " + arguments.toString();
	}
}
