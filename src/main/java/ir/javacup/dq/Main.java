package ir.javacup.dq;

public class Main {
    public static void main(String[] args) {
        DequeUtil<Integer> dequeUtil = new DequeUtilImpl<>();
        for(int i=0; i<6; i++)
            dequeUtil.getDeque().push(i);
        System.out.println(dequeUtil.getDeque());
    }
}
