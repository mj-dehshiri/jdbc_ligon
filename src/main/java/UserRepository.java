import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final JdbcConnection jdbcConnection = new JdbcConnection();

    public UserRepository() throws SQLException {
    }

    public int  registeruser(User user) throws SQLException {
        Connection connection = new JdbcConnection().getConnection();
        String addUser = "INSERT INTO users(fist_name, last_name, user_name, password) VALUES (?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(addUser);
        preparedStatement.setString(1,user.getFirstName());
        preparedStatement.setString(2,user.getLastName());
        preparedStatement.setString(3,user.getUsername());
        preparedStatement.setString(4,user.getPassword());
        return preparedStatement.executeUpdate();
    }
    public User findByUsername(String username) throws SQLException {
        Connection connection = new JdbcConnection().getConnection();

        String findUser = "SELECT * FROM users WHERE user_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt("id");
            String firsname = resultSet.getString("fist_name");
            String lastname = resultSet.getString("last_name");
            String fetchUsername = resultSet.getString("user_name");
            String password = resultSet.getString("password");

            return new User(id,firsname,lastname,fetchUsername,password);
        }
        else {
            return null;
        }

    }
}
