import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ColorPickerGUI extends Colour implements ActionListener, MouseMotionListener, ChangeListener, MouseListener
{
    JLabel labelOne = new JLabel("R", SwingConstants.RIGHT);
    JLabel labelTwo = new JLabel("G", SwingConstants.RIGHT);
    JLabel labelThree = new JLabel("B", SwingConstants.RIGHT);

    //JButton OK = new JButton("Ok");
    JButton Reset = new JButton("Reset");
    JButton Upload = new JButton("Upload");


    String[] choices = {"RGB", "HSV", "HEX"};
    JComboBox<String> cb = new JComboBox<String>(choices);

     static JSpinner redValue = new JSpinner(new SpinnerNumberModel(255, 0, 255, 1));
     static JSpinner greenValue = new JSpinner(new SpinnerNumberModel(255, 0, 255, 1));
     static JSpinner blueValue = new JSpinner(new SpinnerNumberModel(255, 0, 255, 1));
     static JSpinner satValue = new JSpinner(new SpinnerNumberModel(1f, 0, 1f, 0.05));


    JSpinner hueValue = new JSpinner(new SpinnerNumberModel(120f, 0, 360f, 1));
    JSpinner lightValue = new JSpinner(new SpinnerNumberModel(0, 0, 100f, 1));
    static JTextField hexValue = new JTextField();





    JPanel current = new JPanel();
    static JPanel previous = new JPanel();


    JLabel window = new JLabel();
    static JSlider lightSlider = new JSlider(JSlider.VERTICAL, 0, 100, 50); // 50 is starting point
    static JSlider hueSlider = new JSlider(JSlider.HORIZONTAL, 0, 360, 120); // 120 = green starting point


    JPanel panelOne = new JPanel(new GridLayout(6, 6, 6, 6));
    JPanel panelTwo = new JPanel(new BorderLayout(5,5));
    JPanel panelThree = new JPanel(new BorderLayout());
    JPanel panelFour = new JPanel(new GridLayout());

    int r = (int) redValue.getValue();
    int g = (int) greenValue.getValue();
    int b = (int) blueValue.getValue();
    //Colour K = new Colour();

    public ColorPickerGUI()
    {

        current.setBackground(Color.WHITE);
        current.setOpaque(true);
        current.setBorder(BorderFactory.createLineBorder(Color.black,3));
        current.setSize(60,60);

        previous.setBackground(Color.WHITE);
        previous.setOpaque(true);
        previous.setBorder(BorderFactory.createLineBorder(Color.black,3));
        previous.setSize(20,20);

        window.setBackground(Color.WHITE);
        window.setOpaque(true);
        window.setBorder(BorderFactory.createLineBorder(Color.black,3));
        window.setSize(650,650);

        panelOne.add(new JLabel());
        panelOne.add(current);
        panelOne.add(previous);

        panelOne.add(new JLabel());
        panelOne.add(new JLabel("current"));
        panelOne.add(new JLabel("previous"));

        panelOne.add(new JLabel());
        panelOne.add(cb);
        panelOne.add(new JLabel());

        panelOne.add(labelOne);
        panelOne.add(redValue);
        panelOne.add(Reset);

        panelOne.add(labelTwo);
        panelOne.add(greenValue);
        panelOne.add(Upload);

        panelOne.add(labelThree);
        panelOne.add(blueValue);
        panelOne.add(new JLabel());

        panelTwo.add(panelOne);


        panelThree.add(window);
        panelThree.add(lightSlider,BorderLayout.EAST);
        panelThree.add(hueSlider,BorderLayout.SOUTH);

        //panelFour.add(panelTwo,BorderLayout.EAST);
       // panelFour.add(panelThree,BorderLayout.CENTER);
        //panelFour.setLayout(new BoxLayout(panelFour, BoxLayout.Y_AXIS));

        panelFour.add(panelThree);
        panelFour.add(panelTwo);



        cb.addActionListener(this);
        Upload.addActionListener(this);
        Reset.addActionListener(this);
        hueSlider.addChangeListener(this);
        hueValue.addChangeListener(this);
        lightSlider.addChangeListener(this);
        //lightValue.addChangeListener(this);
        previous.addMouseListener(this);
        window.addMouseListener(this);
        redValue.addChangeListener(this);
        greenValue.addChangeListener(this);
        blueValue.addChangeListener(this);
        JOptionPane.showConfirmDialog(null, panelFour, "Color Picker", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == cb && cb.getSelectedItem().equals("RGB"))
        {
            labelOne.setText("R");
            labelTwo.setText("G");
            labelThree.setText("B");
            panelOne.add(redValue);
            panelOne.add(greenValue);
            panelOne.add(blueValue);

            panelOne.remove(hueValue);
            panelOne.remove(lightValue);
            panelOne.remove(hexValue);
            panelOne.remove(satValue);
        }
        else if (e.getSource() == cb && cb.getSelectedItem().equals("HSV"))
        {
            labelOne.setText("H");
            labelTwo.setText("S");
            labelThree.setText("V");
            panelOne.add(hueValue);
            panelOne.add(satValue);
            panelOne.add(lightValue);
            lightValue.setValue(lightValue.getValue());
            satValue.setValue(satValue.getValue());
            hueValue.setValue(hueValue.getValue());

            panelOne.remove(redValue);
            panelOne.remove(greenValue);
            panelOne.remove(blueValue);
            panelOne.remove(hexValue);
            //K.createColor(cb.getSelectedItem().toString());
        }
        else if (e.getSource() == cb && cb.getSelectedItem().equals("HEX"))
        {
            String HEX = String.format("%02X%02X%02X", redValue.getValue(), greenValue.getValue(), blueValue.getValue());
            labelOne.setText("#");
            panelOne.add(hexValue);
            hexValue.setText(HEX);
            labelTwo.add(new JLabel());
            labelThree.add(new JLabel());

            panelOne.remove(hueValue);
            panelOne.remove(lightValue);
            panelOne.remove(satValue);
            panelOne.remove(redValue);
            panelOne.remove(greenValue);
            panelOne.remove(blueValue);

        }

        else if (e.getSource() == Upload)
        {
            JFileChooser jfile = new JFileChooser();
            jfile.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "bmp", "jpg", "jpeg", "wbmp", "png", "gif")); // Filters image files from other types
            jfile.setAcceptAllFileFilterUsed(false); // Will only allow image files to be selected
            int response = jfile.showOpenDialog(null); // Will select file to open
            if (response == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = jfile.getSelectedFile(); // Grabs selected file
                String path = selectedFile.getAbsolutePath(); // Gets path of selected file and turns it to a string
                ImageIcon img = new ImageIcon(path);
                Image regularImage = img.getImage();
                Image scaledImage = regularImage.getScaledInstance(window.getWidth(), window.getHeight(), Image.SCALE_SMOOTH); // Resizes the selected image to the size of label
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                window.setIcon(scaledIcon); // Sets the image
                window.addMouseMotionListener(this);
            }
        }
        else if (e.getSource() == Reset)
        {
            lightValue.setValue(100);
            hueValue.setValue(0); // sets back to red
            redValue.setValue(255);
            greenValue.setValue(255);
            blueValue.setValue(255);
            satValue.setValue(0); // Values are set in Frame manner so the color displayed will be white
            String hexValue = String.format("%02X%02X%02X", redValue.getValue(), greenValue.getValue(), blueValue.getValue());
            this.hexValue.setText(hexValue);
            window.setIcon(null);
            window.setBackground(Color.white);
            current.setBackground(Color.white);
            window.removeMouseMotionListener(this);
            window.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); // Changes mouse back to normal
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e)
    {
        window.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));  // Changes cursor into a cross hair cursor
        Icon icon = window.getIcon();
        BufferedImage bi = new BufferedImage(window.getWidth(), window.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        icon.paintIcon(null, g, 0, 0); // Now paint the icon
        g.dispose();
        int pixel = bi.getRGB(e.getX(), e.getY()); //Retrieving contents of a pixel
        Color color = new Color(pixel, true);
        redValue.setValue(color.getRed()); //Retrieving and setting the R G B values
        greenValue.setValue(color.getGreen());
        blueValue.setValue(color.getBlue());
        current.setBackground(new Color((Integer) redValue.getValue(), (Integer) greenValue.getValue(), (Integer) blueValue.getValue())); //Creating a Color object from pixel value
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        if (e.getSource() == hueSlider || e.getSource() == lightSlider|| e.getSource() == satValue)
        {
            String sat = satValue.getValue().toString(); // Gets value from spinner and converts into a string
            float saturationValue = Float.parseFloat(sat); // converts string to a float value
            hueValue.setValue(hueSlider.getValue()); //outputs value to first text field
            lightValue.setValue(lightSlider.getValue());
            window.setBackground(Color.getHSBColor( (float) hueSlider.getValue()/360, saturationValue, (float) lightSlider.getValue()/100 ));
            Color.HSBtoRGB((float) hueSlider.getValue()/360, saturationValue, (float) lightSlider.getValue()/100);
        }

        else if (e.getSource() == redValue || e.getSource() == greenValue || e.getSource() == blueValue)
        {
            String hexValue = String.format("%02X%02X%02X", r, g, b);
            this.hexValue.setText(hexValue);
            window.setBackground(new Color((int) redValue.getValue(), (int) greenValue.getValue(), (int) blueValue.getValue()));
        }

        else if (e.getSource() == hexValue)
        {
            String hexString = "#" + this.hexValue.getText();
            window.setBackground(Color.decode(hexString));
            this.hexValue.setText(hexString);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getSource() == previous)
        {
            window.setIcon(null);
            window.removeMouseMotionListener(this);
            window.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); // Changes mouse back to normal
            //window.setBackground(new Color(K)); // NOT FINAL I want the color passed in to be a serialized object so I don't have to specify if it is rgb or etc.
        }
        else if (e.getSource() == window)
        {
            createColor(cb.getSelectedItem().toString());
            listColor();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


}
