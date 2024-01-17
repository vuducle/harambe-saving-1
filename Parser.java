import java.util.Scanner;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Parser 
{
    private final Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() {
        String inputLine = readLine();
        return getCommand(inputLine);
    }

    private String readLine(){    
        System.out.print("> ");     // print prompt
        return reader.nextLine();
    }

    public Command getCommand(String inputLine)
    {
        String word1 = null;
        String word2 = null;

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        String bullShit = tokenizer.nextLine();
        int first = bullShit.indexOf(" ");
        if (first > 0)
        {
            String firstWord = bullShit.substring(0, first);
            String secondBSWord = bullShit.substring(first + 1);
            word1 = firstWord;
            word2 = secondBSWord;
        }
        else {
            word1 = bullShit;
        }

        return CommandWord.buildCommand(word1, word2);
    }
}
