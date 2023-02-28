import homework.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
            DataBaseConnection dataBaseConnection = new DataBaseConnection(
                    "jdbc:mysql://localhost:3306/homeworkdb2",
                    "root",
                    "123456789");

            LessonDao lessonDao = new LessonDao(dataBaseConnection);
            HomeworkDao homeworkDao = new HomeworkDao(dataBaseConnection);

            Homework hw = new Homework();
            //hw.setName("Physics");
            //hw.setDescription("Atom");
            //homeworkDao.addHomework(hw);

            Lesson lesson = new Lesson();
            //lesson.setName("Physics");
            //lesson.setHomework(hw);
            //lessonDao.addLesson(lesson);

            //lesson.setId(3);
            //lessonDao.deleteLesson(lesson);

            //lessonDao.getLessonById(1);
            lessonDao.getAllLessons();


    }
}
