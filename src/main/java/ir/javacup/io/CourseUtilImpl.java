package ir.javacup.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

public class CourseUtilImpl implements CourseUtil {
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;
    private List<String> lines = new ArrayList<>();
    private int count;
    private Map<String, List<Double>> studentMap;
    private Map<Integer, List<Double>> courseMap;
    private List<String> duplicate;

    @Override
    public void setOutputStream(ByteArrayOutputStream out) {
        studentMap = new HashMap<>();
        courseMap = new HashMap<>();
        duplicate = new ArrayList<>();
        lines = new ArrayList<>();
        this.outputStream = out;
        inputStream = new ByteArrayInputStream(out.toByteArray());
        Scanner scanner = new Scanner(inputStream);
        int count = 0;
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            lines.add(string);
            String[] split = string.split(" ");
            String studentId = split[0];
            int courseId = Integer.parseInt(split[1]);
            double score = Double.parseDouble(split[2]);
            if(duplicate.contains(string))
                continue;
            duplicate.add(string);
            ++count;
            if (!studentMap.containsKey(studentId)) {
                ArrayList<Double> list = new ArrayList<>();
                list.add(score);
                studentMap.put(studentId, list);
            } else {
                studentMap.get(studentId).add(score);
            }
            if (!courseMap.containsKey(courseId)) {
                ArrayList<Double> list = new ArrayList<>();
                list.add(score);
                courseMap.put(courseId, list);
            } else {
                courseMap.get(courseId).add(score);
            }
        }
        this.count = count;
    }

    @Override
    public Grade load(int lineNumber) {
        if (lineNumber > count)
            return null;
        Grade grade = new Grade();
        String[] split = lines.get(lineNumber - 1).split(" ");
        grade.setStudentId(split[0]);
        grade.setCourseCode(Integer.parseInt(split[1]));
        grade.setScore(Double.parseDouble(split[2]));
        return grade;
    }

    @Override
    public void save(Grade score) {
        String string = score.getStudentId() + " "
                + score.getCourseCode() + " " + score.getScore();
        if(duplicate.contains(string))
            return;
        try {
            outputStream.write(string.getBytes());
            inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            duplicate.add(string);
            ++count;
            lines.add(string);
            String[] split = string.split(" ");
            String studentId = split[0];
            int courseId = Integer.parseInt(split[1]);
            double scoree = Double.parseDouble(split[2]);
            if (!studentMap.containsKey(studentId)) {
                ArrayList<Double> list = new ArrayList<>();
                list.add(scoree);
                studentMap.put(studentId, list);
            } else {
                studentMap.get(studentId).add(scoree);
            }
            if (!courseMap.containsKey(courseId)) {
                ArrayList<Double> list = new ArrayList<>();
                list.add(scoree);
                courseMap.put(courseId, list);
            } else {
                courseMap.get(courseId).add(scoree);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double calcCourseAverage(int courseCode) {
        Double[] scores = courseMap.get(courseCode).toArray(new Double[0]);
        double avg = 0;
        for (Double score : scores) {
            avg += score;
        }
        return avg / scores.length;
    }

    @Override
    public double calcStudentAverage(String studentId) {
        Double[] scores = studentMap.get(studentId).toArray(new Double[0]);
        double avg = 0;
        for (Double score : scores) {
            avg += score;
        }
        return avg / scores.length;
    }

    @Override
    public int count() {
        return count;
    }
}
