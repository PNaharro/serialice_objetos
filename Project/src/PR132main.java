

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PR132main {
    public static void main(String args[]){
    String basePath = "Project/data/";
    String filePath = basePath + "PR132people.dat";
     try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

            PR132persona obj0 = new PR132persona("Maria", "López",36);
            PR132persona obj1 = new PR132persona("Gustavo", "Ponts",63);
            PR132persona obj2 = new PR132persona("Irene", "Sales",54);

			oos.writeObject(obj0);
            oos.writeObject(obj1);
            oos.writeObject(obj2);

			oos.close();
			fos.close();

            System.out.println("Llest");

		} catch (IOException e) { e.printStackTrace(); }



        System.out.println("");

		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

            PR132persona obj0 = (PR132persona) ois.readObject();
            PR132persona obj1 = (PR132persona) ois.readObject();
            PR132persona obj2 = (PR132persona) ois.readObject();

            System.out.println(obj0);
            System.out.println(obj1);
            System.out.println(obj2);

			ois.close();
			fis.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); }
    }
}