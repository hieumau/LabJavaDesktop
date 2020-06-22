package numberpuzzlegame;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class NumberPanel extends JPanel {
    
    numberpuzzlegame.NumPad numPads[];
    int totalNumPads;
    int level;
    int moveCount = 0;
    boolean isCountingTime;
    public NumberPanel(int level) {
        numPads = new numberpuzzlegame.NumPad[level * level];
        int count = 0;
        for (int i = 0; i < level; i++){
            for (int j = 0; j < level; j++){
                numPads[count] = new numberpuzzlegame.NumPad(count + 1, count + 1, j, i);
                numPads[count].setBackground(Color.white);
                count++;
            }
        }
        totalNumPads = count;
        this.level = level;
        numPads[count - 1].setCorrectValue(0);
        numPads[count - 1].setCurrentValue(0);
        
        this.setLayout(new GridLayout(level, level, 10, 10));
        for (numberpuzzlegame.NumPad b: numPads){
            this.add(b);     
        }
        
        this.setSize(level*120, level*120);

        setSize(level*120, level*120);

        //them event vao cac MyButton
        for (NumPad numPad: numPads){
            numPad.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isCountingTime = true;
                    NumPad numPad = (NumPad) e.getSource();
                    int column = numPad.getColumn();
                    int row = numPad.getRow();
                    NumPad upNumPad = getNumPadByPosition(row - 1, column);
                    NumPad downNumPad = getNumPadByPosition(row + 1, column);
                    NumPad leftNumPad = getNumPadByPosition(row, column - 1);
                    NumPad rightNumPad = getNumPadByPosition(row, column + 1);

                    if (upNumPad != null){
                        if (upNumPad.getCurrentValue() == 0){
                            swapNumPadCurrentValue(numPad, upNumPad);
                            moveCount ++;
                        }
                    }
                    if (downNumPad != null){
                        if (downNumPad.getCurrentValue() == 0){
                            swapNumPadCurrentValue(numPad, downNumPad);
                            moveCount ++;
                        }
                    }
                    if (leftNumPad != null){
                        if (leftNumPad.getCurrentValue() == 0){
                            swapNumPadCurrentValue(numPad, leftNumPad);
                            moveCount ++;
                        }
                    }
                    if (rightNumPad != null){
                        if (rightNumPad.getCurrentValue() == 0){
                            swapNumPadCurrentValue(numPad, rightNumPad);
                            moveCount ++;
                        }
                    }

                    if (isWin()){
                        JOptionPane.showMessageDialog(null, "You win");
                    }
                }
            });
        }
    }

    public void creatNewGame(){
        moveCount = 0;
        int column;
        int row;
        int direction;
        NumPad numPad;

        NumPad upNumPad;
        NumPad downNumPad;
        NumPad leftNumPad;
        NumPad rightNumPad;

        for (JButton numpad :
                numPads) {
            numpad.setEnabled(true);
        }

        // Random new game
        for (int i = 0; i < level * 1; i++){
            numPad = getNumPadByCurrentValue(0);
            column = numPad.getColumn();
            row = numPad.getRow();
//            System.out.println("before: " + numPad.toString());

            upNumPad = getNumPadByPosition(row - 1, column);
            downNumPad = getNumPadByPosition(row + 1, column);
            leftNumPad = getNumPadByPosition(row, column - 1);
            rightNumPad = getNumPadByPosition(row, column + 1);
            Random random = new Random();
            direction = random.nextInt(4);
            switch (direction){
                case 0:
                    if (upNumPad != null){
                        swapNumPadCurrentValue(numPad, upNumPad);
                        System.out.print(direction + "-");
                        System.out.println(" [down] ");
//                        System.out.println(" [up] ");
//                        row = row - 1;
                    }
                    break;
                case 1:
                    if (downNumPad != null){
                        swapNumPadCurrentValue(numPad, downNumPad);
                        System.out.print(direction + "-");
                        System.out.println(" [up] ");
//                        System.out.println(" [down] ");
//                        row = row + 1;
                    }
                    break;
                case 2:
                    if (leftNumPad != null){
                        swapNumPadCurrentValue(numPad, leftNumPad);
                        System.out.print(direction + "-");
                        System.out.println(" [right] ");
//                        System.out.println(" [left]");
//                        column = column - 1;
                    }
                    break;
                case 3:
                    if (rightNumPad != null){
                        swapNumPadCurrentValue(numPad, rightNumPad);
                        System.out.print(direction + "-");
                        System.out.println(" [left]");
//                        System.out.println(" [right] ");
//                        column = column + 1;
                    }
                    break;
            }
//            numPad = getNumPadByCurrentValue(0);
//            System.out.println("after: " + numPad.toString());
//            System.out.println("");
        }

    }

    public boolean isWin(){
        for (NumPad numPad: numPads){
            if (!numPad.isInTheRightPlace()) return false;
        }
        for (JButton numpad :
                numPads) {
            numpad.setEnabled(false);
        }
        isCountingTime = false;
        return true;
    }
    public void swapNumPadCurrentValue(NumPad numPad1, NumPad numPad2){
        int temp = numPad1.getCurrentValue();
        numPad1.setCurrentValue(numPad2.getCurrentValue());
        numPad2.setCurrentValue(temp);
    }
    public NumPad getNumPadByPosition(int row, int column){
        NumPad numPad = new NumPad();
        for (NumPad temp: numPads){
            if (temp.getColumn() == column && temp.getRow() == row) return temp;
        }
        return null;
    }
    public NumPad getNumPadByCurrentValue(int currentValue){
        for (NumPad numPad:numPads) {
            if (numPad.getCurrentValue() == currentValue){
//                System.out.println(numPad.toString());
                return numPad;
            }
        }
        return null;
    }
    
}