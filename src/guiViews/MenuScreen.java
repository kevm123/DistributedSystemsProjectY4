/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiViews;

import controllers.GameController;
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
    static String username;
    /**
     * Creates new form MenuScreen
     */
    public MenuScreen(int userId, String username) {
        this.userId = userId;
        this.username = username;
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

        playerScoreBtn = new javax.swing.JButton();
        playedGamesBtn = new javax.swing.JButton();
        newGameBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        joinBtn = new javax.swing.JButton();
        warnLbl = new javax.swing.JLabel();
        leaderBoardBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playerScoreBtn.setText("Player Scores");
        playerScoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerScoreBtnActionPerformed(evt);
            }
        });

        playedGamesBtn.setText("Played Games");
        playedGamesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playedGamesBtnActionPerformed(evt);
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

        leaderBoardBtn.setText("Leaderboard");
        leaderBoardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderBoardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerScoreBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playedGamesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leaderBoardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
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
                    .addComponent(playerScoreBtn)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leaderBoardBtn)
                        .addGap(18, 18, 18)
                        .addComponent(playedGamesBtn)
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
        GameScreen gameScreen = new GameScreen(userId, gameIdInt);  
        GameController gameController = new GameController(game, gameScreen);
        gameScreen.setVisible(true);
        //this.dispose();
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
                GameScreen gameScreen = new GameScreen(userId, gameIdInt);
                GameController gameController = new GameController(game, gameScreen);             
                gameScreen.setVisible(true);
                //this.dispose();
            }else if(resultInt == 0){
                warnLbl.setText("ERROR");
            }else{
                warnLbl.setText("ERROR");
            }
            
        }else{
            warnLbl.setText("Select a game ID");
            
        }
        
        
    }//GEN-LAST:event_joinBtnActionPerformed

    private void playedGamesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playedGamesBtnActionPerformed
        // TODO add your handling code here:
        LeagueScreen league = new LeagueScreen(userId, username);
        league.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_playedGamesBtnActionPerformed

    private void playerScoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerScoreBtnActionPerformed
        // TODO add your handling code here:
        ScoreScreen playerScores = new ScoreScreen(userId, username);
        playerScores.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_playerScoreBtnActionPerformed

    private void leaderBoardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderBoardBtnActionPerformed
        // TODO add your handling code here:
        LeaderboardScreen leaderboardScores = new LeaderboardScreen(userId, username);
        leaderboardScores.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_leaderBoardBtnActionPerformed

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
                new MenuScreen(userId, username).setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gameTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinBtn;
    private javax.swing.JButton leaderBoardBtn;
    private javax.swing.JButton newGameBtn;
    private javax.swing.JButton playedGamesBtn;
    private javax.swing.JButton playerScoreBtn;
    private javax.swing.JLabel warnLbl;
    // End of variables declaration//GEN-END:variables
}
