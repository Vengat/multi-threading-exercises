package com.vengat.tuts;

public class NotifyingThread implements Runnable {

    private Message message;

    public NotifyingThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

        synchronized (message) {
            try {
                Thread.sleep(5000);
                message.setMessage(Thread.currentThread().getName());
                message.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
