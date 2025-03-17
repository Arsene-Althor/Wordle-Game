package Wordle;

//Importa Clase de manipulacion de archivos
import java.io.*;
import java.util.*;


//Declaro la clase WordleFileManager
public class WordleFileManager {

    //Metodo para leer las palabras del archivo
    public static List<String> loadWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();

        //Se usa BufferedReader para que lea linea por linea
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {

                //Se filtran 5 palabras y se guarda en la lista
                if (line.length() == 5) {
                    words.add(line.toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return words;
    }

    //Metodo que guarda el historial del juego
    public static void saveGameHistory(String filename, List<String> history) {

        //Se usa BufferedWriter para escribir los intentos en un archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (String attempt : history) {
                writer.write(attempt + "\n");
            }
            writer.write("---------\n");
        } catch (IOException e) {
            System.out.println("Error al guardar la partida: " + e.getMessage());
        }
    }
}
