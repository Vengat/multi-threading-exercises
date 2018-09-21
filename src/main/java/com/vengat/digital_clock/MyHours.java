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
            while(MyVariables.UPDATE_HOURS) {
                myTimer.incrementHours();
                MyVariables.UPDATE_HOURS = false;
                MyVariables.UPDATE_MINUTES = false;
                MyVariables.UPDATE_SECONDS = true;
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
