// Thomas Lascaud
// 1/2/22
// Adds data to the database depending on what the user wants to add

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddWindow extends JFrame implements ActionListener{

    //Declaaring GUI components
    private JMenuBar menubar;
    private JMenuItem helpItem;
    private JLabel addLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel[] titleLabels;
    private JTable[] dbTables;
    private JScrollPane[] scrollPanes;
    private JButton[] addButtons;

    //Declaring constants
    private final int WINDOW_X = 100;
    private final int WINDOW_Y = 100;
    private final int WINDOW_W = 600;
    private final int WINDOW_H = 550;

    public AddWindow(String windowName)
    {
        super("Add " + windowName.toUpperCase());
        if(windowName.equals("frdige"))
        {
            setupFridge();
        }
    }

    //Sets up an add class for the fridge
    private void setupFridge() {
        //Initializing GUI components
        addLabel = new JLabel("Add Ingredient");
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(20);
        titleLabels[0] = new JLabel("Nutritional Information");
        scrollPanes[0] = new JScrollPane();
        dbTables[0] = new JTable();
        menubar = new JMenuBar();
        helpItem = new JMenuItem("Help");
        
        //Adding action listeners
        helpItem.addActionListener(this);
        addButtons[0].addActionListener(this);

        //Preparing 
        
    }

    public static void main(String[] args) {
        new AddWindow("fridge");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
