//Thomas Lascaud
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

public class DietAllergyWindow extends JFrame implements ActionListener{
    
    //Declaring GUI components
    private JMenuBar menubar;
    private JMenuItem helpItem;
    private JLabel dietAllergyLabel;
    private JTable dbTable;
    private JScrollPane scrollPane;
    private JPanel dietAllergyPanel;
    private JButton addButton;
    private Box scrollAddBox;

    //Declaring constants
    private final int WINDOW_X = 100;
    private final int WINDOW_Y = 100;
    private final int WINDOW_W = 600;
    private final int WINDOW_H = 550;

    public DietAllergyWindow() {
        super("Diets and Allergies");

        //Initializing components
        menubar = new JMenuBar();
        helpItem = new JMenuItem("Help");
        dietAllergyLabel = new JLabel("Diets and Allergies");
        dbTable = new JTable();
        scrollPane = new JScrollPane();
        dietAllergyPanel = new JPanel();
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

        //Preparing box
        scrollAddBox.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scrollAddBox.getBorder()));

        //Adding to box
        scrollAddBox.add(scrollPane);
        scrollAddBox.add(addButton);

        //Adding to panel
        dietAllergyPanel.add(dietAllergyLabel);
        dietAllergyPanel.add(scrollAddBox);

        //Preparing Window
        this.setBounds(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Adding to window
        this.add(dietAllergyPanel);

        //Adding menubar
        this.setJMenuBar(menubar);

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new DietAllergyWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(helpItem))
        {
            new HelpWindow();
        }
        else if (source.equals(addButton))
        {

        }
    }
}
