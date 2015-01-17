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
import java.util.Random;
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

    public void BoutonValiderListener(String ipAddress) {
        System.out.println(ipAddress);
    }

    public String BoutonGenererListener() {
        
        String ipGen = "";
        Random randomGenerator = new Random();   
        ipGen = randomGenerator.nextInt(256) + "." + randomGenerator.nextInt(256) + "." + randomGenerator.nextInt(256) + "." + randomGenerator.nextInt(256);

        return ipGen;
    }
}
