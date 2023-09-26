package com.langaricamartinez.visualthreadstates.ui;

import com.langaricamartinez.visualthreadstates.ui.components.CustomLabel;
import com.langaricamartinez.visualthreadstates.ui.themes.DraculaTheme;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel implements DraculaTheme {

    public InfoPanel() {
        super();
        setBackground(DARK_GREY);
        setPreferredSize(new Dimension(320, 0));
        ImageIcon UP_LOGO = new ImageIcon("up_logo.png");
        add(new JLabel(UP_LOGO));
        add(new CustomLabel("Ingeniería en Sistemas y Gráficas Computacionales"));
        add(new CustomLabel("Docente: Dr. Juan Carlos López Pimentel"));
        add(new CustomLabel("Ángel Martínez Rodríguez"));
        add(new CustomLabel("0235347"));
        add(new CustomLabel("Juan Samuel Langarica Mejía"));
        add(new CustomLabel("0228930"));
        add(new CustomLabel("Martes 26 de septiembre de 2023"));
    }
}
