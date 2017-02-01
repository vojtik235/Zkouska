package stopky;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopky {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Casovac c = new Casovac(1000);
        c.addListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Provedla se operace.");
            }
        });
        c.start();
    }
    
}
