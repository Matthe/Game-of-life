package gameoflife.Board;

import gameoflife.Settings;

/**
 *
 * @author Matthe
 */
public class BoardSphere extends Board {

    @Override
    public Boolean getCellAlive(int x, int y) {
        try{
            if(x < 0)
                return cells[Settings.boardWidth - 1][Settings.boardHeight - 1 - y].getStatus();
            if(y < 0)
                return cells[Settings.boardWidth - 1 - x][Settings.boardHeight - 1].getStatus();
            if(x > Settings.boardWidth - 1)
                return cells[0][Settings.boardHeight - 1 - y].getStatus();
            if(y > Settings.boardHeight - 1)
                return cells[Settings.boardWidth - 1 - x][0].getStatus();
            
            return cells[x][y].getStatus();
            }
        
        catch(Exception e){
            return false;
        }
    }
}
