import javax.swing.*;
import java.awt.*;

public class JImageIconTest {
    public static void main(String []args)
    {
        JFrame w = new JFrame();
        w.setTitle("image");
        w.setSize(420,320);
        w.setLocation(100,100);
        w.setVisible(true);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = w.getContentPane();
        JLabel box = new JLabel();
        cp.add(box,BorderLayout.CENTER);
        cp.validate();
        ImageIcon ii = new ImageIcon("https://www.filesmerge.com/img/donate_64.png");
            box.setIcon(ii);
}
}
