package ru.lanit.phvkh;

import static org.junit.Assert.assertEquals;
import static ru.lanit.phvkh.App.*;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class AppTest {
    @Test
    public void printByAppearanceTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printStudentsByAppearance(lines, bufferedWriter);
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(3, studentsByAppearance.size());
            assertEquals("Студент: Бванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [русский]",
                    studentsByAppearance.get(0));
            assertEquals("Студент: Назарбаев Нурсултан Абишулы, рожден: 21.11.1956, пол: М, курс: 4, предметы: [математика]",
                    studentsByAppearance.get(1));
            assertEquals("Студент: Иванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [математика]",
                    studentsByAppearance.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printByAppearanceMultipleSubjectsTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, казахский язык");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, казахская литература");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, история казахстана");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printStudentsByAppearance(lines, bufferedWriter);
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(3, studentsByAppearance.size());
            assertEquals("Студент: Бванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [русский]",
                    studentsByAppearance.get(0));
            assertEquals("Студент: Назарбаев Нурсултан Абишулы, рожден: 21.11.1956, пол: М, курс: 4, предметы: " +
                            "[математика, казахский язык, казахская литература, история казахстана]",
                    studentsByAppearance.get(1));
            assertEquals("Студент: Иванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [математика]",
                    studentsByAppearance.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printLineByNumberTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");
            printLineByNumber(lines, bufferedWriter, 1);
            bufferedWriter.close();

            List<String> result = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(1, result.size());
            assertEquals("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика",
                    result.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printSortedTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printSortedStudents(lines, bufferedWriter);
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(3, studentsByAppearance.size());
            assertEquals("Студент: Бванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [русский]",
                    studentsByAppearance.get(0));
            assertEquals("Студент: Иванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [математика]",
                    studentsByAppearance.get(1));
            assertEquals("Студент: Назарбаев Нурсултан Абишулы, рожден: 21.11.1956, пол: М, курс: 4, предметы: [математика]",
                    studentsByAppearance.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printSortedWithMultipleSubjectsTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, казахский язык");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, казахская литература");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, история казахстана");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printSortedStudents(lines, bufferedWriter);
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(3, studentsByAppearance.size());
            assertEquals("Студент: Бванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [русский]",
                    studentsByAppearance.get(0));
            assertEquals("Студент: Иванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [математика]",
                    studentsByAppearance.get(1));
            assertEquals("Студент: Назарбаев Нурсултан Абишулы, рожден: 21.11.1956, пол: М, курс: 4, предметы: " +
                            "[математика, казахский язык, казахская литература, история казахстана]",
                    studentsByAppearance.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printByCourseTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printStudentsByCourse(lines, bufferedWriter, 4);
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(1, studentsByAppearance.size());
            assertEquals("Студент: Назарбаев Нурсултан Абишулы, рожден: 21.11.1956, пол: М, курс: 4, предметы: [математика]",
                    studentsByAppearance.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printByInvalidCourseTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printStudentsByCourse(lines, bufferedWriter, 0);
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(0, studentsByAppearance.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printBySubjectTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printStudentsByClass(lines, bufferedWriter, "русский");
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(1, studentsByAppearance.size());
            assertEquals("Студент: Бванов Иван Иванович, рожден: 12.04.1998, пол: М, курс: 3, предметы: [русский]",
                    studentsByAppearance.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printByInvalidSubjectTest() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/students_output.txt"));
            List<String> lines = new LinkedList<>();
            lines.add("Бванов, Иван, Иванович, М, 12.04.1998, 3, русский");
            lines.add("Назарбаев, Нурсултан, Абишулы, М, 21.11.1956, 4, математика");
            lines.add("Иванов, Иван, Иванович, М, 12.04.1998, 3, математика");

            printStudentsByClass(lines, bufferedWriter, "мдвалфыъзмщфтьаъмщш");
            bufferedWriter.close();

            List<String> studentsByAppearance = Files.readAllLines(Paths.get("src/test/resources", "students_output.txt"));
            assertEquals(0, studentsByAppearance.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
