
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class View extends JFrame {
    protected static JButton NewGame,Quit, Leaderboard, Tutorial;
    protected JPanel panel, LBpanel;

    public View() throws IOException, FontFormatException {
        JFrame jFrame = new JFrame();

        JPanel mainmenu=new JPanel();
        jFrame.add(mainmenu);
        JLabel Title=new JLabel();
         panel=new JPanel();
         LBpanel =new JPanel();
        JPanel menuButtons=new JPanel();
         NewGame= new JButton("New Game",new ImageIcon("/src/icons/button.gif"));
         Leaderboard= new JButton("Leaderboard");
         Tutorial= new JButton("Tutorial");
         Quit= new JButton("Quit");
         JTextArea leaderboardText=new JTextArea();

        NewGame.setBorder(BorderFactory.createEmptyBorder());
        NewGame.setContentAreaFilled(false);




        Quit.setName("quit");
        Quit.addActionListener(new lmenuListener());

        Leaderboard.setName("leaderboard");
        Leaderboard.addActionListener(new lmenuListener());
        Leaderboard.putClientProperty("lbText",leaderboardText);
        Leaderboard.putClientProperty("LBpanel",LBpanel);
        Leaderboard.putClientProperty("panel",panel);


        NewGame.setName("newgame");
        NewGame.addActionListener(new lmenuListener());
        NewGame.putClientProperty("panel",panel);


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







        mainmenu.add(LBpanel);
        LBpanel.setVisible(false);
        LBpanel.add(leaderboardText);

        panel.add(Title,BorderLayout.PAGE_START);
        panel.add(Box.createVerticalStrut(130));
        panel.add(menuButtons,BorderLayout.LINE_START);





        mainmenu.add(panel);

        jFrame.setResizable(false);
        jFrame.setSize(1400,800);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
