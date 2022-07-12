import java.awt.*;
import java.awt.event.*;

public class Canvas extends Utensil
{
    public Canvas()
    {

    }

    public void updateImage()
    {
        if (newPoint != null)
        {
            Graphics2D g2 = bfImage.createGraphics();
            if (PaintGUI.H.isSelected()) // If Highlighter is selected
            {
                g2.setStroke(new BasicStroke(15));
                if (PaintGUI.firstToggle == 0 && PaintGUI.secondToggle == 0)
                {
                    g2.setColor(baseColor2);
                }
                else if (PaintGUI.firstToggle == 1) {
                    g2.setColor(new Color(PaintGUI.firstColor.getBackground().getRed(), PaintGUI.firstColor.getBackground().getGreen(), PaintGUI.firstColor.getBackground().getBlue(), alpha));
                } else if (PaintGUI.firstToggle == 0) {
                    g2.setColor(new Color(PaintGUI.secondColor.getBackground().getRed(), PaintGUI.secondColor.getBackground().getGreen(), PaintGUI.secondColor.getBackground().getBlue(), alpha));
                }
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
                g2.dispose();
                repaint();
            }
            else if (PaintGUI.P.isSelected()) //If Pencil is selected
            {
                g2.setStroke(size);
                if (PaintGUI.firstToggle == 0 && PaintGUI.secondToggle == 0)
                {
                    g2.setColor(baseColor);
                }
                else if (PaintGUI.firstToggle == 1)
                {
                    g2.setColor(new Color(PaintGUI.firstColor.getBackground().getRed(), PaintGUI.firstColor.getBackground().getGreen(), PaintGUI.firstColor.getBackground().getBlue()));
                }
                else if (PaintGUI.firstToggle == 0)
                {
                    g2.setColor(new Color(PaintGUI.secondColor.getBackground().getRed(), PaintGUI.secondColor.getBackground().getGreen(), PaintGUI.secondColor.getBackground().getBlue()));
                }
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
                g2.dispose();
                repaint();
            }
            else if (PaintGUI.M.isSelected()) //If Marker is selected
            {
                g2.setStroke(new BasicStroke(5));
                if (PaintGUI.firstToggle == 0 && PaintGUI.secondToggle == 0)
                {
                    g2.setColor(null);
                }
                else if (PaintGUI.firstToggle == 1)
                {
                    g2.setColor(new Color(PaintGUI.firstColor.getBackground().getRed(), PaintGUI.firstColor.getBackground().getGreen(), PaintGUI.firstColor.getBackground().getBlue()));
                }
                else if (PaintGUI.firstToggle == 0)
                {
                    g2.setColor(new Color(PaintGUI.secondColor.getBackground().getRed(), PaintGUI.secondColor.getBackground().getGreen(), PaintGUI.secondColor.getBackground().getBlue()));
                }
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
                g2.dispose();
                repaint();
            }
            else if (PaintGUI.E.isSelected()) //If Eraser is selected
            {
                g2.setStroke(new BasicStroke(25));
                g2.setColor(Color.WHITE);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
                g2.dispose();
                repaint();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)); //Changes regular to cross hair so user can tell tool is in use
        newPoint = e.getPoint();
        updateImage(); // Call statement to update the canvas
        oldPoint = newPoint;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        newPoint = e.getPoint();
        updateImage();
        newPoint = null;
        oldPoint = null;
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (oldPoint == null)
        {
            oldPoint = e.getPoint();
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
        g.drawImage(bfImage, 0, 0, null);  //Draws the "canvas" as a buffered image
    }

}
