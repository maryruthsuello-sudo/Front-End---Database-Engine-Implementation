package databaseengine.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TORTab extends javax.swing.JPanel {

    // In-memory list to store TOR records temporarily (no DB yet)
    // Columns: Student, Date Completed
    private ArrayList<String[]> torList = new ArrayList<>();

    public TORTab() {
        initComponents();

        // Populate fields when a row is selected — same as SectionTab
        TT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    TT_TableSelectionChanged(e);
                }
            }
        });
    }

    private void initComponents() {

        TT_LeftPanel = new javax.swing.JPanel();
        TT_Student = new javax.swing.JLabel();
        TT_DateCompleted = new javax.swing.JLabel();
        TT_StudentField = new javax.swing.JTextField();
        TT_DateCompletedField = new javax.swing.JSpinner(new javax.swing.SpinnerDateModel());
        TT_GenerateTOR = new javax.swing.JButton();
        TT_RightPanel = new javax.swing.JPanel();
        TT_RightScrollPane = new javax.swing.JScrollPane();
        TT_Table = new javax.swing.JTable();

        // Date spinner — yyyy-MM-dd format
        javax.swing.JSpinner.DateEditor dateEditor = new javax.swing.JSpinner.DateEditor(TT_DateCompletedField, "yyyy-MM-dd");
        TT_DateCompletedField.setEditor(dateEditor);
        TT_DateCompletedField.setValue(new Date());

        setBackground(new java.awt.Color(130, 65, 72));

        TT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        TT_Student.setFont(new java.awt.Font("Segoe UI", 1, 16));
        TT_Student.setForeground(new java.awt.Color(250, 247, 245));
        TT_Student.setText("Student");

        TT_DateCompleted.setFont(new java.awt.Font("Segoe UI", 1, 16));
        TT_DateCompleted.setForeground(new java.awt.Color(250, 247, 245));
        TT_DateCompleted.setText("Date Completed");

        // Editable student name text field
        TT_StudentField.setBackground(new java.awt.Color(250, 247, 245));

        TT_GenerateTOR.setBackground(new java.awt.Color(210, 180, 140));
        TT_GenerateTOR.setFont(new java.awt.Font("Segoe UI", 1, 18));
        TT_GenerateTOR.setText("Generate TOR");
        TT_GenerateTOR.addActionListener(this::TT_GenerateTORActionPerformed);

        javax.swing.GroupLayout TT_LeftPanelLayout = new javax.swing.GroupLayout(TT_LeftPanel);
        TT_LeftPanel.setLayout(TT_LeftPanelLayout);
        TT_LeftPanelLayout.setHorizontalGroup(
            TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_LeftPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TT_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TT_DateCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TT_GenerateTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TT_DateCompletedField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TT_StudentField, javax.swing.GroupLayout.Alignment.LEADING, 0, 306, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        TT_LeftPanelLayout.setVerticalGroup(
            TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_LeftPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(TT_Student)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TT_StudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(TT_DateCompleted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TT_DateCompletedField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TT_GenerateTOR)
                .addGap(39, 39, 39))
        );

        TT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        // Empty table — no placeholder null rows
        TT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Student", "Date Completed"}
        ));
        TT_RightScrollPane.setViewportView(TT_Table);

        javax.swing.GroupLayout TT_RightPanelLayout = new javax.swing.GroupLayout(TT_RightPanel);
        TT_RightPanel.setLayout(TT_RightPanelLayout);
        TT_RightPanelLayout.setHorizontalGroup(
            TT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        TT_RightPanelLayout.setVerticalGroup(
            TT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TT_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TT_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    // GENERATE TOR — acts as Add: validates, checks duplicate, adds to list and table
    private void TT_GenerateTORActionPerformed(java.awt.event.ActionEvent evt) {
        String student = TT_StudentField.getText().trim();

        Date dateValue = (Date) TT_DateCompletedField.getValue();
        String dateCompleted = new SimpleDateFormat("yyyy-MM-dd").format(dateValue);

        if (student.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a student name.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check duplicate: same student name already in list
        for (String[] entry : torList) {
            if (entry[0].equalsIgnoreCase(student)) {
                JOptionPane.showMessageDialog(this,
                    "A TOR record for \"" + student + "\" already exists.",
                    "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Add to in-memory list
        torList.add(new String[]{student, dateCompleted});

        // Add to table
        DefaultTableModel model = (DefaultTableModel) TT_Table.getModel();
        model.addRow(new Object[]{student, dateCompleted});

        clearFields();
    }

    // ROW SELECTION — clicking a row fills the fields
    private void TT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = TT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) TT_Table.getModel();

            String student      = (String) model.getValueAt(selectedRow, 0);
            String dateCompleted = (String) model.getValueAt(selectedRow, 1);

            TT_StudentField.setText(student);

            try {
                Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateCompleted);
                TT_DateCompletedField.setValue(parsedDate);
            } catch (ParseException ex) {
                System.err.println("Error parsing date: " + ex.getMessage());
            }
        } else {
            clearFields();
        }
    }

    private void clearFields() {
        TT_StudentField.setText("");
        TT_DateCompletedField.setValue(new Date());
        TT_Table.clearSelection();
    }

    private javax.swing.JLabel TT_DateCompleted;
    private javax.swing.JSpinner TT_DateCompletedField;
    private javax.swing.JButton TT_GenerateTOR;
    private javax.swing.JPanel TT_LeftPanel;
    private javax.swing.JPanel TT_RightPanel;
    private javax.swing.JScrollPane TT_RightScrollPane;
    private javax.swing.JLabel TT_Student;
    private javax.swing.JTextField TT_StudentField;
    private javax.swing.JTable TT_Table;
}