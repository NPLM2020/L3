import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        playGuessWord();
    }

    /**
     * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     * "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
     * "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно, можно пользоваться:
     * String str = "apple";
     * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово
     * Используем только маленькие буквы
     */
    static void playGuessWord() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        boolean cycle = true;
        String myWord;
        String prompt;
        char letter;
        int maxLength = 15;

        System.out.println("\nGame \"Guess the word\". Let's start!\n");

        String word = makeWord(words);

        System.out.println("I made a word. Guess it!");

        while (cycle) {
            prompt = "";

            System.out.println("Enter the word:");
            myWord = scanner.next().toLowerCase();

            if (!word.equals(myWord)) {
                for (int i = 0; i < word.length(); i++) {
                    letter = '#';
                    if (myWord.length() >= i + 1 &&
                            word.charAt(i) == myWord.charAt(i)) {
                        letter = word.charAt(i);
                    }
                    prompt += letter;
                }
                for (int i = 0; i < maxLength - word.length(); i++) {
                    prompt += "#";
                }
                System.out.printf("\nNot guess! Prompt: %s%n", prompt);
                System.out.println("Try once again...");
            } else {
                cycle = false;
                System.out.printf("You won! It's %s!", myWord);
            }
        }
    }

    static String makeWord(String[] words) {
        Random index = new Random();
        return words[index.nextInt(words.length)];
    }

}
