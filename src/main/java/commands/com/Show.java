package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;

import java.util.Scanner;

public class Show extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        CollectionManager.collection.forEach(city -> System.out.println("City: " + city));
        return true;
    }
}
