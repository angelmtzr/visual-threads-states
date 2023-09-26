package com.langaricamartinez.visualthreadstates.ui.components;

import com.langaricamartinez.visualthreadstates.Worker;

import javax.swing.*;

public class WorkerLabel extends JLabel {
    public Worker worker;

    public WorkerLabel(Worker worker) {
        this.worker = worker;
    }
}
