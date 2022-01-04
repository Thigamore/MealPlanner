// Thomas Lascaud
// 1/2/22
// Adds data to the database depending on what the user wants to add

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddWindow extends JFrame implements ActionListener{

    //Declaaring GUI components
    private JMenuBar menubar;
    private JMenuItem helpItem;
    private JLabel addLabel;
    private JLabel nameLabel;
    private Box nameBox;
    private JTextField nameField;
    private JLabel[] titleLabels;
    private JTable[] dbTables;
    private JScrollPane[] scrollPanes;
    private JButton[] addButtons;
    private Box mainInfoBox;
    private Box[] scrollBoxes;
    private Box mainAddBox;

    //Declaring constants
    private final int WINDOW_X = 100;
    private final int WINDOW_Y = 100;
    private final int WINDOW_W = 600;
    private final int WINDOW_H = 550;

    public AddWindow(String windowName)
    {
        super("Add " + windowName.toUpperCase());
        if(windowName.equals("fridge"))
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
        nameBox = Box.createHorizontalBox();
        titleLabels = new JLabel[1];
        titleLabels[0] = new JLabel("Nutritional Information");
        scrollPanes = new JScrollPane[1];
        scrollPanes[0] = new JScrollPane();
        dbTables = new JTable[1];
        dbTables[0] = new JTable();
        menubar = new JMenuBar();
        helpItem = new JMenuItem("Help");
        scrollBoxes = new Box[1];
        scrollBoxes[0] = Box.createVerticalBox();
        mainInfoBox = Box.createHorizontalBox();
        addButtons = new JButton[1];
        addButtons[0] = new JButton("Add");
        mainAddBox = Box.createVerticalBox();
        
        //Adding action listeners
        helpItem.addActionListener(this);
        addButtons[0].addActionListener(this);

        //Preparing a label
        addLabel.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0), addLabel.getBorder()));

        //Preparing nameBox
        nameBox.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0), nameBox.getBorder()));

        //Preparing scroll pane
        scrollPanes[0].setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scrollPanes[0].getBorder()));
        scrollPanes[0].getViewport().add(dbTables[0]);

        //Adding to menubar
        menubar.add(helpItem);

        //Adding to nameBox
        nameBox.add(nameLabel);
        nameBox.add(nameField);

        //Adding to scrollBox
        scrollBoxes[0].add(titleLabels[0]);
        scrollBoxes[0].add(scrollPanes[0]);
        scrollBoxes[0].add(addButtons[0]);

        //Adding to mainInfoBox
        mainInfoBox.add(scrollBoxes[0]);

        //Adding to mainAddBox
        mainAddBox.add(addLabel);
        mainAddBox.add(nameBox);
        mainAddBox.add(mainInfoBox);

        //Preparing window
        this.setBounds(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Adding to window
        this.add(mainAddBox);

        //Adding menubar
        this.setJMenuBar(menubar);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AddWindow("fridge");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
