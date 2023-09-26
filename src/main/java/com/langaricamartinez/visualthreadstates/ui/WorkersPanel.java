package com.langaricamartinez.visualthreadstates.ui;

import com.langaricamartinez.visualthreadstates.Worker;
import com.langaricamartinez.visualthreadstates.ui.components.WorkerLabel;
import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import java.awt.*;

public class WorkersPanel extends JPanel implements DraculaTheme {

    private final int MAX_WORKERS = 5;
    public final WorkerLabel[] workerLabels = new WorkerLabel[MAX_WORKERS];
    private final ImageIcon NEW_WORKER_ICON = new ImageIcon("new.png");
    private final ImageIcon RESTING_ICON = new ImageIcon("resting.png");
    private final ImageIcon WORKING_ICON = new ImageIcon("working.png");

    public WorkersPanel() {
        setBackground(DARK_GREY);
        setPreferredSize(new Dimension(0, 200));
        // Create empty labels to later set the icon
        for (int i = 0; i < workerLabels.length; i++) {
            var workerLabel = new WorkerLabel(null);
            workerLabels[i] = workerLabel;
            add(workerLabel);
        }
    }

    public boolean isFull() {
        for (WorkerLabel workerLabel : workerLabels) {
            if (workerLabel.worker == null) {
                return false;
            }
        }
        return true;
    }

    public void newWorker(Worker worker) {
        for (int i = 0; i < workerLabels.length; i++) {
            if (workerLabels[i].worker == null) {
                workerLabels[i].setIcon(NEW_WORKER_ICON);
                worker.setId(i);
                workerLabels[i].worker = worker;
                return;
            }
        }
    }

    public void setWorkerAsResting(int workerId) {
        workerLabels[workerId].setIcon(RESTING_ICON);
    }

    public void setWorkerAsWorking(int workerId) {
        workerLabels[workerId].setIcon(WORKING_ICON);
    }

    public void disposeWorker(Worker worker) {
        for (WorkerLabel workerlabel : workerLabels) {
            if (workerlabel.worker == worker) {
                workerlabel.worker = null;
                workerlabel.setIcon(null);
                return;
            }
        }
    }

    public boolean isEmpty() {
        for (WorkerLabel workerLabel : workerLabels) {
            if (workerLabel.worker != null) {
                return false;
            }
        }
        return true;
    }
}
