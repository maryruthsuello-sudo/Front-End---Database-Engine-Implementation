package databaseengine;

public class CourseTab extends javax.swing.JPanel {

    public CourseTab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

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
        CT_SubjectCodeField = new javax.swing.JComboBox<>();
        CT_UnitsField = new javax.swing.JTextField();
        CT_DescriptiveTitleField = new javax.swing.JTextField();
        CT_GradeField = new javax.swing.JSpinner();
        CT_TimeField = new javax.swing.JTextField();
        CT_TermField = new javax.swing.JComboBox<>();
        CT_DateSubmittedField = new javax.swing.JSpinner();
        CT_Add = new javax.swing.JButton();
        CT_Update = new javax.swing.JButton();
        CT_Delete = new javax.swing.JButton();
        CT_Clear = new javax.swing.JButton();
        CT_RightPanel = new javax.swing.JPanel();
        CT_RightScrollPane = new javax.swing.JScrollPane();
        CT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        CT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        CT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        CT_Program.setForeground(new java.awt.Color(250, 247, 245));
        CT_Program.setText("Program");

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

        CT_SubjectCodeField.setBackground(new java.awt.Color(250, 247, 245));
        CT_SubjectCodeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CS101", "CS104", "CS201", "IT101", "IT201", "IT202", "IS101", "IS301", "IS302" }));

        CT_UnitsField.setEditable(false);
        CT_UnitsField.setBackground(new java.awt.Color(250, 247, 245));
        CT_UnitsField.setText("read-only / auto");
        CT_UnitsField.addActionListener(this::CT_UnitsFieldActionPerformed);

        CT_DescriptiveTitleField.setEditable(false);
        CT_DescriptiveTitleField.setBackground(new java.awt.Color(250, 247, 245));
        CT_DescriptiveTitleField.setText("read-only / auto");
        CT_DescriptiveTitleField.addActionListener(this::CT_DescriptiveTitleFieldActionPerformed);

        CT_TimeField.setBackground(new java.awt.Color(250, 247, 245));
        CT_TimeField.addActionListener(this::CT_TimeFieldActionPerformed);

        CT_TermField.setBackground(new java.awt.Color(250, 247, 245));
        CT_TermField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Sem", "2nd Sem" }));

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
                            .addComponent(CT_SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CT_DescriptiveTitleField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_TimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_TermField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CT_DateSubmittedField)
                            .addComponent(CT_ProgramField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CT_UnitsField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(CT_SubjectCodeField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CT_GradeField))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        CT_LeftPanelLayout.setVerticalGroup(
            CT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CT_LeftPanelLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(CT_Program)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(CT_SubjectCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_SubjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(CT_Units)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_UnitsField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(CT_DescriptiveTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_DescriptiveTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_Grade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_GradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(CT_Time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_Term)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_TermField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CT_DateSubmitted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CT_DateSubmittedField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CT_Add)
                    .addComponent(CT_Update)
                    .addComponent(CT_Delete)
                    .addComponent(CT_Clear))
                .addGap(14, 14, 14))
        );

        CT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        CT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
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
    }// </editor-fold>                        

    private void CT_AddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void CT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void CT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
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

    private javax.swing.JButton CT_Add;
    private javax.swing.JButton CT_Clear;
    private javax.swing.JLabel CT_DateSubmitted;
    private javax.swing.JSpinner CT_DateSubmittedField;
    private javax.swing.JButton CT_Delete;
    private javax.swing.JLabel CT_DescriptiveTitle;
    private javax.swing.JTextField CT_DescriptiveTitleField;
    private javax.swing.JLabel CT_Grade;
    private javax.swing.JSpinner CT_GradeField;
    private javax.swing.JPanel CT_LeftPanel;
    private javax.swing.JLabel CT_Program;
    private javax.swing.JComboBox<String> CT_ProgramField;
    private javax.swing.JPanel CT_RightPanel;
    private javax.swing.JScrollPane CT_RightScrollPane;
    private javax.swing.JLabel CT_SubjectCode;
    private javax.swing.JComboBox<String> CT_SubjectCodeField;
    private javax.swing.JTable CT_Table;
    private javax.swing.JLabel CT_Term;
    private javax.swing.JComboBox<String> CT_TermField;
    private javax.swing.JLabel CT_Time;
    private javax.swing.JTextField CT_TimeField;
    private javax.swing.JLabel CT_Units;
    private javax.swing.JTextField CT_UnitsField;
    private javax.swing.JButton CT_Update;
}