import java.io.*;
import java.awt.*;
import javax.swing.*;

public class LoginGUI extends Colour implements Serializable
{
    Admin a = new Admin(); // New instance of admin
    static JTextField user = new JTextField();
    static JTextField pin = new JTextField();
    static JLabel userLabel = new JLabel("User", SwingConstants.RIGHT);
    static JLabel pinLabel = new JLabel("Pin", SwingConstants.RIGHT);
    static JPanel panelOne = new JPanel(new GridLayout(0, 1, 2, 2));
    JPanel panelTwo = new JPanel(new BorderLayout(5, 5));
    static JPanel panelThree = new JPanel(new GridLayout(0, 1, 2, 2));

    public LoginGUI()
    {
        loadUsers(); // Users are loaded in
        for (User i : classList) // For each loop
        {
            a.Sebas.addItem(i.name); // Drop down list is populated with "User" objects
        }
        panelOne.add(userLabel);
        panelOne.add(pinLabel);
        panelTwo.add(panelOne, BorderLayout.WEST);
        panelThree.add(user);
        panelThree.add(pin);
        panelTwo.add(panelThree, BorderLayout.CENTER);
        int result = JOptionPane.showConfirmDialog(null, panelTwo, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == 0) //Ok button was pressed
        {
            if (user.getText().equals(a.user) && pin.getText().equals(a.pin)) //Checks if input matches with admin credentials
            {
                JOptionPane.showMessageDialog(null, "Welcome Admin."); // Welcome message
                a.AdminGUI(); // Call statement to Admin Menu
                System.exit(0); //Ends program
            }
            else
            {
                for (User i : classList)
                {
                    if (user.getText().equals(i.user) && pin.getText().equals(i.pin))
                    {
                        JOptionPane.showMessageDialog(null, "Welcome " + i.name + "."); // Welcome message for user using their name
                        loadColor(); // Loads the colors of specific user
                        new PaintGUI(); //opens CS Paint
                    }
                    /*else if (!user.getText().equals(i.user) || !pin.getText().equals(i.pin))
                    {
                        JOptionPane.showMessageDialog(null, "This login does not exist.");
                        //new LoginGUI();
                        System.exit(0);
                    }*/
                }
            }
        }
        else
        {
            System.exit(0); // Ends program
        }
    }

}
