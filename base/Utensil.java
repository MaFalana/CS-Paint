import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public abstract class Utensil extends JPanel implements MouseListener, MouseMotionListener {


    static int H = 800;
    static int W = 1100;
    int alpha = 50;
    Color baseColor2 = new Color(250, 237, 39, alpha); // Sets highlighter color to a certain shade of yellow

    static Point oldPoint, newPoint;
    static BufferedImage bfImage = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
    static Color baseColor = new Color(74, 78, 93);
    static BasicStroke size = new BasicStroke(2);

    public Utensil()
    {
        this.setPreferredSize(new Dimension(W,H));
        this.setBackground(Color.WHITE);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }


    public abstract void mouseDragged(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseMoved(MouseEvent e);

    public abstract void mouseClicked(MouseEvent e);

    public abstract void mouseExited(MouseEvent e);

    public abstract void mouseEntered(MouseEvent e);

    public void paintComponent(Graphics g) {}

}
