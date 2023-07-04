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
public class Connector extends Component{
    private Point position;
    
    public Connector(Point position){
        super(position, "Switch");
        this.position = position;
        
        // creates the connector points
        Point connection1 = new Point(position.x + 30, position.y);
        
        // add the connector Points to the list
        ConnectionPoints.add(connection1);
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
        g2D.drawLine(position.x, position.y, position.x + 30, position.y);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawOval(position.x - 10, position.y - 4, 8, 8);
    }

    @Override
    public String toString() {
        return "Schalter{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[1];
        points[0] = new Point(position.x, position.y + 30);
        return points;
    }}
