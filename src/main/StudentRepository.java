package main;

import java.util.Comparator;

public class StudentRepository extends GenericRepository<Student> {
    public void sortByLastName(String order) {
        Comparator<Student> comparator = Comparator.naturalOrder();
        sort(comparator, order, "LastName (Comparable)");
    }

    public void sortByAge(String order) {
        sort(Student.byAge(), order, "Age (Method Reference)");
    }

    public void sortByFirstName(String order) {
        sort(Student.byFirstName(), order, "FirstName (Lambda)");
    }
}