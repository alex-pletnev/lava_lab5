import collection.JsonCollectionParser;
import commands.CommandParser;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("1100 1101 1010 1100");
        JsonCollectionParser jsonCollectionParser = new JsonCollectionParser();
        jsonCollectionParser.parseJsonToSet();
        CommandParser commandParser = new CommandParser();
        commandParser.startProcess(new Scanner(System.in));
        }
    }

