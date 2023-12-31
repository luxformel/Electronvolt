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
import java.nio.file.Path;

/**
 *
 * @author luxformel
 */
public class Voltmeter extends Component{
    private Point position;
    
    public Voltmeter(Point position){
        super(position, "Voltmeter");
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
        // draws the circle
        g2D.drawOval(position.x - 25, position.y - 25, 50, 50);
        // draws the V
        Path2D.Double v = new Path2D.Double();
        v.moveTo(position.x - 7, position.y - 7);
        v.lineTo(position.x, position.y + 9);
        v.lineTo(position.x + 7, position.y - 7);
        g2D.draw(v);
        // draws the lines to connect the components
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(position.x, position.y - 25, position.x, position.y - 40);
        g2D.drawLine(position.x, position.y + 25, position.x, position.y + 40);
    }

    @Override
    public String toString() {
        return "Voltmeter{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[2];
        points[0] = new Point(position.x, position.y + 40);
        points[1] = new Point(position.x, position.y - 40);
        return points;
    }
}
