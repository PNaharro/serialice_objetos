

import java.util.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PR131mainEscriu {
    public static void main(String args[]){
        PR131hashmap a = new PR131hashmap();
        a.personas.put("jose", 20);
        a.personas.put("marcos", 15);
        a.personas.put("luis", 30);
        a.personas.put("alva", 11);
        a.personas.put("juan", 25);     
        String persons = "";
        File file = new File("Project/data/PR131HashMapData.ser");
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            fileOutputStream=new FileOutputStream(file);
            dataOutputStream=new DataOutputStream(fileOutputStream);

            for(Iterator i=a.personas.keySet().iterator(); i.hasNext();){
                String k=(String)i.next();
                int v=(int)a.personas.get(k);
                persons  += "nom: "+k+ " Edad: " +v+"\n";
                }
            dataOutputStream.writeUTF(persons);
            dataOutputStream.flush();

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
