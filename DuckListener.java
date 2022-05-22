import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton duck = (JButton) (e.getSource());

        int DuckId = Integer.parseInt(duck.getName());
        Duck thisDuck = Duck.find(DuckId);
        if (!thisDuck.getDamage(1,duck)){

            duck.setEnabled(false);
            //getmoney
        }
        duck.setText(String.valueOf(thisDuck.HP));

    }
}
