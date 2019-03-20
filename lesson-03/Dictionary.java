
import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        String[] words = {
                "Печенье", "Крекер", "Зефир", "Эклер", "Кекс", "Пастила", "Печенье", "Мармелад", "Мармелад",
                "Пирожное", "Эклер", "Зефир", "Карамель", "Печенье", "Желе", "Пастила", "Брауни",
                "Зефир", "Зефир", "Желе", "Печенье", "Кекс", "Печенье", "Маффин", "Мармелад"
        };

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (String everyWord: wordList) {
            int count = dictionary.getOrDefault(everyWord, 0);
            dictionary.put(everyWord, ++count);
        }

        System.out.println("total words: " + wordList.size());
        System.out.println("unique words: " + dictionary.entrySet().size());
        System.out.println(dictionary);
    }
}