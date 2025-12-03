package main;

import java.util.Comparator;

public class Student implements Entity, Comparable<Student>{
    private final Long id;
    private String firstName;
    private String lastName;
    private int age;

    public Student(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    @Override
    public int compareTo(Student other) {
        return this.lastName.compareTo(other.lastName);
    }

    public static Comparator<Student> byAge() {
        return Comparator.comparingInt(Student::getAge); // Використання посилання на метод
    }

    public static Comparator<Student> byFirstName() {
        return (s1, s2) -> s1.firstName.compareTo(s2.firstName);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + firstName + " " + lastName + "', age=" + age + '}';
    }
}
