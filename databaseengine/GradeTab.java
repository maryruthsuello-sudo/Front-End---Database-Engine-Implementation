package databaseengine;

public class GradeTab extends javax.swing.JPanel {

    public GradeTab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        GT_LeftPanel = new javax.swing.JPanel();
        GT_Student = new javax.swing.JLabel();
        GT_SubjectCode = new javax.swing.JLabel();
        GT_Grade = new javax.swing.JLabel();
        GT_Units = new javax.swing.JLabel();
        GT_StudentField = new javax.swing.JComboBox<>();
        GT_SubjectCodeField = new javax.swing.JComboBox<>();
        GT_GradeField = new javax.swing.JSpinner();
        GT_UnitsField = new javax.swing.JTextField();
        GT_Add = new javax.swing.JButton();
        GT_Update = new javax.swing.JButton();
        GT_Delete = new javax.swing.JButton();
        GT_Clear = new javax.swing.JButton();
        GT_RightPanel = new javax.swing.JPanel();
        GT_RightScrollPane = new javax.swing.JScrollPane();
        GT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        GT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        GT_Student.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_Student.setForeground(new java.awt.Color(250, 247, 245));
        GT_Student.setText("Student");

        GT_SubjectCode.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_SubjectCode.setForeground(new java.awt.Color(250, 247, 245));
        GT_SubjectCode.setText("Subject Code");

        GT_Grade.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_Grade.setForeground(new java.awt.Color(250, 247, 245));
        GT_Grade.setText("Grade");

        GT_Units.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_Units.setForeground(new java.awt.Color(250, 247, 245));
        GT_Units.setText("Units");

        GT_StudentField.setBackground(new java.awt.Color(250, 247, 245));
        GT_StudentField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mary Suello", "John Doe", "Mark Santos", "Anna Reyes", "Paul Garcia", "Nina Lopez", "Chris Tan", "Angel Cruz", "Leo Ramos", "Kate Flores", "Ryan Lim", "Joy Dela Cruz", "Kevin Ong", "Liza Gomez", "James Bautista", "Mia Castillo", "Daniel Perez", "Sophia Navarro", "Ethan Villanueva", "Chloe Rivera" }));

        GT_SubjectCodeField.setBackground(new java.awt.Color(250, 247, 245));
        GT_SubjectCodeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CS101", "CS104", "CS201", "IT101", "IT201", "IT202", "IS101", "IS301", "IS302" }));

        GT_UnitsField.setEditable(false);
        GT_UnitsField.setBackground(new java.awt.Color(250, 247, 245));
        GT_UnitsField.setText("read-only / auto");

        GT_Add.setBackground(new java.awt.Color(210, 180, 140));
        GT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_Add.setText("Add");
        GT_Add.addActionListener(this::GT_AddActionPerformed);

        GT_Update.setBackground(new java.awt.Color(210, 180, 140));
        GT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_Update.setText("Update");
        GT_Update.addActionListener(this::GT_UpdateActionPerformed);

        GT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        GT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_Delete.setText("Delete");
        GT_Delete.addActionListener(this::GT_DeleteActionPerformed);

        GT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        GT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GT_Clear.setText("Clear");
        GT_Clear.addActionListener(this::GT_ClearActionPerformed);

        javax.swing.GroupLayout GT_LeftPanelLayout = new javax.swing.GroupLayout(GT_LeftPanel);
        GT_LeftPanel.setLayout(GT_LeftPanelLayout);
        GT_LeftPanelLayout.setHorizontalGroup(
            GT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GT_LeftPanelLayout.createSequentialGroup()
                .addGroup(GT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GT_LeftPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(GT_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GT_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GT_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GT_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GT_LeftPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(GT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GT_Units, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GT_Grade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GT_SubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GT_StudentField, 0, 306, Short.MAX_VALUE)
                            .addComponent(GT_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GT_SubjectCodeField, 0, 306, Short.MAX_VALUE)
                            .addComponent(GT_GradeField)
                            .addComponent(GT_UnitsField))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        GT_LeftPanelLayout.setVerticalGroup(
            GT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GT_LeftPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(GT_Student)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GT_StudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(GT_SubjectCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GT_SubjectCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(GT_Grade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GT_GradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(GT_Units)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GT_UnitsField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GT_Add)
                    .addComponent(GT_Update)
                    .addComponent(GT_Delete)
                    .addComponent(GT_Clear))
                .addGap(14, 14, 14))
        );

        GT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        GT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student", "Subject Code", "Grade", "Units"
            }
        ));
        GT_RightScrollPane.setViewportView(GT_Table);

        javax.swing.GroupLayout GT_RightPanelLayout = new javax.swing.GroupLayout(GT_RightPanel);
        GT_RightPanel.setLayout(GT_RightPanelLayout);
        GT_RightPanelLayout.setHorizontalGroup(
            GT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        GT_RightPanelLayout.setVerticalGroup(
            GT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GT_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GT_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void GT_AddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void GT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void GT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void GT_ClearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private javax.swing.JButton GT_Add;
    private javax.swing.JButton GT_Clear;
    private javax.swing.JButton GT_Delete;
    private javax.swing.JLabel GT_Grade;
    private javax.swing.JSpinner GT_GradeField;
    private javax.swing.JPanel GT_LeftPanel;
    private javax.swing.JPanel GT_RightPanel;
    private javax.swing.JScrollPane GT_RightScrollPane;
    private javax.swing.JLabel GT_Student;
    private javax.swing.JComboBox<String> GT_StudentField;
    private javax.swing.JLabel GT_SubjectCode;
    private javax.swing.JComboBox<String> GT_SubjectCodeField;
    private javax.swing.JTable GT_Table;
    private javax.swing.JLabel GT_Units;
    private javax.swing.JTextField GT_UnitsField;
    private javax.swing.JButton GT_Update;
}