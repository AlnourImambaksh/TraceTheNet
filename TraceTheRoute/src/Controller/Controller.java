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
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class Controller {
    private final View view;
    
    public Controller(View view) {
        this.view = view;
        view.setController(this);
    }
    
    public void start() {
        view.launch();
    }

    public String BoutonValiderListener(String ipAddress) {
        Runtime r = Runtime.getRuntime();
        Process p = null;
        if(ipAddress == null || ipAddress.length()==0)
        {
            return "Wrong IP address";
        }
        else
        {
            try {
                //Affichage à enlever
                System.out.println(ipAddress);
                String executeString = "tracert " +ipAddress;
                p = r.exec(executeString);
                
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
               
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            InputStream myStream = p.getInputStream();
             return " ";
        }
    }

    public String BoutonGenererListener() {
        
        String ipGen = "";
        Random randomGenerator = new Random();   
        ipGen = randomGenerator.nextInt(256) + "." + randomGenerator.nextInt(256) + "." + randomGenerator.nextInt(256) + "." + randomGenerator.nextInt(256);

        return ipGen;
    }
}
