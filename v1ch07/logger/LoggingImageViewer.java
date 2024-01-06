import sun.rmi.runtime.Log;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;


public class LoggingImageViewer {
    public static void main(String[] args) {
        if (System.getProperty("java.util.logging.config.class") == null && System.getProperty("java.util.logging.config.file") == null) {
            // 没有配置类和配置文件情况下
            try {
                Logger lg = Logger.getLogger("com.bo.goodjavaer").setLevel(Level.ALL);
                lg.ex
                final int LOG_RORATION_COUNT = 10;
                Handler hander = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_RORATION_COUNT);
                Logger.getLogger("com.bo.goodjavaer").addHandler(hander);

            } catch (IOException e) {
                Logger.getLogger("com.bo.goodjavaer").log(Level.SEVERE, "can not create log file handler", e);
            }
        }

        //
        EventQueue.invokeLater(() -> {
            Handler windowHandler = new ();
        });

    }
}

class ImageViewerFrame extends JFrame {
    private JComponent imageComponent;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private static Logger logger = Logger.getLogger("com.bo.goodjavaer");

    public ImageViewerFrame() {
        logger.entering("ImageViewerFrame", "<init>");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileO)


    }


    private class FileOpenListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            logger.entering("ImageViewerFrame", "actionPerformed", event);

            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            chooser.setFileFilter();


        }
    }


}

