package ir.javacup.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String content = "777777777 111 13.5"
                + System.lineSeparator() + "888888888 333 19.5";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            out.write(content.getBytes());
        } catch (IOException e) {
            //ignore
        }

        CourseUtilImpl util = new CourseUtilImpl();
        util.setOutputStream(out);

        Grade grade = util.load(1);
        System.out.println("id: " + grade.getStudentId() + " code: " + grade.getCourseCode() + " score: " + grade.getScore());

        Grade g = new Grade();
        g.setCourseCode(313);
        g.setScore(13);
        g.setStudentId("1111111");
        util.save(g);

        System.out.println("count: " + util.count());
        grade = util.load(3);
        System.out.println("id: " + grade.getStudentId() + " code: " + grade.getCourseCode() + " score: " + grade.getScore());
    }
}
