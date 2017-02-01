package stopky;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author bleha
 */
public class Casovac extends Thread {
    
    private final ArrayList<ActionListener> listeners;
    private boolean running;
    private final int waitTime;
    
    public Casovac(int waitTime) {
        this.waitTime = waitTime;
        this.running = true;
        this.listeners = new ArrayList<>();
    }
    
    public void addListener(ActionListener listener) {
        listeners.add(listener);
    }
    
    public ActionListener getListener(int index) {
        return listeners.get(index);
    }
    
    public ActionListener removeListener(int index) {
        return listeners.remove(index);
    }
    
    public boolean isRunning() {
        return running;
    }
    
    public void setRunning(boolean running) {
        this.running = running;
    }
    
    @Override
    public void run() {
        while(running) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ex) {
                System.out.println("Nepovedlo se uspat vlákno!");
            }
            action();
        }
    }
    
    private void action() {
        for (ActionListener listener : listeners) {
            listener.actionPerformed(new ActionEvent(this, 0, ""));
        }
    }
    
}
