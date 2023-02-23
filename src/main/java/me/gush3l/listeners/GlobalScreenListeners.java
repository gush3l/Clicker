package me.gush3l.listeners;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;
import me.gush3l.MainGUI;
import me.gush3l.Settings;

import javax.swing.*;
import java.awt.*;

public class GlobalScreenListeners implements NativeMouseInputListener, NativeKeyListener {

    public static void startListeners() {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException e) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        GlobalScreenListeners globalScreenListeners = new GlobalScreenListeners();
        GlobalScreen.addNativeMouseListener(globalScreenListeners);
        GlobalScreen.addNativeKeyListener(globalScreenListeners);
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        if (e.getButton() != NativeMouseEvent.BUTTON1) return;
        if (Settings.IGNORE_CLICK) return;
        Window activeWindow = FocusManager.getCurrentManager().getActiveWindow();
        if (!(activeWindow instanceof JFrame)) {
            Settings.CLICKER_ON = true;
            Settings.START_TIME_MILLIS = System.currentTimeMillis();
        }
        else Settings.CLICKER_ON = false;
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        if (e.getButton() != NativeMouseEvent.BUTTON1) return;
        if (Settings.IGNORE_CLICK) return;
        Settings.CLICKER_ON = false;
        Settings.START_TIME_MILLIS = 0;
        Settings.CLICK_COUNTER = 1;
        MainGUI.MAIN_FRAME.setTitle("Clicker | OFF | CPS 0");
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.getKeyCode() == Settings.TOGGLE_KEY_CODE) {
            Settings.SWITCH_CLICKER = !Settings.SWITCH_CLICKER;
            if (Settings.SWITCH_CLICKER) {
                MainGUI.TOGGLE_BUTTON.setText("Turn Off");
                ClickerTimer.CLICKER_CHECK_TIMER_TASK.cancel();
                ClickerTimer.startRepeatedTask();
            }
            else {
                MainGUI.TOGGLE_BUTTON.setText("Turn On");
                ClickerTimer.CLICKER_CHECK_TIMER_TASK.cancel();
                ClickerTimer.startRepeatedTask();
            }
        }
    }

}
