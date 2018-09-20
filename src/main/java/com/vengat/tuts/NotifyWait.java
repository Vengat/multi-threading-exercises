package com.vengat.tuts;

public class NotifyWait {

    public static void main(String[] args) throws InterruptedException {

        Message message = new Message("Start");
        WaitingThread waitingThread = new WaitingThread(message);
        NotifyingThread notifyingThread = new NotifyingThread(message);
        Thread first_thread = new Thread(waitingThread, "first_thread");
        Thread second_thread = new Thread(notifyingThread, "second_thread");
        first_thread.start();
        second_thread.start();

        //first_thread.join();
        //second_thread.join();

        System.out.println("End of main thread");

    }

}
