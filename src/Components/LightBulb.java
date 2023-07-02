/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import luxformelcircuitdesigner_v1.pkg0.Component;
import luxformelcircuitdesigner_v1.pkg0.ConnectionPoints;

/**
 *
 * @author luxformel
 */
public class LightBulb extends Component{
    private Point position;
    
    public LightBulb(Point position){
        super(position, "Glühlampe");
         this.position = position;
         
         // creates the connector points
        Point connection1 = new Point(position.x, position.y + 30);
        Point connection2 = new Point(position.x, position.y - 30);
        
        // add the connector Points to the list
        ConnectionPoints.add(connection1);
        ConnectionPoints.add(connection2);
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
        // Antialiasing
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
        return "Glühlampe{" + "position=" + position + '}';
    }
    
}
