import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
public class F1RaceSwing{
    class F1RACE_PLAYER_CAR_CLASS{
        short pos_x = ((F1RACE_ROAD_1_START_X + F1RACE_ROAD_1_END_X - F1RACE_PLAYER_CAR_IMAGE_SIZE_X) / 2);
        short pos_y = F1RACE_DISPLAY_END_Y - F1RACE_PLAYER_CAR_IMAGE_SIZE_Y - 1;
        short dx = F1RACE_PLAYER_CAR_IMAGE_SIZE_X;
        short dy = F1RACE_PLAYER_CAR_IMAGE_SIZE_Y;
        BufferedImage image = tx.TEXTURE_PLAYER_CAR;
        BufferedImage image_fly = tx.TEXTURE_PLAYER_CAR_FLY;
        BufferedImage image_head_light = tx.TEXTURE_PLAYER_CAR_HEAD_LIGHT;
    }
    
    class F1RACE_OPPOSITE_CAR_CLASS{
        short dx = 0;
	short dy = 0;
	short speed  = 0;
	short dx_from_road  = 0;
	BufferedImage image;
	short pos_x = 0;
	short pos_y = 0;
	byte road_id = 0;
	boolean is_empty = true;
	boolean is_add_score = false;
    }
    
    class f1race_opposite_car_type_class{   
        
        short dx = 0;
	short dy = 0;
	short speed = 0;
        short dx_from_road = 0;
        BufferedImage image;
        
        f1race_opposite_car_type_class(short dx, short dy, short speed, short dx_from_road, BufferedImage image){
            this.dx = dx;
            this.dy = dy;
            this.speed = speed;
            this.dx_from_road = dx_from_road;
            this.image = image;
        }
    }
    //constant variables
    
    private final short WINDOW_WIDTH  = 256;
    private final short WINDOW_HEIGHT = 256;
    //private final short TEXTURE_WIDTH  = 128;
   // private final short TEXTURE_HEIGHT = 128;

    private final short F1RACE_PLAYER_CAR_IMAGE_SIZE_X                 = 15;
    private final short F1RACE_PLAYER_CAR_IMAGE_SIZE_Y                 = 20;
    private final short F1RACE_PLAYER_CAR_CARSH_IMAGE_SIZE_X           = 15;
    private final short F1RACE_PLAYER_CAR_CARSH_IMAGE_SIZE_Y           = 25;
    private final short F1RACE_PLAYER_CAR_FLY_IMAGE_SIZE_X             = 23;
    private final short F1RACE_PLAYER_CAR_FLY_IMAGE_SIZE_Y             = 27;
    private final short F1RACE_PLAYER_CAR_HEAD_LIGHT_IMAGE_SIZE_X      = 7;
    private final short F1RACE_PLAYER_CAR_HEAD_LIGHT_IMAGE_SIZE_Y      = 15;
    private final short F1RACE_PLAYER_CAR_HEAD_LIGHT_0_SHIFT           = 1;
    private final short F1RACE_PLAYER_CAR_HEAD_LIGHT_1_SHIFT           = 7;
    private final short F1RACE_OPPOSITE_CAR_TYPE_COUNT                 = 7;
    private final short F1RACE_PLAYER_CAR_FLY_FRAME_COUNT              = 10;
    
    private final short F1RACE_OPPOSITE_CAR_0_IMAGE_SIZE_X             = 17;
    private final short F1RACE_OPPOSITE_CAR_0_IMAGE_SIZE_Y             = 35;
    private final short F1RACE_OPPOSITE_CAR_1_IMAGE_SIZE_X             = 12;
    private final short F1RACE_OPPOSITE_CAR_1_IMAGE_SIZE_Y             = 18;
    private final short F1RACE_OPPOSITE_CAR_2_IMAGE_SIZE_X             = 15;
    private final short F1RACE_OPPOSITE_CAR_2_IMAGE_SIZE_Y             = 20;
    private final short F1RACE_OPPOSITE_CAR_3_IMAGE_SIZE_X             = 12;
    private final short F1RACE_OPPOSITE_CAR_3_IMAGE_SIZE_Y             = 18;
    private final short F1RACE_OPPOSITE_CAR_4_IMAGE_SIZE_X             = 17;
    private final short F1RACE_OPPOSITE_CAR_4_IMAGE_SIZE_Y             = 27;
    private final short F1RACE_OPPOSITE_CAR_5_IMAGE_SIZE_X             = 13;
    private final short F1RACE_OPPOSITE_CAR_5_IMAGE_SIZE_Y             = 21;
    private final short F1RACE_OPPOSITE_CAR_6_IMAGE_SIZE_X             = 13;
    private final short F1RACE_OPPOSITE_CAR_6_IMAGE_SIZE_Y             = 22;
    
