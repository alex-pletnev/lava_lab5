package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;
import data.City;

import java.util.Scanner;

public class Remove_by_id extends CommandAbstract {
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
        if (!getArgList().get(0).matches("\\d+")) {
            System.err.println("Неверный тип данных аргументов(тип данных long)");
            return false;
        }
        long id = Long.parseLong(getArgList().get(0));
        for (City city: CollectionManager.collection) {
            if (city.getId() == id) {
                CollectionManager.collection.remove(city);
                CollectionManager.lostIdList.add(id);
                return true;
            }
        }
        System.err.println("Элемент с данным id не найден");
        return false;
    }
}
