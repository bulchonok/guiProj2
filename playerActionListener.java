import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playerActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        JTextArea jTextArea=(JTextArea) jButton.getClientProperty("dmgcounter");

        player.levelup();//button text:money needed for upgrade

        jTextArea.setText("your damage is:"+player.dmg);
    }
}
