package data;

public enum Government {
    ARISTOCRACY("АРИСТОКРАТИЯ", "аристовратия"),
    GERONTOCRACY("ГЕРОНТОКРАТИЯ", "геронтократия"),
    DESPOTISM("ДЕСПОТИЗМ", "деспотизм"),
    TIMOCRACY("ТИМОКРАТИЯ", "тимократия");

    private final String upReg;
    private final String lowReg;
    Government(String upReg, String lowReg) {
        this.upReg = upReg;
        this.lowReg = lowReg;
    }

    public String getUpReg() {
        return upReg;
    }

    public String getLowReg() {
        return lowReg;
    }

    @Override
    public String toString() {
        return "Government{" +
                "upReg='" + upReg + '\'' +
                ", lowReg='" + lowReg + '\'' +
                "} " + super.toString();
    }
}
