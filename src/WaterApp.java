package src;


import javax.swing.event.*; 
import java.awt.*; 
import javax.swing.*; 
  

import java.awt.FlowLayout;  
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;  

import java.awt.event.*;  
import javax.swing.*;    

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WaterApp extends JFrame { 
  
    // frame 
    static JFrame f; 
  
    // text areas 
    static JTextArea t1, t2Input; 

     static String className=""; // file name has to match the class name the user wrote.

    //---------------------------------------------------------
    //
    //---------------------------------------------------------
    public static void readFile(String filePath){
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            t2Input.setText(""); 
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                
                t2Input.append(data+"\n"); 
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    //---------------------------------------------------------
    // read the output.txt file, which holds compiler&program output
    //---------------------------------------------------------
    public static void readOutputFile(){
        try {
            File myObj = new File("output.txt");
            Scanner myReader = new Scanner(myObj);
            t1.setText(""); 
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                t1.append(data+"\n"); 
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    //---------------------------------------------------------
    // saves the users-code to filePath
    //---------------------------------------------------------
    public static void saveFile(String filePath){

            try {
                FileWriter myWriter = new FileWriter(filePath);
                myWriter.write(t2Input.getText());
                myWriter.close();
                

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

    }   


    //---------------------------------------------------------
    // saves the code that user writes in the textbox
    //---------------------------------------------------------
    public static void saveCode(){

            try {
                FileWriter myWriter = new FileWriter("input.txt");
                
                // find class name that user wrote
                findClassName(t2Input.getText());


                myWriter.write(t2Input.getText());
                myWriter.close();
                

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

    }   


    //---------------------------------------------------------
    //
    //---------------------------------------------------------
 public static void findClassName( String code ) {
      // String to be scanned to find the pattern.
      String line =code;
      //class\s+(.*)\s+{
      String pattern = "class\\s+(.*)\\s+\\{";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group(1) ); // this is the class name that user wrote
         
         className=m.group(1);
      }else {
         System.out.println("NO MATCH");
      }
   }

    //---------------------------------------------------------
    //
    //---------------------------------------------------------
     public static void createFile(String newFileName,String folderName) {
        try {
          File myObj = new File(folderName+"//"+newFileName);
          File myFolder = new File(folderName);
          myFolder.mkdirs();
          if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("FILE NOT CREATED ->An error occurred.");
          e.printStackTrace();
        }
    }

    //---------------------------------------------------------
    //
    //---------------------------------------------------------
    public static void runScript(){

         //TODO copy to folder with cutomName
        String folder = "live\\src\\";
        String file= className+".java";
        String target = folder+file;
        createFile(file,"live\\src");
        saveFile(target);
            


                 Runtime run = Runtime.getRuntime();  
        //The best possible I found is to construct a command which you want to execute  
        //as a string and use that in exec. If the batch file takes command line arguments  
        //the command can be constructed a array of strings and pass the array as input to  
        //the exec method. The command can also be passed externally as input to the method.  

        Process p = null;  
        String cmd = "C:\\Users\\marc\\Desktop\\ide\\hello.cmd "+className;  
        try {  
            p = run.exec(cmd);  
            p.getErrorStream();  
            
        }  
        catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("ERROR.RUNNING.CMD");  
            p.destroy();  
        }  
       

    }


    //---------------------------------------------------------
    //
    //---------------------------------------------------------
    public static void refreshOutput() throws Exception{
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
                readOutputFile();
                System.out.println("Reading SMTP Info.");
            }
        };
        Timer timer = new Timer(100 ,taskPerformer);
        timer.setRepeats(true);
        timer.start();

        Thread.sleep(5000);
    }


    //---------------------------------------------------------
    //
    //---------------------------------------------------------
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
        t1 = new JTextArea(40, 20); 
        t2Input = new JTextArea(40, 50); 

  JScrollPane sp1 = new JScrollPane(t1); 
  JScrollPane sp2 = new JScrollPane(t2Input); 
  
        // set texts 
        t1.setText("!"); 
        t2Input.setText(" !"); 

        //add button
       
          JButton b=new JButton("RUN");  
    b.setBounds(50,100,95,30);  
    b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                                   // tf.setText("Welcome to Javatpoint.");  
                            
                                    saveCode();
                                    runScript();
                                    readOutputFile();
                                    
                                }    
        });  


           JButton buttonRefresh=new JButton("revert");  
    buttonRefresh.setBounds(50,100,95,30);  
    buttonRefresh.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                                   // tf.setText("Welcome to Javatpoint.");  
                                    
                                }    
        }); 


               JButton buttonReadOutput=new JButton("otuput.txt");  
    buttonReadOutput.setBounds(50,100,95,30);  
    buttonReadOutput.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                                   // tf.setText("Welcome to Javatpoint.");  
                                    
                                    readOutputFile();
                                }    
        }); 

    // make drop down menu
    String[] petStrings = "a,b".split(",");

    //Create the combo box, select item at index 4.
    //Indices start at 0, so 4 specifies the pig.
    JComboBox petList = new JComboBox(petStrings);
    petList.setSelectedIndex(0);
    //petList.addActionListener(this);
  
        // add text area to panel -----------------
        p1.add(sp1); 
        p1.add(b);
        p1.add(buttonRefresh);
        p1.add(buttonReadOutput);
        p.add(sp2); 
        p.add(petList); 
  
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


        
        
        String target2="study_material\\hardcoded.java";
        //readFile("output.txt");
        readFile(target2);
        saveFile("input.txt");

       try{
        refreshOutput();
        }catch(Exception  e){

        }
    } 
} 