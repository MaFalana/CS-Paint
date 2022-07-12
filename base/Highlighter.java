import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

class Highlighter extends Utensil
{
    public Highlighter()
    {
        //super();
        //updateImage();
        //super(g);
        //Graphics2D g2D = (Graphics2D) g;
        //g2D.setStroke(new BasicStroke(5)); // Brush stroke size, size is measured in pixels
        //this.setPreferredSize(new Dimension(W,H));
        //this.setBackground(Color.WHITE);
        //bfImage = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        //this.addMouseMotionListener(this);
        //this.addMouseListener(this);
        //alpha = 240; // 50% transparent
        //this.addMouseMotionListener(this);
        //this.addMouseListener(this);
    }


    public void updateImage()
    {
        if (newPoint != null)
        {
            Graphics2D g2 = bfImage.createGraphics();
            if (PaintGUI.H.isSelected()) // If Highlighter is selected
            {
                g2.setStroke(new BasicStroke(15));
                //alpha = 127; // 50% transparent

                if (PaintGUI.firstToggle == 1) {
                    g2.setColor(new Color(PaintGUI.firstColor.getBackground().getRed(), PaintGUI.firstColor.getBackground().getGreen(), PaintGUI.firstColor.getBackground().getBlue(), 50));
                } else if (PaintGUI.firstToggle == 0) {
                    g2.setColor(new Color(PaintGUI.secondColor.getBackground().getRed(), PaintGUI.secondColor.getBackground().getGreen(), PaintGUI.secondColor.getBackground().getBlue(), 50));
                }
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
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        newPoint = e.getPoint();
        updateImage();
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
        g.drawImage(bfImage, 0, 0, null);
    }





}
