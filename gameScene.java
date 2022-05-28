import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class gameScene extends JFrame {

    static List<JLabel> heartlist = new ArrayList<>();
    static LinkedList<JButton> buttonList = new LinkedList<JButton>();
    static LinkedList<JPanel> panellist = new LinkedList<JPanel>();

    static JFrame jFrame;

    static JPanel GamePanel = new JPanel();
    static JPanel scene = new JPanel();
    static JPanel usersInv = new JPanel();
    static JTextArea jTextArea;
    static JTextArea Timer,Score= new JTextArea();

    public gameScene() {

        jFrame = new JFrame();
        panellist.add(GamePanel);
        panellist.add(scene);
        panellist.add(usersInv);
         jTextArea = new JTextArea();

        jTextArea.setText("your damage is:"+player.dmg+"your balance:"+player.money);
        jTextArea.setEditable(false);

        jTextArea.setBackground(usersInv.getBackground());

        Score = new JTextArea();
        Timer = new JTextArea();

        Score.setText("SCORE:\n"+player.getScore());
        Timer.setText("Timer: " + "00:00:00");

        Score.setEditable(false);
        Timer.setEditable(false);
        Score.setPreferredSize(new Dimension(120, 60));
        Timer.setPreferredSize(new Dimension(100, 60));

        JButton levelup = new JButton("Upgrade for 1$");

        levelup.addActionListener(new playerActionListener());
        levelup.putClientProperty("dmgcounter", jTextArea);
//
        usersInv.setBackground(Color.yellow);
        usersInv.setLayout(new FlowLayout(FlowLayout.LEFT));
        usersInv.setPreferredSize(new Dimension(1000, 200));

        GamePanel.setBackground(Color.magenta);
        GamePanel.setLayout(null);
        GamePanel.setPreferredSize(new Dimension(1000, 700));

        usersInv.add(Score);
        usersInv.add(Timer);
        usersInv.add(jTextArea);
        usersInv.add(levelup);

        scene.add(GamePanel);
        scene.add(usersInv);

        {
            GamePanel.setVisible(true);
            scene.setVisible(true);
            usersInv.setVisible(true);
            showHP();
        }

        jFrame.add(scene);

        jFrame.setResizable(false);
        jFrame.setSize(1400, 900);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void showHP() {
        BufferedImage myPicture = null;
        BufferedImage myPictureBlack = null;
            try {
                myPicture = ImageIO.read(new File("src/icons/heart1.png"));
                myPictureBlack = ImageIO.read(new File("src/icons/heart0.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        for (int i = 0; i < player.HP; i++) {
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            usersInv.add(picLabel);
            heartlist.add(picLabel);
        }
        for (int i = 0; i < player.MaxHP - player.HP; i++) {
            JLabel picLabelBlack = new JLabel(new ImageIcon(myPictureBlack));
            usersInv.add(picLabelBlack);
            heartlist.add(picLabelBlack);
        }

    }


    public static void deleteHP() {
        for (int i = 0; i < heartlist.size(); i++) {
            usersInv.remove(heartlist.get(i));
        }
        heartlist.removeAll(heartlist);
    }


    public static void createDuck(Duck duck) {

        JButton Test = new JButton();

        buttonList.add(Test);

        Test.setBorder(BorderFactory.createEmptyBorder());
        Test.setContentAreaFilled(false);

            try {
                Image d1 = ImageIO.read(gameScene.class.getResource("/icons/Duck1.png"));
                Image d2 = ImageIO.read(gameScene.class.getResource("/icons/Duck2.png"));
                Image d3 = ImageIO.read(gameScene.class.getResource("/icons/Duck3.png"));
                Image d4 = ImageIO.read(gameScene.class.getResource("/icons/Duck4.png"));
                Image d5 = ImageIO.read(gameScene.class.getResource("/icons/Duck5.png"));
                Image d6 = ImageIO.read(gameScene.class.getResource("/icons/Duck6.png"));
                Image d7 = ImageIO.read(gameScene.class.getResource("/icons/Duck7.png"));
                Image img = d1;
                switch (duck.DuckColor){
                    case 1->img=d1;
                    case 2->img=d2;
                    case 3->img=d3;
                    case 4->img=d4;
                    case 5->img=d5;
                    case 6->img=d6;
                    case 7,8,9,10->img=d7;
                }

                Test.setIcon(new ImageIcon(img));
                Test.setName(String.valueOf(duck.index));
            } catch (IOException e) {
                e.printStackTrace();
            }


        Test.setText(String.valueOf(duck.HP));
        Test.setName(String.valueOf(duck.getIndex()));
        Test.addActionListener(new DuckListener());
        Test.setBounds(duck.x, duck.y, 130, 130);

        gameScene.GamePanel.add(Test);

        Test.setVisible(true);

    }
}
