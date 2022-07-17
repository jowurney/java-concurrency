package Concurrency1;

import static Concurrency1.ThreadColor.*;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from thread 2");

        int time = (int) (Math.random() * 10000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "EXCEPTION");
        }

        System.out.println(ANSI_BLUE + time/1000 + " seconds passes?");
    }
}
