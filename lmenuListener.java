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
            case "newgame" -> {
                panel.setVisible(false);
                MyThread thread = new MyThread();
                thread.start();
                View.jFrame.setVisible(false);
                new gameScene();
            }

        }


    }
}