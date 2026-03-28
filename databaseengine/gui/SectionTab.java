package databaseengine.gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SectionTab extends javax.swing.JPanel {

    // In-memory list to store sections temporarily (no DB yet)
    private ArrayList<String[]> sectionList = new ArrayList<>();

    public SectionTab() {
        initComponents();

        // Populate fields when a row is selected — same as StudentTab
        SeT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    SeT_TableSelectionChanged(e);
                }
            }
        });
    }

    private void initComponents() {

        SeT_LeftPanel = new javax.swing.JPanel();
        SeT_CourseYear = new javax.swing.JLabel();
        SeT_NumOfStudents = new javax.swing.JLabel();
        SeT_SubjectCode = new javax.swing.JLabel();
        SeT_CourseYearField = new javax.swing.JComboBox<>();
        SeT_NumOfStudentsField = new javax.swing.JTextField();
        SeT_SubjectCodeField = new javax.swing.JTextField();
        SeT_Add = new javax.swing.JButton();
        SeT_Update = new javax.swing.JButton();
        SeT_Delete = new javax.swing.JButton();
        SeT_Clear = new javax.swing.JButton();
        SeT_RightPanel = new javax.swing.JPanel();
        SeT_RightScrollPane = new javax.swing.JScrollPane();
        SeT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        SeT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        SeT_CourseYear.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_CourseYear.setForeground(new java.awt.Color(250, 247, 245));
        SeT_CourseYear.setText("Course Year");

        SeT_NumOfStudents.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_NumOfStudents.setForeground(new java.awt.Color(250, 247, 245));
        SeT_NumOfStudents.setText("Number of Students");

        SeT_SubjectCode.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_SubjectCode.setForeground(new java.awt.Color(250, 247, 245));
        SeT_SubjectCode.setText("Subject Code");

        SeT_CourseYearField.setBackground(new java.awt.Color(250, 247, 245));
        SeT_CourseYearField.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"1st Year", "2nd Year", "3rd Year", "4th Year"}));

        // Integer-only filter for Number of Students
        SeT_NumOfStudentsField.setBackground(new java.awt.Color(250, 247, 245));
        ((javax.swing.text.PlainDocument) SeT_NumOfStudentsField.getDocument())
            .setDocumentFilter(new javax.swing.text.DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String string,
                        javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                    if (string.matches("\\d+")) super.insertString(fb, offset, string, attr);
                }
                @Override
                public void replace(FilterBypass fb, int offset, int length, String string,
                        javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
                    if (string.matches("\\d*")) super.replace(fb, offset, length, string, attr);
                }
            });

        SeT_SubjectCodeField.setBackground(new java.awt.Color(250, 247, 245));

        SeT_Add.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_Add.setText("Add");
        SeT_Add.addActionListener(this::SeT_AddActionPerformed);

        SeT_Update.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_Update.setText("Update");
        SeT_Update.addActionListener(this::SeT_UpdateActionPerformed);

        SeT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_Delete.setText("Delete");
        SeT_Delete.addActionListener(this::SeT_DeleteActionPerformed);

        SeT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_Clear.setText("Clear");
        SeT_Clear.addActionListener(this::SeT_ClearActionPerformed);

        javax.swing.GroupLayout SeT_LeftPanelLayout = new javax.swing.GroupLayout(SeT_LeftPanel);
        SeT_LeftPanel.setLayout(SeT_LeftPanelLayout);
        SeT_LeftPanelLayout.setHorizontalGroup(
            SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeT_LeftPanelLayout.createSequentialGroup()
                .addGroup(SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeT_LeftPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(SeT_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SeT_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SeT_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SeT_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SeT_LeftPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SeT_CourseYearField, 0, 306, Short.MAX_VALUE)
                            .addComponent(SeT_CourseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeT_SubjectCodeField, 0, 306, Short.MAX_VALUE)
                            .addComponent(SeT_SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeT_NumOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeT_NumOfStudentsField))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        SeT_LeftPanelLayout.setVerticalGroup(
            SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeT_LeftPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(SeT_CourseYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeT_CourseYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(SeT_NumOfStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeT_NumOfStudentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(SeT_SubjectCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeT_SubjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeT_Add)
                    .addComponent(SeT_Update)
                    .addComponent(SeT_Delete)
                    .addComponent(SeT_Clear))
                .addGap(14, 14, 14))
        );

        SeT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        SeT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Course Year", "Number of Students", "Subject Code"}
        ));
        SeT_RightScrollPane.setViewportView(SeT_Table);

        javax.swing.GroupLayout SeT_RightPanelLayout = new javax.swing.GroupLayout(SeT_RightPanel);
        SeT_RightPanel.setLayout(SeT_RightPanelLayout);
        SeT_RightPanelLayout.setHorizontalGroup(
            SeT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        SeT_RightPanelLayout.setVerticalGroup(
            SeT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeT_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SeT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SeT_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SeT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    // ADD — validates fields, checks for duplicate, adds to list and table
    private void SeT_AddActionPerformed(java.awt.event.ActionEvent evt) {
        String courseYear = SeT_CourseYearField.getSelectedItem().toString();
        String numOfStudents = SeT_NumOfStudentsField.getText().trim();
        String subjectCode = SeT_SubjectCodeField.getText().trim();

        if (numOfStudents.isEmpty() || subjectCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check duplicate: same Course Year + Subject Code
        for (String[] section : sectionList) {
            if (section[0].equals(courseYear) && section[2].equals(subjectCode)) {
                JOptionPane.showMessageDialog(this,
                    "A section with the same Course Year and Subject Code already exists.",
                    "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Add to in-memory list
        sectionList.add(new String[]{courseYear, numOfStudents, subjectCode});

        // Add to table
        DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();
        model.addRow(new Object[]{courseYear, numOfStudents, subjectCode});

        SeT_ClearActionPerformed(evt);
    }

    // UPDATE — updates selected row in list and table
    private void SeT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = SeT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String courseYear = SeT_CourseYearField.getSelectedItem().toString();
        String numOfStudents = SeT_NumOfStudentsField.getText().trim();
        String subjectCode = SeT_SubjectCodeField.getText().trim();

        if (numOfStudents.isEmpty() || subjectCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Update in-memory list
        sectionList.set(selectedRow, new String[]{courseYear, numOfStudents, subjectCode});

        // Update table
        DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();
        model.setValueAt(courseYear, selectedRow, 0);
        model.setValueAt(numOfStudents, selectedRow, 1);
        model.setValueAt(subjectCode, selectedRow, 2);

        JOptionPane.showMessageDialog(this, "Updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // DELETE — removes selected row from list and table
    private void SeT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = SeT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Remove from in-memory list
        sectionList.remove(selectedRow);

        // Remove from table
        DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Deleted successfully!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
        SeT_ClearActionPerformed(evt);
    }

    // CLEAR — resets all fields
    private void SeT_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        SeT_NumOfStudentsField.setText("");
        SeT_SubjectCodeField.setText("");
        SeT_CourseYearField.setSelectedIndex(0);
        SeT_Table.clearSelection();
    }

    // ROW SELECTION — clicking a row fills the fields (same as StudentTab)
    private void SeT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = SeT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();

            String courseYear    = (String) model.getValueAt(selectedRow, 0);
            String numOfStudents = (String) model.getValueAt(selectedRow, 1);
            String subjectCode   = (String) model.getValueAt(selectedRow, 2);

            SeT_CourseYearField.setSelectedItem(courseYear);
            SeT_NumOfStudentsField.setText(numOfStudents);
            SeT_SubjectCodeField.setText(subjectCode);
        } else {
            SeT_ClearActionPerformed(null);
        }
    }

    private javax.swing.JButton SeT_Add;
    private javax.swing.JButton SeT_Clear;
    private javax.swing.JLabel SeT_CourseYear;
    private javax.swing.JComboBox<String> SeT_CourseYearField;
    private javax.swing.JButton SeT_Delete;
    private javax.swing.JPanel SeT_LeftPanel;
    private javax.swing.JLabel SeT_NumOfStudents;
    private javax.swing.JTextField SeT_NumOfStudentsField;
    private javax.swing.JPanel SeT_RightPanel;
    private javax.swing.JScrollPane SeT_RightScrollPane;
    private javax.swing.JLabel SeT_SubjectCode;
    private javax.swing.JTextField SeT_SubjectCodeField;
    private javax.swing.JTable SeT_Table;
    private javax.swing.JButton SeT_Update;
}