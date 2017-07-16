package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.oracle.javafx.jmx.json.JSONException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse zum Erstellen und Bearbeiten von Dateien und dem Verarbeiten von JSON Strings
 * @author sbruhse
 */
public abstract class Datei<T>
{

    /**
     * Wandelt einen JSON String in eine Objektliste um
     * @param json JSON String
     * @param <T> Objekttyp
     * @return Liste von Objekten
     */
    public static <T> ArrayList<T> getObjectsFromJson(String json, Class<T[]> clazz)
    {
    	
    	if(json=="") return new ArrayList<>();
    	
        Gson gson = new Gson();
        return new ArrayList<>(Arrays.asList(gson.fromJson(json, clazz)));
        //ArrayList<T> list =  new ArrayList<>(Arrays.asList(gson.fromJson(json, clazz)));
        //return list;

    }

    /**
     * Erstellt aus einer Objektliste einen JSON String
     * @param objects
     * @param <T>
     * @return
     */
    public static <T> String getJsonFromObjects(ArrayList<T> objects)
    {
        Gson gson = new Gson();
        return gson.toJson(objects);
    }

    /**
     * Schreibt einen String in eine Datei im Applikationsordner im Benutzerverzeichnis.
     * @param relativePath
     * @param content
     * @param <T>
     * @throws IOException
     */
    public static <T> void write(String relativePath, String content) throws IOException
    {
        String userHome = System.getProperty("user.home");
        String directory = userHome + "/Zeiterfassung/"  + relativePath;
        File folder = new File(directory);

        if(folder.exists())
        {
            FileWriter fileWriter = new FileWriter(folder);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(content);

            bufferedWriter.close();
        }
        else
        {
            if(!folder.getParentFile().exists())
                folder.getParentFile().mkdir();

            folder.createNewFile();
        }
    }

    /**
     * Liest eine Datei ein
     * @param relativePath
     * @param <T>
     * @return
     * @throws IOException
     */
    public  static <T> String read(String relativePath) throws IOException
    {
        String userHome = System.getProperty("user.home");
        String directory = userHome + "/Zeiterfassung/" + relativePath;
        File folder = new File(directory);

        if(!folder.exists())
        {
            if(!folder.getParentFile().exists())
                folder.getParentFile().mkdir();

            folder.createNewFile();
        }

        FileReader fileReader = new FileReader(folder);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String content = "";
        String line = "";
        while ((line = bufferedReader.readLine()) != null)
        {
            content = content.concat(line);
        }

        bufferedReader.close();

        return content;
    }

}
