import javax.swing.*;
import java.io.IOException;


public class controller extends JFrame {
    static boolean gameover=false;

    static int gamescore;


    public static void killGameThread(Thread thread) {
        thread.interrupt();
        gameScene.jFrame.setVisible(false);
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
        leaderboard.updatelb("\n"+name+":"+gamescore);
    }
}
