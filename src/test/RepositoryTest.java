package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import main.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositoryTest {

    private StudentRepository studentRepository;
    private GroupRepository groupRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
        studentRepository.add(new Student(3L, "Іван", "Коваленко", 20));
        studentRepository.add(new Student(1L, "Олена", "Петренко", 22));
        studentRepository.add(new Student(2L, "Андрій", "Сидоренко", 19));

        groupRepository = new GroupRepository();
        groupRepository.add(new Group(30L, "K-301", 25));
        groupRepository.add(new Group(10L, "F-101", 30));
        groupRepository.add(new Group(20L, "M-205", 28));
    }

    @Test
    void student_SortByIdentity_ASC() {
        studentRepository.sortByIdentity("ASC");
        List<Student> students = studentRepository.getAll();

        assertEquals(1L, students.get(0).getId());
        assertEquals(2L, students.get(1).getId());
        assertEquals(3L, students.get(2).getId());
    }

    @Test
    void group_SortByIdentity_DESC() {
        groupRepository.sortByIdentity("DESC");
        List<Group> groups = groupRepository.getAll();
        assertEquals(30L, groups.get(0).getId());
        assertEquals(20L, groups.get(1).getId());
        assertEquals(10L, groups.get(2).getId());
    }
    @Test
    void student_SortByLastName_Comparable() {
        studentRepository.sortByLastName("ASC");
        List<Student> students = studentRepository.getAll();

        assertEquals("Коваленко", students.get(0).getLastName());
        assertEquals("Петренко", students.get(1).getLastName());
        assertEquals("Сидоренко", students.get(2).getLastName());
    }
    @Test
    void student_SortByAge_MethodReference_ASC() {
        studentRepository.sortByAge("ASC");
        List<Student> students = studentRepository.getAll();

        assertTrue(students.get(0).getAge() == 19 &&
                students.get(1).getAge() == 20 &&
                students.get(2).getAge() == 22);
    }
    @Test
    void student_SortByFirstName_Lambda_DESC() {
        studentRepository.sortByFirstName("DESC");
        List<Student> students = studentRepository.getAll();
        assertEquals("Олена", students.get(0).getFirstName());
        assertEquals("Андрій", students.get(1).getFirstName());
        assertEquals("Іван", students.get(2).getFirstName());
    }

    @Test
    void group_SortByName_Comparable() {
        groupRepository.sortByName("ASC");
        List<Group> groups = groupRepository.getAll();

        assertEquals("F-101", groups.get(0).getName());
        assertEquals("K-301", groups.get(1).getName());
        assertEquals("M-205", groups.get(2).getName());
    }

    @Test
    void group_SortByStudentCount_MethodReference_DESC() {
        groupRepository.sortByStudentCount("DESC");
        List<Group> groups = groupRepository.getAll();

        assertTrue(groups.get(0).getStudentCount() == 30 &&
                groups.get(1).getStudentCount() == 28 &&
                groups.get(2).getStudentCount() == 25);
    }
}