    private final short F1RACE_OPPOSITE_CAR_COUNT                      = 8;
    private final short F1RACE_OPPOSITE_CAR_DEFAULT_APPEAR_RATE        = 2;
    private final short F1RACE_MAX_FLY_COUNT                           = 9;
    private final short F1RACE_TIMER_ELAPSE                            = 100;
    private final short F1RACE_PLAYER_CAR_SHIFT                        = 5;
    private final short F1RACE_PLAYER_CAR_FLY_SHIFT                    = 2;
    private final short F1RACE_DISPLAY_START_X                         = 3;
    private final short F1RACE_DISPLAY_START_Y                         = 3;
    private final short F1RACE_DISPLAY_END_X                           = 124;
    private final short F1RACE_DISPLAY_END_Y                           = 124;
    private final short F1RACE_ROAD_WIDTH                              = 23;
    private final short F1RACE_SEPARATOR_WIDTH                         = 3;
    private final short F1RACE_GRASS_WIDTH                             = 7;
    private final short F1RACE_STATUS_WIDTH                            = 32;
    private final short F1RACE_SEPARATOR_HEIGHT_SPACE                  = 3;
    private final short F1RACE_SEPARATOR_RATIO                         = 6;

    private final short F1RACE_SEPARATOR_HEIGHT                        = (F1RACE_SEPARATOR_HEIGHT_SPACE*F1RACE_SEPARATOR_RATIO);
    private final short F1RACE_STATUS_NUMBER_WIDTH                     = 4;
    private final short F1RACE_STATUS_NUBBER_HEIGHT                    = 7;
    private final short F1RACE_GRASS_0_START_X                         = (F1RACE_DISPLAY_START_X);
    private final short F1RACE_GRASS_0_END_X                           = (F1RACE_GRASS_0_START_X + F1RACE_GRASS_WIDTH)-1;
    private final short F1RACE_ROAD_0_START_X                          = (F1RACE_GRASS_0_START_X + F1RACE_GRASS_WIDTH);
    private final short F1RACE_ROAD_0_END_X                            = (F1RACE_ROAD_0_START_X + F1RACE_ROAD_WIDTH)-1;
    private final short F1RACE_SEPARATOR_0_START_X                     = (F1RACE_ROAD_0_START_X + F1RACE_ROAD_WIDTH);
    private final short F1RACE_SEPARATOR_0_END_X                       = (F1RACE_SEPARATOR_0_START_X + F1RACE_SEPARATOR_WIDTH)-1;
    private final short F1RACE_ROAD_1_START_X                          = (F1RACE_SEPARATOR_0_START_X + F1RACE_SEPARATOR_WIDTH);
    private final short F1RACE_ROAD_1_END_X                            = (F1RACE_ROAD_1_START_X + F1RACE_ROAD_WIDTH)-1;
    private final short F1RACE_SEPARATOR_1_START_X                     = (F1RACE_ROAD_1_START_X + F1RACE_ROAD_WIDTH);
    private final short F1RACE_SEPARATOR_1_END_X                       = (F1RACE_SEPARATOR_1_START_X + F1RACE_SEPARATOR_WIDTH)-1;
    private final short F1RACE_ROAD_2_START_X                          = (F1RACE_SEPARATOR_1_START_X + F1RACE_SEPARATOR_WIDTH);
    private final short F1RACE_ROAD_2_END_X                            = (F1RACE_ROAD_2_START_X + F1RACE_ROAD_WIDTH)-1;
    private final short F1RACE_GRASS_1_START_X                         = (F1RACE_ROAD_2_START_X + F1RACE_ROAD_WIDTH);
    private final short F1RACE_GRASS_1_END_X                           = (F1RACE_GRASS_1_START_X + F1RACE_GRASS_WIDTH)-1;
    private final short F1RACE_STATUS_START_X                          = (F1RACE_GRASS_1_START_X + F1RACE_GRASS_WIDTH);
    private final short F1RACE_STATUS_END_X                            = (F1RACE_STATUS_START_X + F1RACE_STATUS_WIDTH);
    
