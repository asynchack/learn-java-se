import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class TimerTest {
    public static void main(String[] args) {

        ActionListener listener = new TimerPrinter(); // 用接口类型接收

        Timer t  = new Timer(10000, listener);
        t.start();

    }
}

class TimerPrinter implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("at the tone, the time is " + new Date());
    }

}