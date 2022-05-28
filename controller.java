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
        getGamescore();
        GameEndScreen gameEndScreen=new GameEndScreen(gamescore);

    }

    private static void getGamescore() {
        gamescore = player.getScore();
    }

    public static void save(String name) throws IOException {
        System.out.println("adsdad");
        leaderboard.updatelb("\n"+name+":"+gamescore);
    }
    public static void destroy(){
        for (int i = 0; i < gameScene.buttonList.size(); i++) {
            gameScene.buttonList.get(0).setVisible(false);
            gameScene.buttonList.get(0).setEnabled(false);
            gameScene.jFrame.remove(gameScene.buttonList.get(0));
        }
        for (int i = 0; i < gameScene.panellist.size(); i++) {
            gameScene.panellist.get(0).removeAll();
            gameScene.panellist.remove(gameScene.panellist.get(0));
        }
        for (int i = 0; i <gameScene.heartlist.size() ; i++) {
            gameScene.heartlist.get(0).setVisible(false);
            gameScene.heartlist.remove(gameScene.heartlist.get(0));
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
