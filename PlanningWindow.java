// Thomas Lascaud
// 1/4/21
// Helps the user plan meals

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanningWindow extends JFrame implements ActionListener{

        //Declaring GUI components
        private Box planningBox;
        private Box dietBox;
        private Box allergyBox;
        private Box dietAllergyBox;
        private Box pageBox;
        private JLabel planLabel;
        private JButton mealPlanButton;
        private JButton dayPlanButton;
        private JButton weekPlanButton;
        private JLabel dietLabel;
        private JComboBox dietDropDown;
        private JLabel allergyLabel;
        private JComboBox allergyDropDown;

        //Declaring constants
        private final int WINDOW_X = 100;
        private final int WINDOW_Y = 100;
        private final int WINDOW_W = 500;
        private final int WINDOW_H = 600;

        public PlanningWindow() {
            //Initializing variables
            planningBox = Box.createVerticalBox();
            allergyBox = Box.createVerticalBox();
            dietBox = Box.createVerticalBox();
            dietAllergyBox = Box.createVerticalBox();
            pageBox = Box.createHorizontalBox();
            planLabel = new JLabel("Plan For: ");
            mealPlanButton = new JButton("One Meal");
            dayPlanButton = new JButton("One Day");
            weekPlanButton = new JButton("One Week");
            dietLabel = new JLabel("Diet: ");
            dietDropDown = new JComboBox();
            allergyLabel = new JLabel("Allergy: ");
            allergyDropDown = new JComboBox();

            
        }

    public static void main(String[] args)
    {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
