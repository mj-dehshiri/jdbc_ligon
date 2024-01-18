import java.util.Scanner;

public class Menu {
     private  final Scanner scanner = new Scanner(System.in);
    public void publicMenu(){
        System.out.println("***** WELCOME *****");
        System.out.println("1-signup");
        System.out.println("2- signin");
        System.out.println("3- exit");
        System.out.println("choose your number: ");

        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println(number);
    }
}
