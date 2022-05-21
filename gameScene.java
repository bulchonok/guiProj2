import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gameScene extends JFrame {
    static JButton[] arrOfButtons = new JButton[5];
    static Duck[] arrOfDucks = new Duck[5];
    static JPanel GamePanel = new JPanel();
    static JPanel scene = new JPanel();

    public gameScene() {

        add(GamePanel);


        /*
        JButton Duck1 = new JButton();
        JButton Duck2 = new JButton();
        JButton Duck3 = new JButton();
        JButton Duck4 = new JButton();

        JButton VOID = new JButton();


        Duck1.addActionListener(new DuckListener());
        Duck2.addActionListener(new DuckListener());
        Duck3.addActionListener(new DuckListener());
        Duck4.addActionListener(new DuckListener());



        //arrs
        for (int i = 0; i < arrOfDucks.length; i++) {
            arrOfDucks[i] = new Duck(1);
        }
        arrOfButtons[0] = Duck1;
        arrOfButtons[1] = Duck2;
        arrOfButtons[2] = Duck3;
        arrOfButtons[3] = Duck4;
        //
        Duck1.setName("1");
        Duck2.setName("2");
        Duck3.setName("3");
        Duck4.setName("4");


        Duck1.setText(String.valueOf(arrOfDucks[0].HP));
        Duck2.setText(String.valueOf(arrOfDucks[1].HP));
        Duck3.setText(String.valueOf(arrOfDucks[2].HP));
        Duck4.setText(String.valueOf(arrOfDucks[3].HP));

        try {
            Image yellowDuck = ImageIO.read(getClass().getResource("/icons/duck.gif"));
            Image img = null;
            switch (arrOfDucks[0].DuckColor){
                case "yellow"->{
                    img=yellowDuck;
                }
            }
            //method that changes colors


            Duck1.setIcon(new ImageIcon(img));
            Duck2.setIcon(new ImageIcon(img));
            Duck3.setIcon(new ImageIcon(img));
            Duck4.setIcon(new ImageIcon(img));
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        Duck1.setBorder(BorderFactory.createEmptyBorder());
        Duck1.setContentAreaFilled(false);
        Duck2.setBorder(BorderFactory.createEmptyBorder());
        Duck2.setContentAreaFilled(false);
        Duck3.setBorder(BorderFactory.createEmptyBorder());
        Duck3.setContentAreaFilled(false);
        Duck4.setBorder(BorderFactory.createEmptyBorder());
        Duck4.setContentAreaFilled(false);
        
        */

        GamePanel.setLayout(new BoxLayout(GamePanel,BoxLayout.PAGE_AXIS));
        /*
        GamePanel.add(Duck1);
        GamePanel.add(Duck2);
        GamePanel.add(Duck3);
        GamePanel.add(Duck4);
*/



        setResizable(false);
        setSize(1400, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void createDuck(Duck duck) {
        JButton Test = new JButton();
        arrOfDucks[duck.getIndex()]=duck;
        arrOfButtons[duck.getIndex()]=Test;
        Test.setText(String.valueOf(arrOfDucks[duck.getIndex()].HP));
        Test.setName(String.valueOf(duck.getIndex()));
        Test.addActionListener(new DuckListener());

        try {
            Image yellowDuck = ImageIO.read(gameScene.class.getResource("/icons/duck.gif"));
            Image img = yellowDuck;
            /*switch (arrOfDucks[0].DuckColor){
                case "yellow"->{
                    img=yellowDuck;
                }
            }*/

            Test.setIcon(new ImageIcon(img));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Test.setBorder(BorderFactory.createEmptyBorder());
        Test.setContentAreaFilled(false);
        System.out.print("---------");
        gameScene.GamePanel.add(Test);
    }
}
