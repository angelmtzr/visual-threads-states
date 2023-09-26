package com.langaricamartinez.visualthreadstates.ui;

import com.langaricamartinez.visualthreadstates.ui.components.CustomProgressBar;
import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import java.awt.*;

public class ProgressBarPanel extends JPanel implements DraculaTheme {
    public ProgressBarPanel() {
        super(new CardLayout());
        setPreferredSize(new Dimension(150, 0));
        add(new CustomProgressBar());
    }
}
