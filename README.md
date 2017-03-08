# Robotic Arm 
An implementation of the code exercise found at https://github.com/AdventureProjects/EngInterview in Java

## How To Run
I went ahead and generated a runnable jar to save you the trouble:

```java -jar robotic-arm-runnable.jar```

## Future Additions
 * Testing - Would have liked to start with unit tests and worked backwards to the code, but I didn't feel that I had
 time for this.
 * Validation - Commands needed better validation.  More time would have allowed me to validate not only the syntax,
 but the arguments to each command.  This can get pretty complex, especially if you try to replay a command that is no
 longer valid.
 * Messaging - Adding to the validation point, it would have been good to spend more time telling a user what they may
 have entered incorrectly.  Furthermore, it would have been nice to print out the stack of Commands (maybe with a new
 `stack` command).
 * Undo undo - Making the Undo and Replay commands undoable would have been an interesting exercise.
 * Redo - Add redo functionality.  
 
## Trade Offs and Discussion Points
 * State - This was an interesting exercise in passing the application's state from one Command to the next.  Made more
 interesting by my recent experience with ReactJS and a framework called Redux (http://redux.js.org/).  If I had more
 time I would have explored if using the state differently was appropriate.  Should the state belong to a store?
 Should each Command return a new copy of the state as Redux does?
 * Stack - Could potentially change how the user interacted with the stack.  Using a Dequeue or an Array could 
 potentially give more power in controlling the order of commands. 