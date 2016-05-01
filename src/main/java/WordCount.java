import java.util.HashMap;
import java.util.Map;

public class WordCount {

    private Integer countOccurrence(String word, String[] wordArray){
        Integer occurrenceOfWord = 0;
        for (int j = 0; j < wordArray.length; j++) {
            if (word.equals(wordArray[j]))
                occurrenceOfWord += 1;
        }
        return occurrenceOfWord;
    }
    public Map<String,Integer> phrase(String word) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        String filteredWord = filter(word);
        String[] wordArray = filteredWord.split(" ");
        for (int i=0;i<wordArray.length;i++) {
            if (!result.containsKey(wordArray[i]) && !wordArray[i].isEmpty()) {
                Integer occurrenceOfWord = countOccurrence(wordArray[i], wordArray);
                result.put(wordArray[i], occurrenceOfWord);
            }
        }
        return result;
    }

    private String filter(String word) {
        String normalizedWord = normalize(word);
        return ignorePunctuation(normalizedWord);
    }

    private String normalize(String word) {
        return word.toLowerCase();
    }

    private String ignorePunctuation(String word) {
        return word.replaceAll("[^\\w\\s]", "");
    }
}
