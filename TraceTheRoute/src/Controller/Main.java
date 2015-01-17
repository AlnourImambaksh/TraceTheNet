/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Alnour
 */

import View.View;
import Model.Model;
import fr.ece.fauberte.fakeroute.trace.FakeTraceGenerator;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller (view);
        controller.start();
        FakeTraceGenerator generator = new FakeTraceGenerator("ece.fr");
        try {
            System.out.println(generator.generate());
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
