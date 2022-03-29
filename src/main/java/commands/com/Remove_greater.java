package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;
import commands.ElementInput;
import data.City;

import java.util.Scanner;

public class Remove_greater extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return true;
    }
    @Override
    public boolean on(Scanner scanner) {
        City testCity = ElementInput.getNewElement(scanner);
        CollectionManager.lostIdList.add(testCity.getId());
        for (City city : CollectionManager.collection) {
            if (city.compareTo(testCity) > 0) {
                CollectionManager.lostIdList.add(city.getId());
                CollectionManager.collection.remove(city);
            }
        }
        return true;
    }
}
