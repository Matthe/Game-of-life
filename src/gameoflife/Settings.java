package gameoflife;

import gameoflife.Board.Board;
import gameoflife.Board.BoardSquare;
import gameoflife.Board.BoardSphere;
import gameoflife.Board.BoardCylinder;
import gameoflife.Board.BoardMobiusRing;
import gameoflife.Board.BoardTorus;

/**
 *
 * @author Matthe
 */


public class Settings {
    public static Board board;
    
    public static int boardWidth = 50;
    public static int boardHeight = 50;
    
    public static int cellSize = 15;    
    public static int cellType;
    public static int cellShape;
    
    public static void InitializeSettings(int cellType, int boardType, int cellShape){
        Settings.cellType = cellType;
        Settings.cellShape = cellShape;
        
        if(boardType == 0)
            board = new BoardSquare();
        
        if(boardType == 1)
            board = new BoardSphere();
        
        if(boardType == 2)
            board = new BoardCylinder();
        
        if(boardType == 3)
            board = new BoardMobiusRing();
        
        if(boardType == 4)
            board = new BoardTorus();
        
        board.createBoard();
    }
}
