package gameoflife.Cell;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Matthe
 */

public abstract class Cell {
    
    protected Boolean alive = false;
    protected Boolean nextGenStatus = false;

    public abstract void calculateNeighbours();
    public abstract void draw(int x, int y );
    
    public void setCell(Boolean alive){
        this.alive = alive;
    }
    
    public void updateCell(){
        alive = nextGenStatus;
    }
    
    public Boolean getStatus()
    {
        return alive;
    }
}
