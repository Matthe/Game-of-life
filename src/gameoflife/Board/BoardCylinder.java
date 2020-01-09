package gameoflife.Board;

import gameoflife.Settings;

/**
 *
 * @author Matthe
 */
public class BoardCylinder extends Board{

    @Override
    public Boolean getCellAlive(int x, int y) {
        try{
            if(x < 0)
                return cells[Settings.boardWidth - 1][y].getStatus();
            if(x > Settings.boardWidth - 1)
                return cells[0][y].getStatus();
            
            return cells[x][y].getStatus();
        }
        catch(Exception e){
            return false;
        }
    }
}
