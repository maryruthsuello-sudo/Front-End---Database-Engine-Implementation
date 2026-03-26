package databaseengine;

public class TORTab extends javax.swing.JPanel {

    public TORTab() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        TT_LeftPanel = new javax.swing.JPanel();
        TT_Student = new javax.swing.JLabel();
        TT_DateCompleted = new javax.swing.JLabel();
        TT_StudentField = new javax.swing.JComboBox<>();
        TT_DateCompletedField = new javax.swing.JSpinner();
        TT_GenerateTOR = new javax.swing.JButton();
        TT_RightPanel = new javax.swing.JPanel();
        TT_RightScrollPane = new javax.swing.JScrollPane();
        TT_Table = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 65, 72));

        TT_LeftPanel.setBackground(new java.awt.Color(92, 35, 42));

        TT_Student.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        TT_Student.setForeground(new java.awt.Color(250, 247, 245));
        TT_Student.setText("Student");

        TT_DateCompleted.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        TT_DateCompleted.setForeground(new java.awt.Color(250, 247, 245));
        TT_DateCompleted.setText("Date Completed");

        TT_StudentField.setBackground(new java.awt.Color(250, 247, 245));
        TT_StudentField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mary Suello", "John Doe", "Mark Santos", "Anna Reyes", "Paul Garcia", "Nina Lopez", "Chris Tan", "Angel Cruz", "Leo Ramos", "Kate Flores", "Ryan Lim", "Joy Dela Cruz", "Kevin Ong", "Liza Gomez", "James Bautista", "Mia Castillo", "Daniel Perez", "Sophia Navarro", "Ethan Villanueva", "Chloe Rivera" }));

        TT_GenerateTOR.setBackground(new java.awt.Color(210, 180, 140));
        TT_GenerateTOR.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TT_GenerateTOR.setText("Generate TOR");
        TT_GenerateTOR.addActionListener(this::TT_GenerateTORActionPerformed);

        javax.swing.GroupLayout TT_LeftPanelLayout = new javax.swing.GroupLayout(TT_LeftPanel);
        TT_LeftPanel.setLayout(TT_LeftPanelLayout);
        TT_LeftPanelLayout.setHorizontalGroup(
            TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_LeftPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TT_Student, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TT_DateCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TT_GenerateTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TT_DateCompletedField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TT_StudentField, javax.swing.GroupLayout.Alignment.LEADING, 0, 306, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        TT_LeftPanelLayout.setVerticalGroup(
            TT_LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_LeftPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(TT_Student)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TT_StudentField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(TT_DateCompleted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TT_DateCompletedField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TT_GenerateTOR)
                .addGap(39, 39, 39))
        );

        TT_RightPanel.setBackground(new java.awt.Color(92, 35, 42));

        TT_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Student", "Date Completed"
            }
        ));
        TT_RightScrollPane.setViewportView(TT_Table);

        javax.swing.GroupLayout TT_RightPanelLayout = new javax.swing.GroupLayout(TT_RightPanel);
        TT_RightPanel.setLayout(TT_RightPanelLayout);
        TT_RightPanelLayout.setHorizontalGroup(
            TT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        TT_RightPanelLayout.setVerticalGroup(
            TT_RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TT_RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TT_RightScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TT_LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TT_LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TT_RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void TT_GenerateTORActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private javax.swing.JLabel TT_DateCompleted;
    private javax.swing.JSpinner TT_DateCompletedField;
    private javax.swing.JButton TT_GenerateTOR;
    private javax.swing.JPanel TT_LeftPanel;
    private javax.swing.JPanel TT_RightPanel;
    private javax.swing.JScrollPane TT_RightScrollPane;
    private javax.swing.JLabel TT_Student;
    private javax.swing.JComboBox<String> TT_StudentField;
    private javax.swing.JTable TT_Table;
}