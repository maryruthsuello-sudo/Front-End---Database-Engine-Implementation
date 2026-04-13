package databaseengine.gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import databaseengine.backend.Database;
import databaseengine.backend.model.Department;

public class ProgramTab extends javax.swing.JPanel {

    private ArrayList<Department> departmentList;
    private Database db;

    public ProgramTab(Database db) {
        initComponents();
        this.db = db;
        loadTable();

        PT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    PT_TableSelectionChanged(e);
                }
            }
        });
    }

    // Fetches all departments from DB and reloads the table — same pattern as StudentTab
    private void loadTable() {
        this.departmentList = db.getDepartment().getAllDepartments();
        DefaultTableModel model = (DefaultTableModel) PT_Table.getModel();
        model.setRowCount(0);
        for (Department d : departmentList) {
            model.addRow(new Object[]{
                d.getDeptCollege(),
                d.getProgram(),
                d.getDeptHead(),
                d.getDean(),
                d.getInstructor(),
                d.getCourse()
            });
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        PT_LeftPanel = new javax.swing.JPanel();
        PT_Program = new javax.swing.JLabel();
        PT_Instructor = new javax.swing.JLabel();
        PT_Dean = new javax.swing.JLabel();
        PT_DeptHead = new javax.swing.JLabel();
        PT_Program1 = new javax.swing.JLabel();
        PT_DeptHead1 = new javax.swing.JLabel();

        // All fields are now plain editable JTextFields — no hardcoded dropdowns
        PT_ProgramField = new javax.swing.JTextField();   // Program (e.g. BSCS)
        PT_ProgramField1 = new javax.swing.JTextField();  // Department College
        PT_InstructorField = new javax.swing.JTextField(); // Department Head
        PT_DeanField = new javax.swing.JTextField();       // Dean
        PT_DeptHeadField = new javax.swing.JTextField();   // Instructor
        PT_DeptHeadField1 = new javax.swing.JTextField();  // Course

        PT_Add = new javax.swing.JButton();
        PT_Edit = new javax.swing.JButton();
        PT_Delete = new javax.swing.JButton();
        PT_RightPanel = new javax.swing.JPanel();
        PT_RightScrollPane = new javax.swing.JScrollPane();
        PT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        PT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        PT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Program.setForeground(new java.awt.Color(250, 247, 245));
        PT_Program.setText("Department College");

        PT_Program1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Program1.setForeground(new java.awt.Color(250, 247, 245));
        PT_Program1.setText("Program");

        PT_Instructor.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Instructor.setForeground(new java.awt.Color(250, 247, 245));
        PT_Instructor.setText("Department Head");

        PT_Dean.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Dean.setForeground(new java.awt.Color(250, 247, 245));
        PT_Dean.setText("Dean");

        PT_DeptHead.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_DeptHead.setForeground(new java.awt.Color(250, 247, 245));
        PT_DeptHead.setText("Instructor");

        PT_DeptHead1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_DeptHead1.setForeground(new java.awt.Color(250, 247, 245));
        PT_DeptHead1.setText("Course");

        PT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        PT_ProgramField1.setBackground(new java.awt.Color(250, 247, 245));
        PT_InstructorField.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeanField.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeptHeadField.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeptHeadField1.setBackground(new java.awt.Color(250, 247, 245));

        PT_Add.setBackground(new java.awt.Color(210, 180, 140));
        PT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Add.setText("Add");
        PT_Add.addActionListener(this::PT_AddActionPerformed);

        PT_Edit.setBackground(new java.awt.Color(210, 180, 140));
        PT_Edit.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Edit.setText("Edit");
        PT_Edit.addActionListener(this::PT_EditActionPerformed);

        PT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        PT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Delete.setText("Delete");
        PT_Delete.addActionListener(this::PT_DeleteActionPerformed);

        javax.swing.GroupLayout PT_LeftPanelLayout = new javax.swing.GroupLayout(PT_LeftPanel);
        PT_LeftPanel.setLayout(PT_LeftPanelLayout);
        PT_LeftPanelLayout.setHorizontalGroup(
            PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PT_LeftPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PT_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(PT_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(PT_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(PT_LeftPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PT_DeptHead1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeptHeadField1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Program1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeptHead, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeptHeadField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Dean, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeanField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Instructor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_InstructorField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_ProgramField1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PT_LeftPanelLayout.setVerticalGroup(
            PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PT_LeftPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(PT_Program)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_ProgramField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_Program1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_Instructor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_InstructorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_Dean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_DeanField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_DeptHead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_DeptHeadField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_DeptHead1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_DeptHeadField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PT_Add)
                    .addComponent(PT_Edit)
                    .addComponent(PT_Delete))
                .addGap(14, 14, 14))
        );

        PT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        PT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Department College", "Program", "Department Head", "Dean", "Instructor", "Course"
            }
        ));
        PT_Table.getColumnModel().getColumn(0).setPreferredWidth(180);
        PT_Table.getColumnModel().getColumn(1).setPreferredWidth(400);
        PT_Table.getColumnModel().getColumn(2).setPreferredWidth(150);
        PT_Table.getColumnModel().getColumn(3).setPreferredWidth(120);
        PT_Table.getColumnModel().getColumn(4).setPreferredWidth(120);
        PT_Table.getColumnModel().getColumn(5).setPreferredWidth(200);
        PT_RightScrollPane.setViewportView(PT_Table);

        javax.swing.GroupLayout PT_RightPanelLayout = new javax.swing.GroupLayout(PT_RightPanel);
        PT_RightPanel.setLayout(PT_RightPanelLayout);
        PT_RightPanelLayout.setHorizontalGroup(
            PT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        PT_RightPanelLayout.setVerticalGroup(
            PT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PT_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PT_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    private void PT_AddActionPerformed(java.awt.event.ActionEvent evt) {
        String deptCollege  = PT_ProgramField1.getText().trim();
        String program      = PT_ProgramField.getText().trim();
        String deptHead     = PT_InstructorField.getText().trim();
        String dean         = PT_DeanField.getText().trim();
        String instructor   = PT_DeptHeadField.getText().trim();
        String course       = PT_DeptHeadField1.getText().trim();

        if (deptCollege.isEmpty() || program.isEmpty() || deptHead.isEmpty()
                || dean.isEmpty() || instructor.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Department newDept = new Department(deptCollege, program, deptHead, dean, instructor, course);

        boolean success = db.getDepartment().createDepartment(newDept);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to add record. The Program code may already exist.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        loadTable();
        PT_Clear();
        JOptionPane.showMessageDialog(this, "Successfully Added!", "Add Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void PT_EditActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = PT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String deptCollege  = PT_ProgramField1.getText().trim();
        String program      = PT_ProgramField.getText().trim();
        String deptHead     = PT_InstructorField.getText().trim();
        String dean         = PT_DeanField.getText().trim();
        String instructor   = PT_DeptHeadField.getText().trim();
        String course       = PT_DeptHeadField1.getText().trim();

        if (deptCollege.isEmpty() || program.isEmpty() || deptHead.isEmpty()
                || dean.isEmpty() || instructor.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Department updatedDept = new Department(deptCollege, program, deptHead, dean, instructor, course);

        boolean success = db.getDepartment().updateDepartment(updatedDept);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to update record.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        loadTable();
        PT_Clear();
        JOptionPane.showMessageDialog(this, "Successfully Updated!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void PT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = PT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this department?",
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        Department toDelete = departmentList.get(selectedRow);
        boolean success = db.getDepartment().deleteDepartment(toDelete.getProgram());
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to delete record from database.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        loadTable();
        PT_Clear();
        JOptionPane.showMessageDialog(this, "Successfully Deleted!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void PT_Clear() {
        PT_ProgramField1.setText("");
        PT_ProgramField.setText("");
        PT_InstructorField.setText("");
        PT_DeanField.setText("");
        PT_DeptHeadField.setText("");
        PT_DeptHeadField1.setText("");
        PT_Table.clearSelection();
    }

    private void PT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = PT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) PT_Table.getModel();
            PT_ProgramField1.setText((String) model.getValueAt(selectedRow, 0));
            PT_ProgramField.setText((String) model.getValueAt(selectedRow, 1));
            PT_InstructorField.setText((String) model.getValueAt(selectedRow, 2));
            PT_DeanField.setText((String) model.getValueAt(selectedRow, 3));
            PT_DeptHeadField.setText((String) model.getValueAt(selectedRow, 4));
            PT_DeptHeadField1.setText((String) model.getValueAt(selectedRow, 5));
        } else {
            PT_Clear();
        }
    }

    private javax.swing.JButton PT_Add;
    private javax.swing.JLabel PT_Dean;
    private javax.swing.JTextField PT_DeanField;
    private javax.swing.JButton PT_Delete;
    private javax.swing.JLabel PT_DeptHead;
    private javax.swing.JLabel PT_DeptHead1;
    private javax.swing.JTextField PT_DeptHeadField;
    private javax.swing.JTextField PT_DeptHeadField1;
    private javax.swing.JButton PT_Edit;
    private javax.swing.JLabel PT_Instructor;
    private javax.swing.JTextField PT_InstructorField;
    private javax.swing.JPanel PT_LeftPanel;
    private javax.swing.JLabel PT_Program;
    private javax.swing.JLabel PT_Program1;
    private javax.swing.JTextField PT_ProgramField;
    private javax.swing.JTextField PT_ProgramField1;
    private javax.swing.JPanel PT_RightPanel;
    private javax.swing.JScrollPane PT_RightScrollPane;
    private javax.swing.JTable PT_Table;
}