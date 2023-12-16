import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest {
    public static void main(String[] args) {

        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

    }
}


class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int  interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter(); // 构造时，自动添加了new TimePrinter(this)把自己的引用传入内部类实例，使其可以访问外部类的数据
        Timer t = new Timer(interval, listener);
        t.start();
    }

    // inner class

    private class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("at the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep(); // if (beep)是内部类访问的自己所属于的外部类示例的beep域，（隐式的，java给TimePrinter每个实例加了一个引用（指向自己所属于的TalkingClock的实例，所以才能访问它的数据）

        }
    }
}
