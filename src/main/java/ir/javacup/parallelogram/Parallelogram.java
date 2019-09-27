package ir.javacup.parallelogram;


import java.util.Scanner;
public class Parallelogram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int breadth = scanner.nextInt();
		int height = scanner.nextInt();
		boolean flag = (breadth > 0) && (height > 0);
		if (flag) {
			int area = breadth * height;
			System.out.print("valid\n" + area);
		}
		else
			System.out.print("invalid\n");
	}
}