    //global vars
    private boolean f1race_is_new_game;
    private boolean f1race_is_crashing;
    private short f1race_crashing_count_down;
    private short f1race_separator_0_block_start_y;
    private short f1race_separator_1_block_start_y;
    private short f1race_last_car_road;
    private boolean f1race_player_is_car_fly;
    private short f1race_player_car_fly_duration;
    private short f1race_score;
    private short f1race_level;
    private short f1race_pass;
    private short f1race_fly_count;
    private short f1race_fly_charger_count;

    private boolean f1race_key_up_pressed = false;
    private boolean f1race_key_down_pressed = false;
    private boolean f1race_key_right_pressed = false;
    private boolean f1race_key_left_pressed = false;
    
    private F1RACE_PLAYER_CAR_CLASS f1race_player_car;
    private f1race_opposite_car_type_class[] f1race_opposite_car_type = new f1race_opposite_car_type_class[F1RACE_OPPOSITE_CAR_TYPE_COUNT];
    private F1RACE_OPPOSITE_CAR_CLASS[]  f1race_opposite_car = new F1RACE_OPPOSITE_CAR_CLASS[F1RACE_OPPOSITE_CAR_COUNT];
   

    private void F1RACE_RELEASE_ALL_KEY() {
        f1race_key_up_pressed      = false;            
        f1race_key_down_pressed    = false;            
        f1race_key_left_pressed    = false;            
        f1race_key_right_pressed   = false;          
        if (f1race_is_crashing == true)               
            return;  
    }
    
    private void init_car_type(){
        f1race_opposite_car_type[0] = new f1race_opposite_car_type_class((short) F1RACE_OPPOSITE_CAR_0_IMAGE_SIZE_X,(short) F1RACE_OPPOSITE_CAR_0_IMAGE_SIZE_Y,(short) 3,(short) ((F1RACE_ROAD_WIDTH - F1RACE_OPPOSITE_CAR_0_IMAGE_SIZE_X) / 2), tx.TEXTURE_OPPOSITE_CAR_0);
        f1race_opposite_car_type[1] = new f1race_opposite_car_type_class((short) F1RACE_OPPOSITE_CAR_1_IMAGE_SIZE_X,(short) F1RACE_OPPOSITE_CAR_1_IMAGE_SIZE_Y,(short) 4,(short) ((F1RACE_ROAD_WIDTH - F1RACE_OPPOSITE_CAR_1_IMAGE_SIZE_X) / 2), tx.TEXTURE_OPPOSITE_CAR_1);
        f1race_opposite_car_type[2] = new f1race_opposite_car_type_class((short) F1RACE_OPPOSITE_CAR_2_IMAGE_SIZE_X,(short) F1RACE_OPPOSITE_CAR_2_IMAGE_SIZE_Y,(short) 6,(short) ((F1RACE_ROAD_WIDTH - F1RACE_OPPOSITE_CAR_2_IMAGE_SIZE_X) / 2), tx.TEXTURE_OPPOSITE_CAR_2);
        f1race_opposite_car_type[3] = new f1race_opposite_car_type_class((short) F1RACE_OPPOSITE_CAR_3_IMAGE_SIZE_X,(short) F1RACE_OPPOSITE_CAR_3_IMAGE_SIZE_Y,(short) 3,(short) ((F1RACE_ROAD_WIDTH - F1RACE_OPPOSITE_CAR_3_IMAGE_SIZE_X) / 2), tx.TEXTURE_OPPOSITE_CAR_3);
        f1race_opposite_car_type[4] = new f1race_opposite_car_type_class((short) F1RACE_OPPOSITE_CAR_4_IMAGE_SIZE_X,(short) F1RACE_OPPOSITE_CAR_4_IMAGE_SIZE_Y,(short) 3,(short) ((F1RACE_ROAD_WIDTH - F1RACE_OPPOSITE_CAR_4_IMAGE_SIZE_X) / 2), tx.TEXTURE_OPPOSITE_CAR_4);
        f1race_opposite_car_type[5] = new f1race_opposite_car_type_class((short) F1RACE_OPPOSITE_CAR_5_IMAGE_SIZE_X,(short) F1RACE_OPPOSITE_CAR_5_IMAGE_SIZE_Y,(short) 3,(short) ((F1RACE_ROAD_WIDTH - F1RACE_OPPOSITE_CAR_5_IMAGE_SIZE_X) / 2), tx.TEXTURE_OPPOSITE_CAR_5);
        f1race_opposite_car_type[6] = new f1race_opposite_car_type_class((short) F1RACE_OPPOSITE_CAR_6_IMAGE_SIZE_X,(short) F1RACE_OPPOSITE_CAR_6_IMAGE_SIZE_Y,(short) 3,(short) ((F1RACE_ROAD_WIDTH - F1RACE_OPPOSITE_CAR_6_IMAGE_SIZE_X) / 2), tx.TEXTURE_OPPOSITE_CAR_6);
        
        for(int i = 0; i < F1RACE_OPPOSITE_CAR_COUNT; i++){
            f1race_opposite_car[i] = new F1RACE_OPPOSITE_CAR_CLASS();
        }
        
        f1race_player_car = new F1RACE_PLAYER_CAR_CLASS();
    }
    
