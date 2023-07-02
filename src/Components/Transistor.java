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
public class Transistor extends Component{
     private Point position;
    
    public Transistor(Point position){
        super(position, "Transistor");
        this.position = position;
        
        // creates the connector points
        Point connection1 = new Point(position.x - 30, position.y);
        Point connection2 = new Point(position.x + 30, position.y - 50);
        Point connection3 = new Point(position.x + 30, position.y + 50);
        
        // add the connector Points to the list
        ConnectionPoints.add(connection1);
        ConnectionPoints.add(connection2);
        ConnectionPoints.add(connection3);
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
        // middle line
        g2D.drawLine(position.x, position.y - 30, position.x, position.y + 30);
        // left most connector line
        g2D.drawLine(position.x, position.y, position.x - 30, position.y);
        // diagonal lines
        g2D.drawLine(position.x, position.y - 5, position.x + 30, position.y - 40);
        g2D.drawLine(position.x, position.y + 5, position.x + 30, position.y + 40);
        // triangle
        int[] xPoints = {position.x + 10, position.x + 20, position.x + 20};
        int[] yPoints = {position.y + 30, position.y + 20, position.y + 30};
        g2D.drawPolygon(xPoints, yPoints, 3);
        // collector and emitter connector lines
        g2D.drawLine(position.x + 30, position.y - 40, position.x + 30, position.y - 50);
        g2D.drawLine(position.x + 30, position.y + 40, position.x + 30, position.y + 50);
    }

    @Override
    public String toString() {
        return "Transistor{" + "position=" + position + '}';
    }
    
    
}
