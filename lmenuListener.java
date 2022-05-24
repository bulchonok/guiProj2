import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class lmenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) (e.getSource());

        JPanel panel2 = (JPanel) jButton.getClientProperty("LBpanel");
        JPanel panel = (JPanel) jButton.getClientProperty("panel");
        JPanel diffs = (JPanel) jButton.getClientProperty("diffs");

        JTextArea lbText = (JTextArea) jButton.getClientProperty("lbText");


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
                        gamestart(1,diffs);
                    }
                 case "newgame2"->{
                        gamestart(3,diffs);
                    }
                 case "newgame3"->{
                        gamestart(6,diffs);

                    }

            }


    }

    static void gamestart(int diff, JPanel diffs){
        MyThread thread = new MyThread(diff);
        GameThreadTimer gameThreadTimer = new GameThreadTimer();

        thread.start();
        gameThreadTimer.start();


        diffs.setVisible(false);
        View.jFrame.setVisible(false);

        gameScene gsc = new gameScene();
    }
}