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
        
        if(args.length > 0){
           if(args[0] == "--hrr"){
                F1RaceSwing f1 = new F1RaceSwing(true);
                f1.startApp();
           }    
        }
        else{
            F1RaceSwing f1 = new F1RaceSwing();
            f1.startApp();
        }
//        SOUNDS s = new SOUNDS();
//        byte[] main = s.CAR_CRASH.readAllBytes();
//        File out = new File("out.txt");
//        PrintWriter pr = new PrintWriter(new FileWriter(out));
//        for(byte x: main){
//            pr.print(x + ", ");
//        }
//        pr.close();
//        System.out.println();

        
        
        
    }
    
}
