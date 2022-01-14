// 1/4/21
// Helps the user plan meals

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.GridLayout;

public class PlanningWindow extends JFrame implements ActionListener{

        //Declaring GUI components
        private JPanel planningPanel;
        private JPanel dietPanel;
        private JPanel allergyPanel;
        private JPanel dietAllergyPanel;
        private JPanel pagePanel;
        private GridLayout pageLayout;
        private JLabel planLabel;
        private JButton mealPlanButton;
        private JButton dayPlanButton;
        private JButton weekPlanButton;
        private JLabel dietLabel;
        private JComboBox<String> dietDropDown;
        private JLabel allergyLabel;
        private JComboBox<String> allergyDropDown;

        //Declaring constants
        private final int WINDOW_X = 100;
        private final int WINDOW_Y = 100;
        private final int WINDOW_W = 500;
        private final int WINDOW_H = 600;

        public PlanningWindow() {
            //Initializing variables
            planningPanel = new JPanel(new GridLayout(4,0));
            dietPanel = new JPanel(new GridLayout(2,0));
            allergyPanel = new JPanel(new GridLayout(2,0));
            dietAllergyPanel = new JPanel(new GridLayout(4,0));
            pageLayout = new GridLayout(0,2);
            pagePanel = new JPanel();
            planLabel = new JLabel("Plan For: ", SwingConstants.LEFT);
            mealPlanButton = new JButton("One Meal");
            dayPlanButton = new JButton("One Day");
            weekPlanButton = new JButton("One Week");
            dietLabel = new JLabel("Diet: ");
            dietDropDown = new JComboBox<String>();
            allergyLabel = new JLabel("Allergy: ");
            allergyDropDown = new JComboBox<String>();


            //Adding action liosteners
            mealPlanButton.addActionListener(this);
            dayPlanButton.addActionListener(this);
            weekPlanButton.addActionListener(this);

            //Preparing layouts
            pageLayout.setHgap(50);

            //Adding to planning panel
            planningPanel.add(planLabel);
            planningPanel.add(mealPlanButton);
            planningPanel.add(dayPlanButton);
            planningPanel.add(weekPlanButton);

            //Adding to diet panel
            dietPanel.add(dietLabel);
            dietPanel.add(dietDropDown);

            //Adding to allergy panel
            allergyPanel.add(allergyLabel);
            allergyPanel.add(allergyDropDown);

            //Adding to dietAllergy panel
            dietAllergyPanel.add(Box.createVerticalStrut(100));
            dietAllergyPanel.add(dietPanel);
            dietAllergyPanel.add(allergyPanel);
            dietAllergyPanel.add(Box.createVerticalStrut(100));

            //Preparing page panel
            pagePanel.setLayout(pageLayout);

            //Adding to page panel
            pagePanel.add(planningPanel);
            pagePanel.add(dietAllergyPanel);

            //Setting up window
            this.setBounds(WINDOW_X, WINDOW_Y, WINDOW_W, WINDOW_H);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            //Adding to window
            this.add(pagePanel);

            this.setVisible(true);

        }

    public static void main(String[] args)
    {
        new PlanningWindow();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        
    }
    
}
