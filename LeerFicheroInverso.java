import java.io.*;
import java.util.Scanner;

public class LeerFicheroInverso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir el nombre del fichero
        System.out.print("Introduce el nombre del fichero de texto: ");
        String nombreFichero = sc.nextLine();

        try {
            // 1ª pasada: contar las líneas
            BufferedReader br = new BufferedReader(new FileReader("src/"+nombreFichero));
            int contador = 0;
            while (br.readLine() != null) {
                contador++;
            }
            br.close();

            System.out.println("\nEl fichero tiene " + contador + " líneas.\n");

            // Crear el array con el número exacto de líneas
            String[] lineas = new String[contador];

            // 2ª pasada: guardar las líneas en el array
            br = new BufferedReader(new FileReader("src/"+nombreFichero));
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                lineas[i] = linea;
                i++;
            }
            br.close();

            // Mostrar en orden inverso
            System.out.println("Contenido en orden inverso:\n");
            for (int j = lineas.length - 1; j >= 0; j--) {
                System.out.println(lineas[j]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Error: el fichero no existe.");
        } catch (IOException e) {
            System.out.println("❌ Error al leer el fichero.");
        }
    }
}
