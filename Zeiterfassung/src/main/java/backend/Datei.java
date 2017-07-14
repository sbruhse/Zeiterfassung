package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import com.oracle.javafx.jmx.json.JSONException;

import java.io.*;
import java.util.ArrayList;

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
    public static <T> ArrayList<T> getObjectsFromJson(String json)
    {
        Gson gson = new Gson();
        TypeToken<ArrayList<T>> token = new TypeToken<ArrayList<T>>(){};
        return gson.fromJson(json, token.getType());

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
     * @param content
     * @param <T>
     * @throws IOException
     */
    public static <T> void write(String content) throws IOException
    {
        String userHome = System.getProperty("user.home");
        String directory = userHome + "/Zeiterfassung/";
        File folder = new File(directory);

        if(folder.exists())
        {
            FileWriter fileWriter = new FileWriter(directory + getPath());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(content);

            bufferedWriter.close();
        }
        else
        {
            throw new FileNotFoundException();
        }
    }

    /**
     * Liest eine Datei ein
     * @param <T>
     * @return
     * @throws IOException
     */
    public  static <T> String read() throws IOException
    {
        String userHome = System.getProperty("user.home");
        String directory = userHome + "/Zeiterfassung/";
        File folder = new File(directory);

        if(!folder.exists())
        {
            throw new FileNotFoundException();
        }

        FileReader fileReader = new FileReader(directory + getPath());
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



    /**
     * Pfad zur Datei
     */
    private static String path = null;

    /**
     * Getter für {@link #path path}
     * @return
     */
    public static String getPath()
    {
        return path;
    }

}
