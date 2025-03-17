package Wordle;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //carga la lista de palabras desde archivo
        List<String> words = WordleFileManager.loadWordsFromFile("src/Wordle/palabras.txt");
        //Verifica si la lista esta vacia
        if (words.isEmpty()) {
            //Si no hay palabras, imprime un mensaje y termina la ejecucion
            System.out.println("No se encontraron palabras en el archivo.");
            return;
        }

        //Crea una instancia de WordleGame pasando la lista de palabras
        WordleGame game = new WordleGame(words);
        //LLama al metodo start() comenzando el juego
        game.start();

        //Llama a saveGameHistory para guardar el historial del juego en un archivo txt
        WordleFileManager.saveGameHistory("historial.txt", game.getTriesHistory());
    }
}
