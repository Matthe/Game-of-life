package gameoflife.Board;

import gameoflife.Cell.Cell;
import gameoflife.Settings;
import gameoflife.Cell.CellSquare;
import gameoflife.Cell.CellTriangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Matthe
 */

public abstract class Board{
    public Cell[][] cells;
    
    public abstract Boolean getCellAlive(int x, int y);
    
    public void createBoard(){
        cells = new Cell[Settings.boardWidth][Settings.boardHeight];
        
        for (int x = 0; x < Settings.boardWidth; x++) {
            for (int y = 0; y < Settings.boardHeight; y++) {
                if(Settings.cellShape == 0)
                    cells[x][y] = new CellSquare();
                
                if(Settings.cellShape == 1)
                    cells[x][y] = new CellTriangle();
            }
        }
    }
    
    public void calculateBoard() {
        for (int x = 0; x < Settings.boardWidth; x++) {
            for (int y = 0; y < Settings.boardHeight; y++) {
                cells[x][y].calculateNeighbours();
            }
        }
    }
    
    public void updateBoard(){
        for (int x = 0; x < Settings.boardWidth; x++) {
            for (int y = 0; y < Settings.boardHeight; y++) {
                cells[x][y].updateCell();
            }
        }
    }
    public void drawCells(){
        for (int x = 0; x < Settings.boardWidth; x++) {
            for (int y = 0; y < Settings.boardHeight; y++) {
                cells[x][y].draw(x, y);
            }
        }
    }
    

}
