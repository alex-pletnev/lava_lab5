package collection;

import data.City;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CollectionManager {
    public static TreeSet<City> collection = new TreeSet<>();
    public static LocalDateTime collectionInitTime = LocalDateTime.now();
    public static List<Long> lostIdList = new ArrayList<>();
    public static final String FILE_PATH = System.getenv("MY_PATH");

}
