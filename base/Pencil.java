import java.awt.*;
import java.awt.event.*;

public class Pencil extends Utensil
{


   public Pencil()
   {

   }



    public void updateImage()
    {
        if (newPoint != null)
        {
            Graphics2D g2 = bfImage.createGraphics();
            g2.setStroke(size);  // sets brush stroke size
            if (PaintGUI.firstToggle == 0 && PaintGUI.secondToggle == 0) //iIf both buttons are off
            {
                g2.setColor(baseColor);  // sets color
            }
            else if (PaintGUI.firstToggle == 1) //If button is on
            {
                g2.setColor(new Color(PaintGUI.firstColor.getBackground().getRed(), PaintGUI.firstColor.getBackground().getGreen(), PaintGUI.firstColor.getBackground().getBlue())); // sets color
            }
            else if (PaintGUI.firstToggle == 0) //If button is off
            {
                g2.setColor(new Color(PaintGUI.secondColor.getBackground().getRed(), PaintGUI.secondColor.getBackground().getGreen(), PaintGUI.secondColor.getBackground().getBlue()));  // sets color
            }
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
            g2.dispose();
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        newPoint = e.getPoint(); //Gets mouse pointer cooirdinates
        updateImage();
        oldPoint = newPoint;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        newPoint = e.getPoint();
        updateImage();
        newPoint = null;
        oldPoint = null; //Sets null coordinates so mouse doesn't keep tracking
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); //Sets cursor back to normal
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (oldPoint == null)
        {
            oldPoint = e.getPoint(); //Gets coordinate when mouse is pressed
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Canvas.bfImage, 0, 0, null);
    }



}
