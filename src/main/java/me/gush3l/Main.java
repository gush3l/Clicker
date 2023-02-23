package me.gush3l;

import me.gush3l.listeners.ClickerTimer;
import me.gush3l.listeners.GlobalScreenListeners;

import java.awt.*;

public class Main {

    public static Robot BOT;

    public static void main(String[] args) {
        MainGUI.startGUI();
        ClickerTimer.startRepeatedTask();
        GlobalScreenListeners.startListeners();
        try {
            BOT = new Robot();
        } catch (AWTException ex) {
            throw new RuntimeException(ex);
        }
    }

}