/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public class Diode extends Component{
     private Point position;
    
    public Diode(Point position){
        super(position, "Diode");
        this.position = position;
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
        // stopping line
        g2D.drawLine(position.x - 10, position.y - 10, position.x + 10, position.y - 10);
        //draws the triangle
        // base
        g2D.drawLine(position.x - 10, position.y + 10, position.x + 10, position.y + 10);
        // sides
        //g.drawLine(position.x - 20, position.y + 20, position.x + 20, position.y + 20);
        g2D.drawLine( position.x, position.y - 10, position.x + 10, position.y + 10);
        g2D.drawLine(position.x - 10, position.y + 10, position.x, position.y - 10);        
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 10, position.x, position.y - 20);
        g2D.drawLine(position.x, position.y + 10, position.x, position.y + 20);
    }

    @Override
    public String toString() {
        return "Diode{" + "position=" + position + '}';
    }
    
    
}
