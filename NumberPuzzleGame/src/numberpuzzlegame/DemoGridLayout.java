package numberpuzzlegame;


import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saost
 */
public class DemoGridLayout extends JFrame{
    MyButton [] arr;
    

    public DemoGridLayout(int max){
        arr = new MyButton[max * max];
        int count = 0;
        for (int i = 0; i < max; i++){
            for (int j = 0; j < max; j++){
                arr[count] = new MyButton(i, j, "" + count);
                arr[count].setBackground(Color.white);
                count++;
            }
        }
        arr[0].setBackground(Color.red);
        arr[0].setForeground(Color.white);      
        JPanel p = (JPanel) this.getContentPane();
        p.setLayout(new GridLayout(max, max));
        for (MyButton b: arr){
            p.add(b);
        }
        setSize(max*120, max*120);

        //them event vao cac MyButton
        for (MyButton myButton: arr){
            myButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                  
                    swap(myButton);
                    if (isWinYet(max)){
                        JOptionPane.showMessageDialog(null, "You win");
                        Window win = SwingUtilities.getWindowAncestor(p);
                        win.dispose();
//                        p.setVisible(false);
                    }
                }
            });
        }
    }
    
    public void swap(MyButton b){
        // check B co phai hop le
        MyButton zeroButton = null;
        for (MyButton myButton: arr){
            if (myButton.getText().equals("0")) zeroButton = myButton;
        }
        if (zeroButton.dong == b.dong || zeroButton.cot == b.cot){
            if (zeroButton.dong == b.dong + 1 || zeroButton.cot == b.cot + 1 || zeroButton.dong == b.dong - 1 || zeroButton.cot == b.cot - 1){
                String temp = b.getText();
                b.setText(zeroButton.getText());
                zeroButton.setText(temp);
                b.setBackground(Color.red);
                b.setForeground(Color.WHITE);
                zeroButton.setBackground(Color.WHITE);
                zeroButton.setForeground(Color.BLACK);
            }            
        }
    }
    public boolean isWinYet(int max){
        MyButton zeroButton = null;
        for (MyButton myButton: arr){
            if (myButton.getText().equals("0")) zeroButton = myButton;
        }
        if (zeroButton.dong == max - 1 && zeroButton.cot == max - 1){
            return true;
        }
        return false;
    }
    
    public static void creatNewGame(){
        CreatNewGameActivity startGame = new CreatNewGameActivity();
        startGame.setVisible(true);
    }
    
   
    public static void main(String[] args) {
        creatNewGame();
    }
    
    
}
