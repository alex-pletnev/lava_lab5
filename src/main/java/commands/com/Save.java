package commands.com;

import collection.CollectionManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import commands.CommandAbstract;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Save extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        try (PrintWriter printWriter = new PrintWriter(CollectionManager.FILE_PATH)){
            gson.toJson(CollectionManager.collection, printWriter);
        } catch (IOException ex) {
            System.err.println("Ошибка при сохранении в файл!");
        }

        return true;
    }
}
