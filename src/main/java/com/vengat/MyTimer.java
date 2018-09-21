package com.vengat;

public class MyTimer {
    private double mySeconds;
    private double myMinutes;
    private double myHours;

    public MyTimer() {
        this.mySeconds = 0;
        this.myMinutes = 0;
        this.myHours = 0;
    }

    public void incrementSeconds() {
        if(mySeconds > 58) {
            mySeconds = 0;
        } else {
            System.out.println("Secs");
            mySeconds++;
        }
    }

    public void incrementMinutes() {
        if(myMinutes > 58) {
            myMinutes = 0;
        } else {
            myMinutes++;
        }
    }

    public void incrementHours() {
        if(myHours > 22) {
            myHours = 0;
        } else {
            myHours++;
        }
    }

    public String getTime() {
        String mySec = new Double(mySeconds).toString();
        String myMin = new Double(myMinutes).toString();
        String myHr = new Double(myHours).toString();
//        if(mySec.length() == 1) mySec = "0" + mySec;
//        if(myMin.length() == 1) myMin = "0" + myMin;
//        if(myHr.length() == 1) myHr = "0" + myHr;
        return myHr+" : "+myMin+" : "+mySec;
    }

    public double getMySeconds() {
        return mySeconds;
    }

    public void setMySeconds(double mySeconds) {
        this.mySeconds = mySeconds;
    }

    public double getMyMinutes() {
        return myMinutes;
    }

    public void setMyMinutes(double myMinutes) {
        this.myMinutes = myMinutes;
    }

    public double getMyHours() {
        return myHours;
    }

    public void setMyHours(double myHours) {
        this.myHours = myHours;
    }
}
