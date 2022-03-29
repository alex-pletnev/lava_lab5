package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;

import java.util.Scanner;

public class Print_ascending extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        CollectionManager.collection.forEach(System.out::println);
        return true;
    }
}
