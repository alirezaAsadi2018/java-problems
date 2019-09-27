package ir.javacup.salary;


import static ir.javacup.salary.SalaryListCreator.addZeroPrefix;

public class Main {
    public static void main(String[] args) {
        System.out.println(addZeroPrefix("1234", 8));
        System.out.println(addZeroPrefix("0234", 8));
        System.out.println(addZeroPrefix("12345678", 8));
    }
}
