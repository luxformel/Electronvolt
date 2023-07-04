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

/**
 *
 * @author luxformel
 */
public class Highpass extends Component{
    private Point position;
    
    public Highpass(Point position){
        super(position, "Hochpass");
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
            // draws the body highpass
            g2D.drawRect(position.x - 40, position.y - 40, 80, 80);
            // draws the lines to connect the components
            g2D.drawLine(position.x, position.y - 40, position.x, position.y - 60);    
            g2D.drawLine(position.x, position.y + 40, position.x, position.y + 60);
            // draws the waves
            g2D.drawArc(position.x - 20, position.y + 5, 20, 17, 0, 180);
            g2D.drawArc(position.x, position.y + 5, 20, 17, 180, 180);
            
            g2D.drawArc(position.x - 20, position.y - 15, 20, 17, 0, 180);
            g2D.drawArc(position.x, position.y - 15, 20, 17, 180, 180);
            // draws the diagonal line
            g2D.drawLine(position.x + 5, position.y + 8, position.x - 5, position.y + 18);
    }

    @Override
    public String toString() {
        return "Hochpass{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[2];
        points[0] = new Point(position.x, position.y + 60);
        points[1] = new Point(position.x, position.y - 60);
        return points;
    }
}
