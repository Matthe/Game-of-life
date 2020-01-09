
package gameoflife.Board;

import gameoflife.Settings;

/**
 *
 * @author Matthe
 */
public class BoardTorus extends Board {

    @Override
    public Boolean getCellAlive(int x, int y) {
        try{
            if(x < 0)
                return cells[Settings.boardWidth - 1][y].getStatus();
            if(x > Settings.boardWidth - 1)
                return cells[0][y].getStatus();
            if(y < 0)
                return cells[x][Settings.boardHeight - 1].getStatus();
            if(y > Settings.boardHeight - 1)
                return cells[x][0].getStatus();
            
            return cells[x][y].getStatus();
        }
        catch(Exception e){
            return false;
        }
    }
}
