package tagger.token;

import lombok.Getter;

import java.util.Map;

public class Token {

    @Getter
    private String word;

    @Getter
    private int count;

    public Token(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public Token(Map.Entry<String,Integer> mapEntry) {
        this.word = mapEntry.getKey();
        this.count = mapEntry.getValue();
    }



}
