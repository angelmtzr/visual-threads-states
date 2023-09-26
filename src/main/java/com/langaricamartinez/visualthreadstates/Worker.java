package com.langaricamartinez.visualthreadstates;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.langaricamartinez.visualthreadstates.Worker.Action.*;

public class Worker implements Runnable {
    public enum Action {REST, WORK, QUIT, NONE}
    private int id;
    private final String name;
    public Action action;
    private final Thread thread;

    public Worker(String name) {
        this.name = name;
        action = NONE;
        thread = new Thread(this);
        Logger.getLogger(this.getName()).log(Level.INFO,
                "Worker thread created: " + thread.getState());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Thread getThread() {
        return thread;
    }

    public void startWorking() {
        thread.start(); // New -> Runnable
        Logger.getLogger(this.getName()).log(Level.INFO,
                "Worker thread terminated: " + thread.getState());
    }

    private void rest() {
        try {
            Thread.sleep(999999999); // Here the thread is TIMED_WAITING
        } catch (InterruptedException e) {
            Logger.getLogger(this.getName()).log(Level.INFO, "Worker thread interrupted.");
        }
    }

    @Override
    public void run() {
        while (action != QUIT) { // Runnable -> Terminated
            Logger.getLogger(this.getName()).log(Level.INFO,
                    "Worker thread running: " + thread.getState());
            if (action == REST) {
                rest(); // Runnable -> Timed Waiting
            }
            // TODO: do some work
        }
    }
}
