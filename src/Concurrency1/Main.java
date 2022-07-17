package Concurrency1;

import java.util.TreeMap;

import static Concurrency1.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "hi");

        Thread thread2 = new AnotherThread();
        thread2.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "From anonymouse thread class");
            }
        }.start();

        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();

        Thread anonRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_BLACK + "ANON RUNNABLE");

                try {
                    System.out.println(ANSI_BLACK + "annon runnable waiting for thread2 to finish");
                    thread2.join();
                    System.out.println(ANSI_BLACK + "anon runnable woke up, continue operation");
                }  catch (Exception e) {
                    System.out.println(ANSI_RED + "Interrupted exception");
                }
            }
        });

        anonRunnableThread.start();



        System.out.println("From main hi");
    }

}
