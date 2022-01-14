//12/30/21
//The launch window which the user starts at and which will guide them through the different parts
// of the application

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class MainWindow extends JFrame implements ActionListener {
    
    //Declaring variables
    private JMenuBar menubar;
    private JMenuItem helpItem;
    private JButton fridgeButton;
    private JButton planningButton;
    private JButton recipeBookButton;
    private JButton dietAllergyButton;
    private JPanel buttonPanel;
    private Box[] rowBoxes;
    private ImageIcon fridgeIcon;
    private ImageIcon recipeBookIcon;
    private ImageIcon planningIcon;
    private ImageIcon dietAllergyIcon;

    //Initializing constants
    private final int WINDOW_X = 100;
    private final int WINDOW_Y = 100;
    private final int WINDOW_W = 500;
    private final int WINDOW_H = 500;

    //Constructor for window
    public MainWindow() {
        super("Main");

        //Initializing GUI componenets
        menubar = new JMenuBar();
        helpItem = new JMenuItem("Help");
        fridgeIcon = new ImageIcon(new ImageIcon("fridge.jpg").getImage().getScaledInstance(WINDOW_W / 3, WINDOW_H / 3, Image.SCALE_SMOOTH));
        fridgeButton = new JButton(fridgeIcon);
        planningIcon = new ImageIcon(new ImageIcon("planning.png").getImage().getScaledInstance(WINDOW_W / 3, WINDOW_H / 3, Image.SCALE_SMOOTH));
        planningButton = new JButton(planningIcon);
        recipeBookIcon = new ImageIcon(new ImageIcon("recipeBook.jpg").getImage().getScaledInstance(WINDOW_W / 3, WINDOW_H / 3, Image.SCALE_SMOOTH));
        recipeBookButton = new JButton(recipeBookIcon);
        dietAllergyIcon = new ImageIcon(new ImageIcon("dietAllergy.jpg").getImage().getScaledInstance(WINDOW_W / 3, WINDOW_H / 3, Image.SCALE_SMOOTH));
        dietAllergyButton = new JButton(dietAllergyIcon);
        buttonPanel = new JPanel();
        rowBoxes = new Box[2];

        //Adding action listeners to the components
        fridgeButton.addActionListener(this);
        planningButton.addActionListener(this);
        recipeBookButton.addActionListener(this);
        dietAllergyButton.addActionListener(this);
        helpItem.addActionListener(this);

        //Setting up the boxes
        rowBoxes[0] = Box.createHorizontalBox();
        rowBoxes[1] = Box.createHorizontalBox();

        //Adding the components to the boxes
        rowBoxes[0].add(fridgeButton);
        rowBoxes[0].add(planningButton);
        rowBoxes[1].add(recipeBookButton);
        rowBoxes[1].add(dietAllergyButton);

        //Adding the help to the menu
        menubar.add(helpItem);

        //Preparing the window
        this.setBounds(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Adding boxes to window
        buttonPanel.add(rowBoxes[0]);
        buttonPanel.add(rowBoxes[1]);

        //Putting menu on window
        this.setJMenuBar(menubar);

        //Adding the buttonPanel
        this.add(buttonPanel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(helpItem))
        {
            new HelpWindow("main");
        }
        else if(source.equals(fridgeButton))
        {
            new FridgeWindow();
        }
        else if (source.equals(planningButton))
        {
            new PlanningWindow();
        }
        else if (source.equals(recipeBookButton))
        {
            new RecipeBookWindow();
        }
        else if (source.equals(dietAllergyButton))
        {
            new DietAllergyWindow();
        }
    }
    
}
