package com.langaricamartinez.visualthreadstates.ui.components;

import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class CustomProgressBar extends JProgressBar implements DraculaTheme {
    public CustomProgressBar() {
        super(JProgressBar.VERTICAL);
        setStringPainted(true);
        setValue(80);
        setFont(new Font("", Font.BOLD, 15));
        setForeground(GREEN);
        setBackground(LIGHT_GREY);
        setUI(new BasicProgressBarUI() {
            @Override
            protected Color getSelectionForeground() {
                return DARK_GREY;
            }

            @Override
            protected Color getSelectionBackground() {
                return SOFT_WHITE;
            }
        });
    }
}
