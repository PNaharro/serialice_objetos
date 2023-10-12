import java.io.RandomAccessFile;
import java.io.IOException;

public class PR134 {
    private static final int ID_SIZE = 4; // Tamaño en bytes para el número de registro (entero).
    private static final int CHAR_SIZE = 2; // Tamaño en bytes por carácter en UTF-16.
    private static final int NAME_SIZE = 20; // Longitud máxima en caracteres para el nombre.
    private static final int NOTA_SIZE = 4; // Tamaño en bytes para la nota (float).

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("Project\\data\\estudiants.dat", "rw")) {
            // Agregar estudiantes
            afegirEstudiant(raf, 1, "Juan Pérez", 8.5f);
            afegirEstudiant(raf, 2, "María López", 7.2f);

            // Consultar y mostrar las notas de estudiantes agregados
            mostrarEstudiant(raf, 1, "Original");
            mostrarEstudiant(raf, 2, "Original");

            // Actualizar las notas de estudiantes
            actualitzarNotaEstudiant(raf, 1, 9.0f);
            actualitzarNotaEstudiant(raf, 2, 7.8f);

            // Consultar y mostrar las notas actualizadas de estudiantes
            mostrarEstudiant(raf, 1, "Actualitzat");
            mostrarEstudiant(raf, 2, "Actualitzat");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void afegirEstudiant(RandomAccessFile raf, int id, String nom, float nota) throws Exception {
        raf.seek(raf.length());
        raf.writeInt(id);
        raf.writeChars(getPaddedName(nom));
        raf.writeFloat(nota);
    }

    public static void mostrarEstudiant(RandomAccessFile raf, int id, String msg) throws Exception {
        raf.seek(getSeekPosition(id));
        int numeroRegistre = raf.readInt();
        String nom = readPaddedName(raf);
        float nota = raf.readFloat();
        System.out.println(msg + " " + id + ": Número de Registro: " + numeroRegistre + ", Nombre: " + nom + ", Nota: " + nota);
    }

    public static void actualitzarNotaEstudiant(RandomAccessFile raf, int id, float novaNota) throws Exception {
        raf.seek(getSeekPosition(id) + ID_SIZE + NAME_SIZE * CHAR_SIZE);
        raf.writeFloat(novaNota);
    }

    private static long getSeekPosition(int id) {
        return (id - 1) * (ID_SIZE + NAME_SIZE * CHAR_SIZE + NOTA_SIZE);
    }

    private static String getPaddedName(String name) {
        if (name.length() > NAME_SIZE) {
            return name.substring(0, NAME_SIZE);
        }
        return String.format("%1$-" + NAME_SIZE + "s", name);
    }

    private static String readPaddedName(RandomAccessFile raf) throws IOException {
        char[] chars = new char[NAME_SIZE];
        for (int i = 0; i < NAME_SIZE; i++) {
            chars[i] = raf.readChar();
        }
        return new String(chars).trim();
    }
}
