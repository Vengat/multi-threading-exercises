package com.vengat.digital_clock;

import com.vengat.MyTimer;

public class MyMinutes implements Runnable {

    private MyTimer myTimer;

    public MyMinutes(MyTimer myTimer) {
        this.myTimer = myTimer;
    }

    @Override
    public void run() {
        synchronized (myTimer) {
            while(MyVariables.UPDATE_MINUTES) {
                if(myTimer.getMyMinutes() > 58) MyVariables.UPDATE_HOURS = true;
                myTimer.incrementMinutes();
                MyVariables.UPDATE_MINUTES = false;
                if(MyVariables.UPDATE_HOURS) {
                    MyVariables.UPDATE_SECONDS = false;
                } else {
                    MyVariables.UPDATE_SECONDS = true;
                }
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
