package Tpack;
import java.awt.*;
import javax.swing.*;

public class Panel2 extends JPanel{
    private JTextArea textArea;
    public Panel2(){
        JLabel panelhead = new JLabel();
        panelhead.setText("Ai Suggestion");
        panelhead.setFont(new Font("Serif", Font.BOLD, 20));
        add(panelhead);
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    public void updateContent(String content) {
        textArea.setText(content);
    }
}
