package databaseengine.gui;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import databaseengine.backend.Database;
import databaseengine.backend.model.Graduate;

public class GraduateTab extends javax.swing.JPanel {

    private ArrayList<Graduate> graduateList;
    private Database db;

    public GraduateTab(Database db) {
        initComponents();
        this.db = db;

        // Load existing records from the database
        this.graduateList = db.getGraduate().viewGraduates();
        loadTableFromList();

        // Populate fields when a row is selected
        GrT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    GrT_TableSelectionChanged(e);
                }
            }
        });
    }

    // Populates the JTable from the graduateList (used on startup)
    private void loadTableFromList() {
        DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Graduate g : graduateList) {
            model.addRow(new Object[]{
                String.valueOf(g.getStudentId()),
                g.getProg(),
                g.getUnitGrade() != null ? g.getUnitGrade().toString() : "",
                g.getRating() != null ? g.getRating().toString() : "",
                g.getGraduationDate() != null ? sdf.format(g.getGraduationDate()) : "",
                g.getFinalGrade() != null ? g.getFinalGrade().toString() : "",
                g.getMajor()
            });
        }
    }

    private void initComponents() {

        GrT_LeftPanel = new javax.swing.JPanel();
        GrT_Student = new javax.swing.JLabel();
        GrT_Program = new javax.swing.JLabel();
        GrT_UnitGrade = new javax.swing.JLabel();
        GrT_Rating = new javax.swing.JLabel();
        GrT_GraduationDate = new javax.swing.JLabel();
        GrT_FinalGrade = new javax.swing.JLabel();
        GrT_Major = new javax.swing.JLabel();
        GrT_StudentField = new javax.swing.JTextField();
        GrT_ProgramField = new javax.swing.JComboBox<>();
        GrT_UnitGradeField = new javax.swing.JTextField();
        GrT_RatingField = new javax.swing.JTextField();
        GrT_GraduationDateField = new javax.swing.JSpinner(new javax.swing.SpinnerDateModel());
        GrT_FinalGradeField = new javax.swing.JTextField();
        GrT_MajorField = new javax.swing.JComboBox<>();
        GrT_Add = new javax.swing.JButton();
        GrT_Update = new javax.swing.JButton();
        GrT_Delete = new javax.swing.JButton();
        GrT_Clear = new javax.swing.JButton();
        GrT_RightPanel = new javax.swing.JPanel();
        GrT_RightScrollPane = new javax.swing.JScrollPane();
        GrT_Table = new javax.swing.JTable();

        // Setup date spinner with date editor
        javax.swing.JSpinner.DateEditor dateEditor = new javax.swing.JSpinner.DateEditor(GrT_GraduationDateField, "yyyy-MM-dd");
        GrT_GraduationDateField.setEditor(dateEditor);
        GrT_GraduationDateField.setValue(new Date());

        setBackground(new java.awt.Color(130, 65, 72));

        GrT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        GrT_Student.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Student.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Student.setText("Student ID");

        GrT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Program.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Program.setText("Program");

        GrT_UnitGrade.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_UnitGrade.setForeground(new java.awt.Color(250, 247, 245));
        GrT_UnitGrade.setText("Unit Grade");

        GrT_Rating.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Rating.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Rating.setText("Rating");

        GrT_GraduationDate.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_GraduationDate.setForeground(new java.awt.Color(250, 247, 245));
        GrT_GraduationDate.setText("Graduation Date");

        GrT_FinalGrade.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_FinalGrade.setForeground(new java.awt.Color(250, 247, 245));
        GrT_FinalGrade.setText("Final Grade");

        GrT_Major.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Major.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Major.setText("Major");

        GrT_StudentField.setFont(new java.awt.Font("Segoe UI", 0, 16));
        GrT_StudentField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_StudentField.setForeground(new java.awt.Color(0, 0, 0));

        GrT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "BSCS", "BSIT", "BSIS"
        }));

        GrT_UnitGradeField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_UnitGradeField.addActionListener(this::GrT_UnitGradeFieldActionPerformed);

        GrT_RatingField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_RatingField.addActionListener(this::GrT_RatingFieldActionPerformed);

        GrT_FinalGradeField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_FinalGradeField.addActionListener(this::GrT_FinalGradeFieldActionPerformed);

        GrT_MajorField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_MajorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Software Engineering", "Networking", "Information Systems"
        }));

        GrT_Add.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Add.setText("Add");
        GrT_Add.addActionListener(this::GrT_AddActionPerformed);

        GrT_Update.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Update.setText("Update");
        GrT_Update.addActionListener(this::GrT_UpdateActionPerformed);

        GrT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Delete.setText("Delete");
        GrT_Delete.addActionListener(this::GrT_DeleteActionPerformed);

        GrT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16));
        GrT_Clear.setText("Clear");
        GrT_Clear.addActionListener(this::GrT_ClearActionPerformed);

        javax.swing.GroupLayout GrT_LeftPanelLayout = new javax.swing.GroupLayout(GrT_LeftPanel);
        GrT_LeftPanel.setLayout(GrT_LeftPanelLayout);
        GrT_LeftPanelLayout.setHorizontalGroup(
            GrT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrT_LeftPanelLayout.createSequentialGroup()
                .addGroup(GrT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrT_LeftPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(GrT_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GrT_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GrT_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GrT_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GrT_LeftPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(GrT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GrT_Major, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT_FinalGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT_GraduationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT_RatingField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(GrT_Rating, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT_UnitGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GrT_StudentField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GrT_ProgramField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GrT_UnitGradeField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(GrT_GraduationDateField)
                            .addComponent(GrT_FinalGradeField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(GrT_MajorField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        GrT_LeftPanelLayout.setVerticalGroup(
            GrT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrT_LeftPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(GrT_Student)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrT_StudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrT_Program)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrT_UnitGrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrT_UnitGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrT_Rating)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrT_RatingField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrT_GraduationDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrT_GraduationDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrT_FinalGrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrT_FinalGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GrT_Major)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GrT_MajorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(GrT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GrT_Add)
                    .addComponent(GrT_Update)
                    .addComponent(GrT_Delete)
                    .addComponent(GrT_Clear))
                .addGap(14, 14, 14))
        );

        GrT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        GrT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Student ID", "Program", "Unit Grade", "Rating", "Graduation Date", "Final Grade", "Major"}
        ));
        GrT_RightScrollPane.setViewportView(GrT_Table);

        javax.swing.GroupLayout GrT_RightPanelLayout = new javax.swing.GroupLayout(GrT_RightPanel);
        GrT_RightPanel.setLayout(GrT_RightPanelLayout);
        GrT_RightPanelLayout.setHorizontalGroup(
            GrT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        GrT_RightPanelLayout.setVerticalGroup(
            GrT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrT_RightScrollPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GrT_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GrT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GrT_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GrT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    // ADD — validates, saves to DB, adds to list and table
    private void GrT_AddActionPerformed(java.awt.event.ActionEvent evt) {
        String studentIdStr = GrT_StudentField.getText().trim();
        String program      = GrT_ProgramField.getSelectedItem().toString();
        String unitGradeStr = GrT_UnitGradeField.getText().trim();
        String ratingStr    = GrT_RatingField.getText().trim();
        String finalGradeStr = GrT_FinalGradeField.getText().trim();
        String major        = GrT_MajorField.getSelectedItem().toString();

        Date gradDateValue  = (Date) GrT_GraduationDateField.getValue();
        String gradDate     = new SimpleDateFormat("yyyy-MM-dd").format(gradDateValue);

        if (studentIdStr.isEmpty() || unitGradeStr.isEmpty() || ratingStr.isEmpty() || finalGradeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int studentId;
        try {
            studentId = Integer.parseInt(studentIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Student ID must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal unitGrade, rating, finalGrade;
        try {
            unitGrade  = new BigDecimal(unitGradeStr);
            rating     = new BigDecimal(ratingStr);
            finalGrade = new BigDecimal(finalGradeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Unit Grade, Rating, and Final Grade must be valid decimal numbers.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Build Graduate object
        Graduate newGraduate = new Graduate(studentId, program, unitGrade, rating,
                java.sql.Date.valueOf(gradDate), finalGrade, major);

        // Save to database
        boolean success = db.getGraduate().createGraduate(newGraduate);
        if (!success) {
            JOptionPane.showMessageDialog(this,
                "Failed to add graduate record. Student may already have a record.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add to local list and table
        graduateList.add(newGraduate);
        DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();
        model.addRow(new Object[]{studentIdStr, program, unitGradeStr, ratingStr, gradDate, finalGradeStr, major});

        GrT_ClearActionPerformed(evt);
    }

    // UPDATE — saves to DB, updates list and table
    private void GrT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = GrT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String studentIdStr  = GrT_StudentField.getText().trim();
        String program       = GrT_ProgramField.getSelectedItem().toString();
        String unitGradeStr  = GrT_UnitGradeField.getText().trim();
        String ratingStr     = GrT_RatingField.getText().trim();
        String finalGradeStr = GrT_FinalGradeField.getText().trim();
        String major         = GrT_MajorField.getSelectedItem().toString();

        Date gradDateValue   = (Date) GrT_GraduationDateField.getValue();
        String gradDate      = new SimpleDateFormat("yyyy-MM-dd").format(gradDateValue);

        if (studentIdStr.isEmpty() || unitGradeStr.isEmpty() || ratingStr.isEmpty() || finalGradeStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int studentId;
        try {
            studentId = Integer.parseInt(studentIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Student ID must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal unitGrade, rating, finalGrade;
        try {
            unitGrade  = new BigDecimal(unitGradeStr);
            rating     = new BigDecimal(ratingStr);
            finalGrade = new BigDecimal(finalGradeStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Unit Grade, Rating, and Final Grade must be valid decimal numbers.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Graduate updatedGraduate = new Graduate(studentId, program, unitGrade, rating,
                java.sql.Date.valueOf(gradDate), finalGrade, major);

        // Update in database
        boolean success = db.getGraduate().updateGraduate(updatedGraduate);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to update graduate record.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update local list and table
        graduateList.set(selectedRow, updatedGraduate);
        DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();
        model.setValueAt(studentIdStr, selectedRow, 0);
        model.setValueAt(program,      selectedRow, 1);
        model.setValueAt(unitGradeStr, selectedRow, 2);
        model.setValueAt(ratingStr,    selectedRow, 3);
        model.setValueAt(gradDate,     selectedRow, 4);
        model.setValueAt(finalGradeStr, selectedRow, 5);
        model.setValueAt(major,        selectedRow, 6);

        JOptionPane.showMessageDialog(this, "Updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // DELETE — removes from DB, list, and table
    private void GrT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = GrT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Graduate toDelete = graduateList.get(selectedRow);

        // Delete from database
        boolean success = db.getGraduate().deleteGraduate(toDelete.getStudentId());
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to delete graduate record from database.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove from local list and table
        graduateList.remove(selectedRow);
        DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Deleted successfully!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
        GrT_ClearActionPerformed(evt);
    }

    // CLEAR — resets all fields
    private void GrT_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        GrT_StudentField.setText("");  // fixed: was incorrectly calling setSelectedIndex on a JTextField
        GrT_ProgramField.setSelectedIndex(0);
        GrT_UnitGradeField.setText("");
        GrT_RatingField.setText("");
        GrT_FinalGradeField.setText("");
        GrT_MajorField.setSelectedIndex(0);
        GrT_GraduationDateField.setValue(new Date());
        GrT_Table.clearSelection();
    }

    // ROW SELECTION — clicking a row fills all fields
    private void GrT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = GrT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();

            String studentId  = (String) model.getValueAt(selectedRow, 0);
            String program    = (String) model.getValueAt(selectedRow, 1);
            String unitGrade  = (String) model.getValueAt(selectedRow, 2);
            String rating     = (String) model.getValueAt(selectedRow, 3);
            String gradDate   = (String) model.getValueAt(selectedRow, 4);
            String finalGrade = (String) model.getValueAt(selectedRow, 5);
            String major      = (String) model.getValueAt(selectedRow, 6);

            GrT_StudentField.setText(studentId);
            GrT_ProgramField.setSelectedItem(program);
            GrT_UnitGradeField.setText(unitGrade);
            GrT_RatingField.setText(rating);
            GrT_FinalGradeField.setText(finalGrade);
            GrT_MajorField.setSelectedItem(major);

            try {
                Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(gradDate);
                GrT_GraduationDateField.setValue(parsedDate);
            } catch (java.text.ParseException ex) {
                System.err.println("Error parsing graduation date: " + ex.getMessage());
            }
        } else {
            GrT_ClearActionPerformed(null);
        }
    }

    private void GrT_RatingFieldActionPerformed(java.awt.event.ActionEvent evt) {}
    private void GrT_UnitGradeFieldActionPerformed(java.awt.event.ActionEvent evt) {}
    private void GrT_FinalGradeFieldActionPerformed(java.awt.event.ActionEvent evt) {}

    private javax.swing.JButton GrT_Add;
    private javax.swing.JButton GrT_Clear;
    private javax.swing.JButton GrT_Delete;
    private javax.swing.JLabel GrT_FinalGrade;
    private javax.swing.JTextField GrT_FinalGradeField;
    private javax.swing.JLabel GrT_GraduationDate;
    private javax.swing.JSpinner GrT_GraduationDateField;
    private javax.swing.JPanel GrT_LeftPanel;
    private javax.swing.JLabel GrT_Major;
    private javax.swing.JComboBox<String> GrT_MajorField;
    private javax.swing.JLabel GrT_Program;
    private javax.swing.JComboBox<String> GrT_ProgramField;
    private javax.swing.JLabel GrT_Rating;
    private javax.swing.JTextField GrT_RatingField;
    private javax.swing.JPanel GrT_RightPanel;
    private javax.swing.JScrollPane GrT_RightScrollPane;
    private javax.swing.JLabel GrT_Student;
    private javax.swing.JTextField GrT_StudentField;
    private javax.swing.JTable GrT_Table;
    private javax.swing.JLabel GrT_UnitGrade;
    private javax.swing.JTextField GrT_UnitGradeField;
    private javax.swing.JButton GrT_Update;
}