package commands.com;

import collection.CollectionManager;
import commands.CommandAbstract;
import data.City;

import java.util.*;

public class Group_counting_by_meters_above_sea_level extends CommandAbstract {
    private Map<Double, List<City>> metMap = new TreeMap<>();
    private int i = 0;
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        for (City city : CollectionManager.collection) {
            metMap.put(city.getMetersAboveSeaLevel(), new ArrayList<>());
        }
        for (City city : CollectionManager.collection) {
            if (metMap.get(city.getMetersAboveSeaLevel()) != null) {
                metMap.get(city.getMetersAboveSeaLevel()).add(city);
            }
        }
        for (Double key : metMap.keySet()) {
            i++;
            System.out.println("Группа " + i + ": " + metMap.get(key).size());
        }
        return true;
    }
}
