package command;

/**
 * Wanted to flesh this out more to provide better feedback to the user.  But didn't really have time.
 * 
 * @author Noah Solomon
 *
 */
public class CommandException extends Exception {
	public CommandException() {
		super("Invalid command");
	}
}
