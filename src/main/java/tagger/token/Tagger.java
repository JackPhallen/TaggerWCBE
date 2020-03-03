package tagger.token;

import lombok.Getter;
import lombok.Setter;
import tagger.words.StopWords;


@Getter
public class Tagger {

    @Getter
    private static Tagger instance = new Tagger();

    private Tokenizer tokenizer;
    private StopWords stopWords;
    private TokenList tokens;
    @Setter
    private int threshold = 0;

    @Setter
    private String text;

    public Tagger() {
        try {
            this.stopWords = new StopWords();
            this.tokenizer = new Tokenizer(this.stopWords);
            this.tokens = new TokenList();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void tag() {
        this.tokens = this.tokenizer.tokenize(this.text, this.threshold);
    }

    public TokenList reduce() {
        return this.tokens.reduce(this.threshold);
    }

}
