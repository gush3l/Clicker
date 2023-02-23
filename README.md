# Clicker

![gui-screenshot](https://img001.prntscr.com/file/img001/qi2Z_jb0TCK8SGz3Ai2-iA.png)

A simple auto clicker that uses JNativeHook to listen for mouse clicks and key strokes. 

Only works for Left-Click. Keep Left-Click pressed and it will start clicking automatically. Release Left-Click and it will stop clicking.

You can toggle it ON or OFF by clicking the "Turn On" button in the GUI or just press F4 on your keyboard.

Increase the jitter amount in order to change the amount of movement of the mouse pointer, set it to 0 in order to make it not "jitter".

There is a chance to skip a click or double click so the CPS is not constant.

Check [this file](https://github.com/gush3l/Clicker/blob/main/src/main/java/me/gush3l/utils/Util.java#L14) to see the key bind strings you can use for the toggle key bind.

**CAUTION:** Don't worry if a DLL file gets created in the directory where you run it, it's being created by JNativeHook.
