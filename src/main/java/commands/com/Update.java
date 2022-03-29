package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;
import commands.ElementInput;
import data.City;

import java.util.Scanner;

public class Update extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return true;
    }
    @Override
    public boolean on(Scanner scanner) {
        if (getArgList().size() != 1) {
            System.err.println("Неверное количество аргументов повторите ввод команды!");
            return false;
        }
        if (!getArgList().get(0).matches("\\d+")) {
            System.err.println("Неверный тип данных аргументов(тип данных long)");
            return false;
        }
        long id = Long.parseLong(getArgList().get(0));
        for (City city : CollectionManager.collection) {
            if (city.getId() == id){
                CollectionManager.collection.remove(city);
                City newCity = ElementInput.getNewElement(scanner);
                newCity.setId(id);
                City.setIdCounter(City.getIdCounter() - 1);
                CollectionManager.collection.add(newCity);
                return true;
            }
        }
        System.err.println("Элемент с данным id не найден");
        return false;

    }
}
