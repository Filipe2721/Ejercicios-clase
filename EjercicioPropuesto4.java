import java.io.*;
import java.util.*;
import java.util.Scanner;

public class EjercicioPropuesto4 {
    public static void main(String[] args) throws InterruptedException {

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

                    int contador=0;

                    while (lector.readLine() != null) {
                        contador++;
                    }

                    lector.close();

                    System.out.println(contador);

                    String[] lineas = new String[contador];

                    BufferedReader lectorInvertido = new BufferedReader(new FileReader("src/"+nombre));

                    int i = 0;

                    String linea;

                    while ((linea = lectorInvertido.readLine()) != null) {
                        lineas[i] = linea;
                        i++;
                    }
                    lectorInvertido.close();

                    System.out.println("Voy a escribir el archivo en orden inverso");

                    Thread.sleep(1000);

                    for (int j = lineas.length - 1; j >= 0; j--) {
                        System.out.println(lineas[j]);
                    }

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