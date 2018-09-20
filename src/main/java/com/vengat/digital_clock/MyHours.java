package com.vengat.digital_clock;
import com.vengat.MyTimer;

public class MyHours implements Runnable {

    private MyTimer myTimer;

    public MyHours(MyTimer myTimer) {
        this.myTimer = myTimer;
    }

    @Override
    public void run() {
        synchronized (myTimer) {
            while(true) {
                if(myTimer.getMyMinutes() == 0 && myTimer.getMySeconds() == 0) myTimer.incrementHours();
                try {
                    myTimer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myTimer.notifyAll();
            }
        }

    }
}
