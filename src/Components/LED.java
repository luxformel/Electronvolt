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
public class LED extends Component{
    private Point position;
    
    public LED(Point position){
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
    @Override
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
        // base
        //g2D.drawLine(position.x - 15, position.y + 20, position.x + 15, position.y + 20);
        // sides
        //g2D.drawLine( position.x, position.y - 20, position.x + 20, position.y + 20);
        //g2D.drawLine(position.x - 20, position.y + 20, position.x, position.y - 20);        
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 40, position.x, position.y + 40);
        //g2D.drawLine(position.x, position.y + 20, position.x, position.y + 40);
        
        // LED arrows
        // bottom line
        g2D.drawLine(position.x + 25, position.y + 10, position.x + 37, position.y);
        // top line
        g2D.drawLine(position.x + 15, position.y, position.x + 27, position.y - 10);
        
        // LED arrows triangles
        // lower triangle
        int number = -1;
        int[] xPoints2 = {position.x + 28 - number, position.x + 37 - number, position.x + 35 - number};
        int[] yPoints2 = {position.y - 1 - number, position.y - 2 - number, position.y + 5 - number};
        g2D.drawPolygon(xPoints2, yPoints2, 3);
        
        // upper triangle
        int number2 = 10;
        int[] xPoints3 = {position.x + 28 + 5 - number2, position.x + 37 + 5 - number2, position.x + 35 + 5 - number2};
        int[] yPoints3 = {position.y - 1 - number2, position.y - 2 - number2, position.y + 5 - number2};
        g2D.drawPolygon(xPoints3, yPoints3, 3);
    }

    @Override
    public String toString() {
        return "LED{" + "position=" + position + '}';
    }

   @Override
    public Point[] getConnectionPoints() {
        Point[] points = new Point[2];
        points[0] = new Point(position.x, position.y + 40);
        points[1] = new Point(position.x, position.y - 40);
        return points;
    }
}
