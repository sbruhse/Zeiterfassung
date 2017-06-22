package backend;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
     * Pfad zur Datei
     */
    private String path;

    /**
     * Getter für {@link #path path}
     * @return
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Setter für {@link #path path}
     * @param path
     */
    public void setPath(String path)
    {
        this.path = path;
    }
}
