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
            while(true) {
                if (myTimer.getMySeconds() == 0) myTimer.incrementMinutes();
                try {
                    myTimer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myTimer.notifyAll();
            }

//            if(myTimer.getMyMinutes() == 0) {
//                try {
//                    myTimer.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                myTimer.notifyAll();
//            }
        }

    }
}
