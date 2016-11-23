package com.github.vatbub.surfacepenfixer;

import common.Common;
import logging.FOKLogger;
import org.apache.commons.lang.SystemUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;

public class Main {

    private static FOKLogger log;

    public static void main(String[] args) {

        Common.setAppName("surfacepenfixer");
        log = new FOKLogger(Main.class.getName());

        String vbsScriptCopy = Common.getAndCreateAppDataPath() + "focusOnenote.vbs";
        String oneNote;

        // Onenote path
        // C:\Program Files (x86)\Microsoft Office\root\Office16\ONENOTE.EXE
        // get oneNote location
        log.getLogger().info("OS Architecture detected as: " + SystemUtils.OS_ARCH);

        if (SystemUtils.OS_ARCH.contains("64")) {
            // 64 bit os
            oneNote = "C:\\Program Files (x86)\\Microsoft Office\\root\\Office16\\ONENOTE.EXE";
        } else {
            // 32 bit os
            oneNote = "C:\\Program Files\\Microsoft Office\\root\\Office16\\ONENOTE.EXE";
        }

        try {
            if (isProcessRunning("ONENOTE.EXE")) {
                // Onenote is already running, create a new page

                // Activate Onenote using a vb script
                // Export vb script
                File vbsScript = new File(vbsScriptCopy);
                if (vbsScript.exists()) {
                    //noinspection ResultOfMethodCallIgnored
                    vbsScript.delete();
                }
                Files.copy(Main.class.getResourceAsStream("focusOnenote.vbs"), vbsScript.toPath());
                Runtime.getRuntime().exec("wscript " + vbsScriptCopy);

                // Send CTRL+N to OneNote
                Robot robot = new Robot();

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_N);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_N);
            } else {
                // Launch Onenote
                ProcessBuilder processBuilder = new ProcessBuilder(oneNote);
                processBuilder.start();
            }
        } catch (IOException | InterruptedException |AWTException e) {
            log.getLogger().log(Level.SEVERE, "An error occurred", e);
        }
    }

    private static boolean isProcessRunning(String processName) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("tasklist.exe");
        Process process = processBuilder.start();
        String tasksList = toString(process.getInputStream());

        return tasksList.contains(processName);
    }

    // http://stackoverflow.com/a/5445161/3764804
    private static String toString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        String string = scanner.hasNext() ? scanner.next() : "";
        scanner.close();

        return string;
    }
}
