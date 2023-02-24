package homework;

import java.sql.Timestamp;

public class Lesson {
    private Integer id;
    private String name;
    private Homework homework;

    public Lesson() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "Lesson {" +
                "id = " + id +
                ", name ='" + name + '\'' +
                ", homework ='" + homework + '\'' +
                '}';
    }
}
