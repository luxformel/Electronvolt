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
public class Transformer extends Component{
     private Point position;
    
    public Transformer(Point position){
        super(position, "Spule");
        this.position = position;
         
         // creates the connector points
        Point connection1 = new Point(position.x - 55, position.y - 50);
        Point connection2 = new Point(position.x - 55, position.y + 50);
        Point connection3 = new Point(position.x + 55, position.y - 50);
        Point connection4 = new Point(position.x + 55, position.y + 50);        
        // add the connector Points to the list
        ConnectionPoints.add(connection1);
        ConnectionPoints.add(connection2);
        ConnectionPoints.add(connection3);
        ConnectionPoints.add(connection4);
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
        
        // primary coil
        g2D.drawArc(position.x - 30, position.y - 30, 20, 20, -90, 180);
        g2D.drawArc(position.x - 30, position.y - 10, 20, 20, -90, 180);
        g2D.drawArc(position.x - 30, position.y + 10, 20, 20, -90, 180);
        // draws the lines to connect the components
        g2D.drawLine(position.x - 25, position.y - 30, position.x - 25, position.y - 50);    
        g2D.drawLine(position.x - 25, position.y + 31, position.x - 25, position.y + 50);
        // connectors left
        g2D.drawLine(position.x - 55, position.y - 50, position.x - 25, position.y - 50);    
        g2D.drawLine(position.x - 55, position.y + 50, position.x - 25, position.y + 50);
        
        // secondary coil
        g2D.drawArc(position.x + 15, position.y - 30, 20, 20, 90, 180);
        g2D.drawArc(position.x + 15, position.y - 10, 20, 20, 90, 180);
        g2D.drawArc(position.x + 15, position.y + 10, 20, 20, 90, 180);
        // draws the lines to connect the coils
        g2D.drawLine(position.x + 25, position.y - 30, position.x + 25, position.y - 50);    
        g2D.drawLine(position.x + 25, position.y + 31, position.x + 25, position.y + 50);
        // connectors right
        g2D.drawLine(position.x + 25, position.y - 50, position.x + 55, position.y - 50);    
        g2D.drawLine(position.x + 25, position.y + 50, position.x + 55, position.y + 50);
        
        // iron core
        g2D.drawLine(position.x - 3, position.y - 45, position.x - 3, position.y + 45);
        g2D.drawLine(position.x + 6, position.y - 45, position.x + 6, position.y + 45);
    }

    @Override
    public String toString() {
        return "Transformator{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[4];
        points[0] = new Point(position.x - 55, position.y - 50);
        points[1] = new Point(position.x - 55, position.y + 50);
        points[2] = new Point(position.x + 55, position.y - 50);
        points[3] = new Point(position.x + 55, position.y + 50);
        return points;
    }
}
