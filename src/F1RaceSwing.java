import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.sound.midi.*;
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
    //x1 window
    //private final short WINDOW_WIDTH  = 145;
    //private final short WINDOW_HEIGHT = 160;
    //x2 window
    private final short WINDOW_WIDTH  = (short) (145*(1.896551724));
    private final short WINDOW_HEIGHT = (short) (160*(1.8125));

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
    private final short F1RACE_DISPLAY_START_Y                         = 0;
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
    private boolean gover = false;
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
    private BufferedImage[] numbers = new BufferedImage[10];
   

    private void F1RACE_RELEASE_ALL_KEY() {
        f1race_key_up_pressed      = false;            
        f1race_key_down_pressed    = false;            
        f1race_key_left_pressed    = false;            
        f1race_key_right_pressed   = false;          
        if (f1race_is_crashing == true)               
            return;  
    }
    
    private void init_assets(){
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
        
        numbers[0] = tx.TEXTURE_NUMBER_0;
        numbers[1] = tx.TEXTURE_NUMBER_1;
        numbers[2] = tx.TEXTURE_NUMBER_2;
        numbers[3] = tx.TEXTURE_NUMBER_3;
        numbers[4] = tx.TEXTURE_NUMBER_4;
        numbers[5] = tx.TEXTURE_NUMBER_5;
        numbers[6] = tx.TEXTURE_NUMBER_6;
        numbers[7] = tx.TEXTURE_NUMBER_7;
        numbers[8] = tx.TEXTURE_NUMBER_8;
        numbers[9] = tx.TEXTURE_NUMBER_9;
    }
    
    //swing vars
    
    private TEXTURES tx;
    private JFrame f;
    private JPanel p;
    private Graphics2D g2d;
    private Timer t;
    private Sequencer mid;
    
    private MTKGameFrameWork mtkgfw;
    public F1RaceSwing(){
        try {
            tx = new TEXTURES();
            init_assets();
            mid = MidiSystem.getSequencer();
            mid.open();
            Thread.sleep(250);
        }
        catch(IOException | MidiUnavailableException | InterruptedException ex){
                System.err.println(ex.toString());
        }
        
        f = new JFrame("JF1Race");
        p = new JPanel() {
             public void paint(Graphics g) {
                g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g2d.scale(2.0, 2.0);
                mtkgfw = new MTKGameFrameWork(g2d, WINDOW_WIDTH, WINDOW_HEIGHT, p);
                g2d.setColor(new Color(0,0,0));
                g2d.drawRect(F1RACE_DISPLAY_START_X, F1RACE_DISPLAY_START_Y+3, F1RACE_DISPLAY_END_X, F1RACE_DISPLAY_END_Y-4);
                if (f1race_is_crashing == false){
                    
                    F1Race_Framemove();
                   
                    F1Race_Render_Background();
                    F1Race_Render_Status();
                    F1Race_Render_Road();
                    F1Race_Render_Separator();
                     
                    F1Race_Render_Opposite_Car();
                    
                    F1Race_Render_Player_Car();
                   
                }
                else{
                    f1race_crashing_count_down--;
                    F1Race_Render_Player_Car_Crash();
                   
                    if (f1race_crashing_count_down <= 0){
                        f1race_is_crashing = false;
                        f1race_is_new_game = true;
                        F1Race_Draw_GameOver();
                        t.stop();
                    }
                }
 
            }
        };
       
    }
    
    
    //a keyhandler that uses Swing timers to remove animation delay
    /*
    * From: https://stackoverflow.com/questions/12102619/java-keylistener-is-delayed-registration
    */
    private class GameLogic extends KeyAdapter {       
        
        GameLogic(){
            t = new Timer(100, (e) -> {
                 p.repaint();  
            });
            int index;
            f1race_is_new_game = true;
            f1race_is_crashing = false;
            f1race_key_up_pressed = false;
            f1race_key_down_pressed = false;
            f1race_key_right_pressed = false;
            f1race_key_left_pressed = false;
            f1race_separator_0_block_start_y = F1RACE_DISPLAY_START_Y;
            f1race_separator_1_block_start_y = F1RACE_DISPLAY_START_Y;
            f1race_crashing_count_down = 10;
            f1race_player_is_car_fly = false;
            f1race_player_car.pos_x = (short) ((F1RACE_ROAD_1_START_X + F1RACE_ROAD_1_END_X - F1RACE_PLAYER_CAR_IMAGE_SIZE_X) / 2);
            f1race_player_car.pos_y = F1RACE_DISPLAY_END_Y - F1RACE_PLAYER_CAR_IMAGE_SIZE_Y - 1;
            f1race_is_crashing = false;
            f1race_last_car_road = 0;
            f1race_score = 0;
            f1race_level = 1;
            f1race_pass = 0;
            f1race_fly_count = 1;
            f1race_fly_charger_count = 0;	
        
            for (index = 0; index < F1RACE_OPPOSITE_CAR_COUNT; index++){
                f1race_opposite_car[index].is_empty = true; /* clear all slot, no car */
                f1race_opposite_car[index].is_add_score = false;
            }
            try{
                mid.setSequence(new SOUNDS().F1RACE_THEME);
            }
            catch(IOException | InvalidMidiDataException ex){
                System.err.println(ex.toString());
            }
            mid.setLoopCount(mid.LOOP_CONTINUOUSLY);
            mid.start();
            t.start();  
            
            
        }
        
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    f1race_key_up_pressed = true;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    f1race_key_down_pressed = true;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    f1race_key_left_pressed = true;
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    f1race_key_right_pressed = true;
                    break;
                case KeyEvent.VK_NUMPAD5:
                case KeyEvent.VK_SPACE:
                    if (f1race_fly_count > 0 ){	
                        f1race_player_is_car_fly = true;
                        f1race_player_car_fly_duration = 0;
                        f1race_fly_count--;
                        f1race_fly_count = f1race_fly_count;
                    }
                   if (gover == true){
                       gover = false;
                       newGame();
                       
                   }
                   break;
            }
        }

        public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    f1race_key_up_pressed = false;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    f1race_key_down_pressed = false;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    f1race_key_left_pressed = false;
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    f1race_key_right_pressed = false;
                    break;
            }
        }
    }
    
    public void startApp(){
        f.add(p);
        f.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        GameLogic gl = new GameLogic();
        f.addKeyListener(gl);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        

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

        mtkgfw.gui_show_image(F1RACE_STATUS_START_X + 2, F1RACE_DISPLAY_START_Y + 89, tx.TEXTURE_STATUS_FLY);
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
    
    public void F1Race_Render_Status(){
        short x_pos;
        short y_pos;
        short value;
        short remain;
        int score;
        short index;
        Color c;
        
        mtkgfw.gui_fill_rectangle(
        F1RACE_STATUS_START_X + 4,
        F1RACE_DISPLAY_START_Y + 52,
        F1RACE_STATUS_START_X + 29,
        F1RACE_DISPLAY_START_Y + 58,
        new Color(0,0,0));
        
        x_pos = F1RACE_STATUS_START_X + 25;
        y_pos = F1RACE_DISPLAY_START_Y + 52;
        score = f1race_score;
        

        
        
        if(score < 10)
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[score]);
        
        if(score >= 10 && score < 100){
            
            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[score / 10] );
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[score % 10]);
        }
        
        if(score >= 100 && score < 1000){
            int hund = score / 100;		// counter = 123 --> hunds = 1
            int temp = score % 100;		// temp = 23

            int tens = temp / 10;			// tens = 2
            int ones = temp % 10;			// ones = 3
            mtkgfw.gui_show_image(x_pos-12, y_pos, numbers[hund]);
            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[tens]);
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[ones]);
        }
        
        if(score >= 1000 && score <= 9999){
            int thou = score / 1000;		// counter = 123 --> hunds = 1
            int thoumod = score % 1000;		// temp = 23
            
            int hund = thoumod / 100;		// counter = 123 --> hunds = 1
            int hundmod = thoumod % 100;		// temp = 23

            int tens = hundmod / 10;			// tens = 2
            int ones = hundmod % 10;			// ones = 3
            mtkgfw.gui_show_image(x_pos-18, y_pos, numbers[thou]);
            mtkgfw.gui_show_image(x_pos-12, y_pos, numbers[hund]);
            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[tens]);
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[ones]);
        }
        
        if(score > 9999){
            f1race_score = 0;
            score = 0;
        }
        
        
        /* render level */
        mtkgfw.gui_fill_rectangle(
        F1RACE_STATUS_START_X + 4,
        F1RACE_DISPLAY_START_Y + 74,
        F1RACE_STATUS_START_X + 29,
        F1RACE_DISPLAY_START_Y + 80,
        new Color(0,0,0));
        

        x_pos = (short) ((F1RACE_STATUS_START_X + F1RACE_STATUS_END_X) / 2);
        y_pos = F1RACE_DISPLAY_START_Y + 74;
        
        if(f1race_level < 10)
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[f1race_level]);
        
        if(f1race_level >= 10 && score < 100){
            mtkgfw.gui_show_image(x_pos-3, y_pos, numbers[f1race_level / 10]);
            mtkgfw.gui_show_image(x_pos+2, y_pos, numbers[f1race_level % 10]);
        }
        
