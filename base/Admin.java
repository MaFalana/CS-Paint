import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Admin extends User implements Serializable, ActionListener
{
    JPanel panelOne = new JPanel(new GridLayout(0, 1, 2, 2));
    JPanel panelTwo = new JPanel(new BorderLayout(5, 5));
    JComboBox Sebas = new JComboBox(); // Combobox that holds names of available users

    JPanel panelLabel = new JPanel(new GridLayout(0, 1, 2, 2)); // panel that holds the labels
    JPanel panelGUI = new JPanel(new BorderLayout(5, 5));
    JPanel panelLog = new JPanel(new GridLayout(0, 1, 2, 2)); // panel that holds the login textfields (user and pin)
    JPanel panelAdmin = new JPanel(new GridLayout(0, 1, 2, 2)); //panel for the Admin menu

    static JTextField name = new JTextField(); // textfield for the user's actual name
    JLabel nameLabel = new JLabel("Name", SwingConstants.RIGHT); // label for name

    JButton alpha = new JButton("Add");  // Button for add users method
    JButton beta = new JButton("Delete"); // Button for delete users method
    JButton omega = new JButton("Back"); // Button to take user back to Login screen

    public Admin()
    {
        user = "00000";
        pin = "12345";
        loadUsers(); // Call statement for method to load all users
        Sebas.addActionListener(this);
        alpha.addActionListener(this);
        beta.addActionListener(this);
        omega.addActionListener(this);
    }

    public void DeleteUserGUI() // Method for admin to delete a user on a GUI
    {
        panelOne.add(Sebas); // Combobox is added to GUI
        panelTwo.add(panelOne,BorderLayout.CENTER);
        int result = JOptionPane.showConfirmDialog(null, panelTwo,"Delete",JOptionPane.OK_CANCEL_OPTION);

        if (result == 0) // If Ok button was pressed
        {
            for (int i = 0; i < classList.size(); i++) //Iterates through entire length of arraylist
            {
                if (Sebas.getSelectedItem().equals(user)) // If item from combobox is the same as a name from arraylist
                {
                    User v = classList.get(i); // Data pertaining to specific user is retrieved
                    classList.remove(v); // Selected data is removed
                    JOptionPane.showMessageDialog(null, "User " + user + " has been removed"); // Confirmation message to show that user has been removed from arraylist
                }

            }
            saveUser(); // Call statement to save user method
        }
    }

    public void AddUserGUI() // Method for admin to add a user on a GUI
    {
        panelLabel.add(nameLabel);  // Label for the user's actual name is added to GUI
        panelLabel.add(LoginGUI.userLabel); // Label for user is added to GUI
        panelLabel.add(LoginGUI.pinLabel); // Label for pin is added to GUI
        panelGUI.add(panelLabel, BorderLayout.WEST);
        panelLog.add(name);  // name textfield is added to GUI
        panelLog.add(LoginGUI.user);  // user textfield is added to GUI
        panelLog.add(LoginGUI.pin); // pin textfield is added to GUI
        panelGUI.add(panelLog, BorderLayout.CENTER);
        JOptionPane.showConfirmDialog(null, panelGUI, "User Creation", JOptionPane.OK_CANCEL_OPTION);
        addUser(); // Call statement to the add user method
    }

    public void AdminGUI() // Method for the admin to interact with user info on a GUI
    {

        panelAdmin.add(alpha); // Adds add button to GUI
        panelAdmin.add(beta); // Adds delete button to GUI
        panelAdmin.add(omega); // Adds back button to GUI
        JOptionPane.showConfirmDialog(null, panelAdmin, "Admin Menu", JOptionPane.OK_CANCEL_OPTION);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == alpha)
        {
            AddUserGUI(); // Call statement
        }
        else if (e.getSource() == beta)
        {
            DeleteUserGUI(); // Call statement
        }
        else if (e.getSource() == omega)
        {
            //LoginGUI.mainMenu();
        }
    }
}
