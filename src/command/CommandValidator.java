package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class validates that the commands are "syntactically valid".  Assumption: this means that the command is well
 * structured, and not that it necessarily has valid parameters.  For the sake of saving time, I'm going to assume
 * that all commands have valid parameters (the numbers passed after the command string).  If I had more time, I would
 * want to ensure that more things passed to this class were validated properly.
 *   
 * @author Noah Solomon
 *
 */
public class CommandValidator {
	private Scanner scanner;
	
	public CommandValidator(Scanner s) {
		scanner = s;
	}

	/**
	 * This is the center of the validation.  This command will throw an exception if the input line is improperly
	 * formatted.  Additionally, if an invalid command was entered, this function will return null.  See Main method
	 * for handling of null values.
	 * @return
	 * @throws CommandException
	 */
	public Command validateInputLine() throws CommandException {
		String line = scanner.nextLine();
		
		//tokenize line
		String[] args = line.split("\\s");
		
		//get command
		String commandString = getCommandString(args);
		
		//get command args
		List<Integer> commandArgs = getCommandArgs(args);
		
		//create command and return
		return createCommand(commandString, commandArgs);
	}
	
	/**
	 * Check that this is one of the acceptable commands and return it
	 * @param command
	 * @throws CommandException
	 */
	private String getCommandString(String[] args) throws CommandException {
		String command = args[0];
		
		if (!(command.equals("size") || 
			command.equals("add") ||
			command.equals("mv") || 
			command.equals("rm") || 
			command.equals("replay") ||
			command.equals("undo")) ) {
			throw new CommandException();
		}
		
		return command;
	}
	
	/**
	 * Get the command arguments from the line (either 1 or 2 arguments) and return them.
	 * @param command
	 * @return
	 * @throws CommandException
	 */
	private List<Integer> getCommandArgs(String[] args) throws CommandException {
		List<Integer> argList = new ArrayList<>();
		
		Integer arg1 = Integer.parseInt(args[1]);
		argList.add(arg1);
		
		if (args[0].equals("mv")) {
			Integer arg2 = Integer.parseInt(args[2]);
			argList.add(arg2);			
		}
		
		return argList;
	}
	
	/**
	 * Create a command and return it.  Would be nice to turn this into some sort of factory.  But don't have time.
	 * @param command
	 * @param args
	 * @return
	 */
	public static Command createCommand(String command, List<Integer> args) {
		Command c = null;
		
		if (command.equals("size")) {
			c = new SizeCommand(command, args);
		}
		else if (command.equals("add")) {
			c = new AddCommand(command, args);
		}
		else if (command.equals("mv")) {
			c = new MoveCommand(command, args);
		}
		else if (command.equals("rm")) {
			c = new RemoveCommand(command, args);
		}
		else if (command.equals("undo")) {
			c = new UndoCommand(command, args);
		}
		else if (command.equals("replay")) {
			c = new ReplayCommand(command, args);
		}
		
		return c;
	}
}
