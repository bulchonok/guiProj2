import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class GameEndScreen extends JFrame {
    static JFrame jFrame;

    public GameEndScreen(int Score) {
         jFrame = new JFrame();
        JPanel endPanel = new JPanel();
        JPanel ResultPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        endPanel.setLayout(null);
        ResultPanel.setLayout(null);
        buttonsPanel.setLayout(new FlowLayout());

        ResultPanel.setPreferredSize(new Dimension(200,100));
        ResultPanel.setBounds(100,50,400,200);
        buttonsPanel.setBounds(100,250,400,50);

        JTextPane Result = new JTextPane();
        JTextPane name = new JTextPane();
        JTextField Name = new JTextField();

        Result.setText("Your Result is:\n"+Score);
        name.setText("enter your name:");

        Result.setEditable(false);
        name.setEditable(false);

        Result.setBounds(100,50,200,60);
        name.setBounds(100,110,200,40);
        Name.setBounds(100,150,200,50);


//https://stackoverflow.com/questions/3213045/centering-text-in-a-jtextarea-or-jtextpane-horizontal-text-alignment
        StyledDocument doc = Result.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        StyledDocument doc2 = name.getStyledDocument();
        SimpleAttributeSet center2 = new SimpleAttributeSet();
        StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
        doc2.setParagraphAttributes(0, doc2.getLength(), center2, false);

//

        JButton Save = new JButton("SAVE");
        JButton Cancel = new JButton("Cancel");

        Save.setName("save");
        Cancel.setName("cancel");

        Save.putClientProperty("name",Name);
        Save.addActionListener(new EndListener());
        Cancel.addActionListener(new EndListener());

        Save.setPreferredSize(new Dimension(100,20));
        Cancel.setPreferredSize(new Dimension(100,20));

        endPanel.add(ResultPanel);
        endPanel.add(buttonsPanel);

        ResultPanel.add(Result);
        ResultPanel.add(name);
        ResultPanel.add(Name);

        buttonsPanel.add(Save);
        buttonsPanel.add(Cancel);



        jFrame.add(endPanel);
        jFrame.setResizable(false);
        jFrame.setSize(600, 500);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
