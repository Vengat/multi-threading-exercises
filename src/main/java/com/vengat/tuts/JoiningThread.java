package com.vengat.tuts;

public class JoiningThread implements Runnable {
    @Override
    public void run() {
        int i = 0;
        while(true) {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
//            for(int j=0; j < 10; j++) {
//                System.out.println(Thread.currentThread().getName());
//            }
            if(i>10) break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread");
        JoiningThread joiningThread = new JoiningThread();
        Thread t1 = new Thread(joiningThread, "First Thread");
        Thread t2 = new Thread(joiningThread, "Second Thread");
        t1.start();
        t2.start();

        t2.join();

        t1.join();

        if(t2.isAlive()) {
            System.out.println(t2.getName() + " is alive");
        } else {
            System.out.println(t2.getName() + " is not alive");
        }

        if(t1.isAlive()) {
            System.out.println(t1.getName() + " is alive");
        } else {
            System.out.println(t1.getName() + " is not alive");
        }

        System.out.println("Main thread exiting");


    }
}
