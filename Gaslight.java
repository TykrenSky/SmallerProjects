import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Gaslight {
   
   public static void main(String[] args) throws AWTException, IOException {
      Robot robot = new Robot();
      robot.delay(1000);
      robot.setAutoDelay(40);
      Runtime.getRuntime().exec("notepad");
      robot.delay(1000);
      type("this is really fast hopefully yeeeeeeeeeet nlkajdiaJdsanbifosuahfanjfs,hdbasfdjabfs");
   }
   
   public static void type(String s) throws AWTException {
      Robot robot = new Robot();
      robot.setAutoDelay(1);
      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         if (c != ':') {
            if (Character.isUpperCase(c)) {
               robot.keyPress(KeyEvent.VK_SHIFT);
            }
            robot.keyPress(Character.toUpperCase(c));
            robot.keyRelease(Character.toUpperCase(c));
            if (Character.isUpperCase(c)) {
               robot.keyRelease(KeyEvent.VK_SHIFT);
            }
         } else {
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(59);
            robot.keyRelease(59);
            robot.keyRelease(KeyEvent.VK_SHIFT);
         }
      }
   }
   
   public static void enter() throws AWTException {
      Robot robot = new Robot();
      robot.setAutoDelay(40);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
   }
} 