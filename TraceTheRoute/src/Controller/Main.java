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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Runtime r = Runtime.getRuntime();
        Process p = null;
        
        try {
            p = r.exec("tracert ece.fr");
            
            File file = new File("output.txt");
            if(file.delete())
            {
                
            }
            FileOutputStream fout = new FileOutputStream("output.txt", true);
                        
            BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(p.getInputStream()));
            
            String s = null;

            while ((s = stdInput.readLine()) != null) {

                PrintStream out = new PrintStream(new FileOutputStream("output.txt", true));
                System.setOut(out);
            System.out.println(s);
            }

            stdInput.close();
            fout.close();
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream myStream = p.getInputStream();
     }
}


