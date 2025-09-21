import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioPropuesto2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        File fichero2 = new File("src/Archivos/Libro");

        while (fichero2.exists()) {
            System.out.println("Escribe el nombre del fichero de texto para mostrar su contenido");

            String nombre = sc.nextLine();

            if (nombre.equals("Libro")) {
                try (BufferedReader lector = new BufferedReader(new FileReader(fichero2))){

                    String linea;

                    int contador=0;

                    while ((linea = lector.readLine()) != null) {
                        System.out.println(linea);
                        contador++;
                        if (contador == 25) {
                            System.out.println("\nPresiona enter para continuar\n");

                            String pausa = sc.nextLine();

                            contador=0;
                        }
                    }
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
            break;
        }
    }
}