
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class View extends JFrame {
    protected static JButton NewGame, Quit, Leaderboard;
    protected JPanel panel, LBpanel, diffs;
    static JFrame jFrame;

    public View() throws IOException, FontFormatException {

        jFrame = new JFrame();

        JPanel mainmenu = new JPanel();
        JPanel menuButtons = new JPanel();
        diffs = new JPanel();
        panel = new JPanel();
        LBpanel = new JPanel();

        JLabel Title = new JLabel();
        JTextArea leaderboardText = new JTextArea();


        Font titleFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/DOOM-font.ttf"));
                //https://stackoverflow.com/questions/21081586/using-a-custom-font-for-a-jlabel
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(titleFont);
        titleFont = titleFont.deriveFont(150f);
                //
        Title.setText("Bill, The Duck Killer");
        Title.setFont(titleFont);

        menuButtons.setLayout(new BoxLayout(menuButtons, BoxLayout.PAGE_AXIS));
        diffs.setLayout(new BoxLayout(diffs, BoxLayout.PAGE_AXIS));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        diffs.setVisible(false);


        JButton back = new JButton("back");
        JButton Back = new JButton("back");
        JButton Easy = new JButton("easy");
        JButton Hard = new JButton("Hard");
        JButton HELL = new JButton("HELL");
        NewGame = new JButton("New Game");
        Leaderboard = new JButton("Leaderboard");
        Quit = new JButton("Quit");


        back.addActionListener(new lmenuListener());
        back.setName("back");
        back.putClientProperty("LBpanel",LBpanel);
        back.putClientProperty("panel",panel);
        back.putClientProperty("diffs",diffs);

        Back.addActionListener(new lmenuListener());
        Back.setName("back");
        Back.putClientProperty("LBpanel",LBpanel);
        Back.putClientProperty("panel",panel);
        Back.putClientProperty("diffs",diffs);

        Easy.addActionListener(new lmenuListener());
        Easy.setName("newgame1");
        Easy.putClientProperty("diffs", diffs);

        Hard.addActionListener(new lmenuListener());
        Hard.setName("newgame2");
        Hard.putClientProperty("diffs", diffs);

        HELL.addActionListener(new lmenuListener());
        HELL.setName("newgame3");
        HELL.putClientProperty("diffs", diffs);

        Image img = ImageIO.read(gameScene.class.getResource("/icons/button.jpg"));

        NewGame.addActionListener(new lmenuListener());
        NewGame.setName("newgame");
        NewGame.putClientProperty("panel", panel);
        NewGame.putClientProperty("diffs", diffs);
        NewGame.setContentAreaFilled(false);
        NewGame.setIcon(new ImageIcon(img));

        Leaderboard.addActionListener(new lmenuListener());
        Leaderboard.setName("leaderboard");
        Leaderboard.putClientProperty("lbText", leaderboardText);
        Leaderboard.putClientProperty("LBpanel", LBpanel);
        Leaderboard.putClientProperty("panel", panel);
        Leaderboard.setContentAreaFilled(false);
        Leaderboard.setIcon(new ImageIcon(img));

        Quit.addActionListener(new lmenuListener());
        Quit.setName("quit");
        Quit.setContentAreaFilled(false);
        Quit.setIcon(new ImageIcon(img));



        mainmenu.add(panel);
        mainmenu.add(diffs);
        mainmenu.add(LBpanel);

        menuButtons.add(NewGame);
        menuButtons.add(Box.createVerticalStrut(50));
        menuButtons.add(Leaderboard);
        menuButtons.add(Box.createVerticalStrut(50));
        menuButtons.add(Quit);

        diffs.add(Easy);
        diffs.add(Hard);
        diffs.add(HELL);
        diffs.add(Back);

        panel.add(Title, BorderLayout.PAGE_START);
        panel.add(Box.createVerticalStrut(130));
        panel.add(menuButtons, BorderLayout.LINE_START);

        LBpanel.setVisible(false);
        LBpanel.add(leaderboardText);
        LBpanel.add(back);




        jFrame.add(mainmenu);
        jFrame.setResizable(false);
        jFrame.setSize(1400, 900);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
