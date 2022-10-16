package models;

import java.util.HashMap;
import java.util.Map;

public class FileNavigator {
    Map<String, FileDataList> files = new HashMap<>();

    public void add(FileData file) {
        if (files.containsKey(file.getPathToFile())) {
            files.get(file.getPathToFile()).addFile(file);
        } else {
            files.put(file.getPathToFile(), new FileDataList());
            files.get(file.getPathToFile()).addFile(file);
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
            entry.getValue().showInfo();
        }

    }

}
