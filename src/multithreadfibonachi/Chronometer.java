/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadfibonachi;

/**
 *
 * @author YZub
 * @version 1.0
 */
public class Chronometer extends Thread{
    private final StateObject StateObj;//Sate object for saving time

    public Chronometer(StateObject StateObj) {
        this.StateObj = StateObj;
    }
    
    @Override
    public void run(){    
        while (!Thread.interrupted()){ 
            if (this.isInterrupted()) return;//Go away if this stopped
            this.StateObj.setTime();    
        }
    }
    
    @Override
    public void start(){
        super.start();
        StateObj.setBegin();//Set begin time for Sate object 
    }
}