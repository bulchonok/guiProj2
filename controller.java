import javax.swing.*;
import java.io.IOException;


public class controller extends JFrame {
    static boolean gameover=false;

    static int gamescore;


    public static void killGameThread(Thread thread) {
        thread.interrupt();
        gameScene.jFrame.setVisible(false);

        gameScene.jTextArea.remove(gameScene.jTextArea);
        if (!gameover){
            gameover=true;
            GameEnd();
        }

    }

    public static void GameEnd() {

        gameScene.scene.setVisible(false);
        if (!bind.connection){
        getGamescore();
        GameEndScreen gameEndScreen=new GameEndScreen(gamescore);
        }else{
            EndListener.killer();
            bind.connection=false;
        }

    }

    private static void getGamescore() {
        gamescore = player.getScore();
    }

    public static void save(String name) throws IOException {
        leaderboard.updatelb(name+":"+gamescore+"\n");
    }
    public static void destroy(){
        gameScene.usersInv.removeAll();
        for (int i = 0; i < gameScene.buttonList.size(); i++) {
            gameScene.buttonList.get(0).removeAll();
            gameScene.buttonList.remove(gameScene.buttonList.get(0));
        }

        for (int i = 0; i < gameScene.panellist.size(); i++) {

            gameScene.panellist.get(0).removeAll();
            gameScene.panellist.remove(gameScene.panellist.get(0));
        }

        for (int i = 0; i < Duck.ducklist.size() ; i++) {
            Duck.ducklist.get(i).setVisible(false);
            Duck.ducklist.remove( Duck.ducklist.get(0));
        }
        for (int i = 0; i < Duck.aliveList.size() ; i++) {
            Duck.aliveList.get(i).setVisible(false);
            Duck.aliveList.remove( Duck.aliveList.get(0));
        }
    }
}
