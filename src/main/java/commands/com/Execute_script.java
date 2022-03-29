package commands.com;

import commands.CommandAbstract;
import commands.CommandInterface;
import commands.CommandParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Execute_script extends CommandAbstract {
    private static List<String> scriptList = new ArrayList<>();
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        if (getArgList().size() != 1) {
            System.err.println("Неверное количество аргументов повторите ввод команды!");
            return false;
        }
        scriptList.add(getArgList().get(0));
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(getArgList().get(0)))) {
            Scanner input = new Scanner(inputStream);
            while (input.hasNext()) {
                String commandStr = input.nextLine();
                String[] splitStr = commandStr.split(" | \n");
                for (String lScr: scriptList) {
                    for (String str : splitStr)
                    if (lScr.equals(str)) {
                        System.err.println("Рекурсия!(Скрипт завершен досрочно)");
                        return false;
                    }
                }
                System.out.println(commandStr);
                if (CommandParser.commandMap.containsKey(splitStr[0])) {
                    CommandInterface command = CommandParser.commandMap.get(splitStr[0]);
                    command.setArgList(splitStr);
                    command.on(input);
                    History.getHistoryList().add(splitStr[0]);
                } else {
                    System.err.println("В файле допущенна ошибка(скрипт завершенн досрочно)");
                    return false;
                }
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при чтении файла!");
        }

        System.out.println("---------------------");
        System.out.println("Скрипт выполнен");
        System.out.println("---------------------");
        return true;
    }
}
