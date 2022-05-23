import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playerActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        player.levelup();
        jButton.setText(String.valueOf(player.dmg));
        System.out.println("action performed");
        JTextArea jTextArea=(JTextArea) jButton.getClientProperty("dmgcounter");
        jTextArea.setText("your damage is:"+player.dmg);
    }
}
