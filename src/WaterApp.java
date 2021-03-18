package src;
// Java Program  to create a vertical  
// JSplitPane to separate two text areas 
import javax.swing.event.*; 
import java.awt.*; 
import javax.swing.*; 
class WaterApp extends JFrame { 
  
    // frame 
    static JFrame f; 
  
    // text areas 
    static JTextArea t1, t2; 
  
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
        f = new JFrame("frame"); 

  
        // create a object 
        WaterApp s = new WaterApp(); 
  
        // create a panel 
        JPanel p1 = new JPanel(); 
        JPanel p = new JPanel(); 
  
        // create text areas 
        t1 = new JTextArea(10, 10); 
        t2 = new JTextArea(10, 10); 
  
        // set texts 
        t1.setText("this is first text area"); 
        t2.setText("this is second text area"); 
  
        // add text area to panel 
        p1.add(t1); 
        p.add(t2); 
  
        // create a splitpane 
        JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, p1, p); 
  
        // set Orientation for slider 
        sl.setOrientation(SwingConstants.VERTICAL); 
  
        // add panel 
        f.add(sl); 
  
        // set the size of frame 
        f.setSize(300, 300); 
    
        f.show(); 

        
         f.setVisible(true);
    f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);


    } 
} 