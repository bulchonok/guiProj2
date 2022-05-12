import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class menu extends JFrame {
    public menu() throws IOException, FontFormatException {
        JPanel mainmenu=new JPanel();
        add(mainmenu);
        JLabel Title=new JLabel();
        JPanel panel=new JPanel();
        JPanel menuButtons=new JPanel();
        JButton NewGame= new JButton("New Game");
        JButton Leaderboard= new JButton("Leaderboard");
        JButton Tutorial= new JButton("Tutorial");
        JButton Quit= new JButton("Quit");

        Font titleFont= Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/DOOM-font.ttf"));
        //https://stackoverflow.com/questions/21081586/using-a-custom-font-for-a-jlabel
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(titleFont);
        titleFont = titleFont.deriveFont(150f);
        //



        Title.setText("Bill, The Duck Killer");
        Title.setFont(titleFont);
        menuButtons.setLayout(new BoxLayout(menuButtons,BoxLayout.PAGE_AXIS));
        menuButtons.add(NewGame);
        menuButtons.add(Box.createVerticalStrut(15));
        menuButtons.add(Tutorial);
        menuButtons.add(Box.createVerticalStrut(15));
        menuButtons.add(Leaderboard);
        menuButtons.add(Box.createVerticalStrut(50));
        menuButtons.add(Quit);
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

        panel.add(Title,BorderLayout.PAGE_START);
        panel.add(Box.createVerticalStrut(130));
        panel.add(menuButtons,BorderLayout.LINE_START);

        mainmenu.add(panel);
        setSize(1344,756);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
