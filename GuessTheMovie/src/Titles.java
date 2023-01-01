import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Titles {
    String[]  titles;
    public void titles() throws Exception{
        String fileName = "/home/michal/Desktop/Prework-GuessTheMovie/GuessTheMovie/src/movies.txt";
        Path path = Paths.get(fileName);

        try (FileReader fr = new FileReader(fileName, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(fr)) {

            long lines;
            lines = Files.lines(path, StandardCharsets.UTF_8).count();
            this.titles = new String[(int) lines];
            int i = 0;
            String str;
            while ((str = reader.readLine()) != null) {
                this.titles[i] = str;
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
