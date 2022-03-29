package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;
import commands.ElementInput;
import data.City;

import java.util.Scanner;


public class Add extends CommandAbstract {

    @Override
    public boolean getNewEl() {
        return true;
    }

    @Override
    public boolean on(Scanner scanner) {
        City newCity = ElementInput.getNewElement(scanner);
        for (City city : CollectionManager.collection) {
            if (newCity.compareTo(city) == 0) {
                CollectionManager.lostIdList.add(newCity.getId());
                System.err.println("Элемент не добавленн т.к. элемент эквивкелентный этому уже есть!");
                return false;
            }
        }


        CollectionManager.collection.add(newCity);

        return true;
    }


}
