/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dyhar
 */

import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
        F1RaceSwing f1 = new F1RaceSwing();
        f1.startApp();
//        byte[] mid = {77, 84, 104, 100, 0, 0, 0, 6, 0, 0, 0, 1, 3, -64, 77, 84, 114, 107, 0, 0, 1, 26, 0, -1, 2, 22, 67, 111, 112, 121, 114, 105, 103, 104, 116, 32, 99, 32, 50, 48, 48, 51, 32, 98, 121, 32, 67, 67, 0, -1, 1, 2, 67, 67, 0, -1, 88, 4, 4, 2, 24, 8, 0, -1, 89, 2, 0, 0, 0, -1, 81, 3, 6, -56, 28, 0, -112, 72, 111, -125, 96, 72, 0, 0, 76, 124, -125, 96, 76, 0, 0, 79, 124, -125, 96, 79, 0, 0, 72, 103, -127, 112, 72, 0, 0, 76, 124, -123, 73, 76, 0, 7, 79, 124, -125, 96, 79, 0, 0, 72, 103, -125, 96, 72, 0, 0, 76, 111, -125, 96, 76, 0, 0, 77, 124, -125, 96, 77, 0, 0, 81, 124, -125, 96, 81, 0, 0, 84, 124, -125, 96, 84, 0, 0, 77, 124, -127, 112, 77, 0, 0, 81, 124, -123, 80, 84, 124, 6, 81, 0, -125, 90, 84, 0, 0, 77, 125, -125, 96, 77, 0, 0, 81, 124, -125, 96, 81, 0, 0, 79, 124, -125, 96, 79, 0, 0, 83, 90, -125, 96, 83, 0, 0, 86, 124, -125, 96, 86, 0, 0, 79, 111, -127, 112, 79, 0, 0, 83, 124, -123, 80, 89, 124, 14, 83, 0, -125, 82, 89, 0, 0, 79, 124, -125, 96, 79, 0, 0, 83, 124, -125, 96, 83, 0, 0, 84, 124, -125, 96, 84, 0, 0, 88, 103, -125, 96, 88, 0, 0, 91, 124, -125, 96, 91, 0, 0, 84, 111, -127, 112, 84, 0, 0, 88, 124, -123, 40, 88, 0, 40, 91, 111, -125, 96, 91, 0, 0, 84, 111, -125, 96, 84, 0, 0, 88, 124, -125, 96, 88, 0, 0, -1, 47, 0};
//        
//        MIDPlayer mp = new MIDPlayer();
//       
//        InputStream is = new BufferedInputStream(new ByteArrayInputStream( mid));
//        mp.load(is);
//        mp.setLoopCount(mp.LOOP_CONTINUOUSLY);
//        mp.start();
//        Thread.sleep(5000);
//        mp.stopPlayback();
//        mp.load(new ASSETS().GAMEOVER);
//        mp.setLoopCount(0);
//        mp.resumePlayback();
//        Thread.sleep(5000);
//        mp.stopPlayback();
//        mp.load(new BufferedInputStream(new ByteArrayInputStream( mid)));
//        mp.setLoopCount(mp.LOOP_CONTINUOUSLY);
//        mp.resumePlayback();
//        Thread.sleep(5000);
//        mp.stopPlayback();
//        mp.load(new ASSETS().GAMEOVER);
//        mp.setLoopCount(0);
//        mp.resumePlayback();
        
        
        
    }
    
    private static byte[] toByte(int[] data) throws IOException {
    
    byte[] bytes = new byte[data.length];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) data[i];
    }
    return bytes;
  }
}
