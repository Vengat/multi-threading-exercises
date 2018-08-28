package com.vengat.tuts;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OperateLift implements Runnable {
    private ArrayList<Lift> lifts = new ArrayList<>();

    public OperateLift(ArrayList<Lift> lifts) throws Exception {
        this.lifts = lifts;
    }



    public Lift getAvailableLift() {
        return lifts.get(0);
    }

    public void  useLift(Lift lift) {

    }


    @Override
    public void run() {
        Lift lift = getAvailableLift();
        synchronized (lift) {
            lift.boardLift();
        }
    }

    public static void main(String[] args) throws Exception {
        final Lift lift1 = new Lift(14, -1, 12);
        final Lift lift2 = new Lift(14, -1, 12);
        final Lift lift3 = new Lift(14, -1, 12);
        ArrayList<Lift> lifts = new ArrayList<>();
        lifts.add(lift1);
        lifts.add(lift2);
        lifts.add(lift3);

        final OperateLift operateLift = new OperateLift(lifts);

        /*
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();
        Person person7 = new Person();
        */

        Thread person1 = new Thread(operateLift);
        person1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Lift lift = operateLift.getAvailableLift();
                synchronized (lift) {
                    try {
                        lift.open();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Lift lift = operateLift.getAvailableLift();
                synchronized (lift) {
                    try {
                        lift.enter();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        //The number of threads in the thread pool could be the max number of people allowed to board a lift at any point in time
        //So everyone doing some operation on the lift is a distinct possibility
        //Assuming 10
        ExecutorService lift1Pool = Executors.newFixedThreadPool(10);

        lift1Pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    lift1.enter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
