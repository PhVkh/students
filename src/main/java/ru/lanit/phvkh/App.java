package ru.lanit.phvkh;

import ru.lanit.phvkh.model.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class App {
    public static void printLineByNumber(List<String> lines, BufferedWriter bufferedWriter, int number) throws IOException {
        bufferedWriter.write(lines.get(number));
    }

    private static Deque<Student> getDequeOfStudents(List<String> lines) {
        Deque<Student> students = new LinkedBlockingDeque<>();
        for (String line : lines) {
            Student student = new Student(line);
            if (!students.isEmpty()) {
                if (students.getLast().getName().equals(student.getName()) &&
                        students.getLast().getLastName().equals(student.getLastName()) &&
                        students.getLast().getPatronymic().equals(student.getPatronymic())) {
                    students.getLast().getClasses().addAll(student.getClasses());
                } else {
                    students.addLast(student);
                }
            } else {
                students.addLast(student);
            }
        }
        return students;
    }

    public static void printStudentsByAppearance(List<String> lines, BufferedWriter bufferedWriter) throws IOException {
        Deque<Student> students = getDequeOfStudents(lines);
        while (!students.isEmpty()) {
            bufferedWriter.write(students.pop().toString() + "\n");
        }
    }

    public static void printSortedStudents(List<String> lines, BufferedWriter bufferedWriter) throws IOException {
        List<Student> students = new LinkedList<>();
        for (String line : lines) {
            Student student = new Student(line);
            if (students.isEmpty()) {
                students.add(student);
            } else {
                if (students.get(students.size() - 1).equals(student)) {
                    students.get(students.size() - 1).getClasses().addAll(student.getClasses());
                } else {
                    students.add(student);
                }
            }
        }
        Collections.sort(students);
        for (Student student : students) {
            bufferedWriter.write(student.toString() + "\n");
        }
    }

    public static void printStudentsByCourse(List<String> lines, BufferedWriter bufferedWriter, int course) throws IOException {
        Deque<Student> students = getDequeOfStudents(lines);
        while (!students.isEmpty()) {
            if (students.getFirst().getCourse() == course) {
                bufferedWriter.write(students.getFirst().toString() + "\n");
            }
            students.pop();
        }
    }

    public static void printStudentsByClass(List<String> lines, BufferedWriter bufferedWriter, String subject) throws IOException {
        Deque<Student> students = getDequeOfStudents(lines);
        while (!students.isEmpty()) {
            if (students.getFirst().getClasses().contains(subject)) {
                bufferedWriter.write(students.getFirst().toString() + "\n");
            }
            students.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        "src/main/resources/students_output.txt"))) {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources", "students.txt"));
            //place for some methods
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
