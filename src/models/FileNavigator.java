package models;

import models.api.SecureException;

import java.util.HashMap;
import java.util.Map;

public class FileNavigator {
   private Map<String, FileDataList> files = new HashMap<>();

    public void add(String path, FileData file) throws SecureException {
        if(!path.equals(file.getPathToFile())){
            throw new SecureException("Указанный путь не соответствует тому пути который хранится в данных файла");
        }

        if (files.containsKey(path)) {
            files.get(path).addFile(file);
        } else {
            files.put(path, new FileDataList());
            files.get(path).addFile(file);
        }
    }

    public FileDataList find(String key) {
        return files.get(key);
    }

    public FileDataList filterBySizeWithPath(String path, int capacity) {
        FileDataList result;

        if (files.containsKey(path)) {
            result = files.get(path).filterBySize(capacity);
        } else {
            System.out.println("Нет такого пути!");
            return null;
        }

        return result;
    }

    public FileDataList filterBySize(int capacity) {
        FileDataList result = new FileDataList();

        for (var entry : files.entrySet()) {
            FileDataList tempList = entry.getValue().filterBySize(capacity);

            result.addFiles(tempList);
        }

        return result;
    }

    public void remove(String path) {
        files.remove(path);
    }

    public FileDataList sortBySize() {
        FileDataList result = new FileDataList();

        for (var entry : files.entrySet()) {
            FileDataList tempList = entry.getValue();

            result.addFiles(tempList);
        }


        return result;
    }

    public void showAll() {

        for (var entry : files.entrySet()) {
            entry.getValue().printInfo();
        }

    }

}
