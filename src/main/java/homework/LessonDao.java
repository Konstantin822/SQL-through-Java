package homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private DataBaseConnection dataBaseConnection;
    public LessonDao(DataBaseConnection dataBaseConnection) {
        this.dataBaseConnection = dataBaseConnection;
    }

    public void addLesson(Lesson lesson) {
        String sql = "INSERT INTO lesson " +
                "(name, homeworkId)" +
                " VALUES(?, ?)";
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, lesson.getName());
            statement.setInt(2, lesson.getHomework().getId());

            int i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteLesson(Lesson lesson) {
        String sql = "DELETE FROM lesson WHERE id = ?";
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lesson.getId());

            int i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Lesson getAllLessons() {
        List<Lesson> lessonList = new ArrayList<>();
        String sql = "SELECT * FROM lesson";
        try (Connection connection = dataBaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(resultSet.getInt("lesson.id"));
                lesson.setName(resultSet.getString("lesson.name"));

                Homework hw = new Homework();
                hw.setId(resultSet.getInt("homework.id"));

                lessonList.add(lesson);
            }
            System.out.println(lessonList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Lesson getLessonById(Integer id) {
        String sql = "SELECT lesson.*, homework.* FROM lesson"
                + " JOIN homework"
                + " ON lesson.homeworkId = homework.id"
                + " WHERE lesson.id = ?";
        try (Connection connection = dataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            Lesson lesson = new Lesson();
            lesson.setId(resultSet.getInt("lesson.id"));
            lesson.setName(resultSet.getString("lesson.name"));

            Homework hw = new Homework();
            hw.setId(resultSet.getInt("homework.id"));

            lesson.setHomework(hw);

            return lesson;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
