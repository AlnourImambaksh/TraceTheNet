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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class View {
    
    static private final int WIDTH = 600;
    static private final int HEIGHT = 800;
    private Controller controller;
    private final JFrame frame;
    private final JTextField ipField;
    private final JButton boutonValider;
    private final JButton boutonGenerer;
    private final JButton boutonHelp;
    private final JLabel labelInfo;
    
    public View(){
        frame = new JFrame("TraceTheRoute");
        ipField = new JTextField();
        boutonValider = new JButton("Trace");
        boutonGenerer = new JButton("Generate");
        boutonHelp = new JButton("?");
        labelInfo = new JLabel(" ");
    }

    public void launch(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0,5));  

        panel.add(new JLabel("IP Address : "));
        panel.add(ipField);
        panel.add(boutonValider);
        panel.add(boutonGenerer);
        panel.add(boutonHelp);
        panel.add(labelInfo);
       
        boutonValider.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                controller.BoutonValiderListener(ipField.getText());
            }
        });
        boutonGenerer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String ipGenerated="";
                ipGenerated = controller.BoutonGenererListener();
                 ipField.setText(ipGenerated);
            }
        });
        boutonHelp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                BoutonHelpListener();
            }
        });
        
        frame.setVisible(true);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
            
    public void BoutonHelpListener()
    {
        JFrame infoFrame = new JFrame("How does it work ?");
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setSize(WIDTH/2, HEIGHT/3);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setResizable(false);
        JPanel pan = new JPanel();
        infoFrame.add(pan, BorderLayout.CENTER);
        
        /*
        A corriger !! c'est pas beau à voir
        */
           
        JTextArea info = new JTextArea("You can enter your IP Address or generate one by clicking the button. Then click on "+"Trace"+" to see the path followed by your packet");
        pan.add(info);
        infoFrame.setVisible(true);
    }
}
