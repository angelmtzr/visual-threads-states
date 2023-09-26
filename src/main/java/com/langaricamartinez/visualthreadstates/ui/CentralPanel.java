package com.langaricamartinez.visualthreadstates.ui;

import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends JPanel implements DraculaTheme {
    public CentralPanel() {
        setBackground(LIGHT_GREY);
        setLayout(new GridBagLayout());
        ImageIcon imageIcon = new ImageIcon("construction.png");
        var label = new JLabel(imageIcon);
        add(label);
    }
}