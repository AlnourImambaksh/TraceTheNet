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

public class Controller {
    private final View view;
    
    public Controller(View view) {
        this.view = view;
        view.setController(this);
    }
    
    public void start() {
        view.launch();
    }
}
