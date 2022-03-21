package TetrisHomework;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

/**
 *
 * @author zgl
 */
public class NewJFrame extends javax.swing.JFrame {

    NewJPanel jp = new NewJPanel();
    NewJPanel1 jp1 = new NewJPanel1(jp);
    Controller co = new Controller(jp, jp1, this);

    public NewJFrame() {
        initComponents();

        //游戏图标
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TetrisHomework/图标.jpg")));
        jLabel1.setSize(400, 150);
        jLabel1.setLocation(25, 25);
        this.getContentPane().add(jLabel1);
        jLabel1.setVisible(true);

        //开始游戏按钮
        jButton1.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        jButton1.setText("开始游戏");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setSize(200, 85);
        jButton1.setLocation(125, 350);
        this.getContentPane().add(jButton1);
        jButton1.setVisible(true);

        //难度选择   
        combox1.addItem("-难度选择-");
        combox1.addItem("简单");
        combox1.addItem("中等");
        combox1.addItem("困难");
        combox1.addItem("噩梦");
        combox1.setFont(new java.awt.Font("宋体", 0, 24));
        combox1.setSize(155, 50);
        combox1.setLocation(152, 225);
        this.getContentPane().add(combox1);
        combox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {     // 查看是否为新选中的选项触发
                    if (evt.getItem().equals("简单")) {  // 查看触发的选项
                        co.speed = 700;
                    } else if (evt.getItem().equals("中等")) {
                        co.speed = 500;
                    } else if (evt.getItem().equals("困难")) {
                        co.speed = 300;
                    } else if (evt.getItem().equals("噩梦")) {
                        co.speed = 100;
                    }
                }
            }
        });

        //游戏结束
        jLabel2.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        jLabel2.setText("游戏结束");
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setSize(150, 50);
        jLabel2.setLocation(150, 175);
        this.getContentPane().add(jLabel2);
        jLabel2.setVisible(false);

        //分数显示
        jLabel3.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        jLabel3.setText("你的分数：100");
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setSize(450, 75);
        jLabel3.setLocation(0, 225);
        this.getContentPane().add(jLabel3);
        jLabel3.setVisible(false);

        //重新开始
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        jButton2.setText("重新开始");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setSize(175, 85);
        jButton2.setLocation(250, 375);
        this.getContentPane().add(jButton2);
        jButton2.setVisible(false);

        //结束游戏
        jButton3.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        jButton3.setText("结束游戏");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setSize(175, 85);
        jButton3.setLocation(25, 375);
        this.getContentPane().add(jButton3);
        jButton3.setVisible(false);

        //署名
        jLabel4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("by——Destiny12138");
        jLabel4.setSize(250, 25);
        jLabel4.setLocation(200, 465);
        this.getContentPane().add(jLabel4);
        jLabel4.setVisible(true);

        //提示
        jLabel5.setFont(new java.awt.Font("宋体", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("注意：难度将随分数提高而提高");
        jLabel5.setSize(300, 25);
        jLabel5.setLocation(75, 300);
        this.getContentPane().add(jLabel5);
        jLabel5.setVisible(true);

        //游戏界面
        jp.setSize(200, 400);
        jp.setLocation(50, 50);
        this.getContentPane().add(jp);

        jp1.setSize(130, 400);
        jp1.setLocation(300, 50);
        this.getContentPane().add(jp1);

        jp.setVisible(false);
        jp1.setVisible(false);
        this.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()) {
            case 37:
                co.left();
                break;
            case 39:
                co.right();
                break;
            case 40:
                co.down();
                break;
            case 38:
                co.up();
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.requestFocus();
        co.start();
        jp.restart();
        jp.setVisible(true);

        jp1.setVisible(true);
        jButton1.setVisible(false);
        jLabel1.setVisible(false);
        jLabel5.setVisible(false);
        combox1.setVisible(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.requestFocus();
        jp.restart();
        jp.setVisible(true);

        jp1.setVisible(true);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        combox1.setVisible(false);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

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
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    public javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    public javax.swing.JButton jButton1 = new javax.swing.JButton();
    public javax.swing.JButton jButton2 = new javax.swing.JButton();
    public javax.swing.JButton jButton3 = new javax.swing.JButton();
    public JComboBox<String> combox1 = new JComboBox<String>();
    public javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    public javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    public javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    public javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
