package Wordle;

//Estas son constantes ANSI que agrega colores en la consola
public class WordleFeedback {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GRAY = "\u001B[37m";

    //Este metodo da una retroalimentación comparando la palabra ingresada (guess) con la palabra secreta (secretWord)
    public static String feedBackString(String guess, String secretWord) {

        //Se usa el StringBuilder para construir la cadena de retroalimentación mas eficiente
        StringBuilder feedback = new StringBuilder();

        //Recorre letra por letra la palabra ingresada
        for (int i = 0; i < guess.length(); i++) {

            //Obtiene la letra en la posicion (i)
            char letter = guess.charAt(i);

            //Se comparan las letras con la palabra secreta

            //Cambia la letra en la posicion correcta a verde
            if (i < secretWord.length() && letter == secretWord.charAt(i)) {
                feedback.append(ANSI_GREEN).append(letter).append(ANSI_RESET);
            //Cambia al color amarillo
            } else if (secretWord.contains(Character.toString(letter))) {
                feedback.append(ANSI_YELLOW).append(letter).append(ANSI_RESET);
            //Cambia a gris si no esta la letra
            } else {
                feedback.append(ANSI_GRAY).append(letter).append(ANSI_RESET);
            }
        }
        //Devuelve la cadena generada con los colores aplicados
        return feedback.toString();
    }
}
