/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

import java.util.Stack;

/**
 *
 * @author luxformel
 */
public class StackItems {
    private Stack <StackItem> stack = new Stack<StackItem>();
    
    public void push(StackItem item){
        stack.push(item);
    }
    public void pop(){
        if (!stack.empty()) {
            stack.pop();
        }
    }

    public Stack<StackItem> getRedoStack() {
        return stack;
    }

   
    public void clear(){
        stack.clear();
    }
}
