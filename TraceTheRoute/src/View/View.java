/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Alnour
 */

import java.awt.*;
import javax.swing.*;
import Controller.Controller;
import Model.Model;
public class View {
    
    static private final int WIDTH = 600;
    static private final int HEIGHT = 400;
    private Controller controller;
    private final JFrame frame;
    
    public View(){
        frame = new JFrame("TraceTheRoute");
        
    }
    
    public void launch(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
            
    
}
