package JSON;

import Collection.Organization;
import Tools.Tools;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayDeque;

/**
 * The type Json writer.
 */
public class JsonWriter {
    /**
     * Save collections to file.
     *
     * @param arrayDeque the array deque
     * @param targetPath the target path
     * @throws IOException the io exception
     */
    public static void SaveCollectionsToFile(ArrayDeque<Organization> arrayDeque, String targetPath) throws IOException {
        File file = new File(targetPath);
        if (!file.exists()) {
            file.createNewFile();
        } else {
            Tools.Message("Program: File Already exist, Would you like to replace it? Y/N:");
            switch (Tools.Input()) {
                case "Y": {
                    file.delete();
                    file.createNewFile();
                    break;
                }
                case "N": {
                    throw new FileAlreadyExistsException("Program: command return because file exist");
                }
                default: {
                    Tools.MessageL("Program: command return because input error!");
                    break;
                }
            }
        }
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedReader = new BufferedWriter(fileWriter);

        Gson gson = new Gson();
        //Type arrayDequeType = new TypeToken<ArrayDeque<Organization>>() {}.getType();

        Tools.MessageL("Program: Collection saved at " + file.getAbsolutePath());
        bufferedReader.write(gson.toJson(arrayDeque));
        bufferedReader.close();
    }
}
