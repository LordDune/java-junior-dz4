package pac.main;

import java.util.Random;
import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {

    private static final String[] names = new String[] { "Java Junior", "Data Base", "Linux"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;

    public Courses() {

    }

    public Courses(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public Courses(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public static Courses create(){
        return new Courses(names[random.nextInt(names.length)], random.nextInt(30) + 20);
    }



    public void updateDuration(){
        duration = random.nextInt(30) + 20;
    }

    public void updateName(){
        name = names[random.nextInt(names.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int age) {
        this.duration = age;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}