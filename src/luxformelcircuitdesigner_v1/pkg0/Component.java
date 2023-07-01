/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public class Component {
    private Point position;
    private String typeOfComponent;

    //private int numberOfProngs;

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
    public Component(Point position, String typeOfComponent){
        this.position = position;
        this.typeOfComponent = typeOfComponent;   
    }

    //may not be needed
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, position.x, position.y);
        g.drawString("No valid component", 50, 50);
    }


    @Override
    public String toString() {
        return "Component{" + "position=" + position + '}';
    }
    
    
}
