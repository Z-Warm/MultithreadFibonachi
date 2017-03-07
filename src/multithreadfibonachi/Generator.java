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
public class Generator extends Thread{
    private final StateObject StateObj;//State object for saving iteration count
    private Chronometer Chr;//Chronometer for timing

    public Generator(StateObject StateObj) {
        this.StateObj = StateObj;//Set current State object
        this.Chr =  new Chronometer(this.StateObj);//Create Chronometer
    }    
    
     @Override
     public void run(){  
        long PrevFibonachi = 0;
        long CurrFibonachi = 1;    
        Chr.start();//Start Chronometer
        do{
            /*Generate new Fibonachi*/
            long Fibonachi  = PrevFibonachi  + CurrFibonachi;
            PrevFibonachi = CurrFibonachi;
            CurrFibonachi = Fibonachi;
            /*Stop chronometer if this soppet and go away*/
            if (this.isInterrupted()) {this.Chr.interrupt();this.Chr = null; return;}
            this.StateObj.increment();
        } while(CurrFibonachi<Long.MAX_VALUE);
        Chr.interrupt();//Stop Chronometer
    }

}
