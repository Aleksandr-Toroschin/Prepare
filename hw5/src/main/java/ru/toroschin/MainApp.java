package ru.toroschin;

import ru.toroschin.hw5.Student;
import ru.toroschin.hw5.StudentDAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
//        Connection connection = DriverManager.getConnection("jdbc:h2:mem:database", "sa", "");
        StudentDAO studentDAO = new StudentDAO();

        // добваление одной записи
        studentDAO.insertStudent(new Student("Bob", 75));

        // чтение одной записи
        Student student = studentDAO.getStudentById(1L);
        System.out.println(student);

        // изменение одной записи
        student.setMark(90);
        studentDAO.updateStudent(student);
        System.out.println(studentDAO.getStudentById(1L));

        // добавление списка
        List<Student> studentsList = List.of(new Student("Jack", 55),
                new Student("Mark", 69),
                new Student("Oleg", 65),
                new Student("Petr", 78),
                new Student("Paul", 96),
                new Student("Alex", 88),
                new Student("Danil", 72),
                new Student("Viktor", 45),
                new Student("Andrew", 84));
        studentDAO.insertStudents(studentsList);

        printlnStudents(studentDAO);

        // удаление одной записи
        studentDAO.deleteStudentById(5L);

        printlnStudents(studentDAO);

        // добавление 1000 записей
        List<Student> studentsList1000 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            studentsList1000.add(new Student(getRandomName(), i + 5));
        }
        studentDAO.insertStudents(studentsList1000);

        printlnStudents(studentDAO);
    }

    public static String getRandomName() {
        char n1 = (char) (Math.random() * 31 + 1040);
        return String.valueOf(n1);
    }

    public static void printlnStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.getAllStudents();
        System.out.println(Arrays.toString(students.toArray()));
    }
}
