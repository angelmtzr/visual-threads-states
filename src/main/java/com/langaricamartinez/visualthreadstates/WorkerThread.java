package com.langaricamartinez.visualthreadstates;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.langaricamartinez.visualthreadstates.WorkerThread.Action.*;

public class WorkerThread extends Thread {
    public enum Action {REST, WORK, QUIT, NONE}
    public Action action;


    public WorkerThread(String name) {
        super(name);
        action = NONE;
        Logger.getLogger(this.getName()).log(Level.INFO,
                "Worker thread created: " + getState());
    }

    public void startWorking() {
        start(); // New -> Runnable
        Logger.getLogger(this.getName()).log(Level.INFO,
                "Worker thread terminated: " + getState());
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
                    "Worker thread running: " + getState());
            if (action == REST) {
                rest(); // Runnable -> Timed Waiting
            }
            // TODO: do some work
        }
    }
}
