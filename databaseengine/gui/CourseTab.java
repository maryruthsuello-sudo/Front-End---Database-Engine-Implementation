package databaseengine.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class CourseTab extends javax.swing.JPanel {

    public CourseTab() {
        initComponents();

        // Add selection listener to the table to sync with input fields
        CT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    CT_TableSelectionChanged(e);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        CT_LeftPanel = new javax.swing.JPanel();
        CT_Program = new javax.swing.JLabel();
        CT_StudentID = new javax.swing.JLabel();
        CT_SubjectCode = new javax.swing.JLabel();
        CT_Units = new javax.swing.JLabel();
        CT_DescriptiveTitle = new javax.swing.JLabel();
        CT_Grade = new javax.swing.JLabel();
        CT_Time = new javax.swing.JLabel();
        CT_Term = new javax.swing.JLabel();
        CT_DateSubmitted = new javax.swing.JLabel();
        CT_ProgramField = new javax.swing.JComboBox<>();
        CT_StudentIDField = new javax.swing.JTextField();
        CT_SubjectCodeField = new javax.swing.JTextField();
        CT_UnitsField = new javax.swing.JTextField();
        CT_DescriptiveTitleField = new javax.swing.JTextField();
        CT_GradeField = new javax.swing.JTextField();
        CT_TimeField = new javax.swing.JTextField();
        CT_TermField = new javax.swing.JComboBox<>();
        CT_DateSubmittedField = new javax.swing.JSpinner(new javax.swing.SpinnerDateModel());
        CT_Add = new javax.swing.JButton();
        CT_Update = new javax.swing.JButton();
        CT_Delete = new javax.swing.JButton();
        CT_Clear = new javax.swing.JButton();
        CT_Clear.addActionListener(this::CT_ClearActionPerformed);
        CT_RightPanel = new javax.swing.JPanel();
        CT_RightScrollPane = new javax.swing.JScrollPane();
        CT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        CT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        CT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Program.setForeground(new java.awt.Color(250, 247, 245));
        CT_Program.setText("Program");

        CT_StudentID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_StudentID.setForeground(new java.awt.Color(250, 247, 245));
        CT_StudentID.setText("Student ID");

        CT_SubjectCode.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_SubjectCode.setForeground(new java.awt.Color(250, 247, 245));
        CT_SubjectCode.setText("Subject Code");

        CT_Units.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Units.setForeground(new java.awt.Color(250, 247, 245));
        CT_Units.setText("Units");

        CT_DescriptiveTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_DescriptiveTitle.setForeground(new java.awt.Color(250, 247, 245));
        CT_DescriptiveTitle.setText("Descriptive Title");

        CT_Grade.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Grade.setForeground(new java.awt.Color(250, 247, 245));
        CT_Grade.setText("Grade");

        CT_Time.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Time.setForeground(new java.awt.Color(250, 247, 245));
        CT_Time.setText("Time");

        CT_Term.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Term.setForeground(new java.awt.Color(250, 247, 245));
        CT_Term.setText("Term");

        CT_DateSubmitted.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_DateSubmitted.setForeground(new java.awt.Color(250, 247, 245));
        CT_DateSubmitted.setText("Date Submitted");

        CT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        CT_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor of Science in Computer Science", "Bachelor of Science in Information Technology", "Bachelor of Science in Information Systems" }));

        CT_StudentIDField.setBackground(new java.awt.Color(250, 247, 245));
        CT_StudentIDField.addActionListener(this::CT_StudentIDFieldActionPerformed);

        CT_SubjectCodeField.setBackground(new java.awt.Color(250, 247, 245));

        CT_UnitsField.setBackground(new java.awt.Color(250, 247, 245));
        CT_UnitsField.addActionListener(this::CT_UnitsFieldActionPerformed);

        CT_DescriptiveTitleField.setBackground(new java.awt.Color(250, 247, 245));
        CT_DescriptiveTitleField.addActionListener(this::CT_DescriptiveTitleFieldActionPerformed);

        CT_GradeField.setBackground(new java.awt.Color(250, 247, 245));

        CT_TimeField.setBackground(new java.awt.Color(250, 247, 245));
        CT_TimeField.addActionListener(this::CT_TimeFieldActionPerformed);

        CT_TermField.setBackground(new java.awt.Color(250, 247, 245));
        CT_TermField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Sem", "2nd Sem" }));

        javax.swing.JSpinner.DateEditor dateEditor = new javax.swing.JSpinner.DateEditor(CT_DateSubmittedField, "yyyy-MM-dd");
        CT_DateSubmittedField.setEditor(dateEditor);
        CT_DateSubmittedField.setValue(new java.util.Date());

        CT_Add.setBackground(new java.awt.Color(210, 180, 140));
        CT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Add.setText("Add");
        CT_Add.addActionListener(this::CT_AddActionPerformed);

        CT_Update.setBackground(new java.awt.Color(210, 180, 140));
        CT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Update.setText("Update");
        CT_Update.addActionListener(this::CT_UpdateActionPerformed);

        CT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        CT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Delete.setText("Delete");
        CT_Delete.addActionListener(this::CT_DeleteActionPerformed);

        CT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        CT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Clear.setText("Clear");

        javax.swing.GroupLayout CT_LeftPanelLayout = new javax.swing.GroupLayout(CT_LeftPanel);
        CT_LeftPanel.setLayout(CT_LeftPanelLayout);
        CT_LeftPanelLayout.setHorizontalGroup(
            CT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CT_LeftPanelLayout.createSequentialGroup()
                .addGroup(CT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CT_LeftPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(CT_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CT_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CT_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CT_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CT_LeftPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(CT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CT_DateSubmitted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_Term, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_DescriptiveTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_Units, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_DescriptiveTitleField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_TimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_TermField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CT_ProgramField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CT_UnitsField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_GradeField)
                            .addComponent(CT_DateSubmittedField)
                            .addComponent(CT_SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_SubjectCodeField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CT_StudentIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        CT_LeftPanelLayout.setVerticalGroup(
            CT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CT_LeftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CT_Program)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_StudentID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_StudentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_SubjectCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_SubjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(CT_Units)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_UnitsField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_DescriptiveTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_DescriptiveTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_Grade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_GradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_Time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_Term)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_TermField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_DateSubmitted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_DateSubmittedField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CT_Add)
                    .addComponent(CT_Update)
                    .addComponent(CT_Delete)
                    .addComponent(CT_Clear))
                .addGap(14, 14, 14))
        );

        CT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        CT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Program", "Student ID", "Subject Code", "Units", "Title", "Grade", "Time", "Term", "Date Submitted"
            }
        ));
        CT_Table.getColumnModel().getColumn(0).setPreferredWidth(400); // Program
        CT_Table.getColumnModel().getColumn(1).setPreferredWidth(120); // Student ID
        CT_Table.getColumnModel().getColumn(2).setPreferredWidth(120); // Subject Code
        CT_Table.getColumnModel().getColumn(3).setPreferredWidth(80);  // Units
        CT_Table.getColumnModel().getColumn(4).setPreferredWidth(300); // Title
        CT_Table.getColumnModel().getColumn(5).setPreferredWidth(80);  // Grade
        CT_Table.getColumnModel().getColumn(6).setPreferredWidth(120); // Time
        CT_Table.getColumnModel().getColumn(7).setPreferredWidth(120); // Term
        CT_Table.getColumnModel().getColumn(8).setPreferredWidth(150); // Date Submitted
        CT_RightScrollPane.setViewportView(CT_Table);

        javax.swing.GroupLayout CT_RightPanelLayout = new javax.swing.GroupLayout(CT_RightPanel);
        CT_RightPanel.setLayout(CT_RightPanelLayout);
        CT_RightPanelLayout.setHorizontalGroup(
            CT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        CT_RightPanelLayout.setVerticalGroup(
            CT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CT_RightScrollPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CT_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CT_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void CT_AddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String program = (String) CT_ProgramField.getSelectedItem();
        String studentID = CT_StudentIDField.getText().trim();
        String subjectCode = CT_SubjectCodeField.getText().trim();
        String units = CT_UnitsField.getText().trim();
        String title = CT_DescriptiveTitleField.getText().trim();
        String grade = CT_GradeField.getText().trim();
        String time = CT_TimeField.getText().trim();
        String term = (String) CT_TermField.getSelectedItem();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateSubmitted = sdf.format((Date) CT_DateSubmittedField.getValue());

        if (studentID.isEmpty() || subjectCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID and Subject Code are required.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
        model.addRow(new Object[]{program, studentID, subjectCode, units, title, grade, time, term, dateSubmitted});

        JOptionPane.showMessageDialog(this, "Successfully Added!");
        CT_ClearActionPerformed(null);
    }                                      

    private void CT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedRow = CT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
        model.setValueAt(CT_ProgramField.getSelectedItem(), selectedRow, 0);
        model.setValueAt(CT_StudentIDField.getText(), selectedRow, 1);
        model.setValueAt(CT_SubjectCodeField.getText(), selectedRow, 2);
        model.setValueAt(CT_UnitsField.getText(), selectedRow, 3);
        model.setValueAt(CT_DescriptiveTitleField.getText(), selectedRow, 4);
        model.setValueAt(CT_GradeField.getText(), selectedRow, 5);
        model.setValueAt(CT_TimeField.getText(), selectedRow, 6);
        model.setValueAt(CT_TermField.getSelectedItem(), selectedRow, 7);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model.setValueAt(sdf.format((Date) CT_DateSubmittedField.getValue()), selectedRow, 8);

        JOptionPane.showMessageDialog(this, "Successfully Updated!");
    }                                         

    private void CT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedRow = CT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Successfully Deleted!");
        CT_ClearActionPerformed(null);
    }                                         

    private void CT_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        CT_ProgramField.setSelectedIndex(0);
        CT_StudentIDField.setText("");
        CT_SubjectCodeField.setText("");
        CT_UnitsField.setText("");
        CT_DescriptiveTitleField.setText("");
        CT_GradeField.setText("");
        CT_TimeField.setText("");
        CT_TermField.setSelectedIndex(0);
        CT_DateSubmittedField.setValue(new Date());
        CT_Table.clearSelection();
    }

    private void CT_DescriptiveTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    private void CT_TimeFieldActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void CT_UnitsFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void CT_StudentIDFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void CT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = CT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
            
            CT_ProgramField.setSelectedItem(model.getValueAt(selectedRow, 0));
            CT_StudentIDField.setText((String) model.getValueAt(selectedRow, 1));
            CT_SubjectCodeField.setText((String) model.getValueAt(selectedRow, 2));
            CT_UnitsField.setText((String) model.getValueAt(selectedRow, 3));
            CT_DescriptiveTitleField.setText((String) model.getValueAt(selectedRow, 4));
            CT_GradeField.setText((String) model.getValueAt(selectedRow, 5));
            CT_TimeField.setText((String) model.getValueAt(selectedRow, 6));
            CT_TermField.setSelectedItem(model.getValueAt(selectedRow, 7));
            String dateStr = (String) model.getValueAt(selectedRow, 8);

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                CT_DateSubmittedField.setValue(sdf.parse(dateStr));
            } catch (ParseException ex) {
                System.err.println("Error parsing date: " + ex.getMessage());
            }
        }
    }

    private javax.swing.JButton CT_Add;
    private javax.swing.JButton CT_Clear;
    private javax.swing.JLabel CT_DateSubmitted;
    private javax.swing.JSpinner CT_DateSubmittedField;
    private javax.swing.JButton CT_Delete;
    private javax.swing.JLabel CT_DescriptiveTitle;
    private javax.swing.JTextField CT_DescriptiveTitleField;
    private javax.swing.JLabel CT_Grade;
    private javax.swing.JTextField CT_GradeField;
    private javax.swing.JPanel CT_LeftPanel;
    private javax.swing.JLabel CT_Program;
    private javax.swing.JComboBox<String> CT_ProgramField;
    private javax.swing.JPanel CT_RightPanel;
    private javax.swing.JScrollPane CT_RightScrollPane;
    private javax.swing.JLabel CT_StudentID;
    private javax.swing.JTextField CT_StudentIDField;
    private javax.swing.JLabel CT_SubjectCode;
    private javax.swing.JTextField CT_SubjectCodeField;
    private javax.swing.JTable CT_Table;
    private javax.swing.JLabel CT_Term;
    private javax.swing.JComboBox<String> CT_TermField;
    private javax.swing.JLabel CT_Time;
    private javax.swing.JTextField CT_TimeField;
    private javax.swing.JLabel CT_Units;
    private javax.swing.JTextField CT_UnitsField;
    private javax.swing.JButton CT_Update;
}