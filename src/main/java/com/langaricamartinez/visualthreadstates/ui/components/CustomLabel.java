package com.langaricamartinez.visualthreadstates.ui.components;

import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;

public class CustomLabel extends JLabel implements DraculaTheme {
    public CustomLabel(String text) {
        super(text);
        setForeground(SOFT_WHITE);
    }
}