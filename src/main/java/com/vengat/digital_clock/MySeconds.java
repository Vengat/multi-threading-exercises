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
            while(MyVariables.UPDATE_SECONDS) {
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Updating seconds");
                myTimer.incrementSeconds();
                if(myTimer.getMySeconds() == 0) {
                    try {
                        MyVariables.UPDATE_SECONDS = false;
                        MyVariables.UPDATE_MINUTES = true;
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
