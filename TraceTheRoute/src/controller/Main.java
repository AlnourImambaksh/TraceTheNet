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
import java.io.IOException;
import java.io.InputStream;

public class Main {
    
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller (view);
        controller.start();
        
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("java -jar fakeroute.jar ece.fr");

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        InputStream myStream = p.getInputStream();
        

        
    }
    
}


