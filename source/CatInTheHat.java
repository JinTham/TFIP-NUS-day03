

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class CatInTheHat {
    public static void main(String[] args) {
        //Read the file the_cat_in_the_hat
        Path cithPath = Paths.get("./cat_in_the_hat.txt");
        File cith = cithPath.toFile();

        try {
            //Open and read a file
            InputStream is = new FileInputStream(cith);
            OutputStream os = new FileOutputStream("copy_of_cat_in_the_hat.txt");
            byte[] buffer = new byte[512]; // create a 0.5k buffer
            int size;
            while ((size = is.read(buffer))>=0){
                System.out.printf("read: %d\n",size);
                os.write(buffer,0,size);
            }
            //Close the input stream
            is.close();
            //Close the output stream
            os.flush();
            os.close();
        } catch (FileNotFoundException ex) {
            System.err.printf("IO exception:%s\n", ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.printf("IO exception:%s\n", ex.getMessage());
            ex.printStackTrace();
        }
    }
}
