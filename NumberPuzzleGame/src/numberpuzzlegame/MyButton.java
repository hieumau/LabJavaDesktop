package numberpuzzlegame;


import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saost
 */
public class MyButton extends JButton{
    int dong;
    int cot;

    public MyButton(int dong, int cot, String text) {
        super(text);
        this.dong = dong;
        this.cot = cot;
    }
    
    
}
