package com.langaricamartinez.visualthreadstates.ui;

import com.langaricamartinez.visualthreadstates.Worker;
import com.langaricamartinez.visualthreadstates.ui.components.CustomButton;
import com.langaricamartinez.visualthreadstates.ui.components.WorkerChooser;
import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import java.awt.*;

import static com.langaricamartinez.visualthreadstates.Worker.Action.*;
import static java.lang.Thread.State.NEW;
import static java.lang.Thread.State.TIMED_WAITING;

public class ControlPanel extends JPanel implements DraculaTheme {
    public ControlPanel(WorkersPanel workersPanel) {
        setBackground(DARK_GREY);

        var newWorkerNameLbl = new JLabel("New worker name: ");
        newWorkerNameLbl.setForeground(SOFT_WHITE);
        var newWorkerNameTxtField = new JTextField();
        newWorkerNameTxtField.setPreferredSize(new Dimension(100, 25));
        var newWorkerBtn = new CustomButton("New worker", GREEN);
        var workerChooser = new WorkerChooser();
        var restBtn = new CustomButton("Rest", CYAN);
        var workBtn = new CustomButton("Work", ORANGE);
        var quitBtn = new CustomButton("Quit", RED);

        newWorkerBtn.addActionListener(e -> {
            // Exit if empty name or no vacant available
            if (newWorkerNameTxtField.getText().isEmpty() || workersPanel.isFull())
                return;
            var worker = new Worker(newWorkerNameTxtField.getText());
            workersPanel.newWorker(worker);
            workerChooser.insertItemAt(worker, worker.getId());
            workerChooser.setSelectedIndex(worker.getId());
        });

        restBtn.addActionListener(e -> {
            if (workersPanel.isEmpty())
                return;
            Worker worker = (Worker) workerChooser.getSelectedItem();
            if (worker == null || worker.getThread().getState() == NEW)
                return;
            worker.action = REST; // Runnable -> Timed Waiting
            workersPanel.setWorkerAsResting(workerChooser.getSelectedIndex());
        });

        workBtn.addActionListener(e -> {
            if (workersPanel.isEmpty())
                return;
            Worker worker = (Worker) workerChooser.getSelectedItem();
            if (worker == null)
                return;
            worker.action = WORK;
            if (worker.getThread().getState() == NEW) {
                worker.startWorking(); // New -> Runnable
            } else if (worker.getThread().getState() == TIMED_WAITING) {
                worker.getThread().interrupt(); // Timed Waiting -> Runnable
            }
            workersPanel.setWorkerAsWorking(workerChooser.getSelectedIndex());
        });

        quitBtn.addActionListener(e -> {
            if (workersPanel.isEmpty())
                return;
            Worker worker = (Worker) workerChooser.getSelectedItem();
            if (worker == null)
                return;
            if (worker.getThread().getState() == TIMED_WAITING) {
                worker.getThread().interrupt(); // Timed Waiting -> Terminated
            }
            worker.action = QUIT; // Runnable -> Terminated
            workersPanel.disposeWorker(worker);
            workerChooser.removeItemAt(workerChooser.getSelectedIndex());
        });

        add(newWorkerNameLbl);
        add(newWorkerNameTxtField);
        add(newWorkerBtn);
        add(workerChooser);
        add(restBtn);
        add(workBtn);
        add(quitBtn);
    }
}