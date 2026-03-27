package databaseengine.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;

public class EnrollmentTab extends javax.swing.JPanel {

    public EnrollmentTab() {
        initComponents();
        populateInitialData();
        adjustColumnWidths();
        
        ET_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    ET_TableSelectionChanged(e);
                }
            }
        });
    }

    private void initComponents() {

        ET_LeftPanel = new javax.swing.JPanel();
        ET_Student = new javax.swing.JLabel();
        ET_StudentName = new javax.swing.JLabel();
        ET_Program = new javax.swing.JLabel();
        ET_SchoolYear = new javax.swing.JLabel();
        ET_Term = new javax.swing.JLabel();
        ET_DateAdmitted = new javax.swing.JLabel();
        ET_StudentField = new javax.swing.JTextField();
        ET_StudentNameField = new javax.swing.JTextField();
        ET_Search = new javax.swing.JButton();
        ET_ProgramField = new javax.swing.JComboBox<>();
        ET_SchoolYearField = new javax.swing.JTextField();
        ET_TermField = new javax.swing.JComboBox<>();
        ET_DateAdmittedField = new javax.swing.JSpinner(new javax.swing.SpinnerDateModel());
        javax.swing.JSpinner.DateEditor admittedDateEditor = new javax.swing.JSpinner.DateEditor(ET_DateAdmittedField, "yyyy-MM-dd");
        ET_DateAdmittedField.setEditor(admittedDateEditor);
        ET_DateAdmittedField.setValue(new java.util.Date());
        ET_Add = new javax.swing.JButton();
        ET_Update = new javax.swing.JButton();
        ET_Delete = new javax.swing.JButton();
        ET_Clear = new javax.swing.JButton();
        ET_RightPanel = new javax.swing.JPanel();
        ET_RightScrollPane = new javax.swing.JScrollPane();
        ET_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        ET_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        ET_Student.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Student.setForeground(new java.awt.Color(250, 247, 245));
        ET_Student.setText("Student ID");

        ET_StudentName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_StudentName.setForeground(new java.awt.Color(250, 247, 245));
        ET_StudentName.setText("Student Name");

        ET_Program.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Program.setForeground(new java.awt.Color(250, 247, 245));
        ET_Program.setText("Program");

        ET_SchoolYear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_SchoolYear.setForeground(new java.awt.Color(250, 247, 245));
        ET_SchoolYear.setText("School Year");

        ET_Term.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Term.setForeground(new java.awt.Color(250, 247, 245));
        ET_Term.setText("Term");

        ET_DateAdmitted.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_DateAdmitted.setForeground(new java.awt.Color(250, 247, 245));
        ET_DateAdmitted.setText("Date Admitted");

        ET_StudentField.setBackground(new java.awt.Color(250, 247, 245));

        ET_StudentNameField.setBackground(new java.awt.Color(250, 247, 245));

        ET_Search.setBackground(new java.awt.Color(210, 180, 140));
        ET_Search.setText("Search");
        ET_Search.addActionListener(this::ET_SearchActionPerformed);

        ET_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        ET_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor of Science in Computer Science", "Bachelor of Science in Information Technology", "Bachelor of Science in Information Systems" }));

        ET_SchoolYearField.setEditable(false);
        ET_SchoolYearField.setBackground(new java.awt.Color(250, 247, 245));
        ET_SchoolYearField.setText("2025-2026");

        ET_TermField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Term", "2nd Term" }));

        ET_Add.setBackground(new java.awt.Color(210, 180, 140));
        ET_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Add.setText("Add");
        ET_Add.addActionListener(this::ET_AddActionPerformed);

        ET_Update.setBackground(new java.awt.Color(210, 180, 140));
        ET_Update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Update.setText("Update");
        ET_Update.addActionListener(this::ET_UpdateActionPerformed);

        ET_Delete.setBackground(new java.awt.Color(210, 180, 140));
        ET_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Delete.setText("Delete");
        ET_Delete.addActionListener(this::ET_DeleteActionPerformed);

        ET_Clear.setBackground(new java.awt.Color(210, 180, 140));
        ET_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Clear.setText("Clear");
        ET_Clear.addActionListener(this::ET_ClearActionPerformed);

        javax.swing.GroupLayout ET_LeftPanelLayout = new javax.swing.GroupLayout(ET_LeftPanel);
        ET_LeftPanel.setLayout(ET_LeftPanelLayout);
        ET_LeftPanelLayout.setHorizontalGroup(
            ET_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ET_LeftPanelLayout.createSequentialGroup()
                .addGroup(ET_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ET_LeftPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ET_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ET_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ET_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ET_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ET_LeftPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(ET_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ET_Term, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_DateAdmitted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_SchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ET_LeftPanelLayout.createSequentialGroup()
                                .addComponent(ET_StudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ET_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .addComponent(ET_StudentNameField, 0, 306, Short.MAX_VALUE)
                            .addComponent(ET_ProgramField, 0, 306, Short.MAX_VALUE)
                            .addComponent(ET_TermField, 0, 306, Short.MAX_VALUE)
                            .addComponent(ET_DateAdmittedField)
                            .addComponent(ET_SchoolYearField))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ET_LeftPanelLayout.setVerticalGroup(
            ET_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ET_LeftPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ET_Student)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ET_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ET_StudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ET_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ET_StudentName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_StudentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ET_Program)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ET_SchoolYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_SchoolYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ET_Term)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_TermField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ET_DateAdmitted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_DateAdmittedField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ET_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ET_Add)
                    .addComponent(ET_Update)
                    .addComponent(ET_Delete)
                    .addComponent(ET_Clear))
                .addGap(14, 14, 14))
        );

        ET_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        ET_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                // Rows will be populated by populateInitialData()
            },
            new String [] {
                "Student ID", "Student Name", "Program", "School Year", "Term", "Date Admitted"
            }
        ));
        ET_RightScrollPane.setViewportView(ET_Table);

        javax.swing.GroupLayout ET_RightPanelLayout = new javax.swing.GroupLayout(ET_RightPanel);
        ET_RightPanel.setLayout(ET_RightPanelLayout);
        ET_RightPanelLayout.setHorizontalGroup(
            ET_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ET_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ET_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        ET_RightPanelLayout.setVerticalGroup(
            ET_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ET_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ET_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ET_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ET_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ET_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ET_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void populateInitialData() {
        DefaultTableModel model = (DefaultTableModel) ET_Table.getModel();
        model.addRow(new Object[]{"REC-001", "Mary Suello", "Bachelor of Science in Computer Science", "2025-2026", "1st Term", "2025-06-15"});
        model.addRow(new Object[]{"REC-002", "John Doe", "Bachelor of Science in Information Technology", "2025-2026", "1st Term", "2025-06-16"});
        model.addRow(new Object[]{"REC-003", "Mark Santos", "Bachelor of Science in Information Systems", "2025-2026", "2nd Term", "2025-11-05"});
    }

    private void adjustColumnWidths() {
        TableColumnModel columnModel = ET_Table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100); // ID
        columnModel.getColumn(1).setPreferredWidth(200); // Name
        columnModel.getColumn(2).setPreferredWidth(300); // Program
        columnModel.getColumn(3).setPreferredWidth(100); // SY
        columnModel.getColumn(4).setPreferredWidth(80);  // Term
        columnModel.getColumn(5).setPreferredWidth(120); // Date
    }

    private void ET_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = ET_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) ET_Table.getModel();
            ET_StudentField.setText(model.getValueAt(selectedRow, 0).toString());
            ET_StudentNameField.setText(model.getValueAt(selectedRow, 1).toString());
            ET_ProgramField.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
            ET_SchoolYearField.setText(model.getValueAt(selectedRow, 3).toString());
            ET_TermField.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
            
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(model.getValueAt(selectedRow, 5).toString());
                ET_DateAdmittedField.setValue(date);
            } catch (ParseException ex) {
                System.err.println("Error parsing date: " + ex.getMessage());
            }
        }
    }

    private void ET_AddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String id = ET_StudentField.getText().trim();
        String name = ET_StudentNameField.getText().trim();
        String program = ET_ProgramField.getSelectedItem().toString();
        String sy = ET_SchoolYearField.getText();
        String term = ET_TermField.getSelectedItem().toString();
        
        Date admittedDate = (Date) ET_DateAdmittedField.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(admittedDate);

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Student ID.");
            return;
        }
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Student Name.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) ET_Table.getModel();
        model.addRow(new Object[]{id, name, program, sy, term, date});
        
        JOptionPane.showMessageDialog(this, "Successfully added!");
        ET_ClearActionPerformed(null);
    }                                      

    private void ET_SearchActionPerformed(java.awt.event.ActionEvent evt) {
        String studentID = ET_StudentField.getText().trim();
        if (studentID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Student ID.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) ET_Table.getModel();
        boolean found = false;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).toString().equalsIgnoreCase(studentID)) {
                ET_Table.setRowSelectionInterval(i, i);
                ET_Table.scrollRectToVisible(ET_Table.getCellRect(i, 0, true));
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Student ID " + studentID + " not found in the list.");
        }
    }

    private void ET_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedRow = ET_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) ET_Table.getModel();
        model.setValueAt(ET_StudentField.getText(), selectedRow, 0);
        model.setValueAt(ET_StudentNameField.getText(), selectedRow, 1);
        model.setValueAt(ET_ProgramField.getSelectedItem().toString(), selectedRow, 2);
        model.setValueAt(ET_SchoolYearField.getText(), selectedRow, 3);
        model.setValueAt(ET_TermField.getSelectedItem().toString(), selectedRow, 4);
        
        Date admittedDate = (Date) ET_DateAdmittedField.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model.setValueAt(sdf.format(admittedDate), selectedRow, 5);

        JOptionPane.showMessageDialog(this, "Successfully updated!");
    }                                         

    private void ET_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedRow = ET_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) ET_Table.getModel();
        model.removeRow(selectedRow);
        JOptionPane.showMessageDialog(this, "Successfully deleted!");
        ET_ClearActionPerformed(null);
    }                                         

    private void ET_ClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ET_StudentField.setText("");
        ET_StudentNameField.setText("");
        ET_ProgramField.setSelectedIndex(0);
        ET_TermField.setSelectedIndex(0);
        ET_DateAdmittedField.setValue(new Date());
        ET_Table.clearSelection();
    }                                        

    private javax.swing.JButton ET_Add;
    private javax.swing.JButton ET_Clear;
    private javax.swing.JLabel ET_DateAdmitted;
    private javax.swing.JSpinner ET_DateAdmittedField;
    private javax.swing.JButton ET_Delete;
    private javax.swing.JPanel ET_LeftPanel;
    private javax.swing.JLabel ET_Program;
    private javax.swing.JComboBox<String> ET_ProgramField;
    private javax.swing.JPanel ET_RightPanel;
    private javax.swing.JScrollPane ET_RightScrollPane;
    private javax.swing.JLabel ET_SchoolYear;
    private javax.swing.JTextField ET_SchoolYearField;
    private javax.swing.JLabel ET_Term;
    private javax.swing.JComboBox<String> ET_TermField;
    private javax.swing.JLabel ET_Student;
    private javax.swing.JLabel ET_StudentName;
    private javax.swing.JTextField ET_StudentField;
    private javax.swing.JTextField ET_StudentNameField;
    private javax.swing.JButton ET_Search;
    private javax.swing.JTable ET_Table;
    private javax.swing.JButton ET_Update;
}