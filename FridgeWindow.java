//12/30/21
//Allows the user to see different ingredients in database and add ingredients

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FridgeWindow extends JFrame implements ActionListener{
    
    //Declaring GUI components
    private JMenuBar menubar;
    private JMenuItem helpItem;
    private JLabel fridgeLabel;
    private JTable dbTable;
    private JScrollPane scrollPane;
    private JPanel fridgePanel;
    private JButton addButton;
    private Box scrollAddBox;

    //Declaring constants
    private final int WINDOW_X = 100;
    private final int WINDOW_Y = 100;
    private final int WINDOW_W = 600;
    private final int WINDOW_H = 550;

    public FridgeWindow() {
        super("Fridge");

        //Initializing components
        menubar = new JMenuBar();
        helpItem = new JMenuItem("Help");
        fridgeLabel = new JLabel("Fridge");
        dbTable = new JTable();
        scrollPane = new JScrollPane();
        fridgePanel = new JPanel();
        scrollAddBox = Box.createHorizontalBox();
        addButton = new JButton("Add");

        //Adding action listeners to componenets
        helpItem.addActionListener(this);
        addButton.addActionListener(this);

        //Adding to menubar
        menubar.add(helpItem);

        //Preparing scrollPane
        scrollPane.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scrollPane.getBorder()));
        scrollPane.getViewport().add(dbTable);

        //Preaparing box
        scrollAddBox.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scrollAddBox.getBorder()));

        //Adding to box
        scrollAddBox.add(scrollPane);
        scrollAddBox.add(addButton);

        //Adding to panel
        fridgePanel.add(fridgeLabel);
        fridgePanel.add(scrollAddBox);

        //Preparing Window
        this.setBounds(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Adding to window
        this.add(fridgePanel);

        //Adding menubar
        this.setJMenuBar(menubar);

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new FridgeWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(helpItem))
        {
            new HelpWindow("fridge");
        }
        else if (source.equals(addButton))
        {
            new AddWindow("ingredient");
        }
    }
}
