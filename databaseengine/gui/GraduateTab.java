package databaseengine.gui;

public class GraduateTab extends javax.swing.JPanel {

    public GraduateTab() {
        initComponents();
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
        GrT_StudentField = new javax.swing.JComboBox<>();
        GrT_ProgramField = new javax.swing.JComboBox<>();
        GrT_UnitGradeField = new javax.swing.JTextField();
        GrT_RatingField = new javax.swing.JTextField();
        GrT_GraduationDateField = new javax.swing.JSpinner();
        GrT_FinalGradeField = new javax.swing.JTextField();
        GrT_MajorField = new javax.swing.JComboBox<>();
        GrT_Add = new javax.swing.JButton();
        GrT_Update = new javax.swing.JButton();
        GrT_Delete = new javax.swing.JButton();
        GrT_Clear = new javax.swing.JButton();
        GrT_RightPanel = new javax.swing.JPanel();
        GrT_RightScrollPane = new javax.swing.JScrollPane();
        GrT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        GrT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        GrT_Student.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Student.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Student.setText("Student");

        GrT_Program.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Program.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Program.setText("Program");

        GrT_UnitGrade.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_UnitGrade.setForeground(new java.awt.Color(250, 247, 245));
        GrT_UnitGrade.setText("Unit Grade");

        GrT_Rating.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Rating.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Rating.setText("Rating");

        GrT_GraduationDate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_GraduationDate.setForeground(new java.awt.Color(250, 247, 245));
        GrT_GraduationDate.setText("Graduation Date");

        GrT_FinalGrade.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_FinalGrade.setForeground(new java.awt.Color(250, 247, 245));
        GrT_FinalGrade.setText("Final Grade");

        GrT_Major.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Major.setForeground(new java.awt.Color(250, 247, 245));
        GrT_Major.setText("Major");

        GrT_StudentField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_StudentField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mary Suello", "John Doe", "Mark Santos", "Anna Reyes", "Paul Garcia", "Nina Lopez", "Chris Tan", "Angel Cruz", "Leo Ramos", "Kate Flores", "Ryan Lim", "Joy Dela Cruz", "Kevin Ong", "Liza Gomez", "James Bautista", "Mia Castillo", "Daniel Perez", "Sophia Navarro", "Ethan Villanueva", "Chloe Rivera" }));

        GrT_ProgramField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_ProgramField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor of Science in Computer Science", "Bachelor of Science in Information Technology", "Bachelor of Science in Information Systems" }));

        GrT_UnitGradeField.setEditable(false);
        GrT_UnitGradeField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_UnitGradeField.setText("read-only / auto");
        GrT_UnitGradeField.addActionListener(this::GrT_UnitGradeFieldActionPerformed);

        GrT_RatingField.setEditable(false);
        GrT_RatingField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_RatingField.setText("read-only / auto");
        GrT_RatingField.addActionListener(this::GrT_RatingFieldActionPerformed);

        GrT_FinalGradeField.setEditable(false);
        GrT_FinalGradeField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_FinalGradeField.setText("read-only / auto");
        GrT_FinalGradeField.addActionListener(this::GrT_FinalGradeFieldActionPerformed);

        GrT_MajorField.setBackground(new java.awt.Color(250, 247, 245));
        GrT_MajorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Software Engineering", "Networking", "Information Systems" }));

        GrT_Add.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Add.setText("Add");
        GrT_Add.addActionListener(this::GrT_AddActionPerformed);

        GrT_Update.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Update.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Update.setText("Update");
        GrT_Update.addActionListener(this::GrT_UpdateActionPerformed);

        GrT_Delete.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Delete.setText("Delete");
        GrT_Delete.addActionListener(this::GrT_DeleteActionPerformed);

        GrT_Clear.setBackground(new java.awt.Color(210, 180, 140));
        GrT_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        GrT_Clear.setText("Clear");

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

        GrT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Student", "Program", "Unit Grade", "Rating", "Graduation Date", "Final Grade", "Major"
            }
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
    }// </editor-fold>                        

    private void GrT_AddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void GrT_UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void GrT_DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void GrT_RatingFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void GrT_UnitGradeFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void GrT_FinalGradeFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

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
    private javax.swing.JComboBox<String> GrT_StudentField;
    private javax.swing.JTable GrT_Table;
    private javax.swing.JLabel GrT_UnitGrade;
    private javax.swing.JTextField GrT_UnitGradeField;
    private javax.swing.JButton GrT_Update;
}