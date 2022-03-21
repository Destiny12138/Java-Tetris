package TetrisHomework;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zgl
 */
public class Controller extends Thread {

    NewJPanel jp;
    Rule rule;
    NewJPanel1 jp1;
    NewJFrame gjf;
    int speed = 700;

    public Controller(NewJPanel jp, NewJPanel1 jp1, NewJFrame gjf) {
        this.jp = jp;
        this.jp1 = jp1;
        this.rule = new Rule(this.jp);
        this.gjf = gjf;
    }

    @Override
    public void run() {

        while (rule.isright(jp.x, jp.y)) {
            try {
                sleep(speed);
                down();
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void left() {
        if (rule.isright(jp.x - 20, jp.y)) {
            jp.x -= 20;
            jp.repaint();
        }

    }

    public void right() {
        if (rule.isright(jp.x + 20, jp.y)) {
            jp.x += 20;
            jp.repaint();
        }

    }

    public void down() {
        if (rule.isright(jp.x, jp.y + 20)) {
            jp.y += 20;
            jp.repaint();
        } else {
            rule.changeMap(jp.x, jp.y);
            jp.score += rule.delline();
            if (speed > 50) {
                speed -= jp.score;
            }
            jp1.jLabel2.setText(Integer.toString(jp.score));
            jp.nextblocks();
            jp.x = 40;
            jp.y = 0;
            if (!rule.isright(jp.x, jp.y)) {
                jp.repaint();
                rule.gameOver(gjf);

            }
            jp.repaint();
            jp1.repaint();
        }

    }

    public void up() {
        int a = jp.status;
        jp.status = (jp.status + 1) % jp.nowblocks.length;
        if (!rule.isright(jp.x, jp.y)) {
            jp.status = a;
        }
        jp.repaint();
    }
}
