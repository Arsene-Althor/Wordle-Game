package Wordle;

//Importar clases para el manejo de listas y aleatoriedad
import java.util.*;

public class WordleGame {
    //Atributos
    //Valores constantes para gestionar logica del juego
    private static final int MAX_TRIES = 6;
    private static final int WORD_LENGTH = 5;
    private final List<String> fileWords;
    private final String secretWord;
    private int remainingAttempts;
    private final List<String> triesHistory;

    //Constructor que inicializa la palabra secreta y los intentos
    public WordleGame(List<String> fileWords) {
        //Carga palabras desde el archivo
        this.fileWords = fileWords;
        //Llama a selectRandomWord para elegir una palabra aleatoria
        this.secretWord = selectRandomWord(fileWords);
        //Intentos restantes
        this.remainingAttempts = MAX_TRIES;
        //Historial de palabras del jugador
        this.triesHistory = new ArrayList<>();
    }

    //MEtodo para seleccionar palabra aleatoria
    private String selectRandomWord(List<String> words) {
        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

    //Metodo maneja logica principal del juego
    public void start() {
        //Pide al usuario una palabra
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Wordle! Tienes " + MAX_TRIES + " intentos.");

        //Bucle que permite al usuario jugar hasta agotar los intentos
        while (remainingAttempts > 0) {
            System.out.println("\nIntentos restantes: " + remainingAttempts);
            System.out.print("Introduce una palabra de " + WORD_LENGTH + " letras: ");

            //Llama a getUserInput para leer la entrada del usuario y validarla
            String guess = getUserInput(scanner);
            if (guess == null) {
                System.out.println("¡Has agotado tus intentos! La palabra secreta era: " + secretWord);
                break;
            }
            triesHistory.add(guess);
            if (guess.equals(secretWord)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + secretWord);
                break;
            } else {
                remainingAttempts--;
                System.out.println("Retroalimentación: " + WordleFeedback.feedBackString(guess, secretWord));
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("Lo siento, has perdido. La palabra era: " + secretWord);
        }

        scanner.close();
    }

    //Metodo para leer y validar la palabra del usuario
    private String getUserInput(Scanner scanner) {
        String input;
        int intentosRestantes = 6;

        while (intentosRestantes > 0) {
            input = scanner.next().toLowerCase();

            if (input.length() == WORD_LENGTH) {
                if (!fileWords.contains(input)) {
                    System.out.println("Palabra no está en la lista, pero aquí tienes una pista:");
                }
                return input;
            } else {
                System.out.println("Palabra invalida. Pistas:");
            }

            System.out.println(WordleFeedback.feedBackString(input, secretWord));
            intentosRestantes--;
            System.out.println("Intentos restantes para ingresar palabra válida: " + intentosRestantes);
        }

        return null;
    }

    //Devuelve el HIstorial de intentos
    public List<String> getTriesHistory() {
        return triesHistory;
    }
}

