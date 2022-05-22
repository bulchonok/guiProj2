import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class gameScene extends JFrame {

    static LinkedList<JButton> buttonList = new LinkedList<JButton>();
    static JPanel GamePanel = new JPanel();
    static JPanel scene = new JPanel();

    public gameScene() {


        //add(scene);
        add(GamePanel);

        //scene.setBackground(Color.yellow);
        //scene.setLayout(new BoxLayout(scene,BoxLayout.PAGE_AXIS));
        //scene.add(GamePanel);
        GamePanel.setBackground(Color.magenta);
        GamePanel.setLayout(null);
        GamePanel.setPreferredSize(new Dimension(1000,700));



        setResizable(false);
        setSize(1400, 900);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
        Test.setBounds(duck.x, duck.y,130,130);
        gameScene.GamePanel.add(Test);
        Test.setVisible(true);



    }
}
