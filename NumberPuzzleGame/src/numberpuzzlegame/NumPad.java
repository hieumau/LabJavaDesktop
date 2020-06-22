package numberpuzzlegame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author saost
 */
public class NumPad extends JButton{
    private int correctValue;
    private int currentValue;
    private int column;
    private int row;
    public NumPad() {
        this.correctValue = 0;
        this.currentValue = 0;
        this.column = 0;
        this.row = 0;
    }

    public NumPad(int correctValue, int currentValue, int column, int row) {
        if (currentValue != 0){
//            this.setText(currentValue + "" + "[" + row +", " + column+ "]");
            this.setText(currentValue + "");

        }
//        this.setText(currentValue + " test");
        this.correctValue = correctValue;
        this.currentValue = currentValue;
        this.column = column;
        this.row = row;
        this.setFont(new Font("SansSerif", Font.BOLD, 18));
    }

    public int getCorrectValue() {
        return correctValue;
    }

    public void setCorrectValue(int correctValue) {
        this.correctValue = correctValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        if (currentValue == 0) {
            this.setText("");
        } else {
//            this.setText(currentValue + "");
//            this.setText(currentValue + "" + "[" + row +", " + column+ "]");
            this.setText(currentValue + "");

        }
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isInTheRightPlace(){
        if (currentValue == correctValue) return true;
        return false;
    }

    public boolean isEmptyNumPad(){
        if (currentValue == 0) return true;
        return false;
    }

    @Override
    public String toString() {
        return "NumPad{" +
                "correctValue=" + correctValue +
                ", currentValue=" + currentValue +
                ", row=" + row +
                ", column=" + column +
                '}';
    }
}
