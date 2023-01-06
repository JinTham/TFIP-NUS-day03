package day03;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AppRating {
    public static void main(String[] args) throws NoSuchFileException, FileNotFoundException, IOException {
        String line;
        String[] colVal = {};
        Map<String,PlaystoreData> playstoreMap = new HashMap<>();

        //Read csv file and parse the data into map;
        Reader fileReader = new FileReader("googleplaystore.csv");
        BufferedReader reader = new BufferedReader(fileReader);
        //Create a loop to read through each line of the csv file until the end of the file
        while ((line = reader.readLine()) != null) { 
            line = line.trim();
            if (line.length() <= 0){
                continue;
            }
            colVal = line.split(",");
            //Discard rows with less than 3 columns
            if (colVal.length < 3){
                continue;
            }
            String name = colVal[0].trim();
            String category = colVal[1].trim();
            String strRating = colVal[2].trim();
            Float rating = 0f;
            //Discard rows with NaN rating
            if (strRating.toLowerCase().equals("nan")){
                continue;
            }
            //Discard rows if rating not a number
            try {
                rating = Float.parseFloat(strRating);
            } catch (NumberFormatException ex){
                continue;
            }
            //Create a map with each category
            PlaystoreData data = playstoreMap.get(category);
            if (data == null){
                data = new PlaystoreData(category);
                playstoreMap.put(category,data);
            }
            //Add rating to current data
            data.add(rating);
            //Evaluate if current data is highest or lowest
            data.evaluate(name,rating);
        }
        reader.close();
        fileReader.close();

        //Print out info for each category
        System.out.print("--------App Ratings");
        for (String category : playstoreMap.keySet()){
            PlaystoreData data1 = playstoreMap.get(category);
            System.out.printf("Category: %s\n",data1.getCategory());
            System.out.printf("AvgRating: %.2f\n",data1.getAverageRating());
            System.out.printf("Highest rated game: %s (%.2f)\n",data1.getHighestRatedGame(),data1.getHighestRating());
            System.out.printf("Lowest rated game: %s (%.2f)\n",data1.getLowestRatedGame(),data1.getLowestRating());
            System.out.printf("-------------------------------------\n");
        }
    }
}