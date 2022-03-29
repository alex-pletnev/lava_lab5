package collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.City;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class JsonCollectionParser {

    public void parseJsonToSet() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        List<String> dateList = new ArrayList<>();
        File file = new File(CollectionManager.FILE_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException exception) {
            System.err.println("Недостаточно прав для создания файла или указан неверный путь!");
            exception.printStackTrace();
        }
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(CollectionManager.FILE_PATH))) {
            //парсинг всего кроме creationDate
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
            String json = scanner.hasNext() ? scanner.next() : "";

            TreeSet<City> collection = gson.fromJson(json, new TypeToken<TreeSet<City>>() {}.getType());
            if (collection != null) {
                City.setIdCounter(City.getIdCounter() + collection.size());

                //парсинг creationDate
                String[] splitJson = json.split("\n");
                for (String str : splitJson) {
                    if (str.matches("[ \t\n\\x0B\f\r]* \"creationDate\": \".*\",")) {
                        dateList.add(str.split("\"")[3]);
                    }
                }
                int i = 0;
                for (City city : collection) {
                    try {
                        city.setCreationDate(LocalDate.parse(dateList.get(i), DateTimeFormatter.ISO_LOCAL_DATE));

                        city.setCreationDateStr(dateList.get(i));
                    } catch (Exception ex) {
                        ex.getMessage();
                        i++;
                    }

                }
                //крооекция id
                long maxId = 0;
                List<Long> idList = new ArrayList<>();
                for (City city : collection) {
                    idList.add(city.getId());
                    maxId = Long.max(maxId, city.getId());
                }
                City.setIdCounter(maxId);
                for (long j = 1; i <= maxId; i++) {
                    if (!idList.contains(j)) {
                        CollectionManager.lostIdList.add(j);
                    }
                }
                for (City city : collection) {
                    if (city.validation()) {
                        CollectionManager.collection.add(city);
                    }
                }
            } else {
                CollectionManager.collection = new TreeSet<>();
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при чтении файла!");
        }
    }
}
