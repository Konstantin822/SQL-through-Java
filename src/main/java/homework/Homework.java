package homework;

public class Homework {
    private Integer id;
    private String name;
    private String description;

    public Homework() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lesson {" +
                "id = " + id +
                ", name ='" + name + '\'' +
                ", description ='" + description + '\'' +
                '}';
    }
}
