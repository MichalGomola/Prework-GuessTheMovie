import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Titles {
    String[]  titles;
    Titles() throws Exception {

        this.titles = makeTitlesArray();

    }
    private String[] makeTitlesArray() throws Exception{
        // put file path here
        String fileName = "/home/michal/Desktop/Prework-GuessTheMovie/GuessTheMovie/src/movies.txt";
        Path path = Paths.get(fileName);

        // get the lines count to make array
        long lines;
        lines = Files.lines(path, StandardCharsets.UTF_8).count();

        // make an array
        String[] movies = new String[(int) lines];

        // put titles in array
        try (FileReader fr = new FileReader(fileName, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(fr)) {

            for (int i = 0; i < movies.length; i++) {
                movies[i] = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
