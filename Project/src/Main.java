import java.io.IOException;
import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in); // System.in és global, Scanner també ho a de ser

    // Main
    public static void main(String[] args) throws InterruptedException, IOException {
        
        boolean running = true;

        while (running) {

            String menu = "Escull una opció:";
            menu = menu + "\n 0) PR130mainPersonesHashmap";
            menu = menu + "\n 1) PR131mainEscriu";
            menu = menu + "\n 2) PR131mainLlegeix";
            menu = menu + "\n 3) PR132main";
            menu = menu + "\n 4) PR133mainTreballadors";
            menu = menu + "\n 5) PR133mainTreballadors";
            menu = menu + "\n 6) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            
            try {
                switch (opcio) {
                    case 0: PR130mainPersonesHashmap.main(args);                break;
                    case 1: PR131mainEscriu.main(args);       break;
                    case 2: PR131mainLlegeix.main(args);         break;
                    case 3: PR132main.main(args);         break;
                    case 4: PR133mainTreballadors.main(args);            break;
                    case 5: PR134.main(args);            break;
                    case 6: running = false;                       break;
                    default: break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

		in.close();
    }

    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
    }
}