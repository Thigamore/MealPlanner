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
    private JButton addDietButton;
    private JButton addAllergyButton;
    private Box scrollAddBox;
    private Box buttonBox;

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
        addDietButton = new JButton("Add Diet");
        addAllergyButton = new JButton("Add Allergy");
        buttonBox = Box.createVerticalBox();

        //Adding action listeners to componenets
        helpItem.addActionListener(this);
        addDietButton.addActionListener(this);
        addAllergyButton.addActionListener(this);

        //Adding to menubar
        menubar.add(helpItem);

        //Preparing scrollPane
        scrollPane.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scrollPane.getBorder()));
        scrollPane.getViewport().add(dbTable);

        //Preparing box
        scrollAddBox.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scrollAddBox.getBorder()));

        //Adding to button box
        buttonBox.add(addDietButton);
        buttonBox.add(addAllergyButton);

        //Adding to box
        scrollAddBox.add(scrollPane);
        scrollAddBox.add(buttonBox);

        //Adding to panel
        dietAllergyPanel.add(dietAllergyLabel);
        dietAllergyPanel.add(scrollAddBox);

        //Preparing Window
        this.setBounds(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
            new HelpWindow("dietAllergy");
        }
        else if (source.equals(addDietButton)) {
            new AddWindow("diet");
        }
        else if (source.equals(addAllergyButton))
        {
            new AddWindow("allergy");
        }
    }
}
