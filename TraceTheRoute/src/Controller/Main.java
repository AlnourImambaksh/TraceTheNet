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

public class Main {
    /*public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        View view = new View();
        Controller controller = new Controller (view);
        controller.start();
        FakeTraceGenerator generator = new FakeTraceGenerator("ece.fr");
        
        try {
            PrintWriter writer = new PrintWriter("Fakeroute.txt", "UTF-8");
            writer.println(generator.generate());
            writer.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
     public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller (view);
        controller.start();
     }
}


