package main;

import java.util.Comparator;

public class GroupRepository extends GenericRepository<Group> {
    public void sortByName(String order) {
        Comparator<Group> comparator = Comparator.naturalOrder();
        sort(comparator, order, "Name (Comparable)");
    }

    public void sortByStudentCount(String order) {
        sort(Group.byStudentCount(), order, "StudentCount (Method Reference)");
    }
}