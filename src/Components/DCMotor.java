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
public class DCMotor extends Component{
    private Point position;
    
    public DCMotor(Point position){
        super(position, "Gleichstrom-Motor");
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
        // draws the M
        Path2D.Double m = new Path2D.Double();
        m.moveTo(position.x - 8, position.y + 10);
        m.lineTo(position.x - 8, position.y - 10);
        m.lineTo(position.x, position.y - 2);
        m.lineTo(position.x + 8, position.y - 10);
        m.lineTo(position.x + 8, position.y + 10);
        g2D.draw(m);
        // M vertical Lines
        //g2D.drawLine(position.x - 8, position.y - 10 ,position.x - 8, position.y + 10);
        //g2D.drawLine(position.x + 8, position.y - 10 ,position.x + 8, position.y + 10);
        // v of the M
        //g2D.drawLine(position.x - 8, position.y - 10 , position.x, position.y - 2);
        //g2D.drawLine(position.x, position.y - 2, position.x + 8, position.y - 10);
        // horizontal line under the M
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(position.x - 10, position.y + 15, position.x + 10, position.y + 15);
        // draws the lines to connect the components
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(position.x, position.y - 25, position.x, position.y - 40);
        g2D.drawLine(position.x, position.y + 25, position.x, position.y + 40);
    }

    @Override
    public String toString() {
        return "Gleichstrom-Motor{" + "position=" + position + '}';
    }
}
