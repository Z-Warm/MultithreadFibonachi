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

public class StateObject {
    private long i=0;//Count of iteration
    private long Begin;//Begin time
    private long Current;//Current time
    private final MyJFrame Frame;//User window

    /**
     *
     * @param Frame
     */
    public StateObject(MyJFrame Frame) {
        this.Frame = Frame;
        this.Begin = (long) System.currentTimeMillis();
    }   
    /*increment iteration*/
    public synchronized void increment(){this.i++; Frame.setIterations(Long.toString(i));}
    /*Set new current time*/
    public synchronized void setTime(){
       Current = (long) System.currentTimeMillis();
       Frame.setTime(Long.toString(this.Current-this.Begin));
       //System.err.println("time = " +Long.toString(Current));
    }
    /*Get iterarions count*/
    public  long getI(){
        return this.i;        
    } 
    /*Get current time*/
    public  long getTime(){  
        return this.Current-this.Begin;        
    } 
    /*Set begin time*/   
    public void setBegin(){
        this.Begin = (long) System.currentTimeMillis();
    }
}

