package com.vengat.digital_clock;

import com.vengat.MyTimer;

public class MySeconds implements Runnable {

    private MyTimer myTimer;

    public MySeconds(MyTimer myTimer) {
        this.myTimer = myTimer;
    }

    @Override
    public void run() {
        synchronized (myTimer) {
            while(true) {
                myTimer.incrementSeconds();
                if(myTimer.getMySeconds() == 0) {
                    try {
                        myTimer.wait();
                        myTimer.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
