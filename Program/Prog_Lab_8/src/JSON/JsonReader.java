package JSON;

import Collection.Organization;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * The type Json reader.
 */
public class JsonReader {
    /**
     * Gets collection from file.
     *
     * @param path the path
     * @return the collection from file
     * @throws IOException the io exception
     */
    public static LinkedBlockingDeque<Organization> getCollectionFromFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Error: File [" + path + "] not found!");
        }
        if (!file.canRead()) {
            throw new SecurityException("Error: File [" + path + "] can not read!");
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder fileData = new StringBuilder();
        String newLine;
        while ((newLine = bufferedReader.readLine()) != null) {
            fileData.append(newLine);
        }

        Type linkedBlockingDequeType = new TypeToken<LinkedBlockingDeque<Organization>>(){}.getType();

        Gson gson = new Gson();
        LinkedBlockingDeque<Organization> collectionGot = gson.fromJson(fileData.toString(), linkedBlockingDequeType);
        //Tools.MessageL("Program: Collection got from file successfully!");

        bufferedReader.close();
        return collectionGot;
    }
}
