package tagger.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    private String delimiter;
    private String quote;

    public CSVReader(String delimiter, String quote) {
        this.delimiter = delimiter;
        this.quote = quote;
    }

    public List<String> read(File file) throws FileNotFoundException {
        List<String> data = new ArrayList<>();
        Scanner scanner = new Scanner( file );

        while ( scanner.hasNext() ) {
            String line = scanner.nextLine();
            data.addAll( parseLine( line ) );
        }
        return data;
    }

    private List<String> parseLine( String line ) {
        line = line.replaceAll(this.quote, "");
        line = line.replace(" ", "");
        return Arrays.asList( line.split(this.delimiter) );
    }

}
