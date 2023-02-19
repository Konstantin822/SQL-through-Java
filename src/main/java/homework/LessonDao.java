package homework;

import java.sql.*;

public class LessonDao {

    public void addLesson(Connection connection, Lesson lesson) {
        String sql = "INSERT INTO lesson " +
                "(name, homework)" +
                " VALUES(?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, lesson.getName());
            statement.setString(2, lesson.getHomework());

            int i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Lesson getLessonById(Connection connection, Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM lesson WHERE id = ?")) {
            statement.setInt(2, id);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            Lesson lesson = new Lesson();
            lesson.setId(resultSet.getInt("id"));
            lesson.setName(resultSet.getString("name"));
            lesson.setHomework(resultSet.getString("homework"));
            return lesson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
