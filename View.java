
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
        JLabel Title = new JLabel();
        JPanel menuButtons = new JPanel();
        JTextArea leaderboardText = new JTextArea();

        jFrame.add(mainmenu);

        diffs = new JPanel();
        panel = new JPanel();
        LBpanel = new JPanel();


        JButton Easy = new JButton("easy");
        JButton Hard = new JButton("Hard");
        JButton HELL = new JButton("HELL");

        diffs.setLayout(new BoxLayout(diffs,BoxLayout.PAGE_AXIS));
        diffs.add(Easy);
        diffs.add(Hard);
        diffs.add(HELL);

        Easy.setName("newgame1");
        Hard.setName("newgame2");
        HELL.setName("newgame3");


        Easy.addActionListener(new lmenuListener());
        Hard.addActionListener(new lmenuListener());
        HELL.addActionListener(new lmenuListener());

        Easy.putClientProperty("diffs", diffs);
        Hard.putClientProperty("diffs", diffs);
        HELL.putClientProperty("diffs", diffs);

        diffs.setVisible(false);
        mainmenu.add(diffs);

        //buttons
        NewGame = new JButton("New Game");
        Leaderboard = new JButton("Leaderboard");
        Quit = new JButton("Quit");


        NewGame.setBorder(BorderFactory.createEmptyBorder());
        NewGame.setContentAreaFilled(false);

        Image img = ImageIO.read(gameScene.class.getResource("/icons/button.jpg"));
        NewGame.setIcon(new ImageIcon(img));

        Quit.setName("quit");
        Quit.addActionListener(new lmenuListener());

        Leaderboard.setName("leaderboard");
        Leaderboard.addActionListener(new lmenuListener());
        Leaderboard.putClientProperty("lbText", leaderboardText);
        Leaderboard.putClientProperty("LBpanel", LBpanel);
        Leaderboard.putClientProperty("panel", panel);


        NewGame.setName("newgame");
        NewGame.addActionListener(new lmenuListener());
        NewGame.putClientProperty("panel", panel);
        NewGame.putClientProperty("diffs", diffs);

        Font titleFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/DOOM-font.ttf"));
        //https://stackoverflow.com/questions/21081586/using-a-custom-font-for-a-jlabel
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(titleFont);
        titleFont = titleFont.deriveFont(150f);
        //


        Title.setText("Bill, The Duck Killer");
        Title.setFont(titleFont);
        menuButtons.setLayout(new BoxLayout(menuButtons, BoxLayout.PAGE_AXIS));
        menuButtons.add(NewGame);
        menuButtons.add(Box.createVerticalStrut(15));

        menuButtons.add(Box.createVerticalStrut(15));
        menuButtons.add(Leaderboard);
        menuButtons.add(Box.createVerticalStrut(50));
        menuButtons.add(Quit);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        mainmenu.add(LBpanel);
        LBpanel.setVisible(false);
        LBpanel.add(leaderboardText);

        panel.add(Title, BorderLayout.PAGE_START);
        panel.add(Box.createVerticalStrut(130));
        panel.add(menuButtons, BorderLayout.LINE_START);


        mainmenu.add(panel);

        jFrame.setResizable(false);
        jFrame.setSize(1400, 900);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
