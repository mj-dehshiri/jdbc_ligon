import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
