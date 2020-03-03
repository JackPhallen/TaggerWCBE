package tagger.token;

import tagger.words.Words;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tokenizer {

    private Words stopWords;

    private static int THRESHOLD = 2;

    public Tokenizer(Words stopWords) {
        this.stopWords = stopWords;
    }


    public TokenList tokenize(String text, int threshold) {
        TokenList tokens = this.tokenize(text);
        return tokens.reduce(threshold);
    }

    public TokenList tokenize(String text) {
        Map<String,Integer> countMap = Tokenizer.buildCounts(text, this.stopWords);
        return buildTokenList(countMap);
    }

    private static Map<String,Integer> buildCounts(String text, Words stopWords) {
        Map<String, Integer> countMap = new LinkedHashMap<>();
        String[] words = text.split("\\W+");
        for (String word: words) {
            word = Words.clean(word);
            if ( !stopWords.contains(word) ) {
                Tokenizer.incrementCount(word, countMap);
            }
        }
        return countMap;
    }

    private static TokenList buildTokenList(Map<String, Integer> countMap) {
        TokenList tokenList = new TokenList();
        countMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> tokenList.add(new Token(x)) );
        return tokenList;
    }

    private static void incrementCount(String word, Map<String,Integer> countMap) {
        if ( countMap.containsKey(word) ) {
            int currentCount = countMap.get( word );
            countMap.replace( word, currentCount + 1 );
        } else {
            countMap.put(word, 1);
        }
    }

    private static String cleanWord(String word) {
        return word.toLowerCase();
    }

}
