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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class View {
    
    static private final int WIDTH = 600;
    static private final int HEIGHT = 800;
    private Controller controller;
    private final JFrame frame;
    private final JTextField ipField;
    private final JButton boutonValider;
    private final JButton boutonGenerer;
    private final JButton boutonHelp;
    private final JLabel wrongIP;
    public View(){
        frame = new JFrame("TraceTheRoute");
        ipField = new JTextField();
        boutonValider = new JButton("Trace");
        boutonGenerer = new JButton("Generate");
        boutonHelp = new JButton("?");
        wrongIP = new JLabel(" ");
    }

    public void launch(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        Box boxFields = Box.createHorizontalBox();
        JLabel ipLabel = new JLabel("IP Address : ");
        boxFields.add(ipLabel);
        boxFields.add(ipField);
        boxFields.add(boutonValider);
        boxFields.add(boutonGenerer);
        boxFields.add(boutonHelp);
        
        Box boxMessage = Box.createHorizontalBox();
        boxMessage.add(wrongIP);
        
        Box boxDiagram = Box.createHorizontalBox();
        JPanel graphPanel = new JPanel();
        graphPanel.setBorder(new TitledBorder(new EtchedBorder(), "Diagram"));
        JTextArea info = new JTextArea(100,50);
        info.setText("You can enter your IP Address or generate one by clicking the button. Then click on 'Trace' to see the path followed by your packet.");
        info.append("test");
        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(info);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        graphPanel.add(scroll);      
        boxDiagram.add(graphPanel);

        boutonValider.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String message = " ";
                message = controller.BoutonValiderListener(ipField.getText());
                wrongIP.setText(message);
            }
        });
        boutonGenerer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String ipGenerated="";
                ipGenerated = controller.BoutonGenererListener();
                ipField.setText(ipGenerated);
                wrongIP.setText(" ");
            }
        });
        boutonHelp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                wrongIP.setText(" ");
                BoutonHelpListener();
            }
        });

        Box boxContainer = Box.createVerticalBox();
        boxContainer.add(boxFields);
        boxContainer.add(boxMessage);
        boxContainer.add(boxDiagram);
        frame.add(boxContainer, BorderLayout.NORTH);
        frame.setVisible(true);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }
            
    public void BoutonHelpListener()
    {
        JDialog infoDialog = new JDialog();
        infoDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoDialog.setSize(WIDTH/2, HEIGHT/6);
        infoDialog.setLocationRelativeTo(null);
        infoDialog.setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Help"));
        JTextArea info = new JTextArea(4, 22);
        info.setText("You can enter your IP Address or generate one by clicking the button. Then click on 'Trace' to see the path followed by your packet.");
        info.setEditable(false);
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(info);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(scroll);      
        infoDialog.add(panel);
        infoDialog.requestFocusInWindow();
        infoDialog.setModal(true);
        infoDialog.setVisible(true);

    }
}
