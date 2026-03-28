package databaseengine.gui;

public class ProgramTab extends javax.swing.JPanel {

    public ProgramTab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        PT_LeftPanel = new javax.swing.JPanel();
        PT_Program = new javax.swing.JLabel();
        PT_Instructor = new javax.swing.JLabel();
        PT_Dean = new javax.swing.JLabel();
        PT_DeptHead = new javax.swing.JLabel();
        PT_ProgramField = new javax.swing.JComboBox<>();
        PT_InstructorField = new javax.swing.JComboBox<>();
        PT_DeanField = new javax.swing.JComboBox<>();
        PT_DeptHeadField = new javax.swing.JComboBox<>();
        PT_Add = new javax.swing.JButton();
        PT_Edit = new javax.swing.JButton();
        PT_Delete = new javax.swing.JButton();
        PT_ProgramField1 = new javax.swing.JComboBox<>();
        PT_Program1 = new javax.swing.JLabel();
        PT_DeptHeadField1 = new javax.swing.JComboBox<>();
        PT_DeptHead1 = new javax.swing.JLabel();
        PT_RightPanel = new javax.swing.JPanel();
        PT_RightScrollPane = new javax.swing.JScrollPane();
        PT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        PT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        PT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_Program.setForeground(new java.awt.Color(250, 247, 245));
        PT_Program.setText("Department College");

        PT_Instructor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_Instructor.setForeground(new java.awt.Color(250, 247, 245));
        PT_Instructor.setText("Department Head");

        PT_Dean.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_Dean.setForeground(new java.awt.Color(250, 247, 245));
        PT_Dean.setText("Dean");

        PT_DeptHead.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_DeptHead.setForeground(new java.awt.Color(250, 247, 245));
        PT_DeptHead.setText("Instructor");

        PT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        PT_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor of Science in Computer Science", "Bachelor of Science in Information Technology", "Bachelor of Science in Information Systems" }));

        PT_InstructorField.setBackground(new java.awt.Color(250, 247, 245));
        PT_InstructorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr. Lim", "Mr. Tan", "Mr. Ong" }));

        PT_DeanField.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeanField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr. Santos", "Dr. Gomez", "Dr. Lopez" }));

        PT_DeptHeadField.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeptHeadField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prof. Cruz", "Prof. Reyes", "Prof. Garcia" }));

        PT_Add.setBackground(new java.awt.Color(210, 180, 140));
        PT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_Add.setText("Add");
        PT_Add.addActionListener(this::PT_AddActionPerformed);

        PT_Edit.setBackground(new java.awt.Color(210, 180, 140));
        PT_Edit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_Edit.setText("Edit");
        PT_Edit.addActionListener(this::PT_EditActionPerformed);

        PT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        PT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_Delete.setText("Delete");
        PT_Delete.addActionListener(this::PT_DeleteActionPerformed);

        PT_ProgramField1.setBackground(new java.awt.Color(250, 247, 245));
        PT_ProgramField1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "College of Science", "College of Engineering", "College of Liberal Arts", "College of Architecture and Fine Arts", "College of Industrial Education", "College of Industrial Technology" }));

        PT_Program1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_Program1.setForeground(new java.awt.Color(250, 247, 245));
        PT_Program1.setText("Program");

        PT_DeptHeadField1.setBackground(new java.awt.Color(250, 247, 245));
        PT_DeptHeadField1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Introduction to Computing", "Programming Language 2", "Object-Oriented Programming", "Introduction to Information Technology", "Data Structures and Algorithm", "Information Management", "Introduction to Information Systems", "Systems Analysis and Design", "Application Development" }));

        PT_DeptHead1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        PT_DeptHead1.setForeground(new java.awt.Color(250, 247, 245));
        PT_DeptHead1.setText("Course");

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
                    .addComponent(PT_ProgramField1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeptHead, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeptHeadField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Dean, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_DeanField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Instructor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_InstructorField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_Program, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PT_ProgramField, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Department College", "Program", "Department Head", "Dean", "Instructor", "Course"
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
    }// </editor-fold>                        

    private void PT_AddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void PT_EditActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void PT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private javax.swing.JButton PT_Add;
    private javax.swing.JLabel PT_Dean;
    private javax.swing.JComboBox<String> PT_DeanField;
    private javax.swing.JButton PT_Delete;
    private javax.swing.JLabel PT_DeptHead;
    private javax.swing.JLabel PT_DeptHead1;
    private javax.swing.JComboBox<String> PT_DeptHeadField;
    private javax.swing.JComboBox<String> PT_DeptHeadField1;
    private javax.swing.JButton PT_Edit;
    private javax.swing.JLabel PT_Instructor;
    private javax.swing.JComboBox<String> PT_InstructorField;
    private javax.swing.JPanel PT_LeftPanel;
    private javax.swing.JLabel PT_Program;
    private javax.swing.JLabel PT_Program1;
    private javax.swing.JComboBox<String> PT_ProgramField;
    private javax.swing.JComboBox<String> PT_ProgramField1;
    private javax.swing.JPanel PT_RightPanel;
    private javax.swing.JScrollPane PT_RightScrollPane;
    private javax.swing.JTable PT_Table;
}