import java.io.*;
import java.util.Scanner;

public class EjercicioPropuesto3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscribe el nombre del fichero para mostrar su contenido:");

            String nombre = sc.nextLine();

            File fichero2 = new File("src/"+nombre);

            String rutaCarpeta = "src";

            File carpeta =new File(rutaCarpeta);

            File[] archivos = carpeta.listFiles();

            if (fichero2.exists()) {
                try (BufferedReader lector = new BufferedReader(new FileReader(fichero2))){

                    long lineas = lector.lines().count();

                    System.out.println(lineas);

                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
                break;
            }else{
                System.out.println("El archivo no se ha encontrado.\n");
                System.out.println("Estos son los archivos disponibles:\n");
                for (File archivo : archivos) {
                    System.out.println(archivo.getName());
                }
            }
        }
    }
}