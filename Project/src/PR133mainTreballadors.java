

import java.io.File;
import java.util.*;

public class PR133mainTreballadors {
     public static void main(String args[]){
        String noms = " 1) Nom 2) Cognom 3) Departament 4) Salari 5) salir";
        String filePath = "Project/data/PR133treballadors.csv";
        System.out.println("");
        List<String> csv = UtilsCSV.read(filePath);
        String[] columnes = UtilsCSV.getKeys(csv);
        UtilsCSV.list(csv);
        String[] dadesTitol = UtilsCSV.getColumnData(csv, "Id");
        dadesTitol = Arrays.copyOfRange(dadesTitol, 1, dadesTitol.length); // Treu el primer element, que és el nom de la columna
        System.out.println("Els títols de l'arxiu són: " + Arrays.toString(dadesTitol));

        Scanner scanner = new Scanner(System.in);
        while (true){
        int opcion,opc,pos,dato_num;
        String dato;
        System.out.println("escribe una opcion(escriba 0 para salir): ");
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
           
            for (int i =0; i<dadesTitol.length;i++){

                int datos = Integer. parseInt(dadesTitol[i]);
                if (datos == opcion ){
                    Boolean select = true;
                    String id = ""+opcion;
                    System.out.println(id);
                    int numLinia = UtilsCSV.getLineNumber(csv, "Id", id);
                    String strLinia = csv.get(numLinia);
                    String[] arr = UtilsCSV.getLineArray(strLinia);
                    while(select){
                    System.out.println("escribe un para metro a cambiar de los siguente\n"+noms);
                    if (scanner.hasNextInt()) {
                        opc = scanner.nextInt();
                        switch(opc){
                            case 1:
                                scanner.nextLine();
                                pos = UtilsCSV.csvGetColumnPosition(csv, "Nom");
                                System.out.println("introduce nombre");
                                dato = scanner.nextLine();
                                UtilsCSV.update(csv, numLinia, "Nom", dato);
                                UtilsCSV.write(filePath, csv);
                                break;
                            
                              
                            case 2:
                                scanner.nextLine();
                                pos = UtilsCSV.csvGetColumnPosition(csv, "Cognom");
                                System.out.println("introduce Cognom");
                                dato = scanner.nextLine();
                                UtilsCSV.update(csv, numLinia, "Cognom", dato);
                                UtilsCSV.write(filePath, csv);
                                break;
                            case 3:
                                scanner.nextLine();
                                pos = UtilsCSV.csvGetColumnPosition(csv, "Departament");
                                
                                while(true){
                                    System.out.println("introduce Departament");
                                  if (scanner.hasNextInt()) {
                                         dato_num = scanner.nextInt();
                                         break;
                                     }else {
                                        System.out.println("Entrada no válida. Debes ingresar un número entero.");
                                        scanner.nextLine(); // Consumir la entrada no válida
                                        }}


                                UtilsCSV.update(csv, numLinia, "Departament", Integer.toString(dato_num));
                                UtilsCSV.write(filePath, csv);
                                break;
                            case 4:
                               scanner.nextLine();
                               pos = UtilsCSV.csvGetColumnPosition(csv, "Salari");
                                  while(true){
                                    System.out.println("introduce Salari");
                                  if (scanner.hasNextInt()) {
                                         dato_num = scanner.nextInt();
                                         break;
                                     }else {
                                        System.out.println("Entrada no válida. Debes ingresar un número entero.");
                                        scanner.nextLine(); // Consumir la entrada no válida
                                        }}
                                 
                                UtilsCSV.update(csv, numLinia, "Salari", Integer.toString(dato_num));
                                UtilsCSV.write(filePath, csv);
                                break;
                            case 5:select= false;

                    
                    }
                    }else {
                        System.out.println("Entrada no válida. Debes ingresar un número entero.");
                        scanner.nextLine(); // Consumir la entrada no válida
                        }
                }
            }
            }   
        if (opcion==0){
            System.exit(0);
        }
            
        
        
        
        } else {
                System.out.println("Entrada no válida. Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la entrada no válida
            }}
}
}
