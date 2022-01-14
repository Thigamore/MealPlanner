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
import java.awt.Dimension;


public class AddWindow extends JFrame implements ActionListener{

    //Declaring GUI components
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
    private Box buttonBox;

    //Declaring extra variable
    private String type;

    //Declaring constants
    private final int WINDOW_X = 100;
    private final int WINDOW_Y = 100;
    private final int WINDOW_W = 600;
    private final int WINDOW_H = 550;

    public AddWindow(String purpose)
    {
        super("Add " + purpose.toUpperCase());
        if(purpose.equals("ingredient"))
        {
            setupIngredient();
        }
        else if(purpose.equals("recipe"))
        {
            setupRecipe();
        }
        else if(purpose.equals("diet"))
        {
            setupDiet();
        }
        else if(purpose.equals("allergy"))
        {
            setupAllergy();
        }
    }

    //Sets up an add class for a recipe
    private void setupRecipe() {
        //Initializing variables
        type = "recipe";
        addLabel = new JLabel("Add Recipe");
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(20);
        nameBox = Box.createHorizontalBox();
        titleLabels = new JLabel[2];
        titleLabels[0] = new JLabel("Steps");
        titleLabels[1] = new JLabel("Ingredients");
        scrollPanes = new JScrollPane[2];
        scrollPanes[0] = new JScrollPane();
        scrollPanes[1] = new JScrollPane();
        dbTables = new JTable[2];
        dbTables[0] = new JTable();
        dbTables[1] = new JTable();
        menubar = new JMenuBar();
        helpItem = new JMenuItem("Help");
        scrollBoxes = new Box[2];
        scrollBoxes[0] = Box.createVerticalBox();
        scrollBoxes[1] = Box.createVerticalBox();
        mainInfoBox = Box.createHorizontalBox();
        addButtons = new JButton[2];
        addButtons[0] = new JButton("Add Step");
        addButtons[1] = new JButton("Add Recipe");
        mainAddBox = Box.createVerticalBox();
        buttonBox = Box.createHorizontalBox();

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
        scrollPanes[1].setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), scrollPanes[1].getBorder()));
        scrollPanes[1].getViewport().add(dbTables[1]);
        scrollPanes[1].setMaximumSize(new Dimension(400,500));

        //Adding to menubar
        menubar.add(helpItem);
        
        //Adding to nameBox
        nameBox.add(nameLabel);
        nameBox.add(nameField);

        //Adding to button box
        buttonBox.add(addButtons[0]);
        buttonBox.add(addButtons[1]);

        //Adding to scrollBox[0]
        scrollBoxes[0].add(titleLabels[0]);
        scrollBoxes[0].add(scrollPanes[0]);
        scrollBoxes[0].add(buttonBox);

        //Adding to scrollBox[1]
        scrollBoxes[1].add(titleLabels[1]);
        scrollBoxes[1].add(scrollPanes[1]);

        //Adding to mainInfoBox
        mainInfoBox.add(scrollBoxes[0]);
        mainInfoBox.add(scrollBoxes[1]);

        //Adding to mainAddBox
        mainAddBox.add(addLabel);
        mainAddBox.add(nameBox);
        mainAddBox.add(mainInfoBox);

        //Preparing window
        this.setBounds(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Adding to window
        this.add(mainAddBox);

        //Adding menubar
        this.setJMenuBar(menubar);

        this.setVisible(true);
    }

    //Sets up an add class for an allergy
    private void setupAllergy() {
        //Initializing GUI components
        type = "allergy";
        addLabel = new JLabel("Add Allergy");
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(20);
        nameBox = Box.createHorizontalBox();
        titleLabels = new JLabel[1];
        titleLabels[0] = new JLabel("Restricting Information");
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Adding to window
        this.add(mainAddBox);

        //Adding menubar
        this.setJMenuBar(menubar);

        this.setVisible(true);
    }

    //Sets up an add class for a diet
    private void setupDiet() {
        //Initializing GUI components
        type = "diet";
        addLabel = new JLabel("Add Diet");
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(20);
        nameBox = Box.createHorizontalBox();
        titleLabels = new JLabel[1];
        titleLabels[0] = new JLabel("Restricting Information");
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Adding to window
        this.add(mainAddBox);

        //Adding menubar
        this.setJMenuBar(menubar);

        this.setVisible(true);
    }

    //Sets up a diet add window
    //Sets up an add class for an ingredient
    private void setupIngredient() {
        //Initializing GUI components
        type = "ingredient";
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Adding to window
        this.add(mainAddBox);

    

        //Adding menubar
        this.setJMenuBar(menubar);

        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new AddWindow("recipe");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(helpItem))
        {
            new HelpWindow("add"+type);
        }
        for (int i = 0; i < addButtons.length; i++)
        {
            if (addButtons[i].equals(source)) 
            {
                if(type.equals("ingredient"))
                {
                    
                } 
                else if(type.equals("recipe"))
                {

                }
                else if(type.equals("diet"))
                {

                }
                else if(type.equals("allergy"))
                {

                }
            }
        }
        
    }
}
