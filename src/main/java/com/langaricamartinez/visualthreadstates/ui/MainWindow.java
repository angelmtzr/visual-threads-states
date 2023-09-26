package com.langaricamartinez.visualthreadstates.ui;

import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements DraculaTheme {
    public MainWindow() {
        super("Visual Thread States");
        setSize(600, 600); // Default size when not maximized
        setExtendedState(MAXIMIZED_BOTH); // Maximize window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        var workersPanel = new WorkersPanel();
        getContentPane().add(workersPanel, BorderLayout.SOUTH);
        getContentPane().add(new ControlPanel(workersPanel), BorderLayout.NORTH);
        getContentPane().add(new CentralPanel(), BorderLayout.CENTER);
        getContentPane().add(new ProgressBarPanel(), BorderLayout.WEST);
        getContentPane().add(new InfoPanel(), BorderLayout.EAST);

        setVisible(true);
    }
}
