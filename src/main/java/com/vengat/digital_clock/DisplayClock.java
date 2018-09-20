package com.vengat.digital_clock;


import com.vengat.MyTimer;

public class DisplayClock implements Runnable {
    private MyTimer myTimer;

    public DisplayClock(MyTimer myTimer) {
        this.myTimer = myTimer;
    }

    public void displayClock() {
        while(true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(this.myTimer.getTime());
        }
    }

    @Override
    public void run() {
        synchronized (myTimer) {
            displayClock();
            try {
                myTimer.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myTimer.notifyAll();
        }

    }

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        DisplayClock displayClock = new DisplayClock(myTimer);
        MySeconds mySeconds = new MySeconds(myTimer);
        MyMinutes myMinutes = new MyMinutes(myTimer);
        MyHours myHours = new MyHours(myTimer);

        Thread secondsThread = new Thread(mySeconds, "Seconds");
        Thread minutesThread = new Thread(myMinutes, "Minutes");
        Thread hoursThread = new Thread(myHours, "Hours");
        Thread displayTime = new Thread(displayClock, "Clock");

        secondsThread.start();
        minutesThread.start();
        hoursThread.start();
        displayTime.start();

    }


}
