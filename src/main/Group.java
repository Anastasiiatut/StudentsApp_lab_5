package main;
import java.util.Comparator;

public class Group implements Entity, Comparable<Group> {
    private final Long id;
    private String name;
    private int studentCount;

    public Group(Long id, String name, int studentCount) {
        this.id = id;
        this.name = name;
        this.studentCount = studentCount;
    }

    @Override
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getStudentCount() { return studentCount; }

    @Override
    public int compareTo(Group other) {
        return this.name.compareTo(other.name);
    }

    public static Comparator<Group> byStudentCount() {
        return Comparator.comparingInt(Group::getStudentCount); // Використання посилання на метод
    }

    public static Comparator<Group> byIdComparator() {
        return (g1, g2) -> g1.id.compareTo(g2.id); // Використання лямбда-виразу
    }

    @Override
    public String toString() {
        return "Group{id=" + id + ", name='" + name + "', count=" + studentCount + '}';
    }
}