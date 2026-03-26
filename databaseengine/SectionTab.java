package databaseengine;

public class SectionTab extends javax.swing.JPanel {

    public SectionTab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        SeT_LeftPanel = new javax.swing.JPanel();
        SeT_CourseYear = new javax.swing.JLabel();
        SeT_NumOfStudents = new javax.swing.JLabel();
        SeT_SubjectCode = new javax.swing.JLabel();
        SeT_CourseYearField = new javax.swing.JComboBox<>();
        SeT_NumOfStudentsField = new javax.swing.JTextField();
        SeT_SubjectCodeField = new javax.swing.JComboBox<>();
        SeT_Add = new javax.swing.JButton();
        SeT_Update = new javax.swing.JButton();
        SeT_Delete = new javax.swing.JButton();
        SeT_Clear = new javax.swing.JButton();
        SeT_RightPanel = new javax.swing.JPanel();
        SeT_RightScrollPane = new javax.swing.JScrollPane();
        SeT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        SeT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        SeT_CourseYear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SeT_CourseYear.setForeground(new java.awt.Color(250, 247, 245));
        SeT_CourseYear.setText("Course Year");

        SeT_NumOfStudents.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SeT_NumOfStudents.setForeground(new java.awt.Color(250, 247, 245));
        SeT_NumOfStudents.setText("Number of Students");

        SeT_SubjectCode.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SeT_SubjectCode.setForeground(new java.awt.Color(250, 247, 245));
        SeT_SubjectCode.setText("Subject Code");

        SeT_CourseYearField.setBackground(new java.awt.Color(250, 247, 245));
        SeT_CourseYearField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Year", "2nd Year", "3rd Year", "4th Year" }));

        SeT_NumOfStudentsField.setEditable(false);
        SeT_NumOfStudentsField.setBackground(new java.awt.Color(250, 247, 245));
        SeT_NumOfStudentsField.setText("read-only / auto");

        SeT_SubjectCodeField.setBackground(new java.awt.Color(250, 247, 245));
        SeT_SubjectCodeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CS101", "CS104", "CS201", "IT101", "IT201", "IT202", "IS101", "IS301", "IS302" }));

        SeT_Add.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SeT_Add.setText("Add");
        SeT_Add.addActionListener(this::SeT_AddActionPerformed);

        SeT_Update.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SeT_Update.setText("Update");
        SeT_Update.addActionListener(this::SeT_UpdateActionPerformed);

        SeT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SeT_Delete.setText("Delete");
        SeT_Delete.addActionListener(this::SeT_DeleteActionPerformed);

        SeT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        SeT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
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
                            .addComponent(SeT_NumOfStudentsField))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        SeT_LeftPanelLayout.setVerticalGroup(
            SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeT_LeftPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(SeT_CourseYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeT_CourseYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(SeT_NumOfStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeT_NumOfStudentsField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(SeT_SubjectCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeT_SubjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SeT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeT_Add)
                    .addComponent(SeT_Update)
                    .addComponent(SeT_Delete)
                    .addComponent(SeT_Clear))
                .addGap(14, 14, 14))
        );

        SeT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        SeT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Year", "Number of Students", "Subject Code"
            }
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
    }// </editor-fold>                        

    private void SeT_AddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void SeT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void SeT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void SeT_ClearActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private javax.swing.JButton SeT_Add;
    private javax.swing.JButton SeT_Clear;
    private javax.swing.JLabel SeT_CourseYear;
    private javax.swing.JComboBox<String> SeT_CourseYearField;
    private javax.swing.JButton SeT_Delete;
    private javax.swing.JPanel SeT_LeftPanel;
    private javax.swing.JLabel SeT_NumOfStudents;
    private javax.swing.JTextField SeT_NumOfStudentsField;
    private javax.swing.JPanel SeT_RightPanel;
    private javax.swing.JScrollPane SeT_RightScrollPane;
    private javax.swing.JLabel SeT_SubjectCode;
    private javax.swing.JComboBox<String> SeT_SubjectCodeField;
    private javax.swing.JTable SeT_Table;
    private javax.swing.JButton SeT_Update;
}