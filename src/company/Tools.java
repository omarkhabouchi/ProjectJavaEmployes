package company;


import java.awt.AWTException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tools {

  public static void MsgBox( String message){
    JOptionPane.showMessageDialog(null , message);
  } 

  public static boolean confirmMsg(String message){
   int msgC = JOptionPane.showConfirmDialog(null, message);
   if(msgC == JOptionPane.YES_OPTION){
      return true;
   }
   else{
    return  false ;
   }
  }
  
public static  void CreateFolder(String FolderName , String path){
    
    File f = new File(path + FolderName);
    f.mkdir();  
}

public static  void CreateFolder(String FolderName ){
    
    File f = new File(FolderName);
    f.mkdir();  
}


    

  public static void openForme(JFrame form){
 
    try {
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        Image img = ImageIO.read(Tools.class.getResource("image.png"));
        form.setIconImage(img);
    } catch (IOException ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
   
   public static void clearText(Container form){
    for(Component c : form.getComponents()){
            if(c instanceof JTextField){
                  JTextField txt = (JTextField)c;
                  txt.setText("");
            }else if(c instanceof Container){
                clearText((Container)c);
            }
         }
   }
   
   public static void CreateEmptytFile(String FileName){
      try {
       File f = new File(FileName + ".txt");
        f.createNewFile();
    } catch (IOException ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
    public static void CreateEmptytFiles(String FileNames[]){
         
         for( String Fnames:FileNames){
              CreateEmptytFile(Fnames);
         }
    }
   
   public static void createFile(String FileName, Object data[]){
   
    try {
        PrintWriter p = new PrintWriter(FileName + ".txt");
        for(Object obj : data){
        p.println(obj);
        }
        p.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
    public static void createFiles(String FileNames[], Object AllData[][]){
           for(int i=0;i<FileNames.length;i++){
         createFile(FileNames[i], AllData[i]);
     }
     
     }
   
   public static Object Inputbox(String title){
      Object myobj = JOptionPane.showInputDialog(title);
      return myobj;
   }
   
   public static String getNumber(String text){
        String val =" ";
     for(char c : text.toCharArray()){
        if(c == '0' || c == '1'|| c == '2' || c == '3'|| c == '4' || c=='6'|| c == '5'|| c == '7' || c == '8'|| c == '9'){
             val += c;
     }
     }
     return val;
   }
   
 public static int getNumberToInteger(Object text){
        String val =" ";
     for(char c : text.toString().toCharArray()){
        if(c == '0' || c == '1'|| c == '2' || c == '3'|| c == '4' || c == '5'||c=='6'|| c == '7' || c == '8'|| c == '9'){
             val += c;
     }
     }
     return Integer.parseInt(val);
   }

    public static String removeNumber(String text){
        String val =" ";
     for(char c : text.toCharArray()){
        if(!(c == '0' || c == '1'|| c == '2' || c == '3'|| c == '4' || c=='6'|| c == '5'|| c == '7' || c == '8'|| c == '9')){
             val += c;
     }
     }
     return val;
   }
 
   public static String getstring(String str){
     String val ="";
      for(char c : str.toCharArray()){
        if(!(c == '0' || c == '1'|| c == '2' || c == '3'|| c == '4' || c == '5'|| c == '6' || c == '7' || c == '8'|| c == '9'))
        {
            val += c; 
        }
       
       }
       return val;
       
   }
   

   
  
   public static void PrintScreen(String ImageName , JFrame form  ){
       
    try {
        form.setState(1);
        Robot r = new Robot();
     
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage img = r.createScreenCapture(rec);
    
        ImageIO.write(img, "jpg",new File(ImageName + ".jpg"));
        form.setState(0);
        
    }
    catch (Exception ex) {
        Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
    }
   } 
   
   
   
    public static void PrintScreen(String ImageName ){
            try {
        Robot r = new Robot();
        Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage img = r.createScreenCapture(rec);
        ImageIO.write(img, "jpg",new File(ImageName + ".jpg"));
       } 
            catch (Exception ex) 
       {
           MsgBox(ex.getMessage());
            }
   
   }
  

    public static  class StringTools {
      String text;
     private static String inversetext;
     public static void printcharBychar(String text){
      for(char c : text.toCharArray()){
          System.out.println(c);
      }
     }
     
        public static void printcharBycharInverse(String text){
          StringBuilder sb = new  StringBuilder(text);
          inversetext = sb.reverse().toString();
          for(char c: inversetext.toCharArray()){
              System.out.println(c);
          }
        }
    }

public class Table {
  public int columns;
  public Object[][] Items;

  public Table(int columns){
   this.columns = columns;
   Items = new Object[0][columns];
  }

  public void addNewRow(Object row[]){
   Object TempItems[][] = Items;
   Items = new Object[Items.length + 1][columns];
    for(int x=0; x< TempItems.length; x++) {
        Items[x] = TempItems[x];
   }
   Items[Items.length-1] = row;
  }

  public void printItems(){
  for(Object objs[] : Items){
    for(Object obj : objs){
        System.out.println(obj + " ; ");
    }
  }
  }

  public void editRow(int rowIndex, int columnIndex, Object newData){
    Items[rowIndex][columnIndex] = newData;
  }
}

public class MergeArray{
  
    public Object[] array1;
    public Object[] array2;
    
    public MergeArray(Object[] array1, Object[] array2){
      this.array1 = array1;
      this.array2 = array2;
    }

    public Object[] mergeTowArrays(){
    
      int a1 = array1.length;
      int a2 = array2.length;
      Object[] arrayR = new Object[a1 + a2];
        System.arraycopy(array1, 0, arrayR, 0, a1);
        System.arraycopy(array2, 0, arrayR, a1, a2);
        return arrayR;
    }
   
}
}
    




        
        
  


  
  
  
  
  

