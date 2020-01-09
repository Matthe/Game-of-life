package gameoflife;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Matthe
 */
public class GameOfLife extends Frame{
    
    public static Grid drawGrid;
    
    private static JButton startButton;
    private static JButton confirmButton;
    private static JComboBox boardChoice;
    private static JComboBox placementFigureChoice;
    private static JComboBox cellFigureChoice;
    private static JFrame frame = new JFrame();

    public static void main(String[] args) {

        
        Settings.InitializeSettings(0, 0, 0);
        createGameGrid(50, 50);
        
        frame.setSize(1250, 850);
        frame.setLocation(100, 100);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(drawGrid);
        addButtonsToFrame();
        addDropDownMenu();
        frame.setVisible(true);
    }
    
    private static void createGameGrid(int rows, int cols){
        GameOfLife.drawGrid = new Grid();
        drawGrid.addMouseListener(drawGrid.mouseListener);
        drawGrid.setBounds(10, 10, 850, 850);
    }
    
    public static void updateGameBoard(){
        Timer timer = new Timer(75, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Settings.board.calculateBoard();
                Settings.board.updateBoard();
                Settings.board.drawCells();
                drawGrid.repaint();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
    
    public static void addButtonsToFrame(){
        startButton = new JButton("Start Life");;
        startButton.setBounds(1015, 40, 150, 25);;
        
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGameBoard();
            }
        });
        
        confirmButton = new JButton("Set Gameboard");
        confirmButton.setBounds(1015, 5, 150, 25);
        
        confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.InitializeSettings(placementFigureChoice.getSelectedIndex(), boardChoice.getSelectedIndex(), cellFigureChoice.getSelectedIndex());
                drawGrid.repaint();
            }
        });
        
        frame.add(startButton);
        frame.add(confirmButton);
        
    }
    
    public static void addDropDownMenu(){
        String[] boardsSurfaces = { "Square board", "Sphere board", "Cylinder board", "Mobius ring board", "Torus board"};
        boardChoice = new JComboBox(boardsSurfaces);
        boardChoice.setSelectedItem(0);
        boardChoice.setBounds(875, 5, 125, 25);
        
        String[] placementFigures = { "Single figure",  "Square figure"};
        placementFigureChoice = new JComboBox(placementFigures);
        placementFigureChoice.setSelectedItem(0);
        placementFigureChoice.setBounds(875, 40, 125, 25);
        
        String[] cellFigures = { "Square cell figure", "Triangle square figure", "Hexagon cell figure"};
        cellFigureChoice = new JComboBox(cellFigures);
        cellFigureChoice.setBounds(875, 75, 125, 25);
        
        frame.add(boardChoice);
        frame.add(placementFigureChoice);
        frame.add(cellFigureChoice);
    }
}
