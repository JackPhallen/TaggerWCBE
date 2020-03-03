package tagger.token;

import tagger.words.Words;

import java.util.ArrayList;

public class TokenList extends ArrayList<Token> {

    public TokenList reduce(int freq) {
        TokenList tokenList = new TokenList();
        for (Token token : this) {
            if (token.getCount() < freq) {
                break;
            } else {
                tokenList.add(token);
            }
        }
        return tokenList;
    }

    public static Words toWords(TokenList tokenList) {
        Words words = new Words();
        for (Token token: tokenList) {
            words.add( token.getWord() );
        }
        return words;
    }
}
