package commands;

import java.util.Arrays;
import java.util.List;

public abstract class CommandAbstract implements CommandInterface {
    private List<String> argList;
    public List<String> getArgList() {
        return argList;
    }
    public void setArgList(String[] argArr) {
        argList = Arrays.asList(argArr).subList(1, argArr.length);
    }
}
