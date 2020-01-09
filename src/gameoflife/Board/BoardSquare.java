
package gameoflife.Board;

import gameoflife.Settings;

/**
 *
 * @author Matthe
 */
public class BoardSquare extends Board{

    @Override
    public Boolean getCellAlive(int x, int y) {
        if(x > 0 && x <= Settings.boardWidth - 1 && y > 0 && y <= Settings.boardHeight - 1){
            return cells[x][y].getStatus();
        }
        return false;
    }
}
