package Tpack;
import Database.DatabaseOperations;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Panel1 extends JPanel{
    private LinkedList<String> categoryoptions;
    public Panel1(){
        setLayout(new GridLayout(7, 2, 5, 5));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel panelhead = new JLabel();
        panelhead.setText("Entry Panel");
        panelhead.setFont(new Font("Serif", Font.BOLD, 20));
        add(panelhead);

        JLabel emptylabel = new JLabel();
        emptylabel.setText(" ");
        
        JLabel label1 = new JLabel("Enter Title");
        JLabel label2 = new JLabel("Enter Amount");
        JLabel label3 = new JLabel("Select Category");
        
        JTextField title = new JTextField();
        JTextField amount = new JTextField();
       
        //Category 
        categoryoptions = new LinkedList<>();
        categoryoptions.add("Select");
        categoryoptions.add("Food");
        categoryoptions.add("Transport");
        categoryoptions.add("Entertainment");
        categoryoptions.add("Utilities");

        JComboBox <String> category = new JComboBox<>(categoryoptions.toArray(new String[0]));
        category.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) category.getSelectedItem();
                if (selectedCategory.equals("Select")) {
                    JOptionPane.showMessageDialog(Panel1.this, "Please select a valid category", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Radio button to select between expense and income
        JRadioButton income = new JRadioButton("Income");
        JRadioButton expense = new JRadioButton("Expense");
        ButtonGroup group = new ButtonGroup();
        group.add(income);
        group.add(expense);

        //submit , delete , update buttons
        JButton submit = new JButton("Submit");
        JButton delete = new JButton("Delete");
        JButton update = new JButton("Update");
        JButton newCategory = new JButton("Add New Category");


        //Binding to panel
        add(emptylabel);
        add(label1);
        add(title);
        add(label2);
        add(amount);
        add(label3);
        add(category);
        add(income);
        add(expense);
        add(submit);
        add(delete);
        add(update);
        add(newCategory);

        //Implementation of Buttons
        newCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String addcategory = JOptionPane.showInputDialog(null, "Enter Category", "Adding new Category", JOptionPane.PLAIN_MESSAGE);
                categoryoptions.add(addcategory);
                category.addItem(addcategory);
                if (addcategory != null && !addcategory.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Added Category to list : " + addcategory , "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No Category entered", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from UI components
                String titleText = title.getText();
                String amountText = amount.getText();
                String selectedCategory = (String) category.getSelectedItem();
                String type = income.isSelected() ? "Income" : "Expense";
        
                // Validate input
                if (titleText.isEmpty() || amountText.isEmpty() || selectedCategory.equals("Select") || (!income.isSelected() && !expense.isSelected())) {
                    JOptionPane.showMessageDialog(Panel1.this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                // Insert into database
                boolean success = DatabaseOperations.insertEntry(titleText, amountText, selectedCategory, type);
                if (success) {
                    JOptionPane.showMessageDialog(Panel1.this, "Entry saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Panel1.this, "Failed to save entry", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

    
    }
}
