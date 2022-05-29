import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class bind{
    static boolean connection =false;
    public bind(){
        gameScene.scene.getActionMap().put("foo", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                connection=true;
                player.HP=0;
            }
        });
        InputMap inputMap = gameScene.scene.getInputMap();
        KeyStroke controlA = KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                InputEvent.CTRL_DOWN_MASK);


        inputMap.put(controlA,"foo" );
    }
        }