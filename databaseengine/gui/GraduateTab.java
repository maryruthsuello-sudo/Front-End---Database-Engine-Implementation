package databaseengine.gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GraduateTab extends javax.swing.JPanel {

    // In-memory list to store graduate records temporarily (no DB yet)
    // Columns: Student, Program, Unit Grade, Rating, Graduation Date, Final Grade, Major
    private ArrayList<String[]> graduateList = new ArrayList<>();

    public GraduateTab() {
        initComponents();

        // Populate fields when a row is selected — same as SectionTab/StudentTab
        GrT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    GrT_TableSelectionChanged(e);
                }
            }
        });
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
        GrT_Student.setText("Student");

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
        GrT_StudentField.setBackground(new java.awt.Color(250, 247, 245)); // white bg
        GrT_StudentField.setForeground(new java.awt.Color(0, 0, 0));       // black text

        GrT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "Bachelor of Science in Computer Science",
            "Bachelor of Science in Information Technology",
            "Bachelor of Science in Information Systems"
        }));

        // UnitGrade, Rating, FinalGrade — editable, user types values
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(GrT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GrT_Add)
                    .addComponent(GrT_Update)
                    .addComponent(GrT_Delete)
                    .addComponent(GrT_Clear))
                .addGap(14, 14, 14))
        );

        GrT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        // Start with empty table (no placeholder null rows)
        GrT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Student", "Program", "Unit Grade", "Rating", "Graduation Date", "Final Grade", "Major"}
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

    // ADD — validates fields, checks for duplicate student entry, adds to list and table
    private void GrT_AddActionPerformed(java.awt.event.ActionEvent evt) {
        String student      = GrT_StudentField.getText().trim();
        String program      = GrT_ProgramField.getSelectedItem().toString();
        String unitGrade    = GrT_UnitGradeField.getText().trim();
        String rating       = GrT_RatingField.getText().trim();
        String finalGrade   = GrT_FinalGradeField.getText().trim();
        String major        = GrT_MajorField.getSelectedItem().toString();

        Date gradDateValue  = (Date) GrT_GraduationDateField.getValue();
        String gradDate     = new SimpleDateFormat("yyyy-MM-dd").format(gradDateValue);

        if (unitGrade.isEmpty() || rating.isEmpty() || finalGrade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check duplicate: same Student already in list
        for (String[] entry : graduateList) {
            if (entry[0].equals(student)) {
                JOptionPane.showMessageDialog(this,
                    "A graduate record for \"" + student + "\" already exists.",
                    "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        // Add to in-memory list
        graduateList.add(new String[]{student, program, unitGrade, rating, gradDate, finalGrade, major});

        // Add to table
        DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();
        model.addRow(new Object[]{student, program, unitGrade, rating, gradDate, finalGrade, major});

        GrT_ClearActionPerformed(evt);
    }

    // UPDATE — updates selected row in list and table
    private void GrT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = GrT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String student      = GrT_StudentField.getText().trim();
        String program      = GrT_ProgramField.getSelectedItem().toString();
        String unitGrade    = GrT_UnitGradeField.getText().trim();
        String rating       = GrT_RatingField.getText().trim();
        String finalGrade   = GrT_FinalGradeField.getText().trim();
        String major        = GrT_MajorField.getSelectedItem().toString();

        Date gradDateValue  = (Date) GrT_GraduationDateField.getValue();
        String gradDate     = new SimpleDateFormat("yyyy-MM-dd").format(gradDateValue);

        if (unitGrade.isEmpty() || rating.isEmpty() || finalGrade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Update in-memory list
        graduateList.set(selectedRow, new String[]{student, program, unitGrade, rating, gradDate, finalGrade, major});

        // Update table
        DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();
        model.setValueAt(student,    selectedRow, 0);
        model.setValueAt(program,    selectedRow, 1);
        model.setValueAt(unitGrade,  selectedRow, 2);
        model.setValueAt(rating,     selectedRow, 3);
        model.setValueAt(gradDate,   selectedRow, 4);
        model.setValueAt(finalGrade, selectedRow, 5);
        model.setValueAt(major,      selectedRow, 6);

        JOptionPane.showMessageDialog(this, "Updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // DELETE — removes selected row from list and table
    private void GrT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = GrT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        graduateList.remove(selectedRow);

        DefaultTableModel model = (DefaultTableModel) GrT_Table.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Deleted successfully!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
        GrT_ClearActionPerformed(evt);
    }

    // CLEAR — resets all fields
    private void GrT_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        GrT_StudentField.setSelectedIndex(0);
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

            String student    = (String) model.getValueAt(selectedRow, 0);
            String program    = (String) model.getValueAt(selectedRow, 1);
            String unitGrade  = (String) model.getValueAt(selectedRow, 2);
            String rating     = (String) model.getValueAt(selectedRow, 3);
            String gradDate   = (String) model.getValueAt(selectedRow, 4);
            String finalGrade = (String) model.getValueAt(selectedRow, 5);
            String major      = (String) model.getValueAt(selectedRow, 6);

            GrT_StudentField.setText(student);
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