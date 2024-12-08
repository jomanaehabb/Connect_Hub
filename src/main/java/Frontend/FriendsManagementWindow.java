/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.FriendsManagement;

/**
 *
 * @author Lenovo
 */
public class FriendsManagementWindow extends javax.swing.JPanel {
    private FriendsManagement connectHub; // Backend connection
    private String currentUsername; // Current logged-in username

    /**
     * Constructor for FriendsManagementWindow
     * @param username The username of the logged-in user
     */
    public FriendsManagementWindow(String username) {
        this.currentUsername = username;
        this.connectHub = new FriendsManagement(); // Initialize backend connection

        initComponents();   // Initialize GUI components (auto-generated)
        initializeTabs(username);   // Load dynamic content into the tabs
    }

    /**
     * NetBeans auto-generated method to initialize GUI components.
     * This method cannot be changed.
     */
    private void initializeTabs(String username) {
        // Tab 1: Friend Requests
        FriendRequestWindow friendRequestsPanel = new FriendRequestWindow(username, connectHub);
        jTabbedPane1.setComponentAt(0, friendRequestsPanel);

        // Tab 2: Friends List
        FriendsListWindow friendsListPanel = new FriendsListWindow(username,connectHub);
        jTabbedPane1.setComponentAt(1, friendsListPanel);

        // Tab 3: Suggested Friends
        SuggestedFriendsWindow suggestFriendsPanel = new SuggestedFriendsWindow(username, connectHub);
        jTabbedPane1.setComponentAt(2, suggestFriendsPanel);
    }

    /**
     * Custom initialization method to load dynamic content into the tabs.
     * This method allows dynamic updates based on the logged-in username.
     * @param username The username of the logged-in user
     */
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Friend Requests", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Friends List", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Suggested Friends", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Friend Requests");
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration                   
}
