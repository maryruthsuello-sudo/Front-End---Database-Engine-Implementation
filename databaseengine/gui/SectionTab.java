package databaseengine.gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import databaseengine.backend.Database;
import databaseengine.backend.model.Section;

public class SectionTab extends javax.swing.JPanel {

    private ArrayList<Section> sectionList;
    private Database db;

    public SectionTab(Database db) {
        initComponents();
        this.db = db;

        // Load existing records from the database
        this.sectionList = db.getSection().viewSection();
        System.out.println("Sections loaded: " + sectionList.size());
        
        loadTableFromList();

        // Populate fields when a row is selected
        SeT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    SeT_TableSelectionChanged(e);
                }
            }
        });
    }

    // Populates the JTable from the sectionList (used on startup)
    private void loadTableFromList() {
        DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();
        model.setRowCount(0);
        for (Section s : sectionList) {
            model.addRow(new Object[]{
                s.getCourseYear(),
                String.valueOf(s.getNoOfStudents()),
                s.getSubjectCode(),
                s.getInstructor(),
                s.getTime(),
                s.getTerm()
            });
        }
    }

    private void initComponents() {

        SeT_LeftPanel = new javax.swing.JPanel();
        SeT_CourseYear = new javax.swing.JLabel();
        SeT_NumOfStudents = new javax.swing.JLabel();
        SeT_SubjectCode = new javax.swing.JLabel();
        SeT_Instructor = new javax.swing.JLabel();
        SeT_Time = new javax.swing.JLabel();
        SeT_Term = new javax.swing.JLabel();
        SeT_InstructorField = new javax.swing.JTextField();
        SeT_TimeField = new javax.swing.JTextField();
        SeT_TermField = new javax.swing.JComboBox<>();
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

        SeT_Instructor.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_Instructor.setForeground(new java.awt.Color(250, 247, 245));
        SeT_Instructor.setText("Instructor");

        SeT_Time.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_Time.setForeground(new java.awt.Color(250, 247, 245));
        SeT_Time.setText("Time");

        SeT_Term.setFont(new java.awt.Font("Segoe UI", 1, 16));
        SeT_Term.setForeground(new java.awt.Color(250, 247, 245));
        SeT_Term.setText("Term");

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

        SeT_InstructorField.setBackground(new java.awt.Color(250, 247, 245));

        SeT_TimeField.setBackground(new java.awt.Color(250, 247, 245));

        SeT_TermField.setBackground(new java.awt.Color(250, 247, 245));
        SeT_TermField.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]{"1st Sem", "2nd Sem"}
        ));

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
                            .addComponent(SeT_NumOfStudentsField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(SeT_Instructor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeT_InstructorField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(SeT_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeT_TimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(SeT_Term, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SeT_TermField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                        )))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        
        SeT_LeftPanelLayout.setVerticalGroup(
        SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(SeT_LeftPanelLayout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(SeT_CourseYear)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SeT_CourseYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(SeT_NumOfStudents)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SeT_NumOfStudentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(SeT_SubjectCode)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SeT_SubjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(SeT_Instructor)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SeT_InstructorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(SeT_Time)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SeT_TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(SeT_Term)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SeT_TermField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
            .addGroup(SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(SeT_Add)
                .addComponent(SeT_Update)
                .addComponent(SeT_Delete)
                .addComponent(SeT_Clear))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
        SeT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        SeT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Course Year", "Number of Students", "Subject Code", "Instructor", "Time", "Term"}
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

    // ADD — validates, saves to DB, adds to list and table
    private void SeT_AddActionPerformed(java.awt.event.ActionEvent evt) {
        int id = 0; // ID will be auto-generated by the database
        String courseYear = SeT_CourseYearField.getSelectedItem().toString();
        String numOfStudentsStr = SeT_NumOfStudentsField.getText().trim();
        String subjectCode = SeT_SubjectCodeField.getText().trim();
        String instructor = SeT_InstructorField.getText().trim();
        String time = SeT_TimeField.getText().trim();
        String term = SeT_TermField.getSelectedItem().toString();

        if (numOfStudentsStr.isEmpty() || subjectCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int numOfStudents;
        try {
            numOfStudents = Integer.parseInt(numOfStudentsStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Number of Students must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Build Section object
        Section newSection = new Section(id, instructor, courseYear, subjectCode, time, term, numOfStudents);

        // Save to database (createSection handles duplicate check internally)
        boolean success = db.getSection().createSection(newSection);
        if (!success) {
            JOptionPane.showMessageDialog(this,
                "A section with the same Course Year and Subject Code already exists.",
                "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Add to local list and table
        sectionList.add(newSection);
        DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();
        model.addRow(new Object[]{courseYear, numOfStudentsStr, subjectCode, instructor, time, term});

        JOptionPane.showMessageDialog(this, "Successfully Added!");
        SeT_ClearActionPerformed(evt);
    }

    // UPDATE — saves to DB, updates list and table
    private void SeT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = SeT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int id = sectionList.get(selectedRow).getId(); // Get ID from the selected section
        String courseYear = SeT_CourseYearField.getSelectedItem().toString();
        String numOfStudentsStr = SeT_NumOfStudentsField.getText().trim();
        String subjectCode = SeT_SubjectCodeField.getText().trim();
        String instructor = SeT_InstructorField.getText().trim();
        String time = SeT_TimeField.getText().trim();
        String term = SeT_TermField.getSelectedItem().toString();

        if (numOfStudentsStr.isEmpty() || subjectCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int numOfStudents;
        try {
            numOfStudents = Integer.parseInt(numOfStudentsStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Number of Students must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Section updatedSection = new Section(id, instructor, courseYear, subjectCode, time, term, numOfStudents);

        // Update in database
        boolean success = db.getSection().updateSection(updatedSection);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to update section.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update local list and table
        sectionList.set(selectedRow, updatedSection);
        DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();
        
        model.setValueAt(courseYear, selectedRow, 0);
        model.setValueAt(numOfStudentsStr, selectedRow, 1);
        model.setValueAt(subjectCode, selectedRow, 2);
        model.setValueAt(instructor, selectedRow, 3);
        model.setValueAt(time, selectedRow, 4);
        model.setValueAt(term, selectedRow, 5);

        JOptionPane.showMessageDialog(this, "Updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // DELETE — removes from DB, list, and table
    private void SeT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = SeT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Section toDelete = sectionList.get(selectedRow);

        // Delete from database
        boolean success = db.getSection().deleteSection(toDelete.getId());
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to delete section from database.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove from local list and table
        sectionList.remove(selectedRow);
        DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Deleted successfully!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
        SeT_ClearActionPerformed(evt);
    }

    // CLEAR — resets all fields
    private void SeT_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        SeT_NumOfStudentsField.setText("");
        SeT_SubjectCodeField.setText("");
        SeT_InstructorField.setText("");
        SeT_TimeField.setText("");
        SeT_CourseYearField.setSelectedIndex(0);
        SeT_TermField.setSelectedIndex(0);
        SeT_Table.clearSelection();
    }

    // ROW SELECTION — clicking a row fills the fields
    private void SeT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = SeT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) SeT_Table.getModel();

            String courseYear    = (String) model.getValueAt(selectedRow, 0);
            String numOfStudents = (String) model.getValueAt(selectedRow, 1);
            String subjectCode   = (String) model.getValueAt(selectedRow, 2);
            String instructor    = (String) model.getValueAt(selectedRow, 3);
            String time          = (String) model.getValueAt(selectedRow, 4);
            String term          = (String) model.getValueAt(selectedRow, 5);

            SeT_CourseYearField.setSelectedItem(courseYear);
            SeT_NumOfStudentsField.setText(numOfStudents);
            SeT_SubjectCodeField.setText(subjectCode);
            SeT_InstructorField.setText(instructor);
            SeT_TimeField.setText(time);
            SeT_TermField.setSelectedItem(term);
        } else {
            SeT_ClearActionPerformed(null);
        }
    }

    private javax.swing.JButton SeT_Add;
    private javax.swing.JButton SeT_Clear;
    private javax.swing.JLabel SeT_CourseYear;
    private javax.swing.JComboBox<String> SeT_CourseYearField;
    private javax.swing.JButton SeT_Delete;
    private javax.swing.JLabel SeT_Instructor;
    private javax.swing.JTextField SeT_InstructorField;
    private javax.swing.JPanel SeT_LeftPanel;
    private javax.swing.JLabel SeT_NumOfStudents;
    private javax.swing.JTextField SeT_NumOfStudentsField;
    private javax.swing.JPanel SeT_RightPanel;
    private javax.swing.JScrollPane SeT_RightScrollPane;
    private javax.swing.JLabel SeT_SubjectCode;
    private javax.swing.JTextField SeT_SubjectCodeField;
    private javax.swing.JTable SeT_Table;
    private javax.swing.JLabel SeT_Time;
    private javax.swing.JTextField SeT_TimeField;
    private javax.swing.JLabel SeT_Term;
    private javax.swing.JComboBox<String> SeT_TermField;
    private javax.swing.JButton SeT_Update;
}