package com.maik.ApiPostgresTemplate.database;

import java.io.*;

public class DumpDataFromTxt {

    //set up main arg
    public static void main(String[] args) {
        //read file from resources
        String fileName = "inserts.sql";
        String filePath = "src/main/resources/";
        String fileFullPath = filePath + fileName;
        File file = new File(fileFullPath);


        BufferedReader reader;
        try {
            FileWriter myWriter = new FileWriter(file);
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/spanish_words.txt"));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                // read next line
                line = reader.readLine();
                myWriter.write("INSERT INTO dictionary (word) VALUES ('" + line + "');\n");
                i++;
            }
            reader.close();
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    
}
