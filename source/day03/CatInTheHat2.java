package day03;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;

public class CatInTheHat2 {
    public static void main(String[] args) throws IOException {
        //Read the file the_cat_in_the_hat
        Path cithPath = Paths.get("./cat_in_the_hat.txt");
        File cith = cithPath.toFile();
        
        if (!cith.exists()){
            System.err.println("Cannot find file");
            System.exit(1);
        }

        FileReader fileReader = new FileReader(cith);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("capital_copy_of_cat_in_the_hat.txt");
        String line;
        while (null != (line = bufferReader.readLine())){
            fileWriter.write(line.toUpperCase());
            fileWriter.write("\n");
        }
        //Close the reader
        bufferReader.close();
        fileReader.close();
        //Close the writer
        fileWriter.flush();
        fileWriter.close();
    }
}
