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
public class Resistor extends Component{
    private Point position;
    private Point[] connection = new Point[2];
    
    
    
    public Resistor(Point position){
        super(position, "Resistor");
        this.position = position;  
        
        connection[0] = new Point(position.x, position.y - 50);
        connection[1] = new Point(position.x, position.y + 50);
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
            // draws the body of the resistor
            g2D.drawRect(position.x - 10, position.y - 30, 21, 61);
            // draws the lines to connect the components
            g2D.drawLine(position.x, position.y - 30, position.x, position.y - 50);    
            g2D.drawLine(position.x, position.y + 31, position.x, position.y + 50);
    }

    @Override
    public String toString() {
        return "Resistor{" + "position=" + position + '}';
    }
    
}
