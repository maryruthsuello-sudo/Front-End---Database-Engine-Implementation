package databaseengine.gui;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import databaseengine.backend.Database;
import databaseengine.backend.model.Student;


public class StudentTab extends javax.swing.JPanel {

    private ArrayList<Student> studentList;
    private Database db;

    public StudentTab(Database db) {
        initComponents();
        this.db = db;
        loadTable();

        ST_Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    ST_TableSelectionChanged(e);
                }
            }
        });
    }

    // Fetches all students from DB and reloads the table
    private void loadTable() {
        this.studentList = db.getStudent().getAllStudents();
        DefaultTableModel model = (DefaultTableModel) ST_Table.getModel();
        model.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Student s : studentList) {
            model.addRow(new Object[]{
                String.valueOf(s.getId()),
                s.getName(),
                s.getBirthday() != null ? sdf.format(s.getBirthday()) : "",
                s.getBirthPlace(),
                s.getAddress(),
                s.getHighSchool(),
                s.getCategory()
            });
        }
    }

    private void initComponents() {

        ST_LeftPanel = new javax.swing.JPanel();
        ST_StudentID = new javax.swing.JLabel();
        ST_Name = new javax.swing.JLabel();
        ST_Birthday = new javax.swing.JLabel();
        ST_Birthplace = new javax.swing.JLabel();
        ST_Address = new javax.swing.JLabel();
        ST_HighSchool = new javax.swing.JLabel();
        ST_Category = new javax.swing.JLabel();
        ST_StudentIDField = new javax.swing.JTextField();
        ST_NameField = new javax.swing.JTextField();
        ST_BirthplaceField = new javax.swing.JTextField();
        ST_AddressField = new javax.swing.JTextField();
        ST_HighSchoolField = new javax.swing.JTextField();
        ST_BirthdayField = new JSpinner(new javax.swing.SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(ST_BirthdayField, "yyyy-MM-dd");
        ST_BirthdayField.setEditor(dateEditor);
        ST_BirthdayField.setValue(new java.util.Date());
        ST_CategoryField = new javax.swing.JComboBox<>();
        ST_Add = new javax.swing.JButton();
        ST_Update = new javax.swing.JButton();
        ST_Delete = new javax.swing.JButton();
        ST_Clear = new javax.swing.JButton();
        ST_RightPanel = new javax.swing.JPanel();
        ST_RightScrollPane = new javax.swing.JScrollPane();
        ST_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));
        ST_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        ST_StudentID.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_StudentID.setForeground(new java.awt.Color(250, 247, 245));
        ST_StudentID.setText("Student ID");

        ST_Name.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Name.setForeground(new java.awt.Color(250, 247, 245));
        ST_Name.setText("Name");

        ST_Birthday.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Birthday.setForeground(new java.awt.Color(250, 247, 245));
        ST_Birthday.setText("Birthday");

        ST_Birthplace.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Birthplace.setForeground(new java.awt.Color(250, 247, 245));
        ST_Birthplace.setText("Birthplace");

        ST_Address.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Address.setForeground(new java.awt.Color(250, 247, 245));
        ST_Address.setText("Address");

        ST_HighSchool.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_HighSchool.setForeground(new java.awt.Color(250, 247, 245));
        ST_HighSchool.setText("High School");

        ST_Category.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Category.setForeground(new java.awt.Color(250, 247, 245));
        ST_Category.setText("Category");

        // FIX: Student ID field is now editable so the user can type any ID
        ST_StudentIDField.setEditable(true);
        ST_StudentIDField.setBackground(new java.awt.Color(250, 247, 245));

        ST_NameField.setBackground(new java.awt.Color(250, 247, 245));
        ST_BirthplaceField.setBackground(new java.awt.Color(250, 247, 245));
        ST_AddressField.setBackground(new java.awt.Color(250, 247, 245));
        ST_HighSchoolField.setBackground(new java.awt.Color(250, 247, 245));

        ST_CategoryField.setBackground(new java.awt.Color(250, 247, 245));
        ST_CategoryField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Irregular" }));

        ST_Add.setBackground(new java.awt.Color(210, 180, 140));
        ST_Add.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Add.setText("Add");
        ST_Add.addActionListener(this::ST_AddActionPerformed);

        ST_Update.setBackground(new java.awt.Color(210, 180, 140));
        ST_Update.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Update.setText("Update");
        ST_Update.addActionListener(this::ST_UpdateActionPerformed);

        ST_Delete.setBackground(new java.awt.Color(210, 180, 140));
        ST_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Delete.setText("Delete");
        ST_Delete.addActionListener(this::ST_DeleteActionPerformed);

        ST_Clear.setBackground(new java.awt.Color(210, 180, 140));
        ST_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16));
        ST_Clear.setText("Clear");
        ST_Clear.addActionListener(this::ST_ClearActionPerformed);

        javax.swing.GroupLayout ST_LeftPanelLayout = new javax.swing.GroupLayout(ST_LeftPanel);
        ST_LeftPanel.setLayout(ST_LeftPanelLayout);
        ST_LeftPanelLayout.setHorizontalGroup(
            ST_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ST_LeftPanelLayout.createSequentialGroup()
                .addGroup(ST_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ST_LeftPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ST_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ST_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ST_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ST_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ST_LeftPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(ST_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ST_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_HighSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(ST_StudentIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(ST_Birthplace, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ST_BirthplaceField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(ST_AddressField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(ST_HighSchoolField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(ST_BirthdayField)
                            .addComponent(ST_CategoryField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ST_LeftPanelLayout.setVerticalGroup(
            ST_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ST_LeftPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ST_StudentID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST_StudentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ST_Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST_NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ST_Birthday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST_BirthdayField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ST_Birthplace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST_BirthplaceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ST_Address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST_AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ST_HighSchool)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST_HighSchoolField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ST_Category)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ST_CategoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(ST_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ST_Add)
                    .addComponent(ST_Update)
                    .addComponent(ST_Delete)
                    .addComponent(ST_Clear))
                .addGap(14, 14, 14))
        );

        ST_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        ST_Table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Name", "Birthday", "Birthplace", "Address", "High School", "Category"}
        ));

        ST_RightScrollPane.setViewportView(ST_Table);

        javax.swing.GroupLayout ST_RightPanelLayout = new javax.swing.GroupLayout(ST_RightPanel);
        ST_RightPanel.setLayout(ST_RightPanelLayout);
        ST_RightPanelLayout.setHorizontalGroup(
            ST_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ST_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ST_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        ST_RightPanelLayout.setVerticalGroup(
            ST_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ST_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ST_RightScrollPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ST_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ST_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ST_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ST_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    private void ST_AddActionPerformed(java.awt.event.ActionEvent evt) {
        // FIX: Read Student ID from the input field (now editable)
        String studentIdStr = ST_StudentIDField.getText().trim();
        if (studentIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int studentId;
        try {
            studentId = Integer.parseInt(studentIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Student ID must be a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = ST_NameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date birthdayDate = (Date) ST_BirthdayField.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(birthdayDate);

        String birthplace = ST_BirthplaceField.getText().trim();
        String address    = ST_AddressField.getText().trim();
        String highschool = ST_HighSchoolField.getText().trim();
        String category   = ST_CategoryField.getSelectedItem().toString();

        // FIX: Use the constructor that includes the ID so the typed ID is saved
        Student s = new Student(
            studentId,
            name,
            java.sql.Date.valueOf(birthday),
            birthplace,
            address,
            highschool,
            category
        );

        // FIX: Check return value and show proper feedback
        boolean created = db.getStudent().createStudent(s);
        if (created) {
            loadTable(); // re-fetch from DB so table shows real data
            ST_ClearActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Student added successfully!", "Add Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add student. The Student ID may already exist.", "Add Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ST_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = ST_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String name = ST_NameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Use the student from the in-memory list to keep the original DB id
        Student studentToUpdate = studentList.get(selectedRow);

        Date birthdayDate = (Date) ST_BirthdayField.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(birthdayDate);

        studentToUpdate.setName(name);
        studentToUpdate.setBirthday(java.sql.Date.valueOf(birthday));
        studentToUpdate.setBirthPlace(ST_BirthplaceField.getText().trim());
        studentToUpdate.setAddress(ST_AddressField.getText().trim());
        studentToUpdate.setHighSchool(ST_HighSchoolField.getText().trim());
        studentToUpdate.setCategory(ST_CategoryField.getSelectedItem().toString());

        // FIX: Actually persist the update to the database
        boolean updated = db.getStudent().updateStudent(studentToUpdate);
        if (updated) {
            loadTable(); // re-fetch from DB to keep table in sync
            ST_ClearActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Update failed. Please try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ST_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int row = ST_Table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this student?",
            "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        // FIX: Get the real DB id and actually delete from the database
        Student studentToDelete = studentList.get(row);
        boolean deleted = db.getStudent().deleteStudent(studentToDelete.getId());

        if (deleted) {
            loadTable(); // re-fetch from DB to keep table in sync
            ST_ClearActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Deleted successfully!", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Delete failed. Please try again.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ST_ClearActionPerformed(java.awt.event.ActionEvent evt) {
        ST_StudentIDField.setText("");
        ST_NameField.setText("");
        ST_BirthplaceField.setText("");
        ST_AddressField.setText("");
        ST_HighSchoolField.setText("");
        ST_CategoryField.setSelectedIndex(0);
        ST_BirthdayField.setValue(new Date());
        ST_Table.clearSelection();
    }

    private void ST_TableSelectionChanged(ListSelectionEvent e) {
        int selectedRow = ST_Table.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) ST_Table.getModel();

            String studentId  = (String) model.getValueAt(selectedRow, 0);
            String name       = (String) model.getValueAt(selectedRow, 1);
            String birthdayStr= (String) model.getValueAt(selectedRow, 2);
            String birthplace = (String) model.getValueAt(selectedRow, 3);
            String address    = (String) model.getValueAt(selectedRow, 4);
            String highschool = (String) model.getValueAt(selectedRow, 5);
            String category   = (String) model.getValueAt(selectedRow, 6);

            ST_StudentIDField.setText(studentId);
            ST_NameField.setText(name);
            ST_BirthplaceField.setText(birthplace);
            ST_AddressField.setText(address);
            ST_HighSchoolField.setText(highschool);
            ST_CategoryField.setSelectedItem(category);

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthdayDate = sdf.parse(birthdayStr);
                ST_BirthdayField.setValue(birthdayDate);
            } catch (ParseException ex) {
                System.err.println("Error parsing birthday date from table: " + ex.getMessage());
            }
        } else {
            ST_ClearActionPerformed(null);
        }
    }

    private javax.swing.JButton ST_Add;
    private javax.swing.JLabel ST_Address;
    private javax.swing.JTextField ST_AddressField;
    private javax.swing.JLabel ST_Birthday;
    private javax.swing.JSpinner ST_BirthdayField;
    private javax.swing.JLabel ST_Birthplace;
    private javax.swing.JTextField ST_BirthplaceField;
    private javax.swing.JLabel ST_Category;
    private javax.swing.JComboBox<String> ST_CategoryField;
    private javax.swing.JButton ST_Clear;
    private javax.swing.JButton ST_Delete;
    private javax.swing.JLabel ST_HighSchool;
    private javax.swing.JTextField ST_HighSchoolField;
    private javax.swing.JPanel ST_LeftPanel;
    private javax.swing.JLabel ST_Name;
    private javax.swing.JTextField ST_NameField;
    private javax.swing.JPanel ST_RightPanel;
    private javax.swing.JScrollPane ST_RightScrollPane;
    private javax.swing.JLabel ST_StudentID;
    private javax.swing.JTextField ST_StudentIDField;
    private javax.swing.JTable ST_Table;
    private javax.swing.JButton ST_Update;
}