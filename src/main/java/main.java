import homework.Homework;
import homework.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/homeworkdb";
            String username = System.getenv("MYSQL_USER");
            String password = System.getenv("MYSQL_PASSWORD");

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                Statement statement = connection.createStatement();

                statement.execute("SELECT * FROM homework");
                statement.execute("SELECT * FROM lesson");
                ResultSet resultSet = statement.getResultSet();

                List<Homework> homeworkList = new ArrayList<>();
                List<Lesson> lessonList = new ArrayList<>();

                while (resultSet.next()) {
                    Homework homework = new Homework();
                    homework.setId(resultSet.getInt("id"));
                    homework.setName(resultSet.getString("name"));
                    homework.setDescription(resultSet.getString("description"));

                    Lesson lesson = new Lesson();
                    lesson.setId(resultSet.getInt("id"));
                    lesson.setName(resultSet.getString("name"));
                    lesson.setHomework(resultSet.getString("homework"));

                    homeworkList.add(homework);
                    lessonList.add(lesson);
                }

                System.out.println(homeworkList);
                System.out.println(lessonList);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
