package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

public class UserMapper {
    private Database database;

    public UserMapper(Database database)
    {
        this.database = database;
    }

    public User login(String email, String password) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT users.user_id, roles.role, users.email, users.firstName, users.lastName, users.password\n" +
                   "FROM users\n" +
                   "INNER JOIN roles\n" +
                   "ON users.fk_role_id = roles.role_id\n" +
                   "WHERE users.email = ? AND users.password = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("user_id");
                    String role = rs.getString("role");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");

                    User user = new User(email, password, role, firstName, lastName);
                    user.setId(id);
                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

}
