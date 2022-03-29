package commands.com;

import commands.CommandAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class History extends CommandAbstract {
    private static List<String> historyList = new ArrayList<>();
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        System.out.println("---------------------");
        System.out.println("---------------------");
        while (historyList.size() > 14) {
            historyList.remove(0);
        }
        for (String com : historyList) {
            System.out.println(com);
        }
        System.out.println("---------------------");
        System.out.println("---------------------");

        return true;
    }

    public static List<String> getHistoryList() {
        return historyList;
    }
}
