import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
public class ImgReader{
    JFrame f;
    

    
   
    public ImgReader()  throws IOException {
        f = new JFrame("Image Reader");
        
    }

    public void startApp() throws IOException{
        f.add(new ImgCanvas());
        f.setVisible(true);
        f.pack();
    }

    class ImgCanvas extends Canvas {
        BufferedImage tx;
        ImgCanvas()  throws IOException{
            tx = ImageIO.read(new File("assets/GAME_F1RACE_GAMEOVER.bmp"));
        }
        public void paint(Graphics g){
            g.drawImage(tx, 0, 0, this);
            
        }
    }

    public static void main(String[] args) throws IOException {
        ImgReader i = new ImgReader();
        i.startApp();
    }
}