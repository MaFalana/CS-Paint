import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PaintGUI extends JFrame implements MouseListener, ActionListener, ItemListener
{
    static JPanel Win = new JPanel();

    ImageIcon editIcon = new ImageIcon(getClass().getResource("/Color Gradient.jpeg"));
    ImageIcon logo = new ImageIcon(getClass().getResource("/Color Wheel.png")); // Creates an Image Icon

    static JToggleButton firstColor = new JToggleButton(); // First Color
    static JToggleButton secondColor = new JToggleButton(); // Second Color
    static JButton chooseColor = new JButton(); // Color chooser
    static JLabel chooseLabel = new JLabel("Create");
    JLabel label1 = new JLabel("Color 1");
    JLabel label2 = new JLabel("Color 2");


    static JPanel R1B1 = new JPanel(); // Row 1 box 1
    static JPanel R1B2 = new JPanel(); // Row 1 box 2
    static JPanel R1B3 = new JPanel(); // Row 1 box 3
    static JPanel R1B4 = new JPanel(); // Row 1 box 4
    static JPanel R1B5 = new JPanel(); // Row 1 box 5
    static JPanel R1B6 = new JPanel(); // Row 1 box 6
    static JPanel R1B7 = new JPanel(); // Row 1 box 7
    static JPanel R1B8 = new JPanel(); // Row 1 box 8
    static JPanel R1B9 = new JPanel(); // Row 1 box 9
    static JPanel R1BX = new JPanel(); // Row 1 box 10

    static JPanel R2B1 = new JPanel(); // Row 2 box 1
    static JPanel R2B2 = new JPanel(); // Row 2 box 2
    static JPanel R2B3 = new JPanel(); // Row 2 box 3
    static JPanel R2B4 = new JPanel(); // Row 2 box 4
    static JPanel R2B5 = new JPanel(); // Row 2 box 5
    static JPanel R2B6 = new JPanel(); // Row 2 box 6
    static JPanel R2B7 = new JPanel(); // Row 2 box 7
    static JPanel R2B8 = new JPanel(); // Row 2 box 8
    static JPanel R2B9 = new JPanel(); // Row 2 box 9
    static JPanel R2BX = new JPanel(); // Row 2 box 10

    static JPanel R3B1 = new JPanel(); // Row 3 box 1
    static JPanel R3B2 = new JPanel(); // Row 3 box 2
    static JPanel R3B3 = new JPanel(); // Row 3 box 3
    static JPanel R3B4 = new JPanel(); // Row 3 box 4
    static JPanel R3B5 = new JPanel(); // Row 3 box 5
    static JPanel R3B6 = new JPanel(); // Row 3 box 6
    static JPanel R3B7 = new JPanel(); // Row 3 box 7
    static JPanel R3B8 = new JPanel(); // Row 3 box 8
    static JPanel R3B9 = new JPanel(); // Row 3 box 9
    static JPanel R3BX = new JPanel(); // Row 3 box 10


    static Border border = BorderFactory.createLineBorder(Color.black,3);

    static int firstToggle;
    static int secondToggle;

    JPanel panelOne = new JPanel(new GridLayout(3,10,10,2));
    JPanel panelTwo = new JPanel(new BorderLayout(10,10));
    JPanel panelThree = new JPanel(new GridLayout(2, 2, 5, 2));
    JPanel panelFour = new JPanel(new GridLayout(2, 1, 5, 2));
    JPanel panelFive = new JPanel(new GridLayout(3,2));
    JPanel panelSix = new JPanel(new GridLayout());

    JPanel panelTaskbar = new JPanel(new BorderLayout());
    JPanel panelB = new JPanel(new GridLayout(2,3));

    JPanel text = new JPanel();
    JScrollPane scroll = new JScrollPane(text,22,32);
    static JPanel[] Box = {R3B1,R3B2,R3B3,R3B4,R3B5,R3B6,R3B7,R3B8,R3B9,R3BX};
    JPanel[] Set = {R1B1,R1B2,R1B3,R1B4,R1B5,R1B6,R1B7,R1B8,R1B9,R1BX,R2B1,R2B2,R2B3,R2B4,R2B5,R2B6,R2B7,R2B8,R2B9,R2BX,R3B1,R3B2,R3B3,R3B4,R3B5,R3B6,R3B7,R3B8,R3B9,R3BX};


    static JToggleButton H = new JToggleButton("Highlighter");
    static JToggleButton P = new JToggleButton("Pencil");
    static JToggleButton M = new JToggleButton("Marker");
    static JToggleButton E = new JToggleButton("Eraser");
    public static void main(String[] args)
    {
        new PaintGUI();
    }

    PaintGUI()
    {
        text.add(new Canvas());

        panelB.setBorder( new TitledBorder("Tools") );
        panelTwo.setBorder( new TitledBorder("Colors") );

        Image img = editIcon.getImage();
        Image newimg = img.getScaledInstance(45, 40, java.awt.Image.SCALE_SMOOTH);
        editIcon = new ImageIcon(newimg);
        chooseColor.setIcon(editIcon);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits out of application AND program
        this.setTitle("CS Paint"); // Sets title
        this.setSize(1000,750); // Sets x and y dimensions of frame
        Win.setLayout(new BorderLayout());
        Win.setOpaque(true);

        Boxes();


        panelTwo.add(panelOne,BorderLayout.CENTER);
        panelTwo.add(panelThree,BorderLayout.WEST);
        panelTwo.add(panelFour,BorderLayout.EAST);

        panelSix.add(scroll);


        panelB.add(H);
        panelB.add(P);
        panelB.add(M);
        panelB.add(E);
        panelTaskbar.add(panelTwo);
        panelTaskbar.add(panelB);


        panelTaskbar.add(panelTwo);
        panelTaskbar.add(panelB,BorderLayout.WEST);

        this.add(panelTaskbar,BorderLayout.NORTH);
        this.add(panelSix,BorderLayout.CENTER);
        scroll.setBackground(Color.gray);

        this.setVisible(true);
        Win.addMouseListener(this);
        firstColor.addItemListener(this);
        secondColor.addItemListener(this);
        H.addItemListener(this);
        P.addItemListener(this);
        M.addItemListener(this);
        E.addItemListener(this);
        this.setIconImage(logo.getImage());
    }

    public void Boxes()
    {
        firstColor.setBounds(400,10, 40,45);
        firstColor.setBorder(border);
        firstColor.setOpaque(true);
        firstColor.setBackground(Color.WHITE);
        firstColor.addMouseListener(this);
        panelThree.add(firstColor);

        secondColor.setBounds(450,10, 40,45);
        secondColor.setBorder(border);
        secondColor.setOpaque(true);
        secondColor.addMouseListener(this);
        secondColor.setBackground(Color.WHITE);
        panelThree.add(secondColor);
        panelThree.add(label1);
        panelThree.add(label2);

        chooseColor.setBorder(border);
        chooseColor.setOpaque(true);
        chooseColor.addActionListener(this);
        panelFour.add(chooseColor);
        chooseLabel.setBounds(755,20,1,1);
        panelFour.add(chooseLabel);

        // Row 1
        R1B1.setBounds(500,10 ,20,20);
        R1B1.setBorder(border);
        R1B1.setOpaque(true);
        R1B1.setBackground(new Color(0,0,0));
        panelOne.add(R1B1);

        R1B2.setBounds(525,10 ,20,20);
        R1B2.setBorder(border);
        R1B2.setOpaque(true);
        R1B2.setBackground(new Color(127,127,127));
        panelOne.add(R1B2);

        R1B3.setBounds(550,10 ,20,20);
        R1B3.setBorder(border);
        R1B3.setOpaque(true);
        R1B3.setBackground(new Color(140,0,20));
        panelOne.add(R1B3);

        R1B4.setBounds(575,10 ,20,20);
        R1B4.setBorder(border);
        R1B4.setOpaque(true);
        R1B4.setBackground(new Color(235,29,37));
        panelOne.add(R1B4);

        R1B5.setBounds(600,10 ,20,20);
        R1B5.setBorder(border);
        R1B5.setOpaque(true);
        R1B5.setBackground(new Color(255,126,39));
        panelOne.add(R1B5);

        R1B6.setBounds(625,10 ,20,20);
        R1B6.setBorder(border);
        R1B6.setOpaque(true);
        R1B6.setBackground(new Color(253,243,0));
        panelOne.add(R1B6);

        R1B7.setBounds(650,10 ,20,20);
        R1B7.setBorder(border);
        R1B7.setOpaque(true);
        R1B7.setBackground(new Color(39,177,79));
        panelOne.add(R1B7);

        R1B8.setBounds(675,10 ,20,20);
        R1B8.setBorder(border);
        R1B8.setOpaque(true);
        R1B8.setBackground(new Color(16,160,220));
        panelOne.add(R1B8);

        R1B9.setBounds(700,10 ,20,20);
        R1B9.setBorder(border);
        R1B9.setOpaque(true);
        R1B9.setBackground(new Color(67,70,191));
        panelOne.add(R1B9);

        R1BX.setBounds(725,10 ,20,20);
        R1BX.setBorder(border);
        R1BX.setOpaque(true);
        R1BX.setBackground(new Color(162,75,162));
        panelOne.add(R1BX);

        // Row 2
        R2B1.setBounds(500,35 ,20,20);
        R2B1.setBorder(border);
        R2B1.setOpaque(true);
        R2B1.setBackground(new Color(255,255,255));
        panelOne.add(R2B1);

        R2B2.setBounds(525,35 ,20,20);
        R2B2.setBorder(border);
        R2B2.setOpaque(true);
        R2B2.setBackground(new Color(197,197,197));
        panelOne.add(R2B2);

        R2B3.setBounds(550,35 ,20,20);
        R2B3.setBorder(border);
        R2B3.setOpaque(true);
        R2B3.setBackground(new Color(185,121,84));
        panelOne.add(R2B3);

        R2B4.setBounds(575,35 ,20,20);
        R2B4.setBorder(border);
        R2B4.setOpaque(true);
        R2B4.setBackground(new Color(250,174,202));
        panelOne.add(R2B4);

        R2B5.setBounds(600,35 ,20,20);
        R2B5.setBorder(border);
        R2B5.setOpaque(true);
        R2B5.setBackground(new Color(253,202,7));
        panelOne.add(R2B5);

        R2B6.setBounds(625,35 ,20,20);
        R2B6.setBorder(border);
        R2B6.setOpaque(true);
        R2B6.setBackground(new Color(238,228,175));
        panelOne.add(R2B6);

        R2B7.setBounds(650,35 ,20,20);
        R2B7.setBorder(border);
        R2B7.setOpaque(true);
        R2B7.setBackground(new Color(180,229,31));
        panelOne.add(R2B7);

        R2B8.setBounds(675,35 ,20,20);
        R2B8.setBorder(border);
        R2B8.setOpaque(true);
        R2B8.setBackground(new Color(158,214,231));
        panelOne.add(R2B8);

        R2B9.setBounds(700,35 ,20,20);
        R2B9.setBorder(border);
        R2B9.setOpaque(true);
        R2B9.setBackground(new Color(115,144,186));
        panelOne.add(R2B9);

        R2BX.setBounds(725,35 ,20,20);
        R2BX.setBorder(border);
        R2BX.setOpaque(true);
        R2BX.setBackground(new Color(196,191,230));
        panelOne.add(R2BX);

        // Row 3
        R3B1.setBounds(500,60 ,20,20);
        R3B1.setBorder(border);
        R3B1.setOpaque(true);
        //R3B1.setBackground(new Color(colourData.get(0)));
        panelOne.add(R3B1);

        R3B2.setBounds(525,60 ,20,20);
        R3B2.setBorder(border);
        R3B2.setOpaque(true);
        //R3B2.setBackground(new Color(197,197,197));
        panelOne.add(R3B2);

        R3B3.setBounds(550,60 ,20,20);
        R3B3.setBorder(border);
        R3B3.setOpaque(true);
        //R3B3.setBackground(new Color(185,121,84));
        panelOne.add(R3B3);

        R3B4.setBounds(575,60 ,20,20);
        R3B4.setBorder(border);
        R3B4.setOpaque(true);
        //R3B4.setBackground(new Color(250,174,202));
        panelOne.add(R3B4);

        R3B5.setBounds(600,60 ,20,20);
        R3B5.setBorder(border);
        R3B5.setOpaque(true);
        //R3B5.setBackground(new Color(253,202,7));
        panelOne.add(R3B5);

        R3B6.setBounds(625,60 ,20,20);
        R3B6.setBorder(border);
        R3B6.setOpaque(true);
        //R3B6.setBackground(new Color(238,228,175));
        panelOne.add(R3B6);

        R3B7.setBounds(650,60 ,20,20);
        R3B7.setBorder(border);
        R3B7.setOpaque(true);
        //R3B7.setBackground(new Color(180,229,31));
        panelOne.add(R3B7);

        R3B8.setBounds(675,60 ,20,20);
        R3B8.setBorder(border);
        R3B8.setOpaque(true);
        //R3B8.setBackground(new Color(158,214,231));
        panelOne.add(R3B8);

        R3B9.setBounds(700,60 ,20,20);
        R3B9.setBorder(border);
        R3B9.setOpaque(true);
        //R3B9.setBackground(new Color(115,144,186));
        panelOne.add(R3B9);

        R3BX.setBounds(725,60 ,20,20);
        R3BX.setBorder(border);
        R3BX.setOpaque(true);
        //R3BX.setBackground(new Color(196,191,230)); // I want this box to grab the color in location 9 Colour.[9]
        panelOne.add(R3BX);
        for (int i = 0; i < 30; i++)
        {
            Set[i].addMouseListener(this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        for (int i = 0; i < 30; i++)
        {
            if (e.getSource() == Set[i])
            {
                if (firstToggle == 1)
                {
                    firstColor.setBackground(Set[i].getBackground());
                }
                else if (secondToggle == 1)
                {
                    secondColor.setBackground(Set[i].getBackground());
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == chooseColor)
        {
            new ColorPickerGUI();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == firstColor)
        {
            if (e.getStateChange() == e.SELECTED)
            {
                firstColor.setBorder(BorderFactory.createLineBorder(Color.ORANGE,3));  // Makes border gold so user can tell it is activated
                secondColor.setBorder(BorderFactory.createLineBorder(Color.black,3)); // Makes border black so user can tell it is deactivated
                firstToggle = 1; //This means the first button is on
                secondToggle = 0; //Second button is off
            }
            else
            {
                firstColor.setBorder(BorderFactory.createLineBorder(Color.black,3));
                firstToggle = 0; //this means the first button is off
            }
        }
        else if (e.getSource() == secondColor)
        {
            if (e.getStateChange() == e.SELECTED)
            {
                secondColor.setBorder(BorderFactory.createLineBorder(Color.ORANGE,3)); // Makes border gold so user can tell it is activated
                firstColor.setBorder(BorderFactory.createLineBorder(Color.black,3)); // Makes border black so user can tell it is deactivated
                secondToggle = 1; //Second button is on
                firstToggle = 0; //First button is off
            }
            else
            {
                secondColor.setBorder(BorderFactory.createLineBorder(Color.black,3)); // else print deselected in console
                secondToggle = 0;

            }
        }
        else if (e.getSource() == H)
        {
            P.setSelected(false);
            M.setSelected(false);
            E.setSelected(false);
        }
        else if (e.getSource() == P)
        {
            H.setSelected(false);
            M.setSelected(false);
            E.setSelected(false);
        }
        else if (e.getSource() == M)
        {
            H.setSelected(false);
            P.setSelected(false);
            E.setSelected(false);
        }
        else if (e.getSource() == E)
        {
            H.setSelected(false);
            P.setSelected(false);
            M.setSelected(false);
        }


    }

}


