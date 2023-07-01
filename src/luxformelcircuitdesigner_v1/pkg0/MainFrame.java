/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;


import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *
 * @author luxformel
 */
public class MainFrame extends javax.swing.JFrame {
    
    private Components components = new Components();
    private ImageGenerator imagegenerator;
    private Point position;
    /**
     * Creates new form MainFrame
     */
    // Declares the tree view
    DefaultTreeModel model;
       
    public MainFrame() {
        initComponents();
        loadJTree();
        loadComboBox();
        System.out.println("Hello MainFrame!");
        drawPanel.setComponents(components);
        componentsList.setListData(components.toArray());
    }
    
    public void updateView(){
        componentsList.setListData(components.toArray());
        repaint();
    }
    
    public void loadComboBox(){
        UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        
        String name;
        String[] names = new String[lafInfo.length];
        for (int i = 0; i < lafInfo.length; i++) {
            name = lafInfo[i].getName();
            names[i] = name;
            System.out.println(name);
        }
        jThemeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }
    
    DefaultMutableTreeNode componentNode2 = new DefaultMutableTreeNode("Bauteile");
    
    public void loadJTree(){
        DefaultMutableTreeNode componentNode = new DefaultMutableTreeNode("Bauteile");
        componentNode.add(new DefaultMutableTreeNode("Widerstand"));
        componentNode.add(new DefaultMutableTreeNode("Diode"));
        componentNode.add(new DefaultMutableTreeNode("Spule"));
        componentNode.add(new DefaultMutableTreeNode("Kondensator"));
        componentNode.add(new DefaultMutableTreeNode("Transistor"));
        componentNode.add(new DefaultMutableTreeNode("Glühlampe"));
        
        
        DefaultMutableTreeNode switchesNode = new DefaultMutableTreeNode("Schalter");
        switchesNode.add(new DefaultMutableTreeNode("Schalter"));
        switchesNode.add(new DefaultMutableTreeNode("Umschalter"));
        
        DefaultMutableTreeNode powerSourceNode = new DefaultMutableTreeNode("Spannungsquellen");
        powerSourceNode.add(new DefaultMutableTreeNode("Batterie"));

        
        componentNode2.add(componentNode);
        componentNode2.add(switchesNode);
        componentNode2.add(powerSourceNode);
        
        
        model = (DefaultTreeModel)jTree.getModel();
        model.setRoot(componentNode2);
        jTree.setModel(model);
    }
    
    
    
