import javax.swing.*;

public class controller extends JFrame {
    public static void main(String[] args) {

    }
    public static void killGameThread(MyThread thread){
        thread.interrupt();
    }
}
