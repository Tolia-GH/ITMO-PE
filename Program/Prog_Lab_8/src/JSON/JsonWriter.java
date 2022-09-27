package JSON;

import Collection.Organization;
import Tools.Tools;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * The type Json writer.
 */
public class JsonWriter {
    /**
     * Save collections to file.
     *
     * @param linkedBlockingDeque the array deque
     * @param targetPath the target path
     * @throws IOException the io exception
     */
    public static void SaveCollectionsToFile(LinkedBlockingDeque<Organization> linkedBlockingDeque, String targetPath) throws IOException {
        File file = new File(targetPath);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedReader = new BufferedWriter(fileWriter);

        Gson gson = new Gson();

        Tools.MessageL("Program: Collection saved at " + file.getAbsolutePath());
        bufferedReader.write(gson.toJson(linkedBlockingDeque));
        bufferedReader.close();
    }
}
