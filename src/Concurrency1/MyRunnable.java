package Concurrency1;

import static Concurrency1.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from runnable");
    }
}
