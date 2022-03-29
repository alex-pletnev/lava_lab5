package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;
import data.City;

import java.util.Scanner;

public class Remove_any_by_meters_above_sea_level extends CommandAbstract {
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
        if (!getArgList().get(0).matches("^(\\d*\\.?\\d*)$")) {
            System.err.println("Неверный тип данных аргументов(тип данных double)");
            return false;
        }
        for (City city : CollectionManager.collection) {
            if (city.getMetersAboveSeaLevel() == Double.parseDouble(getArgList().get(0))) {
                CollectionManager.collection.remove(city);
                CollectionManager.lostIdList.add(city.getId());
                System.out.println("Элемент удален");
                return true;
            }
        }
        System.err.println("Подходящего элемента не найденно!");
        return false;
    }
}
