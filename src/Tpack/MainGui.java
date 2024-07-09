package Tpack;
import java.awt.*;
import javax.swing.*;

public class MainGui extends JFrame {
    public MainGui() {
        setTitle("Thrift Ai");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        // Create and add the panels to the frame
        add(new Panel1());
        add(new Panel2());
        add(new Panel3());
        add(new Panel4());
        setVisible(true);
    }
}
