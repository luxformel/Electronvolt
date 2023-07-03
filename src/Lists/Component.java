/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public abstract class Component {
    private Point position;
    private String typeOfComponent;

    public abstract Point getPosition();

    public abstract void setPosition(Point position);
    
    public Component(Point position, String typeOfComponent){
        this.position = position;
        this.typeOfComponent = typeOfComponent;   
    }

    public abstract void draw(Graphics g);

    @Override
    public abstract String toString();  
}
