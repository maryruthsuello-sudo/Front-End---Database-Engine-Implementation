package databaseengine.gui;

import databaseengine.backend.Database;
import databaseengine.backend.StartDatabase;

public class MainGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainGUI.class.getName());
    

    public MainGUI() {
        initComponents();
    }
   

    private void initComponents() {
        StartDatabase startDb = new StartDatabase();
        Database db = startDb.getDb();

        MainPanel = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Tabs = new javax.swing.JTabbedPane();
        ST = new databaseengine.gui.StudentTab(db);
        PT = new databaseengine.gui.ProgramTab();
        CT = new databaseengine.gui.CourseTab();
        ET = new databaseengine.gui.EnrollmentTab();
        SeT = new databaseengine.gui.SectionTab();
        GT = new databaseengine.gui.GradeTab();
        GrT = new databaseengine.gui.GraduateTab();
        TT = new databaseengine.gui.TORTab();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(245, 240, 237));

        TopPanel.setBackground(new java.awt.Color(92, 35, 42));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(245, 240, 237));
        Title.setText("Student Management System");

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1006, Short.MAX_VALUE))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabs.setBackground(new java.awt.Color(130, 65, 72));
        Tabs.setForeground(new java.awt.Color(245, 240, 237));
        Tabs.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        Tabs.addTab("Students", ST);
        Tabs.addTab("Enrollment", ET);
        Tabs.addTab("Department", PT);
        Tabs.addTab("Courses", CT);
        Tabs.addTab("Sections", SeT);
        Tabs.addTab("Grades", GT);
        Tabs.addTab("Graduates", GrT);
        Tabs.addTab("TOR", TT);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tabs)
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabs)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> new MainGUI().setVisible(true));
    }

    private databaseengine.gui.CourseTab CT;
    private databaseengine.gui.EnrollmentTab ET;
    private databaseengine.gui.GradeTab GT;
    private databaseengine.gui.GraduateTab GrT;
    private javax.swing.JPanel MainPanel;
    private databaseengine.gui.ProgramTab PT;
    private databaseengine.gui.StudentTab ST;
    private databaseengine.gui.SectionTab SeT;
    private databaseengine.gui.TORTab TT;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel TopPanel;

    //hello world
}