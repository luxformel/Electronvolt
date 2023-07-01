/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public class LightBulb extends Component{
     private Point position;
         private Color color = Color.BLACK;
    
    public LightBulb(Point position){
        super(position, "Glühlampe");
         this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    
    @Override
    public void draw(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.BLACK);
        // draws the circle
        g2D.drawOval(position.x - 20, position.y - 20, 40, 40);
        // draws the X
        g2D.drawLine(position.x - 14 ,position.y - 14, position.x + 14, position.y + 14);
        g2D.drawLine(position.x - 14 ,position.y + 14, position.x + 14, position.y - 14);
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 20, position.x, position.y - 30);
        g2D.drawLine(position.x, position.y + 20, position.x, position.y + 30);
    }

    @Override
    public String toString() {
        return "LightBulb{" + "position=" + position + '}';
    }
    
}
