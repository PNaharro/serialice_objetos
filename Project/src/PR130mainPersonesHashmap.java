
import java.util.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class PR130mainPersonesHashmap implements Serializable {
    private HashMap<String, Integer> personas = new HashMap<String, Integer>();
   
   

    public static void main(String args[]){
        PR130mainPersonesHashmap a = new PR130mainPersonesHashmap();
       
        a.personas.put("jose", 20);
        a.personas.put("marcos", 15);
        a.personas.put("luis", 30);
        a.personas.put("alva", 11);
        a.personas.put("juan", 25);

        a.mostrarAgenda();

    }
    public void mostrarAgenda(){
        String persons = "";
        File file = new File("Project/data/PR130persones.dat");
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;
        try {
            fileOutputStream=new FileOutputStream(file);
            dataOutputStream=new DataOutputStream(fileOutputStream);

            for(Iterator i=this.personas.keySet().iterator(); i.hasNext();){
                String k=(String)i.next();
                int v=(int)this.personas.get(k);
                persons  += "nom: "+k+ " Edad: " +v+"\n";
                }
            dataOutputStream.writeUTF(persons);
            dataOutputStream.flush();

            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);
            System.out.println(dataInputStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {


                if(fileOutputStream!=null){ fileOutputStream.close(); }
                if(dataOutputStream!=null){ dataOutputStream.close(); }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    }
}
