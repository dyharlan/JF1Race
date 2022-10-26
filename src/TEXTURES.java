import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
public class TEXTURES{
    public final BufferedImage TEXTURE_NUMBER_0;
    public final BufferedImage TEXTURE_NUMBER_1;
    public final BufferedImage TEXTURE_NUMBER_2;
    public final BufferedImage TEXTURE_NUMBER_3;
    public final BufferedImage TEXTURE_NUMBER_4;
    public final BufferedImage TEXTURE_NUMBER_5;
    public final BufferedImage TEXTURE_NUMBER_6;
    public final BufferedImage TEXTURE_NUMBER_7;
    public final BufferedImage TEXTURE_NUMBER_8;
    public final BufferedImage TEXTURE_NUMBER_9;
    public final BufferedImage TEXTURE_PLAYER_CAR;
    public final BufferedImage TEXTURE_PLAYER_CAR_FLY;
    public final BufferedImage TEXTURE_PLAYER_CAR_FLY_UP;
    public final BufferedImage TEXTURE_PLAYER_CAR_FLY_DOWN;
    public final BufferedImage TEXTURE_PLAYER_CAR_HEAD_LIGHT;
    public final BufferedImage TEXTURE_PLAYER_CAR_CRASH;
    public final BufferedImage TEXTURE_LOGO;
    public final BufferedImage TEXTURE_STATUS_SCORE;
    public final BufferedImage TEXTURE_STATUS_BOX;
    public final BufferedImage TEXTURE_STATUS_LEVEL;
    public final BufferedImage TEXTURE_STATUS_FLY;
    public final BufferedImage TEXTURE_OPPOSITE_CAR_0;
    public final BufferedImage TEXTURE_OPPOSITE_CAR_1;
    public final BufferedImage TEXTURE_OPPOSITE_CAR_2;
    public final BufferedImage TEXTURE_OPPOSITE_CAR_3;
    public final BufferedImage TEXTURE_OPPOSITE_CAR_4;
    public final BufferedImage TEXTURE_OPPOSITE_CAR_5;
    public final BufferedImage TEXTURE_OPPOSITE_CAR_6;
    public final BufferedImage TEXTURE_GAMEOVER;
    public final BufferedImage TEXTURE_GAMEOVER_CRASH;
    public final BufferedImage TEXTURE_GAMEOVER_FIELD;
    public final BufferedImage TEXTURE_GAMEOVER_FIELD_BLUE;
    public final BufferedImage TEXTURE_ICON;
    

    public TEXTURES() throws IOException{
             TEXTURE_NUMBER_0 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_0.bmp"));
             TEXTURE_NUMBER_1 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_1.bmp"));
             TEXTURE_NUMBER_2 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_2.bmp"));
             TEXTURE_NUMBER_3 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_3.bmp"));
             TEXTURE_NUMBER_4 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_4.bmp"));
             TEXTURE_NUMBER_5 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_5.bmp"));
             TEXTURE_NUMBER_6 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_6.bmp"));
             TEXTURE_NUMBER_7 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_7.bmp"));
             TEXTURE_NUMBER_8 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_8.bmp"));
             TEXTURE_NUMBER_9 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_NUMBER_9.bmp"));
             TEXTURE_PLAYER_CAR = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_PLAYER_CAR.png"));
             TEXTURE_PLAYER_CAR_FLY = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_PLAYER_CAR_FLY.png"));
             TEXTURE_PLAYER_CAR_FLY_UP = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_PLAYER_CAR_FLY_UP.png"));
             TEXTURE_PLAYER_CAR_FLY_DOWN = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_PLAYER_CAR_FLY_DOWN.png"));
             TEXTURE_PLAYER_CAR_HEAD_LIGHT = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_PLAYER_CAR_HEAD_LIGHT.png"));
             TEXTURE_PLAYER_CAR_CRASH = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_PLAYER_CAR_CRASH.png"));
             TEXTURE_LOGO = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_LOGO.bmp"));
             TEXTURE_STATUS_SCORE = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_STATUS_SCORE.bmp"));
             TEXTURE_STATUS_BOX = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_STATUS_BOX.bmp"));
             TEXTURE_STATUS_LEVEL = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_STATUS_LEVEL.bmp"));
             TEXTURE_STATUS_FLY = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_STATUS_FLY.bmp"));
             TEXTURE_OPPOSITE_CAR_0 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_OPPOSITE_CAR_0.png"));
             TEXTURE_OPPOSITE_CAR_1 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_OPPOSITE_CAR_1.png"));
             TEXTURE_OPPOSITE_CAR_2 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_OPPOSITE_CAR_2.png"));
             TEXTURE_OPPOSITE_CAR_3 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_OPPOSITE_CAR_3.png"));
             TEXTURE_OPPOSITE_CAR_4 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_OPPOSITE_CAR_4.png"));
             TEXTURE_OPPOSITE_CAR_5 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_OPPOSITE_CAR_5.png"));
             TEXTURE_OPPOSITE_CAR_6 = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_OPPOSITE_CAR_6.png"));
             TEXTURE_GAMEOVER = ImageIO.read(getClass().getResourceAsStream("/assets/GAME_F1RACE_GAMEOVER.bmp"));
             TEXTURE_GAMEOVER_CRASH = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_GAMEOVER_CRASH.bmp"));
             TEXTURE_GAMEOVER_FIELD = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_GAMEOVER_FIELD.bmp"));
             TEXTURE_GAMEOVER_FIELD_BLUE = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_GAMEOVER_FIELD_BLUE.bmp"));
             TEXTURE_ICON = ImageIO.read(getClass().getResourceAsStream("assets/GAME_F1RACE_ICON.bmp"));
             
        }
}