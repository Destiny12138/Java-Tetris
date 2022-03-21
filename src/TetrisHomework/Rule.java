package TetrisHomework;


/**
 *
 * @author zgl
 */
public class Rule {

    NewJPanel jp;

    public Rule(NewJPanel jp) {
        this.jp = jp;
    }

    public boolean isright(int x, int y) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((jp.nowblocks[jp.status][i * 4 + j] == 1
                        && jp.map[y / 20 + i][x / 20 + j + 1] == 1)
                        || (jp.nowblocks[jp.status][i * 4 + j] == 1
                        && jp.map[y / 20 + i][x / 20 + j + 1] == 2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void changeMap(int x, int y) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (jp.nowblocks[jp.status][i * 4 + j] == 1
                        && jp.map[y / 20 + i][x / 20 + j + 1] == 0) {
                    jp.map[y / 20 + i][x / 20 + j + 1] = 1;
                }
            }
        }
    }

    public int delline() {
        int flag = 0, score = 0;
        for (int i = 19; i >= 0; i--) {
            for (int j = 1; j < 11; j++) {
                if (jp.map[i][j] == 1) {
                    flag += 1;
                }
            }
            if (flag == 10) {
                for (int k = i; k > 0; k--) {
                    jp.map[k] = jp.map[k - 1];
                }
                for (int k = 1; k < 11; k++) {
                    jp.map[0][k] = 0;
                }
                i++;
                score++;
            }

            flag = 0;
        }
        return score;
    }

    public void gameOver(NewJFrame gjf) {
        gjf.jLabel3.setText("你的分数："+Integer.toString(jp.score));
        jp.restart();
        gjf.jp.setVisible(false);
        gjf.jp1.setVisible(false);
        gjf.jLabel1.setVisible(true);
        gjf.jLabel2.setVisible(true);
        gjf.jLabel3.setVisible(true);
        gjf.jButton2.setVisible(true);
        gjf.jButton3.setVisible(true);
        gjf.combox1.setVisible(true);
        gjf.combox1.setLocation(152, 300);
        gjf.jLabel3.setVisible(true);

    }
}
