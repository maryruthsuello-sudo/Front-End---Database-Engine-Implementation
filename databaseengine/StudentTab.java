package databaseengine;

public class StudentTab extends javax.swing.JPanel {

    public StudentTab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

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
        ST_BirthdayField = new javax.swing.JSpinner();
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

        ST_StudentID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_StudentID.setForeground(new java.awt.Color(250, 247, 245));
        ST_StudentID.setText("Student ID");

        ST_Name.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Name.setForeground(new java.awt.Color(250, 247, 245));
        ST_Name.setText("Name");

        ST_Birthday.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Birthday.setForeground(new java.awt.Color(250, 247, 245));
        ST_Birthday.setText("Birthday");

        ST_Birthplace.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Birthplace.setForeground(new java.awt.Color(250, 247, 245));
        ST_Birthplace.setText("Birthplace");

        ST_Address.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Address.setForeground(new java.awt.Color(250, 247, 245));
        ST_Address.setText("Address");

        ST_HighSchool.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_HighSchool.setForeground(new java.awt.Color(250, 247, 245));
        ST_HighSchool.setText("High School");

        ST_Category.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Category.setForeground(new java.awt.Color(250, 247, 245));
        ST_Category.setText("Category");

        ST_StudentIDField.setEditable(false);
        ST_StudentIDField.setBackground(new java.awt.Color(250, 247, 245));
        ST_StudentIDField.setText("read-only / auto");
        ST_StudentIDField.addActionListener(this::ST_StudentIDFieldActionPerformed);

        ST_NameField.setBackground(new java.awt.Color(250, 247, 245));
        ST_NameField.addActionListener(this::ST_NameFieldActionPerformed);

        ST_BirthplaceField.setBackground(new java.awt.Color(250, 247, 245));
        ST_BirthplaceField.addActionListener(this::ST_BirthplaceFieldActionPerformed);

        ST_AddressField.setBackground(new java.awt.Color(250, 247, 245));
        ST_AddressField.addActionListener(this::ST_AddressFieldActionPerformed);

        ST_HighSchoolField.setBackground(new java.awt.Color(250, 247, 245));
        ST_HighSchoolField.addActionListener(this::ST_HighSchoolFieldActionPerformed);

        ST_CategoryField.setBackground(new java.awt.Color(250, 247, 245));
        ST_CategoryField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regular", "Irregular" }));

        ST_Add.setBackground(new java.awt.Color(210, 180, 140));
        ST_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Add.setText("Add");
        ST_Add.addActionListener(this::ST_AddActionPerformed);

        ST_Update.setBackground(new java.awt.Color(210, 180, 140));
        ST_Update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Update.setText("Update");
        ST_Update.addActionListener(this::ST_UpdateActionPerformed);

        ST_Delete.setBackground(new java.awt.Color(210, 180, 140));
        ST_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Delete.setText("Delete");
        ST_Delete.addActionListener(this::ST_DeleteActionPerformed);

        ST_Clear.setBackground(new java.awt.Color(210, 180, 140));
        ST_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        ST_Clear.setText("Clear");

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

        ST_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Birthday", "Birthplace", "Address", "High School", "Category"
            }
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
    }// </editor-fold>                        

    private void ST_AddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void ST_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void ST_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void ST_StudentIDFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void ST_NameFieldActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void ST_BirthplaceFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void ST_AddressFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void ST_HighSchoolFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
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