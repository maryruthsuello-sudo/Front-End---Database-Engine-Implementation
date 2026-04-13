package databaseengine.gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import databaseengine.backend.Database;
import databaseengine.backend.model.Course;


public class CourseTab extends javax.swing.JPanel {

    private ArrayList<Course> courseList;
    private Database db;

    public CourseTab(Database db) {
        initComponents();
        this.db = db;

        this.courseList = db.getCourse().getAllCourses();
        loadTableFromList();

        CT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    CT_TableSelectionChanged(e);
                }
            }
        });
    }

    private void loadTableFromList() {
        DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Course c : courseList) {
            model.addRow(new Object[]{
                c.getProgram(),
                c.getSubjectCode(),
                String.valueOf(c.getUnits()),
                c.getDescriptiveTitle(),
                c.getGrade() != null ? c.getGrade().toString() : "",
                c.getTime(),
                c.getTerm(),
                sdf.format(c.getDateSubmitted())
            });
        }
    }

    private void initComponents() {

        CT_LeftPanel = new javax.swing.JPanel();
        CT_Program = new javax.swing.JLabel();
        CT_SubjectCode = new javax.swing.JLabel();
        CT_Units = new javax.swing.JLabel();
        CT_DescriptiveTitle = new javax.swing.JLabel();
        CT_Grade = new javax.swing.JLabel();
        CT_Time = new javax.swing.JLabel();
        CT_Term = new javax.swing.JLabel();
        CT_DateSubmitted = new javax.swing.JLabel();
        CT_ProgramField = new javax.swing.JComboBox<>();
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

        CT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Program.setForeground(new java.awt.Color(250, 247, 245));
        CT_Program.setText("Program");

        CT_SubjectCode.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_SubjectCode.setForeground(new java.awt.Color(250, 247, 245));
        CT_SubjectCode.setText("Subject Code");

        CT_Units.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Units.setForeground(new java.awt.Color(250, 247, 245));
        CT_Units.setText("Units");

        CT_DescriptiveTitle.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_DescriptiveTitle.setForeground(new java.awt.Color(250, 247, 245));
        CT_DescriptiveTitle.setText("Descriptive Title");

        CT_Grade.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Grade.setForeground(new java.awt.Color(250, 247, 245));
        CT_Grade.setText("Grade");

        CT_Time.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Time.setForeground(new java.awt.Color(250, 247, 245));
        CT_Time.setText("Time");

        CT_Term.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Term.setForeground(new java.awt.Color(250, 247, 245));
        CT_Term.setText("Term");

        CT_DateSubmitted.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_DateSubmitted.setForeground(new java.awt.Color(250, 247, 245));
        CT_DateSubmitted.setText("Date Submitted");

        CT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        // FIX #7: Was using full program names. The course.prog column is a FK
        // to department.prog which stores BSCS/BSIT/BSIS — full names caused FK
        // violations and every insert/update silently failed.
        CT_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSCS", "BSIT", "BSIS" }));

        CT_SubjectCodeField.setBackground(new java.awt.Color(250, 247, 245));
        CT_UnitsField.setBackground(new java.awt.Color(250, 247, 245));
        CT_DescriptiveTitleField.setBackground(new java.awt.Color(250, 247, 245));
        CT_GradeField.setBackground(new java.awt.Color(250, 247, 245));
        CT_TimeField.setBackground(new java.awt.Color(250, 247, 245));

        CT_TermField.setBackground(new java.awt.Color(250, 247, 245));
        CT_TermField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Sem", "2nd Sem" }));

        javax.swing.JSpinner.DateEditor dateEditor = new javax.swing.JSpinner.DateEditor(CT_DateSubmittedField, "yyyy-MM-dd");
        CT_DateSubmittedField.setEditor(dateEditor);
        CT_DateSubmittedField.setValue(new java.util.Date());

        CT_Add.setBackground(new java.awt.Color(210, 180, 140));
        CT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Add.setText("Add");
        CT_Add.addActionListener(this::CT_AddActionPerformed);

        CT_Update.setBackground(new java.awt.Color(210, 180, 140));
        CT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Update.setText("Update");
        CT_Update.addActionListener(this::CT_UpdateActionPerformed);

        CT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        CT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16));
        CT_Delete.setText("Delete");
        CT_Delete.addActionListener(this::CT_DeleteActionPerformed);

        CT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        CT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16));
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
                            .addComponent(CT_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_ProgramField, 0, 306, Short.MAX_VALUE)
                            .addComponent(CT_SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_SubjectCodeField, 0, 306, Short.MAX_VALUE)
                            .addComponent(CT_Units, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_UnitsField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_DescriptiveTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_DescriptiveTitleField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_GradeField)
                            .addComponent(CT_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_TimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_Term, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_TermField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CT_DateSubmitted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_DateSubmittedField))))
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

        // FIX #8: Removed "Student ID" column from table — student_ID does not
        // exist in the course table schema. Keeping it caused getAllCourses() to
        // always throw a SQLException and load nothing.
        CT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Program", "Subject Code", "Units", "Title", "Grade", "Time", "Term", "Date Submitted"
            }
        ));
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
    }

    private void CT_AddActionPerformed(java.awt.event.ActionEvent evt) {
        String program = (String) CT_ProgramField.getSelectedItem();
        String subjectCode = CT_SubjectCodeField.getText().trim();
        String unitsStr = CT_UnitsField.getText().trim();
        String title = CT_DescriptiveTitleField.getText().trim();
        String gradeStr = CT_GradeField.getText().trim();
        String time = CT_TimeField.getText().trim();
        String term = (String) CT_TermField.getSelectedItem();

        if (subjectCode.isEmpty() || unitsStr.isEmpty() || title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int units;
        try {
            units = Integer.parseInt(unitsStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Units must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal grade = null;
        if (!gradeStr.isEmpty()) {
            try {
                grade = new BigDecimal(gradeStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Grade must be a valid decimal number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateSubmittedStr = sdf.format((Date) CT_DateSubmittedField.getValue());

        Course newCourse = new Course(
            program,
            subjectCode,
            units,
            title,
            grade,
            time,
            term,
            java.sql.Date.valueOf(dateSubmittedStr)
        );

        boolean success = db.getCourse().createCourse(newCourse);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to add course. Please check the data and try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        courseList.add(newCourse);
        DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
        model.addRow(new Object[]{
            program,
            subjectCode,
            unitsStr,
            title,
            gradeStr,
            time,
            term,
            dateSubmittedStr
        });

        JOptionPane.showMessageDialog(this, "Successfully Added!");
        CT_ClearActionPerformed(null);
    }

    private void CT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = CT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String program = (String) CT_ProgramField.getSelectedItem();
        String subjectCode = CT_SubjectCodeField.getText().trim();
        String unitsStr = CT_UnitsField.getText().trim();
        String title = CT_DescriptiveTitleField.getText().trim();
        String gradeStr = CT_GradeField.getText().trim();
        String time = CT_TimeField.getText().trim();
        String term = (String) CT_TermField.getSelectedItem();

        if (subjectCode.isEmpty() || unitsStr.isEmpty() || title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int units;
        try {
            units = Integer.parseInt(unitsStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Units must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal grade = null;
        if (!gradeStr.isEmpty()) {
            try {
                grade = new BigDecimal(gradeStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Grade must be a valid decimal number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateSubmittedStr = sdf.format((Date) CT_DateSubmittedField.getValue());

        Course updatedCourse = new Course(
            program,
            subjectCode,
            units,
            title,
            grade,
            time,
            term,
            java.sql.Date.valueOf(dateSubmittedStr)
        );

        boolean success = db.getCourse().updateCourse(updatedCourse);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to update course.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        courseList.set(selectedRow, updatedCourse);

        DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
        model.setValueAt(program, selectedRow, 0);
        model.setValueAt(subjectCode, selectedRow, 1);
        model.setValueAt(unitsStr, selectedRow, 2);
        model.setValueAt(title, selectedRow, 3);
        model.setValueAt(gradeStr, selectedRow, 4);
        model.setValueAt(time, selectedRow, 5);
        model.setValueAt(term, selectedRow, 6);
        model.setValueAt(dateSubmittedStr, selectedRow, 7);

        JOptionPane.showMessageDialog(this, "Successfully Updated!");
    }

    private void CT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = CT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Course toDelete = courseList.get(selectedRow);

        boolean success = db.getCourse().deleteCourse(toDelete.getSubjectCode());
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to delete course. It may be referenced by a section.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        courseList.remove(selectedRow);
        DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Successfully Deleted!");
        CT_ClearActionPerformed(null);
    }

    private void CT_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        CT_ProgramField.setSelectedIndex(0);
        CT_SubjectCodeField.setText("");
        CT_UnitsField.setText("");
        CT_DescriptiveTitleField.setText("");
        CT_GradeField.setText("");
        CT_TimeField.setText("");
        CT_TermField.setSelectedIndex(0);
        CT_DateSubmittedField.setValue(new Date());
        CT_Table.clearSelection();
    }

    private void CT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = CT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) CT_Table.getModel();

            // Column order: Program(0), SubjectCode(1), Units(2), Title(3),
            //               Grade(4), Time(5), Term(6), DateSubmitted(7)
            CT_ProgramField.setSelectedItem(model.getValueAt(selectedRow, 0));
            CT_SubjectCodeField.setText((String) model.getValueAt(selectedRow, 1));
            CT_UnitsField.setText((String) model.getValueAt(selectedRow, 2));
            CT_DescriptiveTitleField.setText((String) model.getValueAt(selectedRow, 3));
            CT_GradeField.setText((String) model.getValueAt(selectedRow, 4));
            CT_TimeField.setText((String) model.getValueAt(selectedRow, 5));
            CT_TermField.setSelectedItem(model.getValueAt(selectedRow, 6));

            String dateStr = (String) model.getValueAt(selectedRow, 7);
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                CT_DateSubmittedField.setValue(sdf.parse(dateStr));
            } catch (ParseException ex) {
                System.err.println("Error parsing date: " + ex.getMessage());
            }
        } else {
            CT_ClearActionPerformed(null);
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