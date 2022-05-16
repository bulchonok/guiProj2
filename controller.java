import javax.swing.*;

public class controller extends JFrame {
    public static void main(String[] args) {
       View.getQuit().addActionListener((e -> System.exit(0)));


    }
}
