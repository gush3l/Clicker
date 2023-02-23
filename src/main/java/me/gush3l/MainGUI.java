package me.gush3l;

import me.gush3l.listeners.ClickerTimer;

import javax.swing.*;
import java.awt.*;

public class MainGUI {

    public static JFrame MAIN_FRAME;

    public static JButton TOGGLE_BUTTON;

    public static void startGUI() {
        MAIN_FRAME = new JFrame("Clicker | OFF | CPS 0");
        MAIN_FRAME.getContentPane().setLayout(null);
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MAIN_FRAME.setSize(350,200);
        MAIN_FRAME.setResizable(false);
        Insets insets = MAIN_FRAME.getContentPane().getInsets();

        TOGGLE_BUTTON = new JButton("Turn On");
        Dimension size = TOGGLE_BUTTON.getPreferredSize();
        TOGGLE_BUTTON.setBounds(100 + insets.left, 100 + insets.top,
                size.width + 50, size.height + 20);
        TOGGLE_BUTTON.addActionListener(e -> {
            Settings.SWITCH_CLICKER = !Settings.SWITCH_CLICKER;
            if (Settings.SWITCH_CLICKER) {
                TOGGLE_BUTTON.setText("Turn Off");
                ClickerTimer.CLICKER_CHECK_TIMER_TASK.cancel();
                ClickerTimer.startRepeatedTask();
            }
            else {
                TOGGLE_BUTTON.setText("Turn On");
                ClickerTimer.CLICKER_CHECK_TIMER_TASK.cancel();
                ClickerTimer.startRepeatedTask();
            }
        });

        SpinnerModel clickDelayModel = new SpinnerNumberModel(Settings.CLICK_DELAY, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);

        JLabel clickDelayLabel = new JLabel("Click Delay");
        size = clickDelayLabel.getPreferredSize();
        clickDelayLabel.setBounds(10 + insets.left, 10 + insets.top,
                size.width, size.height);
        JSpinner clickDelaySpinner = new JSpinner(clickDelayModel);
        clickDelaySpinner.addChangeListener(change -> {
            Settings.CLICK_DELAY = (int) clickDelaySpinner.getValue();
            Settings.CLICKER_ON = false;
            Settings.START_TIME_MILLIS = 0;
            Settings.CLICK_COUNTER = 1;
            MAIN_FRAME.setTitle("Clicker | OFF | CPS 0");
            Settings.SWITCH_CLICKER = false;
            TOGGLE_BUTTON.setText("Turn On");
            ClickerTimer.CLICKER_CHECK_TIMER_TASK.cancel();
            ClickerTimer.startRepeatedTask();
        });
        size = clickDelaySpinner.getPreferredSize();
        clickDelaySpinner.setBounds(200 + insets.left, 10 + insets.top,
                size.width-50, 20);

        SpinnerModel randomDelayRangeModel = new SpinnerNumberModel(Settings.RANDOM_DELAY_RANGE, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);

        JLabel randomDelayRangeLabel = new JLabel("Random Delay Range");
        size = randomDelayRangeLabel.getPreferredSize();
        randomDelayRangeLabel.setBounds(10 + insets.left, 40 + insets.top,
                size.width, size.height);
        JSpinner randomDelayRangeSpinner = new JSpinner(randomDelayRangeModel);
        randomDelayRangeSpinner.addChangeListener(change -> {
            Settings.RANDOM_DELAY_RANGE = (int) randomDelayRangeSpinner.getValue();
            Settings.CLICKER_ON = false;
            Settings.START_TIME_MILLIS = 0;
            Settings.CLICK_COUNTER = 1;
            MAIN_FRAME.setTitle("Clicker | OFF | CPS 0");
            Settings.SWITCH_CLICKER = false;
            TOGGLE_BUTTON.setText("Turn On");
            ClickerTimer.CLICKER_CHECK_TIMER_TASK.cancel();
            ClickerTimer.startRepeatedTask();
        });
        size = randomDelayRangeSpinner.getPreferredSize();
        randomDelayRangeSpinner.setBounds(200 + insets.left, 40 + insets.top,
                size.width-50, 20);

        SpinnerModel jitterAmountModel = new SpinnerNumberModel(Settings.JITTER_AMOUNT, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);

        JLabel jitterAmountLabel = new JLabel("Jitter Amount");
        size = jitterAmountLabel.getPreferredSize();
        jitterAmountLabel.setBounds(10 + insets.left, 70 + insets.top,
                size.width, size.height);
        JSpinner jitterAmountSpinner = new JSpinner(jitterAmountModel);
        jitterAmountSpinner.addChangeListener(change -> {
            Settings.JITTER_AMOUNT = (int) jitterAmountSpinner.getValue();
            Settings.CLICKER_ON = false;
            Settings.START_TIME_MILLIS = 0;
            Settings.CLICK_COUNTER = 1;
            MAIN_FRAME.setTitle("Clicker | OFF | CPS 0");
            Settings.SWITCH_CLICKER = false;
            TOGGLE_BUTTON.setText("Turn On");
            ClickerTimer.CLICKER_CHECK_TIMER_TASK.cancel();
            ClickerTimer.startRepeatedTask();
        });
        size = jitterAmountSpinner.getPreferredSize();
        jitterAmountSpinner.setBounds(200 + insets.left, 70 + insets.top,
                size.width-50, 20);

        MAIN_FRAME.getContentPane().add(clickDelayLabel);
        MAIN_FRAME.getContentPane().add(clickDelaySpinner);

        MAIN_FRAME.getContentPane().add(randomDelayRangeLabel);
        MAIN_FRAME.getContentPane().add(randomDelayRangeSpinner);

        MAIN_FRAME.getContentPane().add(jitterAmountLabel);
        MAIN_FRAME.getContentPane().add(jitterAmountSpinner);

        MAIN_FRAME.getContentPane().add(TOGGLE_BUTTON);
        MAIN_FRAME.setVisible(true);
    }

}
