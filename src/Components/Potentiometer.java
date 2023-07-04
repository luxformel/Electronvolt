/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import Lists.Component;
import Lists.ConnectionPoints;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

/**
 *
 * @author luxformel
 */
public class Potentiometer extends Component{
    private Point position;
    
    public Potentiometer(Point position){
        super(position, "Potentiometer");
        this.position = position;  
        
        // creates the connector points
        Point connection1 = new Point(position.x, position.y + 60);
        Point connection2 = new Point(position.x, position.y - 50);
        
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
            // draws the body of the resistor
            g2D.drawRect(position.x - 10, position.y - 30, 21, 61);
            // draws the lines to connect the components
            g2D.drawLine(position.x, position.y - 30, position.x, position.y - 50);    
            g2D.drawLine(position.x, position.y + 31, position.x, position.y + 60);
            // potentiometer line
            Path2D.Double arrow = new Path2D.Double();
            arrow.moveTo(position.x, position.y + 40);
            arrow.lineTo(position.x - 10, position.y + 40);
            arrow.lineTo(position.x - 25, position.y + 40);
            arrow.lineTo(position.x - 25, position.y);
            arrow.lineTo(position.x + 25, position.y - 30);
            g2D.draw(arrow);
            int[] xPoints3 = {position.x + 32, position.x + 34, position.x + 25};
            int[] yPoints3 = {position.y - 27, position.y - 35, position.y - 35};
            g2D.drawPolygon(xPoints3, yPoints3, 3);
    }

    @Override
    public String toString() {
        return "Potentiometer{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[2];
        points[0] = new Point(position.x, position.y + 60);
        points[1] = new Point(position.x, position.y - 50);
        return points;
    }
}
