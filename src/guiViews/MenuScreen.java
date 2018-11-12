/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiViews;

import daos.GameDao;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import models.Game;

/**
 *
 * @author windows
 */
public class MenuScreen extends javax.swing.JFrame {

    GameDao gameDao;
    static int userId;
    /**
     * Creates new form MenuScreen
     */
    public MenuScreen(int userId) {
        this.userId = userId;
        gameDao = new GameDao();
        initComponents();
        displayGames();
    }
    
    public void displayGames(){
        DefaultTableModel model = (DefaultTableModel) gameTable.getModel();
        model.setRowCount(0);
        String games = gameDao.getGames();
        String [] gamesArr = games.split("\\s*\n\\s*");
        String [] gameDetails;
        
        for(int i=0; i<gamesArr.length; i++){
            Vector row = new Vector();
            
            gameDetails = gamesArr[i].split("\\s*,\\s*");
             for(int j=0; j<gameDetails.length; j++){
                 
                 row.add(gameDetails[j]);
             }
             model.addRow(row);
        }
       
       
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        leagueBtn = new javax.swing.JButton();
        newGameBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        joinBtn = new javax.swing.JButton();
        warnLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Scores");

        leagueBtn.setText("League");
        leagueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leagueBtnActionPerformed(evt);
            }
        });

        newGameBtn.setText("New Game");
        newGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameBtnActionPerformed(evt);
            }
        });

        gameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GameID", "Username", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gameTable.setColumnSelectionAllowed(true);
        gameTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(gameTable);
        gameTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (gameTable.getColumnModel().getColumnCount() > 0) {
            gameTable.getColumnModel().getColumn(0).setResizable(false);
            gameTable.getColumnModel().getColumn(1).setResizable(false);
            gameTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Games to join");

        joinBtn.setText("Join Game");
        joinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinBtnActionPerformed(evt);
            }
        });

        warnLbl.setText("         .");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leagueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newGameBtn))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(joinBtn)
                        .addGap(52, 52, 52)
                        .addComponent(warnLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leagueBtn)
                        .addGap(18, 18, 18)
                        .addComponent(newGameBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joinBtn)
                    .addComponent(warnLbl))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameBtnActionPerformed
        // TODO add your handling code here:
       String gameIdStr =  gameDao.addGame(userId);
       int gameIdInt = Integer.parseInt(gameIdStr);
        displayGames();
        Game game = new Game(userId, gameIdInt, 1);
        GameScreen gameScreen = new GameScreen(userId, gameIdInt, game);
        gameScreen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newGameBtnActionPerformed

    private void joinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinBtnActionPerformed
        // TODO add your handling code here:
        
        
        int row = gameTable.getSelectedRow();
        int column = gameTable.getSelectedColumn();
        System.out.println(column);
        if(column ==0){    
             String gameIdStr = (String)gameTable.getValueAt(row, column );
             int gameIdInt = Integer.parseInt(gameIdStr);
            //System.out.println("GID = "+gameId);
            String resultStr = gameDao.joinGame(userId, gameIdInt);
            int resultInt = Integer.parseInt(resultStr);
            
            if(resultInt ==1){
                Game game = new Game(userId, gameIdInt, 2);
                GameScreen gameScreen = new GameScreen(userId, gameIdInt, game);
                gameScreen.setVisible(true);
                this.dispose();
            }else if(resultInt == 0){
                warnLbl.setText("ERROR");
            }else{
                warnLbl.setText("ERROR");
            }
            
        }else{
            warnLbl.setText("Select a game ID");
            
        }
        
        
    }//GEN-LAST:event_joinBtnActionPerformed

    private void leagueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leagueBtnActionPerformed
        // TODO add your handling code here:
        LeagueScreen league = new LeagueScreen(userId);
        league.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_leagueBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen(userId).setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gameTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinBtn;
    private javax.swing.JButton leagueBtn;
    private javax.swing.JButton newGameBtn;
    private javax.swing.JLabel warnLbl;
    // End of variables declaration//GEN-END:variables
}
