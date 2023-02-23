package me.gush3l.utils;

import java.util.Random;

public class Util {

    public static int getRandomInRange(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

}
