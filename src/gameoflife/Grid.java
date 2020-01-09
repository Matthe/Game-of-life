package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Matthe
 */
public class Grid extends JPanel{
    
    private int columnCount;
    private int rowCount;
    private Point selectedCell;
    
    private int cellWidth = 15;
    private int cellHeight = 15;
    
    public static Graphics2D graphics;
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        graphics = (Graphics2D) g;
        
        graphics.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        Settings.board.drawCells();
    }
    
    public MouseListener mouseListener = new MouseAdapter(){
        @Override
        public void mousePressed(MouseEvent e){
            Point p = e.getPoint();
            
            int X = (p.x - p.x % Settings.cellSize) / Settings.cellSize;
            int Y = (p.y - p.y % Settings.cellSize) / Settings.cellSize;
            
            if(Settings.cellType == 0)            
                Settings.board.cells[X][Y].setCell(Boolean.TRUE);
            
            if(Settings.cellType == 1 && X + 1 <= Settings.boardWidth - 1 && Y + 1 <= Settings.boardHeight - 1){
                Settings.board.cells[X][Y].setCell(Boolean.TRUE);
                Settings.board.cells[X + 1][Y].setCell(Boolean.TRUE);
                Settings.board.cells[X + 1][Y + 1].setCell(Boolean.TRUE);
                Settings.board.cells[X][Y + 1].setCell(Boolean.TRUE);
            }
            
            repaint();
            
            System.out.println(X + "," + Y);
        }
    };
}
