/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dyhar
 */

import java.io.InputStream;
import java.io.IOException;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.InvalidMidiDataException;
public class MIDPlayer extends Thread {
    private Sequencer seq;
    public static final int LOOP_CONTINUOUSLY = Sequencer.LOOP_CONTINUOUSLY;
    MIDPlayer() throws MidiUnavailableException
    {
        seq = MidiSystem.getSequencer();
        seq.open();
    }
    
    public void run(){
        seq.start();
    }
    
    public synchronized void load(InputStream is) throws IOException, InvalidMidiDataException{
        this.yield();
        seq.setSequence(is);
    }
    
    public synchronized void resumePlayback(){
        seq.start();
    }
    
    public synchronized void stopPlayback(){
        this.yield();
        seq.stop();
    }
    
    public synchronized void setLoopCount(int repetitions){
        seq.setLoopCount(repetitions);
    }
}
