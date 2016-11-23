# surfacepenfixer
This tool fixes the bug on the Microsoft Surface Pro 3 which makes the Surface Pen unable to launch OneNote 2016 when pressing the button on the Surface Pen.

## Download
We currently don't use GitHub releases and release on Bintray. Click [here](https://bintray.com/vatbub/fokprojectsReleases/surfacePenFixer#downloads) to get the latest version.

## What it does
This program is quite simple: When you launch it and OneNote 2016 is not launched, it will launch OneNote, if OneNote is already launched, it will bring OneNote up and create a new page.

## What it doesn't do
Unfortunately, OneNote has no api to start a screen capture, like it used to be with Windows 8. That's why we cant fix the double click on the Pen to create a new screenshot.

This fix will only work on Windows and only with OneNote 2016. OneNote 2013 is not supported right now, however you may want to [create a new issue](https://github.com/vatbub/surfacepenfixer/issues/new) if you need support for it.

## How to use it
1. Grab the latest version from the download section
2. Save the *.exe file to a location where you can keep it for a longer time (probably not your download folder)
3. Launch the exe-file once to see if everything works. If OneNote starts, everything is fine. If a dialog pops up that you need to install java, go ahead and follow the on-screen instructions to install java and then retry.
4. If you've installed the latest redstone update for Windows 10, go to windows ink ![windows ink icon](https://cdn.rawgit.com/vatbub/surfacepenfixer/master/readmeImages/WindowsInk.PNG).  
If you haven't, download the [Surface App](https://www.microsoft.com/de-de/store/p/surface/9wzdncrfjb8p) from the Windows Store and head over to the "Pen" section of the app.
5. Click "Customize the Pen button"
6. Open the drop-down menu for "Click once"
7. Select "Launch a classic application"
8. Click "Browse"
9. Go to the folder where you saved the app file in, select it and click ok.
10. Now click your surface pen button once to see if it works.
