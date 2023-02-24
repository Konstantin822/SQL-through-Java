import homework.DataBaseConnection;
import homework.Homework;
import homework.Lesson;
import homework.LessonDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DataBaseConnection dataBaseConnection = new DataBaseConnection(
                    "jdbc:mysql://localhost:3306/homeworkdb",
                    "MYSQL_USER",
                    "MYSQL_PASSWORD");

            LessonDao lessonDao = new LessonDao(dataBaseConnection);
            lessonDao.getAllLessons();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
