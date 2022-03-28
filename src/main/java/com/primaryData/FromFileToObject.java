package com.primaryData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FromFileToObject {

    public static <T> List<T> extractFromJsonFile(String path, TypeToken<List<T>> typeToken) {
        List<T> list = null;
        try {

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(path));

            // convert JSON string to User object
            list = new Gson().fromJson(reader, typeToken.getType());

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
}