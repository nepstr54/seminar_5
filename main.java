import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StringBuilder ourSentence = new StringBuilder();
        try {
            String ourPath1 = System.getProperty("user.dir");
            String ourPath2 = ourPath1.concat("/text.txt");
            File ourFile = new File(ourPath2);
            ourSentence = new StringBuilder();

            BufferedReader ourReader = new BufferedReader(new FileReader(ourFile));
            while (ourReader.readLine() != null) {
                ourSentence.append(ourReader.readLine());
                ourSentence.append(" ");
            }
            ourSentence.deleteCharAt(ourSentence.length() - 1);

            System.out.println("File opened");

        } catch (Exception e) {
            System.out.println("Catch");
        }

        String ourText = ourSentence.toString();
        ourText = ourText.replace(".", "")
                .replace(",", "")
                .replace(":", "")
                .replace(";", "")
                .replace("\"", "")
                .replace("(", "")
                .replace(")", "");

        System.out.println(ourText);

        Map<String, Integer> ourWords = new HashMap<>();
        String[] arr = ourText.split(" ");

        for (String s : arr) {
            if (ourWords.get(s.toLowerCase()) != null) {
                ourWords.put(s.toLowerCase(), ourWords.get(s.toLowerCase()) + 1);
            } else {
                ourWords.putIfAbsent(s.toLowerCase(), 1);
            }


        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите слово для подсчета нахождений");
        String keyWord = sc.nextLine();


        System.out.printf("Слово [%s] в тексте встречается [%d] раз%n", keyWord, ourWords.get(keyWord));
        System.out.println("Количество вхождения каждого слова: ");
        for (Map.Entry<String, Integer> entry : ourWords.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue().toString() + " ");
        }
        sc.close();
    }
}