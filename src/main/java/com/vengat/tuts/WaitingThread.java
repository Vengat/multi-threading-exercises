package com.vengat.tuts;

public class WaitingThread implements Runnable {

    private Message message;

    public WaitingThread(Message message) {
        this.message = message;
    }

    public void printHello(String message) {
        System.out.println("Thread is  and the message is " + message);
    }

    @Override
    public void run() {

        synchronized (message) {
            if (Thread.currentThread().getName().equalsIgnoreCase("first_thread")) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting to get notified at time:" + System.currentTimeMillis());
                    message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " got notified at time:" + System.currentTimeMillis());
            //printHello(Thread.currentThread().getName());
            //message.setMessage("This is "+Thread.currentThread().getName());


        }

    }

}
