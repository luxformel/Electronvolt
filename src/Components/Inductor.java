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
public class Inductor extends Component{
    private Point position;
    
    public Inductor(Point position){
        super(position, "Spule");
         this.position = position;
         
         // creates the connector points
        Point connection1 = new Point(position.x, position.y + 50);
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
        // draws the body of the inductor
        //g.drawRect(position.x - 10, position.y - 30, 21, 61);
        g2D.drawArc(position.x - 10, position.y - 30, 20, 20, 90, 180);
        g2D.drawArc(position.x - 10, position.y - 10, 20, 20, 90, 180);
        g2D.drawArc(position.x - 10, position.y + 10, 20, 20, 90, 180);
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 30, position.x, position.y - 50);    
        g2D.drawLine(position.x, position.y + 31, position.x, position.y + 50);
    }

    @Override
    public String toString() {
        return "Spule{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[2];
        points[0] = new Point(position.x, position.y + 50);
        points[1] = new Point(position.x, position.y - 50);
        return points;
    }
    
}
