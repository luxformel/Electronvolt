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
import Lists.Component;
import Lists.ConnectionPoints;

/**
 *
 * @author luxformel
 */
public class ACGenerator extends Component{
     private Point position;
    
    public ACGenerator(Point position){
        super(position, "Gleichspannungsquelle");
        this.position = position;  
        
        // creates the connector points
        Point connection1 = new Point(position.x, position.y + 60);
        Point connection2 = new Point(position.x, position.y - 60);
        
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
            // draws the body of the ACGenerator
            g2D.drawRect(position.x - 40, position.y - 40, 80, 80);
            // draws the lines to connect the components
            g2D.drawLine(position.x, position.y - 40, position.x, position.y - 60);    
            g2D.drawLine(position.x, position.y + 40, position.x, position.y + 60);
            // draws the arc of the G
            g2D.drawArc(position.x - 25, position.y - 30, 40, 35, 90, 270);
            // draws the horizontal line of the G
            g2D.drawLine(position.x + 5, position.y - 15, position.x + 25, position.y - 15);
            // draws the vertical line of the G
            g2D.drawLine(position.x + 15, position.y + 5, position.x + 15, position.y - 10);
            // draws the wave 
            g2D.drawArc(position.x - 20, position.y + 15, 20, 17, 0, 180);
            g2D.drawArc(position.x, position.y + 15, 20, 17, 180, 180);
            
    }

    @Override
    public String toString() {
        return "Wechselspannungsgenerator{" + "position=" + position + '}';
    }
}
