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
import java.awt.geom.Path2D;

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
        Path2D.Double diagonalLine = new Path2D.Double();
        diagonalLine.moveTo(position.x + 30, position.y - 50);
        diagonalLine.lineTo(position.x + 30, position.y - 40);
        diagonalLine.lineTo(position.x, position.y - 5);
        diagonalLine.lineTo(position.x, position.y + 5);
        diagonalLine.lineTo(position.x + 30, position.y + 40);
        diagonalLine.lineTo(position.x + 30, position.y + 50);
        g2D.draw(diagonalLine);
        // triangle
        int[] xPoints = {position.x + 10, position.x + 20, position.x + 20};
        int[] yPoints = {position.y + 30, position.y + 20, position.y + 30};
        g2D.drawPolygon(xPoints, yPoints, 3);
        
    }

    @Override
    public String toString() {
        return "Transistor{" + "position=" + position + '}';
    }
    @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[3];
        points[0] = new Point(position.x - 30, position.y);
        points[1] = new Point(position.x + 30, position.y - 50);
        points[2] = new Point(position.x + 30, position.y + 50);
        return points;
    }
    
}
