package ir.javacup.thread;

import java.util.concurrent.Semaphore;

public class Resource {

    private int content;
    private Semaphore semaphore = new Semaphore(0);

    public int get() {
        try {
            semaphore.acquire();
            return content;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void set(int value) {
        content = value;
        semaphore.release();
    }

}
