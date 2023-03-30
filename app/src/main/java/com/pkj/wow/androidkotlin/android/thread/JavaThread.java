package com.pkj.wow.androidkotlin.android.thread;
/*
https://www.geeksforgeeks.org/lifecycle-and-states-of-a-thread-in-java/
 */
public class JavaThread extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("PLOG: JavaThread->run: " + Thread.currentThread().getName());
    }
}


