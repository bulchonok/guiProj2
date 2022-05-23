import javax.swing.*;
import java.awt.*;

public class GameEndScreen extends JFrame {
    public GameEndScreen(int Score) {
        JFrame jFrame = new JFrame();
        JPanel endPanel = new JPanel();
        endPanel.setLayout(new BoxLayout(endPanel,BoxLayout.Y_AXIS));


        JPanel ResultPanel = new JPanel();
        JTextArea Result = new JTextArea();
        Result.setText("Your Result is:\\n"+Score);
        JTextArea name = new JTextArea();
        Result.setText("enter your name:");
        JTextField Name = new JTextField();

        Result.setEditable(false);
        name.setEditable(false);

        Result.setPreferredSize(new Dimension(100,50));
        name.setPreferredSize(new Dimension(100,50));

        ResultPanel.setPreferredSize(new Dimension(200,200));
        ResultPanel.setLayout(new BoxLayout(ResultPanel,BoxLayout.PAGE_AXIS));
        ResultPanel.setBackground(Color.yellow);
        ResultPanel.add(Result);
        ResultPanel.add(name);
        ResultPanel.add(Name);


        JPanel buttonsPanel = new JPanel();
        JButton Save = new JButton("SAVE");
        JButton Cancel = new JButton("Cancel");

        Save.setPreferredSize(new Dimension(60,20));
        Cancel.setPreferredSize(new Dimension(60,20));

        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(Save);
        buttonsPanel.add(Cancel);
        buttonsPanel.setBackground(Color.red);



        endPanel.add(ResultPanel);
        endPanel.add(buttonsPanel);


        jFrame.add(endPanel);
        jFrame.setResizable(false);
        jFrame.setSize(800, 500);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
