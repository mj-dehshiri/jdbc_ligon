import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
     private  final Scanner scanner = new Scanner(System.in);
     private  final UserService userService = new UserService();

    public Menu() throws SQLException {
    }

    public void publicMenu() throws SQLException {
        System.out.println("***** WELCOME *****");
        System.out.println("1-signup");
        System.out.println("2- signin");
        System.out.println("3- exit");
        System.out.println("choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number){
            case 1 -> signUp();
            case 2 -> System.out.println("sigin");
            case 3 -> System.out.println("exit");

        }
    }

    public void signUp() throws SQLException {
        userService.signUp();

    }
}
