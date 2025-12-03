package main;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static void printResults(String title, List<?> list) {
        System.out.println("\n--- " + title + " ---");
        list.forEach(System.out::println);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        try {
            Logger rootLogger = Logger.getLogger("");
            rootLogger.setLevel(Level.INFO);
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers.length > 0) {
                SimpleFormatter formatter = new SimpleFormatter();
                for (Handler handler : handlers) {
                    handler.setFormatter(formatter);
                    handler.setLevel(Level.INFO);
                }
            }
        } catch (Exception e) {
            System.err.println("Помилка конфігурації логування: " + e.getMessage());
        }
        StudentRepository studentRepository = new StudentRepository();

        System.out.println("\n[Створення об'єктів студентів]");
        studentRepository.add(new Student(3L, "Іван", "Коваленко", 20));
        studentRepository.add(new Student(1L, "Олена", "Петренко", 22));
        studentRepository.add(new Student(2L, "Андрій", "Сидоренко", 19));

        printResults("Початковий список студентів (до сортування)", studentRepository.getAll());

        studentRepository.sortByIdentity("ASC");
        printResults("Студенти, сортовані за ID (ASC)", studentRepository.getAll());

        studentRepository.sortByLastName("DESC");
        printResults("Студенти, сортовані за Прізвищем (Comparable, DESC)", studentRepository.getAll());

        studentRepository.sortByAge("ASC");
        printResults("Студенти, сортовані за Віком (Method Reference, ASC)", studentRepository.getAll());

        studentRepository.sortByFirstName("DESC");
        printResults("Студенти, сортовані за Іменем (Lambda, DESC)", studentRepository.getAll());

        GroupRepository groupRepository = new GroupRepository();

        System.out.println("\n[Створення об'єктів груп]");
        groupRepository.add(new Group(30L, "K-301", 25));
        groupRepository.add(new Group(10L, "F-101", 30));
        groupRepository.add(new Group(20L, "M-205", 28));

        printResults("Початковий список груп (до сортування)", groupRepository.getAll());

        groupRepository.sortByIdentity("DESC");
        printResults("Групи, сортовані за ID (DESC)", groupRepository.getAll());

        groupRepository.sortByName("ASC");
        printResults("Групи, сортовані за Назвою (Comparable, ASC)", groupRepository.getAll());

        groupRepository.sortByStudentCount("DESC");
        printResults("Групи, сортовані за Кількістю студентів (Method Ref., DESC)", groupRepository.getAll());
    }
}