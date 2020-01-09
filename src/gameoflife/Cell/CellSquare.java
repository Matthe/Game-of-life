
package gameoflife.Cell;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import gameoflife.Board.Board;
import gameoflife.Grid;
import gameoflife.Settings;

/**
 *
 * @author Matthe
 */
public class CellSquare extends Cell {
    private int xCoord;
    private int yCoord;
    private int neightbourCount;
    
   
    @Override
    public void draw(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        
        int X = x * Settings.cellSize;
        int Y = y * Settings.cellSize;
        
        if(alive){
            Grid.graphics.setColor(Color.green);
        }
        else{
            Grid.graphics.setColor(Color.red);
        }
        
        Rectangle2D.Double rect = new Rectangle2D.Double(X, Y, Settings.cellSize, Settings.cellSize);
        
        Grid.graphics.fill(rect);
        Grid.graphics.setColor(Color.black);
        Grid.graphics.draw(rect);
    }

    @Override
    public void calculateNeighbours() {
        neightbourCount = 0;
        
        if(Settings.board.getCellAlive(xCoord - 1, yCoord - 1))
            neightbourCount++;
        if(Settings.board.getCellAlive(xCoord, yCoord - 1))
            neightbourCount++;
        if(Settings.board.getCellAlive(xCoord + 1, yCoord - 1))
            neightbourCount++;
        if(Settings.board.getCellAlive(xCoord + 1, yCoord))
            neightbourCount++;
        if(Settings.board.getCellAlive(xCoord + 1, yCoord + 1))
            neightbourCount++;
        if(Settings.board.getCellAlive(xCoord, yCoord + 1))
            neightbourCount++;
        if(Settings.board.getCellAlive(xCoord - 1, yCoord + 1))
            neightbourCount++;
        if(Settings.board.getCellAlive(xCoord - 1, yCoord))
            neightbourCount++;
        
        if(neightbourCount == 3)
            nextGenStatus = true;
        if((neightbourCount == 3 || neightbourCount == 2) && alive)
            nextGenStatus = true;
        if(neightbourCount > 3 || neightbourCount < 2)
            nextGenStatus = false;
    }
    
}
