package commands.com;

import commands.CommandAbstract;
import commands.CommandParser;

import java.util.Scanner;

public class Exit extends CommandAbstract {
    @Override
    public boolean getNewEl() {
        return false;
    }
    @Override
    public boolean on(Scanner scanner) {
        CommandParser.setReading(false);
        return false;
    }
}
