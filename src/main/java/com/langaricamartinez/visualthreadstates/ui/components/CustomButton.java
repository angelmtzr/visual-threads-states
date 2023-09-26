package com.langaricamartinez.visualthreadstates.ui.components;

import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton implements DraculaTheme {
    public CustomButton(String text, Color bgColor) {
        super(text);
        setBackground(bgColor);
        setFocusable(false);
        setForeground(DARK_GREY);
    }
}