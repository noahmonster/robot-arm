package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import command.Command;
import command.CommandValidator;

/**
 * A command-line controller program for a fictitious robotic arm that takes commands to move blocks.
 * See https://github.com/AdventureProjects/EngInterview
 * @author Noah Solomon
 *
 */
public class RoboArm {

	public static void main(String[] args) {
		
		//Initialize a few things
		Scanner scanner = new Scanner(System.in);
		CommandValidator validator = new CommandValidator(scanner);
		Stack<Command> stack = new Stack<>(); //This could be a stack of UndoableCommands
		List<List<String>> state = new ArrayList<>();
		
		//print valid commands
		printCommands();
		
		try {
			//ready for input
			System.out.print("> ");
			
			//Wait for the user to enter a command
			while(scanner.hasNextLine()) {
				
				try {
					//validate command
					Command command = validator.validateInputLine();

					/*
					 * If Command is null, any operation on it will cause a NPE.  This is fine (for now) because the
					 * catch block will handle it as if it was a bad command (which it probably was).
					 */
					//execute command
					command.execute(stack, state);
				}
				catch (Exception e) {
					//handle bad input
					System.out.println("Bad command");
					
					//Should be "Logging" this as an error, but all I have time for is sysout
					//commenting this out for check in - mostly good for debugging quickly
//					System.out.println(e);
//					e.printStackTrace(System.out);
				}
				finally {
					//print state
					printState(state);
					
					//ready for input
					System.out.print("> ");
				}
				
			}
		}
		catch (Exception e) {
			// Exit (ctrl+c)
			System.out.println("Exit.");
		}
		
		//Any cleanup here
		scanner.close();
		System.exit(0);
		
	}
	
	/**
	 * Print the state of the application. 
	 * @param state
	 */
	public static void printState(List<List<String>> state) {
		for (int i = 0; i < state.size(); i++) {
			System.out.println((i + 1) + ":" + state.get(i));
		}	
	}
	
	/**
	 * Print the valid commands
	 */
	public static void printCommands() {
		System.out.println("Welcome to Noah Solomon's Robotic Arm coding exercise.");
		System.out.println("Valid commands are:");
		System.out.println("size [n]");
		System.out.println("add [slot]");
		System.out.println("mv [slot1] [slot2]");
		System.out.println("rm [slot]");
		System.out.println("replay [n]");
		System.out.println("undo [n]");
		System.out.println("");
		System.out.println("Enter a command.");
	}

}
