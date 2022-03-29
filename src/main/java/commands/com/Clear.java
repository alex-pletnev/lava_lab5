package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;
import data.City;

import java.util.Scanner;

public class Clear extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        CollectionManager.collection.clear();
        City.setIdCounter(0);
        return true;
    }
}
