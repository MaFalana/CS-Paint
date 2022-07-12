import java.io.*;
import java.util.*;
import javax.swing.*;

public class User implements Serializable
{
    ArrayList<User> classList = new ArrayList<User>();
    String name;
    String user;
    String pin;
    ArrayList<Colour> list;

    public User()
    {
        name = "";
        user = "";
        pin = "";
        list = new ArrayList<Colour>();
    } // end null constructor

    public User(String name, String user, String pin, ArrayList<Colour> list)
    {
        this.name = name;
        this.user = user;
        this.pin = pin;
        this.list = list;

    } // end constructor

    void addUser() // Method to add a user
    {
        this.name = Admin.name.getText();
        this.user = LoginGUI.user.getText();
        this.pin = LoginGUI.pin.getText();
        this.list = Colour.colourData;
        User account = new User(name, user, pin, list);
        classList.add(account);
        saveUser();
        JOptionPane.showMessageDialog(null, "User " + name + " added succesfully.");
    }

    void saveUser()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("Active Users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(classList);
            oos.close();
            fos.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // end saveUser

    void loadUsers()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Active Users.ser"));
            classList = (ArrayList<User>) ois.readObject();
            ois.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } // end try
    }

}
