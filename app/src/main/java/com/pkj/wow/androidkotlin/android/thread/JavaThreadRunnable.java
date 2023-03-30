package com.pkj.wow.androidkotlin.android.thread;

public class JavaThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("PLOG: JavaThreadRunnable->run: " + Thread.currentThread().getName());

    }
}
