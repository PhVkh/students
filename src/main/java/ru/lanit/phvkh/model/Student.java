package ru.lanit.phvkh.model;

import java.util.*;

public class Student implements Comparable{
    private String name;
    private String lastName;
    private String patronymic;
    private String sex;
    private String dateOfBirth;
    private int course;
    private List<String> classes;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }

    public List<String> getClasses() {
        return classes;
    }
    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public Student(String s) {
        String[] student = s.split(", ");
        this.name = student[0];
        this.lastName = student[1];
        this.patronymic = student[2];
        this.sex = student[3];
        this.dateOfBirth = student[4];
        this.course = Integer.parseInt(student[5]);
        this.classes = new LinkedList<>();
        this.classes.add(student[6]);
    }

    public Student(String name, String lastName, String patronymic, String sex, String dateOfBirth, int course, List<String> classes) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
        this.classes = classes;
    }

    public Student mergeClasses(Student student) {
        this.getClasses().addAll(student.getClasses());
        return this;
    }

    @Override
    public String toString() {
        return "Студент: " + this.getName() + " " + this.getLastName() + " " + this.getPatronymic() +
                ", рожден: " + this.getDateOfBirth() + ", пол: " + this.getSex() + ", курс: " + this.getCourse() +
                ", предметы: " + this.getClasses().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(patronymic, student.patronymic) &&
                Objects.equals(dateOfBirth, student.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic, dateOfBirth);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student)) return -1;
        return this.toString().compareTo(o.toString());
    }
}
