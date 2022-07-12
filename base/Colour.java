import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class Colour extends User implements Serializable
{
    int R, G, B, A;
    float H, S, V;
    String chess;
    static ArrayList<Colour> colourData = new ArrayList<Colour>();


    public void saveColor() //Method that saves different types of colors
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(LoginGUI.user.getText() + " Colors.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(colourData);
            oos.close();
            fos.close();
            JOptionPane.showMessageDialog(null, "Color data saved.");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void loadColor() // Method used to just solely load up the colors (used at the beginning of program)
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LoginGUI.user.getText() + " Colors.ser"));
            colourData = (ArrayList<Colour>) ois.readObject();

            for (int i = 0; i < colourData.size(); i++)
            {
                Colour x = colourData.get(i);
                if (x instanceof RGB)
                {
                    PaintGUI.Box[i].setBackground(new Color(x.R, x.G, x.B)); // RGB Color
                }
                else if (x instanceof HSV)
                {
                    PaintGUI.Box[i].setBackground(Color.getHSBColor(x.H, x.S, x.V)); // HSV Color
                }
                else if (x instanceof HEX)
                {
                    PaintGUI.Box[i].setBackground(Color.decode(x.chess)); // HEX Color
                }
                if (colourData.size() > PaintGUI.Box.length) //If the amount of colors is full the first one will be overwritten
                {
                    colourData.remove(0);
                }
            }

            ois.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void createColor(String value) // Method used to get a Color to serialize
    {

        Colour check = null;
        //User t = User.classList.get(i);
        //String Item = ColorPickerGUI.cb.getSelectedItem().toString();

       if (value.equals("RGB"))
        {
            this.R = (int) ColorPickerGUI.redValue.getValue();
            this.G = (int) ColorPickerGUI.greenValue.getValue();
            this.B = (int) ColorPickerGUI.blueValue.getValue();
            check = new RGB(R,G,B);
        }
        else if (value.equals("HSV"))
        {
            String sat = ColorPickerGUI.satValue.getValue().toString(); // Gets value from spinner and converts into a string
            this.H = (float) ColorPickerGUI.hueSlider.getValue();
            this.S = Float.parseFloat(sat); // converts string to a float value
            this.V = (float) ColorPickerGUI.lightSlider.getValue();
            //check = new HSV(H,S,V);
            int rgb = Color.HSBtoRGB(H,S,V);
            this.R = (rgb >> 16) & 0xFF;
            this.G = (rgb >> 8) & 0xFF;
            this.B = rgb & 0xFF;
            check = new HSV(R,G,B);
        }
        else if (value.equals("HEX"))
        {
            this.chess = ColorPickerGUI.hexValue.getText();
            check = new HEX(chess);
        }
        colourData.add(check);
        saveColor();
        loadColor();
    }

    public void listColor()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LoginGUI.user.getText() + " Colors.ser"));
            colourData = (ArrayList<Colour>) ois.readObject();
            ois.close();
            Colour x;
            for (int i = 0; i < colourData.size(); i++) //should grab the most recently saved color info
            {
                x = colourData.get(i);
                this.R = x.R;
                this.G = x.G;
                this.B = x.B;
                this.H = x.H;
                this.S = x.S;
                this.V = x.V;
                this.chess = x.chess;
                if (x instanceof RGB)
                {
                    System.out.println("RGB: " + x.R + "\t" + x.G + "\t" + x.B);
                    ColorPickerGUI.previous.setBackground(new Color(R,G,B));
                }
                else if (x instanceof HSV)
                {
                    //System.out.println("HSV: " + x.H + "\t" + x.S + "\t" + x.V);
                    System.out.println("HSV: "  + x.R + "\t" + x.G + "\t" + x.B);
                    ColorPickerGUI.previous.setBackground(new Color(R,G,B));
                }
                else if (x instanceof HEX)
                {
                    System.out.println("HEX: " + x.chess);
                    ColorPickerGUI.previous.setBackground(Color.decode(x.chess)); // HEX Color
                }

            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
