import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Greeter implements ActionListener {

    Runnable;
    Supplier;
    Predicate;
    IntConsumer;
    public void greet() {
        System.out.println("hello bo!");
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}

class TimdedGreeter extends Greeter {
    public void greet(){
        Timer t = new Timer(1000, super::greet);
        t.start();
    }
}

public class MethodRefTest {
    public static void main(String[] args) {
        TimdedGreeter tg = new TimdedGreeter();
        tg.greet();
    }
}