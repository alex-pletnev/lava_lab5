package commands;

import java.util.List;
import java.util.Scanner;

public interface CommandInterface {
    boolean getNewEl();
    boolean on(Scanner scanner);
    List<String> getArgList();
    void setArgList(String[] argArr);
}
