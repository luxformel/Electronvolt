/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

/**
 *
 * @author luxformel
 */
public class StackItem {
    private boolean isComponent = false;
    private boolean isWire = false;
    private boolean isPointDecoration = false;
    private boolean isTwoPointDecoration = false;
    private Component component = null;
    private Wire wire = null;
    private PointDecoration pointDecoration = null;
    private TwoPointDecoration twoPointDecoration = null;

    public StackItem(Component component) {
        this.isComponent = true;
        this.component = component;
    }
    
    public StackItem(Wire wire) {
        this.isWire = true;
        this.wire = wire;
    }
    
     public StackItem(PointDecoration pointDecoration) {
        this.pointDecoration = pointDecoration;
        this.isPointDecoration = true;
    }
     public StackItem(TwoPointDecoration twoPointDecoration) {
        this.twoPointDecoration = twoPointDecoration;
        this.isTwoPointDecoration = true;
    }

    public boolean getIsComponent() {
        return isComponent;
    }

    public void setIsComponent(boolean isComponent) {
        this.isComponent = isComponent;
    }

    public boolean getIsWire() {
        return isWire;
    }

    public void setIsWire(boolean isWire) {
        this.isWire = isWire;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Wire getWire() {
        return wire;
    }

    public void setWire(Wire wire) {
        this.wire = wire;
    }

    public PointDecoration getPointDecoration() {
        return pointDecoration;
    }

    public boolean getIsPointDecoration() {
        return isPointDecoration;
    }
    public void setIsPointDecoration() {
        this.isPointDecoration = true;
    }

    public boolean getIsTwoPointDecoration() {
        return isTwoPointDecoration;
    }

    public TwoPointDecoration getTwoPointDecoration() {
        return twoPointDecoration;
    }
    
}
