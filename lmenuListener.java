import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class lmenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) (e.getSource());
        System.out.println(jButton);

        JPanel panel2 = (JPanel) jButton.getClientProperty("LBpanel");
        JPanel panel = (JPanel) jButton.getClientProperty("panel");
        // JPanel gamepanel = (JPanel) ;
        JTextArea lbText = (JTextArea) jButton.getClientProperty("lbText");
        JPanel diffs = (JPanel) jButton.getClientProperty("diffs");


        switch (jButton.getName()) {
            case "quit" -> System.exit(0);
            case "leaderboard" -> {
                panel.setVisible(false);
                panel2.setVisible(true);
                try {
                    lbText.setText(leaderboard.getlb());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            case "back" -> {
                panel.setVisible(true);
                panel2.setVisible(false);
                diffs.setVisible(false);
            }
            case "newgame" -> {
                panel.setVisible(false);
                diffs.setVisible(true);
            }
            case "newgame1"->{
                diffs.setVisible(false);
                MyThread thread = new MyThread(1);
                thread.start();
                GameThreadTimer gameThreadTimer = new GameThreadTimer();
                gameThreadTimer.start();
                View.jFrame.setVisible(false);
                gameScene gsc = new gameScene();
            }
            case "newgame2"->{
                diffs.setVisible(false);
                MyThread thread = new MyThread(3);
                thread.start();
                GameThreadTimer gameThreadTimer = new GameThreadTimer();
                gameThreadTimer.start();
                View.jFrame.setVisible(false);
                gameScene gsc = new gameScene();
            }
            case "newgame3"->{
                diffs.setVisible(false);
                MyThread thread = new MyThread(6);
                thread.start();
                GameThreadTimer gameThreadTimer = new GameThreadTimer();
                gameThreadTimer.start();
                View.jFrame.setVisible(false);
                System.out.println("++++++++++");
                gameScene gsc = new gameScene();

                System.out.println("++++++++++");
            }

        }


    }
}