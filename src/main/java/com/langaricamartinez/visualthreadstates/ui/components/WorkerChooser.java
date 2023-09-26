package com.langaricamartinez.visualthreadstates.ui.components;

import com.langaricamartinez.visualthreadstates.Worker;

import javax.swing.*;

public class WorkerChooser extends JComboBox<Worker> {
    public WorkerChooser() {
        super();
        setRenderer((list, value, index, isSelected, cellHasFocus) -> {
            if (value == null) return new JLabel();
            return new JLabel(value.getName());
        });
    }

}
