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
public class Diode extends Component{
    private Point position;
    
    public Diode(Point position){
        super(position, "Diode");
        this.position = position;
        
        // creates the connector points
        Point connection1 = new Point(position.x, position.y + 40);
        Point connection2 = new Point(position.x, position.y - 40);
        
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
        // stopping line
        g2D.drawLine(position.x - 20, position.y - 20, position.x + 20, position.y - 20);
        //draws the triangle
        int[] xPoints1 = {position.x - 15, position.x, position.x + 15};
        int[] yPoints1 = {position.y + 20, position.y - 20, position.y + 20};
        g2D.drawPolygon(xPoints1, yPoints1, 3);        
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 40, position.x, position.y + 40);
        //g2D.drawLine(position.x, position.y + 20, position.x, position.y + 40);
    }

    @Override
    public String toString() {
        return "Diode{" + "position=" + position + '}';
    }
    
    
}
