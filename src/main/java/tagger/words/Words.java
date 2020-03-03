package tagger.words;

import lombok.Setter;

import java.util.*;

public class Words implements Iterable<String> {

    @Setter
    protected HashSet<String> words;

    public Words() {
        this.words = new HashSet<>();
    }

    public Words( HashSet<String> words ) {
        this.words = words;
    }

    public Words(Collection<String> words) {
        this.words = new HashSet<>( words );
    }

    @Override
    public Iterator<String> iterator() {
        return this.words.iterator();
    }

    public boolean contains( String string ) {
        return this.words.contains(string);
    }

    public void add( String word ) {
        this.words.add( word );
    }

    public void add( List<String> words ) {
        this.words.addAll( words );
    }

    public void add(Words newWords) {
        this.words.addAll(newWords.words);
    }

    public void remove(String word) {
        this.words.remove(word);
    }

    public void remove(Words words) {
        for (String word : words) {
            this.remove(word);
        }
    }

    public static String clean(String word) {
        return word.replaceAll("\\s", "").toLowerCase();
    }

    public static List<String> clean(List<String> words) {
        List<String> cleanWords = new ArrayList<>();
        for (String word: words) {
            cleanWords.add( clean(word) );
        }
        return cleanWords;
    }

    public int size() {
        return this.words.size();
    }

}
