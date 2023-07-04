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
public class ToggleSwitch extends Component{
    private Point position;
    
    public ToggleSwitch(Point position){
        super(position, "Toggle switch");
        this.position = position;
        
        // creates the connector points
        Point connection1 = new Point(position.x - 30, position.y);
        Point connection2 = new Point(position.x + 50, position.y + 20);
        Point connection3 = new Point(position.x + 50, position.y - 20);
        
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
        
        g2D.drawLine(position.x - 30, position.y, position.x, position.y);
        g2D.drawOval(position.x - 3, position.y - 3, 6, 6);
        g2D.drawLine(position.x, position.y, position.x + 20, position.y - 20);
        
        g2D.drawLine(position.x + 20, position.y + 20, position.x + 50, position.y + 20);
        g2D.drawOval(position.x + 20, position.y + 18, 6, 6);
        
        g2D.drawLine(position.x + 20, position.y - 20, position.x + 50, position.y - 20);
        g2D.drawOval(position.x + 20, position.y - 22, 6, 6);
    }

    @Override
    public String toString() {
        return "Umschalter{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[3];
        points[0] = new Point(position.x - 30, position.y);
        points[1] = new Point(position.x + 50, position.y + 20);
        points[2] = new Point(position.x + 50, position.y - 20);
        return points;
    }
}
