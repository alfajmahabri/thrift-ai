package Tpack;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Panel3 extends JPanel {

    private DefaultTableModel model;
    private JTable table;
    private String url = "jdbc:mysql://127.0.0.1:3306/thirftai";
    private String user = "root";
    private String password = "";

    public Panel3() {
        setLayout(new BorderLayout());

        // Table settings
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Adding columns to the model
        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Amount");
        model.addColumn("Category");
        model.addColumn("Type");

        // Fetch initial data
        fetchAndUpdateTable();

        // Refresh button
        JButton Refresh = new JButton("Refresh");
        add(Refresh, BorderLayout.SOUTH);
        Refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAndUpdateTable();
            }
        });
    }

    private void fetchAndUpdateTable() {
        // Clear existing rows
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, title, amount, category, type FROM entries")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int amount = rs.getInt("amount");
                String category = rs.getString("category");
                String type = rs.getString("type");
                model.addRow(new Object[]{id, title, amount, category, type});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
