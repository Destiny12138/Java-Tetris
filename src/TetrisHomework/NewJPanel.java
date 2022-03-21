
package TetrisHomework;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author zgl
 */
public class NewJPanel extends javax.swing.JPanel {

    int x = 40, y = 0;
    int score = 0;
    Random r = new Random();
    Blocks blocks = new Blocks();
    int[][] nextblocks = blocks.newNextBlock();
    int[][] nowblocks = blocks.newNextBlock();
    int status = r.nextInt(nowblocks.length);
    int[] nowblock;
    int[][] map = new int[21][12];

    /**
     * Creates new form NewJPanel
     */
    public NewJPanel() {
        initComponents();
        newMap();
    }

    public void newMap() {
        for (int i = 0; i < 11; i++) {
            map[20][i] = 2;
        }
        for (int i = 0; i < 21; i++) {
            map[i][0] = 2;
            map[i][11] = 2;
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 1; j <= 10; j++) {
                map[i][j] = 0;
            }
        }
    }

    public void drawblock(Graphics g) {
        nowblock = nowblocks[status];
        g.setColor(switchcolor(nowblocks));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (nowblock[j + i * 4] == 1) {
                    g.fill3DRect((x + j * 20), (y + i * 20), 20, 20, true);
                }
            }
        }
    }

    public void drawmap(Graphics g) {
        g.setColor(Color.gray);
        for (int i = 0; i < 20; i++) {
            for (int j = 1; j < 11; j++) {
                if (map[i][j] == 1) {
                    g.fill3DRect((j * 20 - 20), (i * 20), 20, 20, false);
                }
            }
        }
    }

    public void nextblocks() {
        nowblocks = nextblocks;
        nextblocks = blocks.newNextBlock();
        status = r.nextInt(nowblocks.length);
    }

    public Color switchcolor(int[][] bl) {
        if (bl == blocks.t || bl == blocks.t2) {
            return Color.red;
        } else if (bl == blocks.la || bl == blocks.lb) {
            return Color.blue;
        } else if (bl == blocks.z1
                || bl == blocks.z2) {
            return Color.ORANGE;
        } else if (bl == blocks.l1 || bl == blocks.l2) {
            return Color.CYAN;
        } else {
            return Color.GREEN;
        }
    }

    public void restart() {
        nextblocks = blocks.newNextBlock();
        nowblocks = blocks.newNextBlock();
        status = r.nextInt(nowblocks.length);
        x = 40;
        y = 0;
        score = 0;
        this.newMap();
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawblock(g);
        drawmap(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 204));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}