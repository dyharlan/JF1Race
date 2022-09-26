/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author dyhar
 */
public class CanvasTest{
    JFrame f;
    JPanel p;
    int x = 0;
    int y = 0;
    
    Action up;
    Action down;
    Action left;
    Action right;    
    
    public CanvasTest(){
        f = new JFrame("Canvas Test");
        
        p = new JPanel(){
             public void paint(Graphics g) {
                super.paintComponent(g);
                g.drawRect(0, 0, 5 ,5);
            }
        };
        
        up = new MoveUp();
        down = new MoveDown();
        left = new MoveLeft();
        right = new MoveRight();
    }
    
    private class MoveUp extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            Graphics2D g = (Graphics2D) p.getGraphics();
            g.drawRect(x, y-=2, 5 ,5);
        }
    }
    
    private class MoveDown extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            Graphics2D g = (Graphics2D) p.getGraphics(); 
                g.drawRect(x, y+=2, 5 ,5);
        }
    }
    
    private class MoveLeft extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            Graphics2D g = (Graphics2D) p.getGraphics();
            g.drawRect(x-=2, y, 5 ,5);
        }
    }
    
    private class MoveRight extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            Graphics2D g = (Graphics2D) p.getGraphics();
            g.drawRect(x+=2, y, 5 ,5);
        }
    }
    
    public void startApp(){
        p.getInputMap().put(KeyStroke.getKeyStroke("W"), "up");
        p.getActionMap().put("up", up);
        p.getInputMap().put(KeyStroke.getKeyStroke("S"), "down");
        p.getActionMap().put("down", down);
        p.getInputMap().put(KeyStroke.getKeyStroke("A"), "left");
        p.getActionMap().put("left", left);
        p.getInputMap().put(KeyStroke.getKeyStroke("D"), "right");
        p.getActionMap().put("right", right);
        f.add(p);
        f.setSize(400,400);
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        CanvasTest ct = new CanvasTest();
        ct.startApp();
    }
}
