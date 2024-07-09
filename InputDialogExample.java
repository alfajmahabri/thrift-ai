import javax.swing.*;

public class InputDialogExample {
    public static void main(String[] args) {
        // Show an input dialog and get the user's input
        String name = JOptionPane.showInputDialog(null, "Enter your name:", "Input Dialog", JOptionPane.PLAIN_MESSAGE);
        
        // Check if the user provided input
        if (name != null && !name.trim().isEmpty()) {
            // Show a message dialog with the entered name
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!", "Greeting", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Show a message dialog if no input was provided
            JOptionPane.showMessageDialog(null, "No name entered!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
