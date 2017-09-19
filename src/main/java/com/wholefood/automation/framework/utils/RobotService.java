package com.wholefood.automation.framework.utils;

import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by PaxoStudent on 3/31/2017.
 */
public class RobotService {
    private static RobotService instance = null;
    private Robot robot = null;
    private int defaultGuiDelay = 1000;

    private RobotService() {
        try {
            robot = new Robot();
            robot.setAutoDelay(1000);
            robot.setAutoWaitForIdle(true);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static RobotService getInstance() {
        if (instance == null) {
            instance = new RobotService();
            instance.setAutoDelay(40);
            instance.setAutoWaitForIdle(true);
        }
        return instance;
    }

    public void setAutoDelay(int ms) {
        robot.setAutoDelay(ms);
    }

    public int getAutoDelay() {
        return robot.getAutoDelay();
    }

    public void setAutoWaitForIdle(boolean wait) {
        robot.setAutoWaitForIdle(wait);
    }

    public int getDefaultGuiDelay() {
        return defaultGuiDelay;
    }

    public void setDefaultGuiDelay(int defaultGuiDelay) {
        this.defaultGuiDelay = defaultGuiDelay;
    }

    public void mouseMove(Point point) {
        try {
            robot.mouseMove(point.x, point.y);
            robot.delay(defaultGuiDelay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(Point point) {
        try {
            mouseMove(point);
            robot.mousePress(MouseModifiers.MOUSE_LEFT);
            robot.delay(getDefaultGuiDelay());
            robot.mouseRelease(MouseModifiers.MOUSE_LEFT);
            robot.delay(getDefaultGuiDelay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(Point point, int mouseModifiers) {
        try {
            mouseMove(point);
            robot.mousePress(mouseModifiers);
            robot.delay(getDefaultGuiDelay());
            robot.mouseRelease(mouseModifiers);
            robot.delay(getDefaultGuiDelay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doubleClick(Point point) {
        try {
            mouseMove(point);
            robot.mousePress(MouseModifiers.MOUSE_LEFT);
            robot.delay(50);
            robot.mouseRelease(MouseModifiers.MOUSE_LEFT);
            robot.delay(50);
            robot.mousePress(MouseModifiers.MOUSE_LEFT);
            robot.delay(50);
            robot.mouseRelease(MouseModifiers.MOUSE_LEFT);
            robot.delay(getDefaultGuiDelay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keyPress(int keyCode) {
        robot.delay(40);
        robot.keyPress(keyCode);
    }

    public void keyRelease(int keyCode) {
        robot.delay(40);
        robot.keyRelease(keyCode);
    }

    public void type(int keycode) {
        robot.delay(40);
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
    }

    public void type(String s) {
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            int code = b;
            // keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
            robot.delay(40);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

    public void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }

    public void pastFromClipbord() {
        robot.delay(40);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void pressEnterKey() {
        robot.delay(40);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void pressTabKey(){
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }
    public void pressTabKey(int numberOfTimes){
        for(int i = 1; i <= numberOfTimes; i++) {
            pressTabKey();
        }
    }
    public void delayFor(int timeInmili){
        try {
            Thread.sleep(timeInmili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public byte[] takeScreenshot() {

        byte[] imageInByte = null;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        Rectangle rectangle = new Rectangle(0, 0, screenSize.width,
                screenSize.height);

        try {
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(rectangle);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            imageInByte = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return imageInByte;
    }

    public String takeScreenshot(String path){

        String imageFileName = null;
        byte[] img = takeScreenshot();

        if(!path.endsWith(File.separator)){
            path = path + File.separator;
        }

        File dir  = new File(path);

        if(dir.isDirectory()){
            FileOutputStream fos = null;
            try {
                FileUtils.forceMkdir(dir);
                String fileName = PaxoUtils.getUniqueFileName("Screenshot", "png");
                imageFileName = path + fileName ;
                fos = new FileOutputStream(imageFileName);
                fos.write(img);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        else{
            throw new RuntimeException("Path is not found: " + path);
        }

        return imageFileName;

    }

    public String takeScreenshot(String path,String fileNameStartsWith){

        String imageFileName = null;
        byte[] img = takeScreenshot();

        if(!path.endsWith(File.separator)){
            path = path + File.separator;
        }

        File dir  = new File(path);

        if(dir.isDirectory()){
            FileOutputStream fos = null;
            try {
                FileUtils.forceMkdir(dir);
                String fileName = PaxoUtils.getUniqueFileName(fileNameStartsWith, "png");
                imageFileName = path + fileName ;
                fos = new FileOutputStream(imageFileName);
                fos.write(img);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        else{
            throw new RuntimeException("Path is not found: " + path);
        }

        return imageFileName;

    }



    public static void main(String[] args) {

        RobotService robot = RobotService.getInstance();
        //System.out.println(robot.takeScreenshot("C:\\MyDevelopment"));
        //robot.click(new Point(235, 355));

        //RobotService robot2 = RobotService.getInstance();
        // robot2.type("Hello world");
        //robot2.click(new Point(1900, 10));
        //robot2.type(KeyEvent.VK_TAB);
        //robot2.type(KeyEvent.VK_ENTER);
    }
}