//        if(f1race_level >= 100 && score < 1000){
//            int hund = f1race_level / 100;		// counter = 123 --> hunds = 1
//            int temp = f1race_level % 100;		// temp = 23
//
//            int tens = temp / 10;			// tens = 2
//            int ones = temp % 10;			// ones = 3
//            mtkgfw.gui_show_image(x_pos-12, y_pos, numbers[hund]);
//            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[tens]);
//            mtkgfw.gui_show_image(x_pos, y_pos, numbers[ones]);
//        }
//        
//        if(f1race_level >= 1000){
//            int thou = f1race_level / 1000;		// counter = 123 --> hunds = 1
//            int thoumod = f1race_level % 1000;		// temp = 23
//            
//            int hund = thoumod / 100;		// counter = 123 --> hunds = 1
//            int hundmod = thoumod % 100;		// temp = 23
//
//            int tens = hundmod / 10;			// tens = 2
//            int ones = hundmod % 10;			// ones = 3
//            mtkgfw.gui_show_image(x_pos-18, y_pos, numbers[thou]);
//            mtkgfw.gui_show_image(x_pos-12, y_pos, numbers[hund]);
//            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[tens]);
//            mtkgfw.gui_show_image(x_pos, y_pos, numbers[ones]);
//        }
        
        x_pos = F1RACE_STATUS_START_X + 4;
        y_pos = F1RACE_DISPLAY_START_Y + 102;
        for (index = 0; index < 5; index++){
            if (index < f1race_fly_charger_count){
                c = new Color(255, 0, 0);
            }
            else{
                c = new Color(100, 100, 100);
            }
            mtkgfw.gui_fill_rectangle(x_pos + index * 4, y_pos - 2 - index, x_pos + 2 + index * 4, y_pos, c);
        }
        
        
        x_pos = F1RACE_STATUS_START_X + 25;
        y_pos = F1RACE_DISPLAY_START_Y + 96;
        mtkgfw.gui_show_image(x_pos, y_pos, numbers[f1race_fly_count]);
    }
    
    public void F1Race_CollisionCheck(){
        short index;
        short minA_x, minA_y, maxA_x, maxA_y;
        short minB_x, minB_y, maxB_x, maxB_y;

        minA_x = (short) (f1race_player_car.pos_x - 1);
        maxA_x = (short) (minA_x + f1race_player_car.dx - 1);
        minA_y = (short) (f1race_player_car.pos_y - 1);
        maxA_y = (short) (minA_y + f1race_player_car.dy - 1);
        
        for (index = 0; index < F1RACE_OPPOSITE_CAR_COUNT; index++){
            if (f1race_opposite_car[index].is_empty == false){
                /* not empty, process bbox check */
                minB_x = (short) (f1race_opposite_car[index].pos_x - 1);
                maxB_x = (short) (minB_x + f1race_opposite_car[index].dx - 1);
                minB_y = (short) (f1race_opposite_car[index].pos_y - 1);
                maxB_y = (short) (minB_y + f1race_opposite_car[index].dy - 1);

                /* x axis */
                if (((minA_x <= minB_x) && (minB_x <= maxA_x)) || ((minA_x <= maxB_x) && (maxB_x <= maxA_x))){
                /* y axis */
                    if (((minA_y <= minB_y) && (minB_y <= maxA_y)) || ((minA_y <= maxB_y) && (maxB_y <= maxA_y))){   
                        F1Race_Render_Player_Car_Crash();
                        F1Race_Crashing();
                        return;
                    }
                }

                /* check left up corner */
                if ((minA_x >= minB_x) && (minA_x <= maxB_x) && (minA_y >= minB_y) && (minA_y <= maxB_y)){	
                    F1Race_Render_Player_Car_Crash();
                    F1Race_Crashing();
                    return;
                }

                /* check left down corner */
                if ((minA_x >= minB_x) && (minA_x <= maxB_x) && (maxA_y >= minB_y) && (maxA_y <= maxB_y)){	
                    F1Race_Render_Player_Car_Crash();
                    F1Race_Crashing();
                    return;
                }

                /* check right up corner */
                if ((maxA_x >= minB_x) && (maxA_x <= maxB_x) && (minA_y >= minB_y) && (minA_y <= maxB_y)){	
                    F1Race_Render_Player_Car_Crash();
                    F1Race_Crashing();
                    return;
                }

                /* check right down corner */
                if ((maxA_x >= minB_x) && (maxA_x <= maxB_x) && (maxA_y >= minB_y) && (maxA_y <= maxB_y)){	
                    F1Race_Render_Player_Car_Crash();
                    F1Race_Crashing();
                    return;
                }

                /* calculate score */
                if ((maxA_y < minB_y) && (f1race_opposite_car[index].is_add_score == false)){
                    f1race_score++;
                    f1race_pass++;
                    f1race_opposite_car[index].is_add_score = true;
                    /* change level */
                    if(f1race_pass % 10 == 0 && f1race_pass <= 100){
                        f1race_level++;
                    }           

                    f1race_fly_charger_count++;
                    if (f1race_fly_charger_count >= 6){
                        if (f1race_fly_count < F1RACE_MAX_FLY_COUNT){
                            f1race_fly_charger_count = 0;
                            f1race_fly_count++;
                        }
                        else    /* fly count each max. */{
                            f1race_fly_charger_count--;
                        }
                    }
                }
            }
        }
    }
    
    public void F1Race_New_Opposite_Car(){
        /*----------------------------------------------------------------*/
        /* Local Variables                                                */
        /*----------------------------------------------------------------*/
        short index;
        short validIndex = 0;
        boolean no_slot;
        short car_type = 0;
        byte road;
        short car_pos_x = 0;
        short car_shift;
        boolean enough_space;
        short rand_num;
        short speed_add;
        

        /*----------------------------------------------------------------*/
        /* Code Body                                                      */
        /*----------------------------------------------------------------*/
        /* random generate new car based on SHOW_RATE */
        no_slot = true;
        if ((mtkgfw.rand() % F1RACE_OPPOSITE_CAR_DEFAULT_APPEAR_RATE) == 0){
            /* enter here will try to create a new opposite car */
            for (index = 0; index < F1RACE_OPPOSITE_CAR_COUNT; index++){
                if (f1race_opposite_car[index].is_empty != false){
                    validIndex = index;
                    no_slot = false;
                    break;
                }
            }
        }

        /* no slot availabe */
        if (no_slot != false){
            return;
        }

        /* choose opposite car type */
        road = (byte) (mtkgfw.rand() % 3);  /* 3 = road count */

        /* avoid one car after another in the same road */
        if (road == f1race_last_car_road){
            road++;
            road %= 3;
        }

        /* proablilty for showing different car */
        /* 0,1      = trunk, */
        /* 2,3,4    = red small car */
        /* 5     = race car */
        /* 6, 7     = green small car */
        /* 8     = small truck */
        /* 9        = red sport */
        /* 10    = s.small truck */

        if (f1race_level < 3){
            rand_num = (short) (mtkgfw.rand() % 11);
            switch (rand_num){
                case 0:
                case 1:
                    car_type = 0;
                    break;

                case 2:
                case 3:
                case 4:
                    car_type = 1;
                    break;
                case 5:
                    car_type = 2;
                    break;
                case 6:
                case 7:
                    car_type = 3;
                    break;
                case 8:
                    car_type = 4;
                    break;
                case 9:
                    car_type = 5;
                    break;
                case 10:
                car_type = 6;
                    break;
            }
        }

        /* proablilty for showing different car */
        /* 0,1      = trunk, */
        /* 2,3,4    = red small car */
        /* 5     = race car */
        /* 6, 7     = green small car */
        /* 8     = small truck */
        /* 9        = red sport */
        /* 10    = s.small truck */

        if (f1race_level >= 3){
            rand_num = (short) (mtkgfw.rand() % 11);
            switch (rand_num){
                case 0:
                    car_type = 0;
                    break;

                case 1:
                case 2:
                    car_type = 1;
                    break;
                case 3:
                case 4:
                    car_type = 2;
                    break;
                case 5:
                case 6:
                    car_type = 3;
                    break;
                case 7:
                    car_type = 4;
                    break;
                case 8:
                case 9:
                    car_type = 5;
                    break;
                case 10:
                    car_type = 6;
                    break;
            }
        }
        /* car_type = 6; */
        /* make sure there is enought space for user car to change road */
        enough_space = true;
        for (index = 0; index < F1RACE_OPPOSITE_CAR_COUNT; index++){
            if ((f1race_opposite_car[index].is_empty == false) &&
                (f1race_opposite_car[index].pos_y < (F1RACE_PLAYER_CAR_IMAGE_SIZE_Y * 1.5)))
            {
                enough_space = false;
            }
        }

        if (enough_space == false){
            return;
        }

        speed_add = (short) (f1race_level - 1);
        if (speed_add > 0){
            speed_add = (short) (speed_add / 4);
        }
        /* Init opposite car */
        f1race_opposite_car[validIndex].is_empty = false;
        f1race_opposite_car[validIndex].is_add_score = false;
        f1race_opposite_car[validIndex].dx = f1race_opposite_car_type[car_type].dx;
        f1race_opposite_car[validIndex].dy = f1race_opposite_car_type[car_type].dy;
        f1race_opposite_car[validIndex].speed = (short) (f1race_opposite_car_type[car_type].speed + speed_add);
        f1race_opposite_car[validIndex].dx_from_road = f1race_opposite_car_type[car_type].dx_from_road;
        f1race_opposite_car[validIndex].image = f1race_opposite_car_type[car_type].image;

        car_shift = f1race_opposite_car[validIndex].dx_from_road;

        switch (road){
            case 0:
                car_pos_x = (short) (F1RACE_ROAD_0_START_X + car_shift);
                break;
            case 1:
                car_pos_x = (short) (F1RACE_ROAD_1_START_X + car_shift);
                break;
            case 2:
                car_pos_x = (short) (F1RACE_ROAD_2_START_X + car_shift);
                break;
        }

        f1race_opposite_car[validIndex].pos_x = (short) car_pos_x;
        f1race_opposite_car[validIndex].pos_y = (short) (F1RACE_DISPLAY_START_Y - f1race_opposite_car[validIndex].dy);
        f1race_opposite_car[validIndex].road_id = road;

        f1race_last_car_road = road;
    }
    
    public void F1Race_Render_Opposite_Car(){
        short index;
        for (index = 0; index < F1RACE_OPPOSITE_CAR_COUNT; index++){
            if (f1race_opposite_car[index].is_empty == false){
                mtkgfw.gui_show_image(
                    f1race_opposite_car[index].pos_x,
                    f1race_opposite_car[index].pos_y,
                    f1race_opposite_car[index].image);
            }
        }
    }
    
    public void F1Race_Crashing(){
        //play sound
        mid.stop();
        try{
                mid.setSequence(new SOUNDS().CAR_CRASH);
        }
        catch(IOException | InvalidMidiDataException ex){
                System.err.println(ex.toString());
        }
        mid.setLoopCount(0);
        mid.start();
        f1race_is_crashing = true;
    }
    
    public void F1Race_Draw_GameOver(){
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
       
        int score = f1race_score;
        g2d = (Graphics2D) p.getGraphics();
        
        mtkgfw.gui_fill_rectangle(0, 0, WINDOW_WIDTH,WINDOW_HEIGHT, new Color(234, 243, 255));
        
        text_image_height = mtkgfw.getHeight(tx.TEXTURE_GAMEOVER);
        box_image_height = mtkgfw.getHeight(tx.TEXTURE_GAMEOVER_FIELD);
        pic_image_height = mtkgfw.getHeight(tx.TEXTURE_GAMEOVER_CRASH);
        text_image_width = mtkgfw.getWidth(tx.TEXTURE_GAMEOVER);
        box_image_width = mtkgfw.getWidth(tx.TEXTURE_GAMEOVER_FIELD);
        pic_image_width = mtkgfw.getWidth(tx.TEXTURE_GAMEOVER_CRASH);
        
        spacing = (128 - (text_image_height + box_image_height + pic_image_height)) >> 2;
        
        text_image_offset_y = spacing;
        box_image_offset_y = text_image_offset_y + text_image_height + spacing;
        pic_image_offset_y = box_image_offset_y + box_image_height + spacing;
        
        int x_pos = F1RACE_STATUS_START_X - 3;
        int y_pos = (149 - box_image_offset_y) / 2;
        
        mtkgfw.gui_show_image((128 - text_image_width) / 2, text_image_offset_y, tx.TEXTURE_GAMEOVER);
        mtkgfw.gui_show_image((128 - box_image_width) / 2, box_image_offset_y, tx.TEXTURE_GAMEOVER_FIELD);
        
        
        mtkgfw.gui_show_image((128 - pic_image_width) / 2, pic_image_offset_y, tx.TEXTURE_GAMEOVER_CRASH);
        
        mtkgfw.gui_show_image(36, (148 - box_image_offset_y) /2, tx.TEXTURE_STATUS_SCORE);
        mtkgfw.gui_show_image(65, (145 - box_image_offset_y) /2, tx.TEXTURE_STATUS_BOX);
        
        if(score < 10)
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[score]);
        
        if(score >= 10 && score < 100){
            
            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[score / 10] );
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[score % 10]);
        }
        
        if(score >= 100 && score < 1000){
            int hund = score / 100;		// counter = 123 --> hunds = 1
            int temp = score % 100;		// temp = 23

            int tens = temp / 10;			// tens = 2
            int ones = temp % 10;			// ones = 3
            mtkgfw.gui_show_image(x_pos-12, y_pos, numbers[hund]);
            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[tens]);
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[ones]);
        }
        
        if(score >= 1000 && score <= 9999){
            int thou = score / 1000;		// counter = 123 --> hunds = 1
            int thoumod = score % 1000;		// temp = 23
            
            int hund = thoumod / 100;		// counter = 123 --> hunds = 1
            int hundmod = thoumod % 100;		// temp = 23

            int tens = hundmod / 10;			// tens = 2
            int ones = hundmod % 10;			// ones = 3
            mtkgfw.gui_show_image(x_pos-18, y_pos, numbers[thou]);
            mtkgfw.gui_show_image(x_pos-12, y_pos, numbers[hund]);
            mtkgfw.gui_show_image(x_pos-6, y_pos, numbers[tens]);
            mtkgfw.gui_show_image(x_pos, y_pos, numbers[ones]);
        }
    
        mid.stop();
        try{
                mid.setSequence(new SOUNDS().GAMEOVER);
        }
        catch(IOException | InvalidMidiDataException ex){
                System.err.println(ex.toString());
        }
        mid.setLoopCount(0);
        mid.start();
        //mtkgfw.mmi_gfx_draw_gameover_screen(tx.TEXTURE_GAMEOVER, tx.TEXTURE_GAMEOVER_FIELD, tx.TEXTURE_GAMEOVER_CRASH, f1race_score);
        gover = true;
        
    }
    
    public void F1Race_Render_Player_Car_Crash(){
    mtkgfw.gui_show_image(
        f1race_player_car.pos_x,
        f1race_player_car.pos_y - 5,tx.TEXTURE_PLAYER_CAR_CRASH);
    }
    
    public void newGame(){
        int index;
        f1race_is_new_game = true;
        f1race_is_crashing = false;
        f1race_key_up_pressed = false;
        f1race_key_down_pressed = false;
        f1race_key_right_pressed = false;
        f1race_key_left_pressed = false;
        f1race_separator_0_block_start_y = F1RACE_DISPLAY_START_Y;
        f1race_separator_1_block_start_y = F1RACE_DISPLAY_START_Y;
        f1race_crashing_count_down = 10;
        f1race_player_is_car_fly = false;
        f1race_player_car.pos_x = (short) ((F1RACE_ROAD_1_START_X + F1RACE_ROAD_1_END_X - F1RACE_PLAYER_CAR_IMAGE_SIZE_X) / 2);
        f1race_player_car.pos_y = F1RACE_DISPLAY_END_Y - F1RACE_PLAYER_CAR_IMAGE_SIZE_Y - 1;
        f1race_is_crashing = false;
        f1race_last_car_road = 0;
        f1race_score = 0;
        f1race_level = 1;
        f1race_pass = 0;
        f1race_fly_count = 1;
        f1race_fly_charger_count = 0;	
        
        for (index = 0; index < F1RACE_OPPOSITE_CAR_COUNT; index++){
            f1race_opposite_car[index].is_empty = true; /* clear all slot, no car */
            f1race_opposite_car[index].is_add_score = false;
        }
        
        mid.stop();
        mid.close();
        try{
                mid.setSequence(new SOUNDS().F1RACE_THEME);
                mid.open();
                Thread.sleep(250);
        }
        catch(IOException | InvalidMidiDataException | MidiUnavailableException | InterruptedException ex){
                System.err.println(ex.toString());
        }
        mid.setLoopCount(mid.LOOP_CONTINUOUSLY);
        mid.start();
        t.start();
    }
    
    public void F1Race_Framemove(){
        short shift;
        short max;
        short index;

        f1race_player_car_fly_duration++;
        if (f1race_player_car_fly_duration == F1RACE_PLAYER_CAR_FLY_FRAME_COUNT)
        {
            f1race_player_is_car_fly = false;
        }

        /* Player car movement */
        shift = F1RACE_PLAYER_CAR_SHIFT;
        if (f1race_key_up_pressed)
        {
            if (f1race_player_car.pos_y - shift < F1RACE_DISPLAY_START_Y)
            {
                shift = (short) (f1race_player_car.pos_y - F1RACE_DISPLAY_START_Y - 1);
            }

            if (f1race_player_is_car_fly == false)
            {
                f1race_player_car.pos_y -= shift;
            }
        }

        if (f1race_key_down_pressed)
        {
            max = (short) (f1race_player_car.pos_y + f1race_player_car.dy);
            if (max + shift > F1RACE_DISPLAY_END_Y)
            {
                shift = (short) ( F1RACE_DISPLAY_END_Y - max);
            }

            if (f1race_player_is_car_fly == false)
            {
                f1race_player_car.pos_y += shift;
            }
        }

        if (f1race_key_right_pressed)
        {
            max =  (short) (f1race_player_car.pos_x + f1race_player_car.dx);
            if (max + shift > F1RACE_ROAD_2_END_X)
            {
                shift =  (short) (F1RACE_ROAD_2_END_X - max);
            }

            f1race_player_car.pos_x += shift;
        }

        if (f1race_key_left_pressed)
        {
            if (f1race_player_car.pos_x - shift < F1RACE_ROAD_0_START_X)
            {
                shift =  (short) (f1race_player_car.pos_x - F1RACE_ROAD_0_START_X - 1);
            }

            f1race_player_car.pos_x -= shift;
        }

        /* Oppoiste Car movement */
        for (index = 0; index < F1RACE_OPPOSITE_CAR_COUNT; index++)
        {
            if (f1race_opposite_car[index].is_empty == false)
            {
                /* move one step foward */
                f1race_opposite_car[index].pos_y += f1race_opposite_car[index].speed;

                /* Test if this car within valid display region */
                if (f1race_opposite_car[index].pos_y > (F1RACE_DISPLAY_END_Y + f1race_opposite_car[index].dy))
                {
                    /* out of display region, free the slot */
                    f1race_opposite_car[index].is_empty = true;
                }

            }
        }

        /* Player car fly */
        if (f1race_player_is_car_fly != false)
        {
            /* car fly movement */
            shift = F1RACE_PLAYER_CAR_FLY_SHIFT;
            if (f1race_player_car.pos_y - shift < F1RACE_DISPLAY_START_Y)
            {
                shift =  (short) (f1race_player_car.pos_y - F1RACE_DISPLAY_START_Y - 1);
            }

            f1race_player_car.pos_y -= shift;
        }
        else
        {
            /* Car not flying , process collision Test */
            F1Race_CollisionCheck();
        }

        F1Race_New_Opposite_Car();
        
    }
    
    
}