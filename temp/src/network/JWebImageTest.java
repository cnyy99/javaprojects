package network;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JWebImageTest {
    public static void main(String []args)
    {
        try{
            String netURL = "http://www.bjfu.edu.cn/images/head_r.png";
            System.out.println("从网站读取图片:"+netURL);
            URL url = new URL(netURL);
            BufferedImage img = ImageIO.read(url);
            JFrame w = new JFrame("显示网络图片");
            w.setSize(660,360);
            w.setVisible(true);
            w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SwingUtilities.invokeLater(()->{
                Graphics g = w.getGraphics();
                g.setFont(new Font("Times New Rome",0,24));
                g.drawString(netURL,10,75);
                g.drawImage(img,10,100,null);
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
