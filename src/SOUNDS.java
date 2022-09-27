
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dyhar
 */
public class SOUNDS {
    public final InputStream F1RACE_THEME;
    public final InputStream GAMEOVER;
    public final InputStream CAR_CRASH;
    public SOUNDS() throws FileNotFoundException{
        //for debugging
//        F1RACE_THEME = new BufferedInputStream(new FileInputStream(new File("assets/F1RACE_THEME.mid")));
//        GAMEOVER = new BufferedInputStream(new FileInputStream(new File("assets/GAME_OVER.mid")));
//        CAR_CRASH = new BufferedInputStream(new FileInputStream(new File("assets/CAR_CRASH.MID")));

        F1RACE_THEME = new BufferedInputStream((getClass().getResourceAsStream("assets/F1RACE_THEME.mid")));
        GAMEOVER = new BufferedInputStream((getClass().getResourceAsStream("assets/GAME_OVER.mid")));
        CAR_CRASH = new BufferedInputStream((getClass().getResourceAsStream("assets/CAR_CRASH.mid")));
    }
}
