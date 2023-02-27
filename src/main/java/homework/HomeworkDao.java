package homework;

import java.sql.*;

public class HomeworkDao {
    private static DataBaseConnection dataBaseConnection;

    public HomeworkDao(DataBaseConnection dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    public void addHomework(Homework homework) {
        String sql = "INSERT INTO homework " +
                "(name, description)" +
                " VALUES(?, ?)";
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql,
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, homework.getName());
            statement.setString(2, homework.getDescription());

            int i = statement.executeUpdate();

            try (ResultSet genKeys = statement.getGeneratedKeys()) {
                if (genKeys.next()) {
                    homework.setId(genKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obatained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
