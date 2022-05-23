import javax.swing.*;


public class controller extends JFrame {
    static boolean gameover=false;


    public static void killGameThread(Thread thread) {
        thread.interrupt();
        if (!gameover){
            gameover=true;
            GameEnd();
        }

    }

    public static void GameEnd() {
        GameEndScreen gameEndScreen=new GameEndScreen(player.getScore());
    }
}
