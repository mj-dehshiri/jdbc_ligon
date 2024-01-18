import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public void signUp() throws SQLException {
        System.out.println("please enter your firstname");
        String firsname = scanner.nextLine();

        System.out.println("please enter your lastname");
        String lastname = scanner.nextLine();

        System.out.println("please enter your username");
        String username = scanner.nextLine();

        System.out.println("please enter your password");
        String password = scanner.nextLine();

        User user = new User(firsname,lastname,username,password);
        int result =userRepository.registeruser(user);
        if(result==1){
            System.out.println(firsname+" you successfully register");
        }
        else {
            System.out.println("something is wrong");
        }

    }
}