    public void connectComponents(Point mousePosition1, Point mousePosition2){
        if (components != null) {
            
        }
    }
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        drawPanel = new luxformelcircuitdesigner_v1.pkg0.DrawPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        componentsList = new javax.swing.JList();
        jThemeComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        deleteSelectedComponentButton = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jFileMenu = new javax.swing.JMenu();
        jExportMenuItem = new javax.swing.JMenuItem();
        jDeleteAllMenuItem = new javax.swing.JMenuItem();
        jEditMenu = new javax.swing.JMenu();
        jHelpMenu = new javax.swing.JMenu();
        jHowToUseMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree);

        drawPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Luxformel Circuit Designer");

        componentsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(componentsList);

        jThemeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Windows", " " }));
        jThemeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemeComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Change Look and Feel:");

        deleteSelectedComponentButton.setText("Delete Selected Component");
        deleteSelectedComponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedComponentButtonActionPerformed(evt);
            }
        });

        jFileMenu.setText("File");
        jFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileMenuActionPerformed(evt);
            }
        });

        jExportMenuItem.setText("Export");
        jExportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExportMenuItemActionPerformed(evt);
            }
        });
        jFileMenu.add(jExportMenuItem);

        jDeleteAllMenuItem.setText("Delete All");
        jDeleteAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteAllMenuItemActionPerformed(evt);
            }
        });
        jFileMenu.add(jDeleteAllMenuItem);

        jMenuBar.add(jFileMenu);

        jEditMenu.setText("Edit");
        jMenuBar.add(jEditMenu);

        jHelpMenu.setText("Help");

        jHowToUseMenuItem.setText("How To Use");
        jHowToUseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHowToUseMenuItemActionPerformed(evt);
            }
        });
        jHelpMenu.add(jHowToUseMenuItem);

        jMenuBar.add(jHelpMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteSelectedComponentButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jThemeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGap(24, 24, 24)
                        .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(509, 509, 509)
                        .addComponent(jLabel1)
                        .addGap(0, 594, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jThemeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteSelectedComponentButton)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileMenuActionPerformed

    private void jExportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExportMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Save Your Circuit as .png");

        
        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                // Save button clicked without selecting a file
                String fileName = fileChooser.getSelectedFile().getName();
                File newFile = new File(fileChooser.getCurrentDirectory(), fileName);
                System.out.println("New file: " + newFile.getAbsolutePath());
                
                
                String path = selectedFile.getAbsolutePath() + ".png";
            
                imagegenerator = new ImageGenerator();
                imagegenerator.exportAsPNG(drawPanel, path);
            }
            
        }
        
    }//GEN-LAST:event_jExportMenuItemActionPerformed

    private void jDeleteAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteAllMenuItemActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(
                this, 
                "If You continue your sketch will be deleted!",
                "Confirm", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (response == JOptionPane.YES_OPTION) {
            components.clear();
        }
        updateView();
    }//GEN-LAST:event_jDeleteAllMenuItemActionPerformed

    private void drawPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawPanelMousePressed
        // TODO add your handling code here:
        int  X = evt.getX();
        int Y = evt.getY();
        
        int counter = 0;
        
        Point connection1 = null;
        Point connection2 = null;
        
        if (evt.getButton() == MouseEvent.BUTTON1) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();
            String selectedComponent = selectedNode.getUserObject().toString();

            position = new Point(X, Y);

            // switch statement to check what was selected
            switch (selectedComponent) {
                case "Widerstand":
                    components.add(new Resistor(position));
                    break;
                case "Spule":
                    components.add(new Inductor(position));
                    break;
                case "Kondensator":
                    components.add(new Capacitor(position));
                    break;
                case "Diode":
                    components.add(new Diode(position));
                    break;
                case "Transistor":
                    components.add(new Transistor(position));
                    break;  
                case "Glühlampe":
                    components.add(new LightBulb(position));
                    break;    
                case "Batterie":
                    components.add(new Battery(position));
                    break;
                default:
                    throw new AssertionError();
            }
        }else if (counter == 1 && evt.getButton() == MouseEvent.BUTTON2) {
            counter++;
            connection1 = new Point(X, Y);
        }else if(counter == 2 && evt.getButton() == MouseEvent.BUTTON2){
            counter++;            
            connection2 = new Point(X, Y);
        }else if(connection1 != null && connection2 != null && evt.getButton() == MouseEvent.BUTTON2){
            counter = 0;
        }
        updateView();
    }//GEN-LAST:event_drawPanelMousePressed

    private void jThemeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jThemeComboBoxActionPerformed
        // TODO add your handling code here:
        String lookAndFeelName =  String.valueOf(jThemeComboBox.getSelectedItem());
        System.out.println(lookAndFeelName);
            if (lookAndFeelName != null) {
                for (UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
                    if (lookAndFeelName.equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                            SwingUtilities.updateComponentTreeUI(this);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(LuxformelCircuitDesigner_v10.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }       
                }
            }
    }//GEN-LAST:event_jThemeComboBoxActionPerformed

    private void deleteSelectedComponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedComponentButtonActionPerformed
        // TODO add your handling code here:
        int index = componentsList.getSelectedIndex();
        if (index != -1) {
            Point position = components.get(index).getPosition();
            updateView();
        }
    }//GEN-LAST:event_deleteSelectedComponentButtonActionPerformed

    private void jHowToUseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHowToUseMenuItemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jHowToUseMenuItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList componentsList;
    private javax.swing.JButton deleteSelectedComponentButton;
    private luxformelcircuitdesigner_v1.pkg0.DrawPanel drawPanel;
    private javax.swing.JMenuItem jDeleteAllMenuItem;
    private javax.swing.JMenu jEditMenu;
    private javax.swing.JMenuItem jExportMenuItem;
    private javax.swing.JMenu jFileMenu;
    private javax.swing.JMenu jHelpMenu;
    private javax.swing.JMenuItem jHowToUseMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jThemeComboBox;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
