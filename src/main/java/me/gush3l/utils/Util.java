package me.gush3l.utils;

import java.util.Random;

public class Util {

    public static int getRandomInRange(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    public static int getKeyCode(String keyString) {
        switch (keyString) {
            case "Undefined": return 0;
            case "Escape": return 1;
            case "1": return 2;
            case "2": return 3;
            case "3": return 4;
            case "4": return 5;
            case "5": return 6;
            case "6": return 7;
            case "7": return 8;
            case "8": return 9;
            case "9": return 10;
            case "0": return 11;
            case "Minus": return 12;
            case "Equals": return 13;
            case "Backspace": return 14;
            case "Tab": return 15;
            case "Q": return 16;
            case "W": return 17;
            case "E": return 18;
            case "R": return 19;
            case "T": return 20;
            case "Y": return 21;
            case "U": return 22;
            case "I": return 23;
            case "O": return 24;
            case "P": return 25;
            case "Open Bracket": return 26;
            case "Close Bracket": return 27;
            case "Enter": return 28;
            case "Ctrl": return 29;
            case "A": return 30;
            case "S": return 31;
            case "D": return 32;
            case "F": return 33;
            case "G": return 34;
            case "H": return 35;
            case "J": return 36;
            case "K": return 37;
            case "L": return 38;
            case "Semicolon": return 39;
            case "Quote": return 40;
            case "Back Quote": return 41;
            case "Shift": return 42;
            case "Back Slash": return 43;
            case "Z": return 44;
            case "X": return 45;
            case "C": return 46;
            case "V": return 47;
            case "B": return 48;
            case "N": return 49;
            case "M": return 50;
            case "Comma": return 51;
            case "Period": return 52;
            case "Slash": return 53;
            case "Alt": return 56;
            case "Space": return 57;
            case "Caps Lock": return 58;
            case "F1": return 59;
            case "F2": return 60;
            case "F3": return 61;
            case "F4": return 62;
            case "F5": return 63;
            case "F6": return 64;
            case "F7": return 65;
            case "F8": return 66;
            case "F9": return 67;
            case "F10": return 68;
            case "Num Lock": return 69;
            case "Scroll Lock": return 70;
            case "NumPad ,": return 83;
            case "F11": return 87;
            case "F12": return 88;
            case "F13": return 91;
            case "F14": return 92;
            case "F15": return 93;
            case "F16": return 99;
            case "F17": return 100;
            case "F18": return 101;
            case "F19": return 102;
            case "F20": return 103;
            case "F21": return 104;
            case "F22": return 105;
            case "F23": return 106;
            case "F24": return 107;
            case "Katakana": return 112;
            case "Underscore": return 115;
            case "Furigana": return 119;
            case "Kanji": return 121;
            case "Hiragana": return 123;
            case "¥": return 125;
        }
        return 0;
    }

}
