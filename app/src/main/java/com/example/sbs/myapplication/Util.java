package com.example.sbs.myapplication;

public class Util {
    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {

            }
        }).start();
    }
}