    //swing vars
    private TEXTURES tx;
    private JFrame f;
    private JPanel p;
    
    Action up;
    Action down;
    Action left;
    Action right;
    
    private MTKGameFrameWork mtkgfw;
    public F1RaceSwing(){
        try {
            tx = new TEXTURES();
            init_car_type();
        }
        catch(IOException ioe){
            System.err.println(ioe.toString());
        }
        f = new JFrame("JF1Race");
        p = new JPanel() {
             public void paint(Graphics g) {
                super.paintComponent(g);
                mtkgfw = new MTKGameFrameWork(g, WINDOW_WIDTH, WINDOW_HEIGHT, p);
                F1Race_Render_Background();
                F1Race_Render_Road();
                F1Race_Render_Separator();
                F1Race_Render_Player_Car();
            }
        };
        
        up = new MoveUp();
        down = new MoveDown();
        left = new MoveLeft();
        right = new MoveRight();
       
    }
    
    class RenderLoop implements Runnable{
        public void run(){
           Graphics g = p.getGraphics();
           //mtkgfw = new MTKGameFrameWork(g, WINDOW_WIDTH, WINDOW_HEIGHT, p);
            while(true){
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException iex){
            
                }
                p.repaint();
            }
        }
    }
    
    private class MoveUp extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            f1race_player_car.pos_y-=5;
        }
    }
    
    private class MoveDown extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            f1race_player_car.pos_y+=5;
        }
    }
    
    private class MoveLeft extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            System.out.println(f1race_player_car.pos_x);
            f1race_player_car.pos_x-=5;
        }
    }
    
    private class MoveRight extends AbstractAction {
        public void actionPerformed(ActionEvent e){
            System.out.println(f1race_player_car.pos_x);
            f1race_player_car.pos_x+=5;
        }
    }
    
    
    public void startApp(){
        f.add(p);
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        p.setSize(new Dimension(420,420));
        
        p.getInputMap().put(KeyStroke.getKeyStroke("W"), "up");
        p.getActionMap().put("up", up);
        p.getInputMap().put(KeyStroke.getKeyStroke("S"), "down");
        p.getActionMap().put("down", down);
        p.getInputMap().put(KeyStroke.getKeyStroke("A"), "left");
        p.getActionMap().put("left", left);
        p.getInputMap().put(KeyStroke.getKeyStroke("D"), "right");
        p.getActionMap().put("right", right);
        
        f.setVisible(true);
        RenderLoop rl = new RenderLoop();
        Thread Renderer = new Thread(rl);
        Renderer.start();
    }
    
    public void F1Race_Render_Background() {
        mtkgfw.gui_fill_rectangle(
        F1RACE_DISPLAY_START_X - 3,
        F1RACE_DISPLAY_START_Y - 3,
        F1RACE_DISPLAY_END_X + 3,
        F1RACE_DISPLAY_END_Y + 3,
        new Color(255,255,255));

        mtkgfw.gui_fill_rectangle(F1RACE_GRASS_0_START_X, F1RACE_DISPLAY_START_Y, F1RACE_GRASS_0_END_X, F1RACE_DISPLAY_END_Y, new Color(130, 230, 100));
        mtkgfw.gui_draw_vertical_line(F1RACE_DISPLAY_START_Y, F1RACE_DISPLAY_END_Y, F1RACE_GRASS_0_END_X - 1, new Color(100, 180, 100));
        mtkgfw.gui_draw_vertical_line(F1RACE_DISPLAY_START_Y, F1RACE_DISPLAY_END_Y, F1RACE_GRASS_0_END_X, new Color(0,0,0));
        mtkgfw.gui_fill_rectangle(F1RACE_GRASS_1_START_X, F1RACE_DISPLAY_START_Y, F1RACE_GRASS_1_END_X, F1RACE_DISPLAY_END_Y, new Color(130, 230, 100));
        mtkgfw.gui_draw_vertical_line(F1RACE_DISPLAY_START_Y, F1RACE_DISPLAY_END_Y, F1RACE_GRASS_1_START_X + 1, new Color(100,180,100));
        mtkgfw.gui_draw_vertical_line(F1RACE_DISPLAY_START_Y, F1RACE_DISPLAY_END_Y, F1RACE_GRASS_1_START_X, new Color(0,0,0));
        mtkgfw.gui_fill_rectangle(F1RACE_STATUS_START_X, F1RACE_DISPLAY_START_Y, F1RACE_STATUS_END_X, F1RACE_DISPLAY_END_Y, new Color(0,0,0));
        
        mtkgfw.gui_show_image(F1RACE_STATUS_START_X, F1RACE_DISPLAY_START_Y, tx.TEXTURE_LOGO);
        
        mtkgfw.gui_show_image(F1RACE_STATUS_START_X + 5, F1RACE_DISPLAY_START_Y + 42, tx.TEXTURE_STATUS_SCORE);
        
        mtkgfw.gui_show_image(F1RACE_STATUS_START_X + 2, F1RACE_DISPLAY_START_Y + 50, tx.TEXTURE_STATUS_BOX);
        
        mtkgfw.gui_show_image(F1RACE_STATUS_START_X + 6, F1RACE_DISPLAY_START_Y + 64, tx.TEXTURE_STATUS_LEVEL);
        mtkgfw.gui_show_image(F1RACE_STATUS_START_X + 2, F1RACE_DISPLAY_START_Y + 72, tx.TEXTURE_STATUS_BOX);

        mtkgfw.gui_show_image(F1RACE_STATUS_START_X + 2, F1RACE_DISPLAY_START_Y + 89, tx.TEXTURE_PLAYER_CAR_FLY);
    }
    
    public void F1Race_Render_Road(){
    /*----------------------------------------------------------------*/
    /* Local Variables                                                */
    /*----------------------------------------------------------------*/

    /*----------------------------------------------------------------*/
    /* Code Body                                                      */
    /*----------------------------------------------------------------*/
        mtkgfw.gui_fill_rectangle(
        F1RACE_ROAD_0_START_X,
        F1RACE_DISPLAY_START_Y,
        F1RACE_ROAD_2_END_X,
        F1RACE_DISPLAY_END_Y,
        new Color(150, 150, 150));
    }
    
    public void F1Race_Render_Separator(){
        /*----------------------------------------------------------------*/
        /* Local Variables                                                */
        /*----------------------------------------------------------------*/

        short start_y;
        short end_y;

        /*----------------------------------------------------------------*/
        /* Code Body                                                      */
        /*----------------------------------------------------------------*/
        mtkgfw.gui_fill_rectangle(
        F1RACE_SEPARATOR_0_START_X,
        F1RACE_DISPLAY_START_Y,
        F1RACE_SEPARATOR_0_END_X,
        F1RACE_DISPLAY_END_Y,
        new Color(250, 250, 250));

        mtkgfw.gui_fill_rectangle(
        F1RACE_SEPARATOR_1_START_X,
        F1RACE_DISPLAY_START_Y,
        F1RACE_SEPARATOR_1_END_X,
        F1RACE_DISPLAY_END_Y,
        new Color(250, 250, 250));

        /* separator 0 */
        start_y = f1race_separator_0_block_start_y;
        end_y = (short) (start_y + F1RACE_SEPARATOR_HEIGHT_SPACE);

        while(true){
            mtkgfw.gui_fill_rectangle(
            F1RACE_SEPARATOR_0_START_X,
            start_y,
            F1RACE_SEPARATOR_0_END_X,
            end_y,
            new Color(150, 150, 150));

            start_y += F1RACE_SEPARATOR_HEIGHT;
            end_y = (short) (start_y + F1RACE_SEPARATOR_HEIGHT_SPACE);

            if (start_y > F1RACE_DISPLAY_END_Y){
                break;
            }

            if (end_y > F1RACE_DISPLAY_END_Y){
                end_y = F1RACE_DISPLAY_END_Y;
            }
        }

        f1race_separator_0_block_start_y += F1RACE_SEPARATOR_HEIGHT_SPACE;
        if (f1race_separator_0_block_start_y >= (F1RACE_DISPLAY_START_Y + F1RACE_SEPARATOR_HEIGHT_SPACE * F1RACE_SEPARATOR_RATIO)){
            f1race_separator_0_block_start_y = F1RACE_DISPLAY_START_Y;
        }

        /* separator 1 */
        start_y = f1race_separator_1_block_start_y;
        end_y = (short) (start_y + F1RACE_SEPARATOR_HEIGHT_SPACE);

        while (true){
            mtkgfw.gui_fill_rectangle(
                F1RACE_SEPARATOR_1_START_X,
                start_y,
                F1RACE_SEPARATOR_1_END_X,
                end_y,
                new Color(150, 150, 150));

            start_y += F1RACE_SEPARATOR_HEIGHT;
            end_y = (short) (start_y + F1RACE_SEPARATOR_HEIGHT_SPACE);

            if (start_y > F1RACE_DISPLAY_END_Y){
                break;
            }

            if (end_y > F1RACE_DISPLAY_END_Y){
                end_y = F1RACE_DISPLAY_END_Y;
            }
        }

        f1race_separator_1_block_start_y += F1RACE_SEPARATOR_HEIGHT_SPACE;
        if (f1race_separator_1_block_start_y >= (F1RACE_DISPLAY_START_Y + F1RACE_SEPARATOR_HEIGHT_SPACE * F1RACE_SEPARATOR_RATIO)){
            f1race_separator_1_block_start_y = F1RACE_DISPLAY_START_Y;
        }
    }
    
    public void F1Race_Render_Player_Car(){
        /*----------------------------------------------------------------*/
        /* Local Variables                                                */
        /*----------------------------------------------------------------*/
        short dx;
        short dy;
        BufferedImage image;

        /*----------------------------------------------------------------*/
        /* Code Body                                                      */
        /*----------------------------------------------------------------*/
        if (f1race_player_is_car_fly == false){
            /* car on land */
            mtkgfw.gui_show_image(f1race_player_car.pos_x, f1race_player_car.pos_y, f1race_player_car.image);
        }
        else{

            /* car is flying */

            dx = (F1RACE_PLAYER_CAR_FLY_IMAGE_SIZE_X - F1RACE_PLAYER_CAR_IMAGE_SIZE_X) / 2;
            dy = (F1RACE_PLAYER_CAR_FLY_IMAGE_SIZE_Y - F1RACE_PLAYER_CAR_IMAGE_SIZE_Y) / 2;

            dx = (short) (f1race_player_car.pos_x - dx);
            dy = (short) (f1race_player_car.pos_y - dy);

            switch (f1race_player_car_fly_duration){
                case 0:
                case 1:
                    image = tx.TEXTURE_PLAYER_CAR_FLY_UP;
                    break;

                case (F1RACE_PLAYER_CAR_FLY_FRAME_COUNT - 1):
                case (F1RACE_PLAYER_CAR_FLY_FRAME_COUNT - 2):
                    image = tx.TEXTURE_PLAYER_CAR_FLY_DOWN;
                    break;
                default:
                    image = tx.TEXTURE_PLAYER_CAR_FLY;
                    break;
            }
            mtkgfw.gui_show_image(dx, dy, image);
        }
    };
    
    
}