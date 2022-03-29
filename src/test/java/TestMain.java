import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            int i = Integer.parseInt(scanner.nextLine());
            System.out.println("cyk");
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

    }
}
