package me.gush3l.listeners;

import me.gush3l.Main;
import me.gush3l.MainGUI;
import me.gush3l.Settings;
import me.gush3l.enums.ClickType;
import me.gush3l.utils.Util;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

public class ClickerTimer {

    public static Timer CLICKER_CHECK_TIMER_TASK;

    public static void startRepeatedTask() {
        CLICKER_CHECK_TIMER_TASK = new Timer();

        CLICKER_CHECK_TIMER_TASK.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (Settings.CLICKER_ON && Settings.SWITCH_CLICKER) {
                    MainGUI.MAIN_FRAME.setTitle(String.format("Clicker | %s | CPS %s",Settings.SWITCH_CLICKER ? "ON" : "OFF", String.format("%.2f",(double) Settings.CLICK_COUNTER / ((System.currentTimeMillis()-Settings.START_TIME_MILLIS)/1000.0))));
                    click();
                }
            }
        }, 1000, Settings.CLICK_DELAY+ Util.getRandomInRange(0,Settings.RANDOM_DELAY_RANGE));
    }

    public static void click() {
        Settings.IGNORE_CLICK = true;
        ClickType clickType = (ClickType) Settings.CLICK_TYPE.next();
        switch (clickType) {
            case NORMAL:
                Main.BOT.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                Main.BOT.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Settings.CLICK_COUNTER++;
                break;
            case DOUBLE:
                Main.BOT.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                Main.BOT.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Main.BOT.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                Main.BOT.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Settings.CLICK_COUNTER+=2;
                break;
            case SKIP:
                break;
        }
        if (Settings.JITTER_AMOUNT > 0) {
            Point mouseP = MouseInfo.getPointerInfo().getLocation();
            Main.BOT.mouseMove(mouseP.x+Util.getRandomInRange(-Settings.JITTER_AMOUNT,Settings.JITTER_AMOUNT),mouseP.y+Util.getRandomInRange(-Settings.JITTER_AMOUNT,Settings.JITTER_AMOUNT));
        }
        Settings.IGNORE_CLICK = false;
    }

}
