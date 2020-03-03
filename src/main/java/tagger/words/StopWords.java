package tagger.words;

import tagger.reader.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StopWords extends Words {

//    public File MAIN_FILE = new File(
//            Objects.requireNonNull(StopWords.class.getResource("StopWords.txt").getPath())
//    );

    public StopWords() throws FileNotFoundException {
        super();
        List<String> words = Arrays.asList( StopWordList.getWords() );
        this.add( words );
    }
    public void addSource( File file ) throws FileNotFoundException {
        CSVReader reader = new CSVReader( ",", "\"");
        List<String> list = reader.read(file);
        this.add( list );
    }

    @Override
    public void add( String word ) {
        super.add( word );
//        this.writeFile();
    }

    @Override
    public void add(List<String> words) {
        super.add( words );
//        this.writeFile();
    }

    @Override
    public void add(Words words) {
        super.add(words);
//        this.writeFile();
    }

//    private void writeFile() {
//        try {
//            this.clearFile();
//            PrintWriter writer = new PrintWriter(MAIN_FILE);
//            for ( String word : this.words ) {
//                String out = "\"" + word + "\"" + ",";
//                writer.write(out);
//            }
//            writer.close();
//        } catch (Exception e) {
//            System.out.println( e.toString() );
//        }
//
//    }
//
//    private void clearFile() throws FileNotFoundException {
//        new PrintWriter(MAIN_FILE).close();
//    }

}
