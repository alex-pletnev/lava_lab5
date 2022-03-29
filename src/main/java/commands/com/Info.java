package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;

import java.util.Scanner;

public class Info extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        System.out.println("Type: " + CollectionManager.collection.getClass());
        System.out.println("Date-Time of Init: " + CollectionManager.collectionInitTime);
        System.out.println("Element in the collection: " + CollectionManager.collection.size());
        return true;

    }
}
