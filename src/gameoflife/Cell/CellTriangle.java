package gameoflife.Cell;

import gameoflife.Grid;
import gameoflife.Settings;
import java.awt.Color;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Matthe
 */
public class CellTriangle extends Cell {
    
    private int neightbourCount;
    private int xCoord;
    private int yCoord;
    
    @Override
    public void calculateNeighbours() {
        neightbourCount = 0;
        
        if ((xCoord % 2 == 0 && yCoord % 2 == 0) ||(xCoord % 2 == 1 && yCoord % 2 == 1)){
            if(Settings.board.getCellAlive(xCoord - 1, yCoord - 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord, yCoord - 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 1, yCoord - 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 2, yCoord - 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 2, yCoord))
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
            if(Settings.board.getCellAlive(xCoord - 2, yCoord))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord - 2, yCoord - 1))
                neightbourCount++;
        }
        else{
            if(Settings.board.getCellAlive(xCoord - 1, yCoord - 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord, yCoord - 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 1, yCoord - 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 2, yCoord + 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 2, yCoord))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 1, yCoord))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord + 1, yCoord + 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord, yCoord + 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord - 1, yCoord + 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord - 2, yCoord + 1))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord - 2, yCoord))
                neightbourCount++;
            if(Settings.board.getCellAlive(xCoord - 1, yCoord - 1))
                neightbourCount++;
        }
        
        if(neightbourCount == 4)
            nextGenStatus = true;
        if((neightbourCount >= 3 || neightbourCount <= 5) && alive)
            nextGenStatus = true;
        if(neightbourCount < 3 || neightbourCount > 5)
            nextGenStatus = false;
    }

    @Override
    public void draw(int x, int y) {
        Path2D.Double path = new Path2D.Double();
        
        this.xCoord = x;
        this.yCoord = y;
        
        int X = xCoord * Settings.cellSize;
        int Y = yCoord * Settings.cellSize;
        
        if ((X / Settings.cellSize % 2 == 0 && Y / Settings.cellSize % 2 == 0)||
                (X / Settings.cellSize % 2 == 1 && Y / Settings.cellSize % 2 == 1)){
            path.moveTo(X - (Settings.cellSize / 2), Y);
            path.lineTo(X + (Settings.cellSize / 2), Y + Settings.cellSize);
            path.lineTo(X + (Settings.cellSize / 2) * 3, Y);
            path.lineTo(X - (Settings.cellSize / 2), Y); 
        }
        else{
            path.moveTo(X - (Settings.cellSize / 2), Y + Settings.cellSize);
            path.lineTo(X + (Settings.cellSize / 2), Y);
            path.lineTo(X + (Settings.cellSize / 2) * 3, Y + Settings.cellSize);
            path.lineTo(X - (Settings.cellSize / 2), Y + Settings.cellSize); 
        }
        
        if(alive){
            Grid.graphics.setColor(Color.green);
        }
        else{
            Grid.graphics.setColor(Color.red);
        }
        
        Grid.graphics.fill(path);
        Grid.graphics.setColor(Color.black);
        Grid.graphics.draw(path);
    }
}
