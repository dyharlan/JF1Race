
import java.io.BufferedInputStream;
import java.io.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dyhar
 */
public class SOUND {
    public final InputStream F1RACE_THEME;
    public final InputStream GAMEOVER;
    public final InputStream CAR_CRASH;
    public SOUND() throws FileNotFoundException{
        F1RACE_THEME = new BufferedInputStream(new FileInputStream(new File("assets/F1RACE_THEME.mid")));
        GAMEOVER = new BufferedInputStream(new FileInputStream(new File("assets/GAME_OVER.mid")));
        CAR_CRASH = new BufferedInputStream(new FileInputStream(new File("assets/CAR_CRASH.MID")));
    }
}
