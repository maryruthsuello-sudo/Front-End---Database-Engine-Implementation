package databaseengine.gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import databaseengine.backend.Database;
import databaseengine.backend.model.Department;

public class ProgramTab extends javax.swing.JPanel {

    private ArrayList<Department> departmentList;
    private Database db;

    public ProgramTab(Database db) {
        initComponents();
        this.db = db;

        this.departmentList = db.getDepartment().getAllDepartments();
        loadTableFromList();

        PT_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    PT_TableSelectionChanged(e);
                }
            }
        });
    }

    private void loadTableFromList() {
        DefaultTableModel model = (DefaultTableModel) PT_Table.getModel();
        model.setRowCount(0);

        for (Department d : departmentList) {
            model.addRow(new Object[]{
                d.getCollege(),
                d.getProgram(),
                d.getDeptHead(),
                d.getDean()
            });
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        PT_LeftPanel = new javax.swing.JPanel();
        PT_College = new javax.swing.JLabel();
        PT_Program = new javax.swing.JLabel();
        PT_DeptHead = new javax.swing.JLabel();
        PT_Dean = new javax.swing.JLabel();
        PT_CollegeField = new javax.swing.JComboBox<>();
        PT_ProgramField = new javax.swing.JComboBox<>();
        PT_DeptHeadField = new javax.swing.JComboBox<>();
        PT_DeanField = new javax.swing.JComboBox<>();
        PT_Add = new javax.swing.JButton();
        PT_Update = new javax.swing.JButton();
        PT_Delete = new javax.swing.JButton();
        PT_Clear = new javax.swing.JButton();
        PT_RightPanel = new javax.swing.JPanel();
        PT_RightScrollPane = new javax.swing.JScrollPane();
        PT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        PT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        PT_College.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_College.setForeground(new java.awt.Color(250, 247, 245));
        PT_College.setText("College");

        PT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Program.setForeground(new java.awt.Color(250, 247, 245));
        PT_Program.setText("Program");

        PT_DeptHead.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_DeptHead.setForeground(new java.awt.Color(250, 247, 245));
        PT_DeptHead.setText("Department Head");

        PT_Dean.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Dean.setForeground(new java.awt.Color(250, 247, 245));
        PT_Dean.setText("Dean");

        PT_CollegeField.setBackground(new java.awt.Color(250, 247, 245));
        PT_CollegeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "College of Science",
            "College of Engineering",
            "College of Liberal Arts",
            "College of Architecture and Fine Arts",
            "College of Industrial Education",
            "College of Industrial Technology"
        }));

        PT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        PT_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "BSCS",
            "BSIT",
            "BSIS"
        }));

        PT_DeanField.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeanField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Dr. Santos", "Dr. Gomez", "Dr. Lopez"
        }));

        PT_DeptHeadField.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeptHeadField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Prof. Cruz", "Prof. Reyes", "Prof. Garcia"
        }));

        PT_Add.setBackground(new java.awt.Color(210, 180, 140));
        PT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Add.setText("Add");
        PT_Add.addActionListener(this::PT_AddActionPerformed);

        PT_Update.setBackground(new java.awt.Color(210, 180, 140));
        PT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Update.setText("Update");
        PT_Update.addActionListener(this::PT_UpdateActionPerformed);

        PT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        PT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Delete.setText("Delete");
        PT_Delete.addActionListener(this::PT_DeleteActionPerformed);

        PT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        PT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16));
        PT_Clear.setText("Clear");
        PT_Clear.addActionListener(this::PT_ClearActionPerformed);

        javax.swing.GroupLayout PT_LeftPanelLayout = new javax.swing.GroupLayout(PT_LeftPanel);
        PT_LeftPanel.setLayout(PT_LeftPanelLayout);
        PT_LeftPanelLayout.setHorizontalGroup(
            PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PT_LeftPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                        .addComponent(PT_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PT_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PT_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PT_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PT_LeftPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PT_College, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_CollegeField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeptHead, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeptHeadField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Dean, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeanField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PT_LeftPanelLayout.setVerticalGroup(
            PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PT_LeftPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(PT_College)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_CollegeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_Program)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_Dean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_DeanField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PT_DeptHead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PT_DeptHeadField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(PT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PT_Add)
                    .addComponent(PT_Update)
                    .addComponent(PT_Delete)
                    .addComponent(PT_Clear))
                .addGap(14, 14, 14))
        );

        PT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        PT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Department College", "Program", "Department Head", "Dean"
            }
        ));
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
        String college = PT_CollegeField.getSelectedItem().toString();
        String program = PT_ProgramField.getSelectedItem().toString();
        String deptHead = PT_DeptHeadField.getSelectedItem().toString();
        String dean = PT_DeanField.getSelectedItem().toString();

        Department newDepartment = new Department(college, program, dean, deptHead);

        boolean success = db.getDepartment().createDepartment(newDepartment);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to add department.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        departmentList.add(newDepartment);
        DefaultTableModel model = (DefaultTableModel) PT_Table.getModel();
        model.addRow(new Object[]{college, program, deptHead, dean});

        JOptionPane.showMessageDialog(this, "Successfully Added!");
        PT_ClearActionPerformed(null);
    }

    private void PT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = PT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String college = PT_CollegeField.getSelectedItem().toString();
        String program = PT_ProgramField.getSelectedItem().toString();
        String deptHead = PT_DeptHeadField.getSelectedItem().toString();
        String dean = PT_DeanField.getSelectedItem().toString();

        Department updatedDepartment = new Department(college, program, dean, deptHead);

        boolean success = db.getDepartment().updateDepartment(updatedDepartment);
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to update department.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        departmentList.set(selectedRow, updatedDepartment);

        DefaultTableModel model = (DefaultTableModel) PT_Table.getModel();
        model.setValueAt(college, selectedRow, 0);
        model.setValueAt(program, selectedRow, 1);
        model.setValueAt(deptHead, selectedRow, 2);
        model.setValueAt(dean, selectedRow, 3);

        JOptionPane.showMessageDialog(this, "Successfully Updated!");
    }

    private void PT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = PT_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Department toDelete = departmentList.get(selectedRow);

        boolean success = db.getDepartment().deleteDepartment(toDelete.getProgram());
        if (!success) {
            JOptionPane.showMessageDialog(this, "Failed to delete department.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        departmentList.remove(selectedRow);
        DefaultTableModel model = (DefaultTableModel) PT_Table.getModel();
        model.removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Successfully Deleted!");
        PT_ClearActionPerformed(null);
    }

    private void PT_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        PT_CollegeField.setSelectedIndex(0);
        PT_ProgramField.setSelectedIndex(0);
        PT_DeptHeadField.setSelectedIndex(0);
        PT_DeanField.setSelectedIndex(0);
        PT_Table.clearSelection();
    }

    private void PT_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = PT_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) PT_Table.getModel();

            PT_CollegeField.setSelectedItem(model.getValueAt(selectedRow, 0));
            PT_ProgramField.setSelectedItem(model.getValueAt(selectedRow, 1));
            PT_DeptHeadField.setSelectedItem(model.getValueAt(selectedRow, 2));
            PT_DeanField.setSelectedItem(model.getValueAt(selectedRow, 3));
        } else {
            PT_ClearActionPerformed(null);
        }
    }

    private javax.swing.JButton PT_Add;
    private javax.swing.JButton PT_Clear;
    private javax.swing.JLabel PT_College;
    private javax.swing.JComboBox<String> PT_CollegeField;
    private javax.swing.JLabel PT_Dean;
    private javax.swing.JComboBox<String> PT_DeanField;
    private javax.swing.JButton PT_Delete;
    private javax.swing.JLabel PT_DeptHead;
    private javax.swing.JComboBox<String> PT_DeptHeadField;
    private javax.swing.JButton PT_Update;
    private javax.swing.JPanel PT_LeftPanel;
    private javax.swing.JLabel PT_Program;
    private javax.swing.JComboBox<String> PT_ProgramField;
    private javax.swing.JPanel PT_RightPanel;
    private javax.swing.JScrollPane PT_RightScrollPane;
    private javax.swing.JTable PT_Table;
}