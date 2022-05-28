import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EndListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        JTextField jTextField = (JTextField)jButton.getClientProperty("name");
        String name;
        try{
        name = jTextField.getText();
        }catch(NullPointerException eh){
            name="Fujiko";
        }

            switch (jButton.getName()){
                case "save"->{
                    try {
                        controller.save(name);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
                case "cancel"->{

                }
            }
        controller.destroy();
        GameEndScreen.jFrame.setVisible(false);
            try {
                new View();
            } catch (IOException eh) {
                eh.printStackTrace();
            } catch (FontFormatException eh) {
                eh.printStackTrace();
            }
    }
}
