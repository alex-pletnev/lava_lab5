package commands;

import commands.com.*;
import exception.UnknownCommandException;

import java.util.*;

public class CommandParser {
    public static boolean reading = true;
    public static Map<String ,CommandInterface> commandMap = new TreeMap<>();
    static {
        commandMap.put("help", new Help());
        commandMap.put("info", new Info());
        commandMap.put("show", new Show());
        commandMap.put("add", new Add());
        commandMap.put("update", new Update());
        commandMap.put("remove_by_id", new Remove_by_id());
        commandMap.put("clear", new Clear());
        commandMap.put("save", new Save());
        commandMap.put("execute_script", new Execute_script());
        commandMap.put("exit", new Exit());
        commandMap.put("add_if_max", new Add_if_max());
        commandMap.put("remove_greater", new Remove_greater());
        commandMap.put("history", new History());
        commandMap.put("remove_any_by_meters_above_sea_level", new Remove_any_by_meters_above_sea_level());
        commandMap.put("group_counting_by_meters_above_sea_level", new Group_counting_by_meters_above_sea_level());
        commandMap.put("print_ascending", new Print_ascending());

    }

    public void startProcess(Scanner input) {
        while(reading) {
            try {
                String str = input.nextLine();
                if (!str.equals("")) {
                    String[] splitStr = str.split(" ");

                    if (commandMap.get(splitStr[0]) == null) {
                        try {
                            throw new UnknownCommandException("Введена неизвестная команда!");
                        } catch (UnknownCommandException ex) {
                            ex.printStackTrace();
                            continue;
                        }
                    }
                    commandMap.get(splitStr[0]).setArgList(splitStr);
                    commandMap.get(splitStr[0]).on(input);
                    History.getHistoryList().add(splitStr[0]);
                } else {
                    System.err.print("Enter your command...(plz)\n");
                }
            } catch (NoSuchElementException ex) {
                System.err.println("Обнорженно прирывание!!");
                reading = false;
            }
        }
    }

    public static boolean isReading() {
        return reading;
    }

    public static void setReading(boolean reading) {
        CommandParser.reading = reading;
    }
}
