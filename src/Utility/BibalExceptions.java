package Utility;

import javax.swing.JOptionPane;

/**
 *
 * @author Diallo & Janati
 */
public class BibalExceptions extends Exception{

    public BibalExceptions(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message, "Informations", JOptionPane.PLAIN_MESSAGE);
    }
    
    public BibalExceptions(Throwable cause) {
        super(cause);
    }
    
    public BibalExceptions(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
