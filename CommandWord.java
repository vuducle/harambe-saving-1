/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.LinkedHashMap;
import java.util.Random;

public enum CommandWord
{

    WELCOME("welcome"),
    
    GO("go"), 
    
    LOOK("look"), //wiederholt die description --> Aufgabe 2
    
    INSPECT("inspect"),//details vom Raum ansehen
    SEARCH("search"),
    THINK("think"),

    QUIT("quit"), 
    EAT("eat"),
    UNKNOWN("unknown"),
    HELP("help");

       private static Map<CommandWord, BiFunction<CommandWord,String,Command>> commandFactories = new LinkedHashMap<>();

    static {
        commandFactories.put(GO, (w1,w2)-> new Go(w1,w2));
        commandFactories.put(QUIT, (w1,w2)-> new Quit(w1,w2));
        commandFactories.put(HELP, (w1,w2)-> new Help(w1,w2));
        commandFactories.put(UNKNOWN, (w1,w2)-> new Unknown(w1,w2));
        commandFactories.put(WELCOME, (w1,w2)-> new Welcome(w1,w2));
        commandFactories.put(INSPECT, (w1,w2)-> new InspectRoom(w1,w2));
        commandFactories.put(EAT, (w1,w2)-> new Eat(w1,w2));
        commandFactories.put(SEARCH, (w1,w2)-> new SearchProp(w1,w2));
        commandFactories.put(LOOK, (w1,w2)-> new Unknown(w1, w2));
        commandFactories.put(THINK, (w1,w2)-> new Think(w1, w2));
    
   }

    private String word;
    private CommandWord(String word){
        this.word = word;
    }

    @Override
    public String toString(){
        return word;
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public static boolean isCommand(String aString)
    {
        CommandWord[] validCommands = CommandWord.class.getEnumConstants();
        for(CommandWord cw: validCommands) {
            if(cw.toString().equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    public static CommandWord forString(String commandWord){
        for(CommandWord cw: values()) {
            if(cw.toString().equals(commandWord))
                return cw;
        }
        return UNKNOWN;
    }

    public static Command buildCommand(String firstWord, String secondWord){
        CommandWord key = forString(firstWord);
        return commandFactories.get(key).apply(key, secondWord);
    }
    public static String getCommandWords(){
        return commandFactories
        .keySet()
        .stream()
        .filter(key -> !UNKNOWN.equals(key))
        .map(key -> key.toString())
        .collect(Collectors.joining(" "));
    }
}