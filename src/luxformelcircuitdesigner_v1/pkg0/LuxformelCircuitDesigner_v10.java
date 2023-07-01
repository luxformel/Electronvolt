/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author luxformel
 */
public class LuxformelCircuitDesigner_v10 {
    
    
    static String lookAndFeelName = "Nimbus";
    
    public void setLookAndFeelName(String lookAndFeelName){
        this.lookAndFeelName = lookAndFeelName;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            for (UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }       
            }
        
            
            
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
}
