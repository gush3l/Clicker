package me.gush3l;

import me.gush3l.enums.ClickType;
import me.gush3l.utils.RandomCollection;

public class Settings {

    public static Boolean CLICKER_ON = false;

    public static Boolean IGNORE_CLICK = false;

    public static Boolean SWITCH_CLICKER = false;

    public static int CLICK_DELAY = 100;

    public static int RANDOM_DELAY_RANGE = 25;

    public static long CLICK_COUNTER = 1;

    public static long START_TIME_MILLIS;

    public static int JITTER_AMOUNT = 5;

    public static int TOGGLE_KEY_CODE = 62;

    public static final RandomCollection<Object> CLICK_TYPE = new RandomCollection<>()
            .add(50, ClickType.NORMAL)
            .add(5, ClickType.SKIP)
            .add(20, ClickType.DOUBLE);

}
