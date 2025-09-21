import java.io.*;
import java.util.*;
import java.util.*;

public class EjercicioPropuesto5 {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscribe un nombre del fichero para guardar su contenido invertido:");

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


                    String[] lineas = new String[contador];

                    BufferedReader lectorInvertido = new BufferedReader(new FileReader("src/"+nombre));

                    int i = 0;

                    String linea;

                    File salida = new File("src/salida.txt");

                    BufferedWriter escritor = new BufferedWriter(new FileWriter(salida));

                    while ((linea = lectorInvertido.readLine()) != null) {
                        lineas[i] = linea;
                        i++;
                    }

                    for (int j = lineas.length - 1; j >= 0; j--) {
                        escritor.write(lineas[j]);
                        escritor.newLine();
                    }
                    escritor.close();

                    System.out.println("Fichero escrito inversamente finalzado con exito.");

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