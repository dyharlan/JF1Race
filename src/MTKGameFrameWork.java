/*
 * The MIT License
 *
 * Copyright 2023 dyhar.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * Thank you to nehochupechatat https://github.com/nehochupechatat for providing the original source code of F1-Race
 * and his MTKGameFramework Wrapper. 
 * Thank you to the Kahvibreak community for providing an inclusive community for mobile preservation. Something that a certain Historical Foundation seemed to ignore.
 */

/**
 * This is a port of nehochupechatat's MTKGameFrameWork to Swing.
 * @author dyhar
 */
import java.util.Random;
import java.awt.*;
import java.awt.image.*;
public class MTKGameFrameWork {
    
    private Graphics2D g;
    private int FrameWidth;
    private int FrameHeight;
    private ImageObserver observer;
    
    public MTKGameFrameWork(Graphics gfx, int FrameWidth, int FrameHeight, ImageObserver observer){
        this.g = (Graphics2D) gfx;
        this.FrameWidth = FrameWidth;
        this.FrameHeight = FrameHeight;
        this.observer = observer;
    }
    public int getRandomInt(int min, int max){
        Random rand = new Random();
        return min+rand.nextInt(max);
    }
    
    public int rand(){
        return this.getRandomInt(0, 32768);
    }
    
    public String gui_color(int r, int g, int b){
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(Integer.toHexString(r));
        sb.append(Integer.toHexString(g));
        sb.append(Integer.toHexString(b));
        return sb.toString();
    }
    
    public void gui_fill_rectangle(int x1, int y1, int x2, int y2, Color c) {
        g.setColor(c);
        g.fillRect(x1,y1,x2-x1,y2-y1);
    }
    
    public void gui_draw_vertical_line( int x1, int y1, int y2, Color c){
        g.setColor(c);
        g.drawLine(x1, y1, x1, y2);
    }
    
    public void gui_draw_horizontal_line( int x1, int x2, int y, Color c){
        g.setColor(c);
        g.drawLine(x1, y, x2, y);
    }
    
    public void gui_putpixel(int x, int y, Color c){
        g.setColor(c);
        g.fillRect(x,y,1,1);
    }
    
    public void gui_show_image(int x, int y, BufferedImage img ){
        g.drawImage(img, x,y, observer);
    }
    
    public void gui_set_clip(int x1, int y1, int x2, int y2){
        g.setClip(x1,y1,x2-x1,y2-y1);
    }
    
    public int getWidth(BufferedImage img){
        return img.getWidth();
    }
    
    public int getHeight(BufferedImage img){
        return img.getHeight();
    }
    
    public void mmi_gfx_draw_gameover_screen(BufferedImage text_img_id, BufferedImage box_img_id, BufferedImage pic_img_id, int score){
        int text_image_width = 0;
        int text_image_height = 0;
        int box_image_width = 0;
        int box_image_height = 0;
        int pic_image_width = 0;
        int pic_image_height = 0;
        int text_image_offset_y = 0;
        int box_image_offset_y = 0;
        int pic_image_offset_y = 0;
        int score_str_offset_y = 0;
        int score_str_offset_x = 0;
        int str_width = 0;
        int str_height = 0;
        int spacing = 0;
        
        gui_fill_rectangle(0, 0, FrameWidth,FrameHeight, new Color(234, 243, 255));
        
        text_image_height = getHeight(text_img_id);
        box_image_height = getHeight(box_img_id);
        pic_image_height = getHeight(pic_img_id);
        text_image_width = getWidth(text_img_id);
        box_image_width = getWidth(box_img_id);
        pic_image_width = getWidth(pic_img_id);
        
        spacing = (128 - (text_image_height + box_image_height + pic_image_height)) >> 2;
        
        text_image_offset_y = spacing;
        box_image_offset_y = text_image_offset_y + text_image_height + spacing;
        pic_image_offset_y = box_image_offset_y + box_image_height + spacing;

        gui_show_image((128 - text_image_width) >> 1, text_image_offset_y, text_img_id);
        gui_show_image((128 - box_image_width) >> 1, box_image_offset_y, box_img_id);
        gui_show_image((128 - pic_image_width) >> 1, pic_image_offset_y, pic_img_id);
    
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        
        g.drawString(String.valueOf(score),(int) ((130 - box_image_width)), (int) (165 - box_image_offset_y)/2);
    }
    
    
}
