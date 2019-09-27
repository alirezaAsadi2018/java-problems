package ir.javacup.miceSchool;

import java.util.Arrays;

public class Course {
    private int numOfStudents = 0;
    private Student[] students = new Student[10];
    private String name;

    public boolean register(Student s) {
        if (numOfStudents >= 10)
            return false;
        students[numOfStudents++] = s;
        return true;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public Student[] getStudents() {
        Student[] studentArray;
        studentArray = Arrays.copyOf(students, numOfStudents);
        return studentArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

