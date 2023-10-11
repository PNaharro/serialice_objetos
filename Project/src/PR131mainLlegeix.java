

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PR131mainLlegeix {
    public static void main(String args[]){
        File file = new File("Project/data/PR131HashMapData.ser");

        FileInputStream fileInputStream = null;
        DataInputStream dataInputStream = null;
        try {
        fileInputStream = new FileInputStream(file);
        dataInputStream = new DataInputStream(fileInputStream);
        System.out.println(dataInputStream.readUTF());
        } catch (IOException e) {
        e.printStackTrace();
        }finally {
        try {
            if(fileInputStream!=null){ fileInputStream.close(); }
            if(dataInputStream!=null){ dataInputStream.close(); }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

}
}
