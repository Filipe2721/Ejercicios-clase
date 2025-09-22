import java.io.*;
import java.util.*;

public class EjercicioPropuesto1 {
    public static void main(String[] args) {

        File fichero = new File("src/Archivos/fichero.txt");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Escribe una frase o escribe salir para salir");

            String frase = sc.nextLine();

            if (frase.equals("salir") || frase.equals("Salir")) {
                System.out.println("Saliendo...");
                break;
            }

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero, true))) {
                escritor.write(frase);
                escritor.newLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}