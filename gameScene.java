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
    static JPanel GamePanel = new JPanel();
    static JPanel scene = new JPanel();
    static JPanel usersInv = new JPanel();
    static JTextArea Timer,Score= new JTextArea();
    static JFrame jFrame;

    public gameScene() {

        jFrame = new JFrame();
        jFrame.add(scene);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setText("your damage is:" + player.dmg);
        jTextArea.setEditable(false);


         Score = new JTextArea();
        Score.setText("SCORE:\n"+player.getScore());
        Score.setEditable(false);


        JButton levelup = new JButton("dmg up");
        levelup.addActionListener(new playerActionListener());
        levelup.putClientProperty("dmgcounter", jTextArea);
//
        Timer = new JTextArea();
        Timer.setText("Timer: " + "00:00:00");
        Timer.setEditable(false);
        //
        Timer.setPreferredSize(new Dimension(100, 60));
        Score.setPreferredSize(new Dimension(120, 60));

        usersInv.add(Score);
        usersInv.add(Timer);
        usersInv.add(jTextArea);

        scene.add(GamePanel);
        scene.add(usersInv);

        usersInv.add(levelup);


        usersInv.setBackground(Color.yellow);
        usersInv.setLayout(new FlowLayout(FlowLayout.LEFT));
        usersInv.setPreferredSize(new Dimension(1000, 200));
        GamePanel.setBackground(Color.magenta);
        GamePanel.setLayout(null);
        GamePanel.setPreferredSize(new Dimension(1000, 700));

        showHP();

        jTextArea.setBackground(usersInv.getBackground());

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
            Image yellowDuck = ImageIO.read(gameScene.class.getResource("/icons/duck.gif"));
            Image img = yellowDuck;
            /*switch (arrOfDucks[0].DuckColor){
                case "yellow"->{
                    img=yellowDuck;
                }
            }*/

            Test.setIcon(new ImageIcon(img));
            Test.setName(String.valueOf(duck.index));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Test.setText(String.valueOf(duck.HP));
        Test.setName(String.valueOf(duck.getIndex()));
        Test.addActionListener(new DuckListener());


        System.out.println("---------");
        System.out.println(Test);
        Test.setBounds(duck.x, duck.y, 130, 130);
        gameScene.GamePanel.add(Test);
        Test.setVisible(true);


    }
}
