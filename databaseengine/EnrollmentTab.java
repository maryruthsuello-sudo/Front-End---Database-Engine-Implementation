package databaseengine;

public class EnrollmentTab extends javax.swing.JPanel {

    public EnrollmentTab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        ET_LeftPanel = new javax.swing.JPanel();
        ET_Student = new javax.swing.JLabel();
        ET_Program = new javax.swing.JLabel();
        ET_SchoolYear = new javax.swing.JLabel();
        ET_DateAdmitted = new javax.swing.JLabel();
        ET_StudentField = new javax.swing.JComboBox<>();
        ET_ProgramField = new javax.swing.JComboBox<>();
        ET_SchoolYearField = new javax.swing.JTextField();
        ET_DateAdmittedField = new javax.swing.JSpinner();
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
        ET_Student.setText("Student");

        ET_Program.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_Program.setForeground(new java.awt.Color(250, 247, 245));
        ET_Program.setText("Program");

        ET_SchoolYear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_SchoolYear.setForeground(new java.awt.Color(250, 247, 245));
        ET_SchoolYear.setText("School Year");

        ET_DateAdmitted.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ET_DateAdmitted.setForeground(new java.awt.Color(250, 247, 245));
        ET_DateAdmitted.setText("Date Admitted");

        ET_StudentField.setBackground(new java.awt.Color(250, 247, 245));
        ET_StudentField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mary Suello", "John Doe", "Mark Santos", "Anna Reyes", "Paul Garcia", "Nina Lopez", "Chris Tan", "Angel Cruz", "Leo Ramos", "Kate Flores", "Ryan Lim", "Joy Dela Cruz", "Kevin Ong", "Liza Gomez", "James Bautista", "Mia Castillo", "Daniel Perez", "Sophia Navarro", "Ethan Villanueva", "Chloe Rivera" }));

        ET_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        ET_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor of Science in Computer Science", "Bachelor of Science in Information Technology", "Bachelor of Science in Information Systems" }));

        ET_SchoolYearField.setEditable(false);
        ET_SchoolYearField.setBackground(new java.awt.Color(250, 247, 245));
        ET_SchoolYearField.setText("read-only / auto");

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
                            .addComponent(ET_DateAdmitted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_SchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_StudentField, 0, 306, Short.MAX_VALUE)
                            .addComponent(ET_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ET_ProgramField, 0, 306, Short.MAX_VALUE)
                            .addComponent(ET_DateAdmittedField)
                            .addComponent(ET_SchoolYearField))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ET_LeftPanelLayout.setVerticalGroup(
            ET_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ET_LeftPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(ET_Student)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_StudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(ET_Program)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(ET_SchoolYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ET_SchoolYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student", "Program", "School Year", "Date Admitted"
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

    private void ET_AddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void ET_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void ET_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void ET_ClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
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
    private javax.swing.JLabel ET_Student;
    private javax.swing.JComboBox<String> ET_StudentField;
    private javax.swing.JTable ET_Table;
    private javax.swing.JButton ET_Update;
}