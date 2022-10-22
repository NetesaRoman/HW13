package models;

import java.util.ArrayList;
import java.util.List;

public class FileDataList {
   private List<FileData> files = new ArrayList<>();

    public void addFile(FileData file) {
        files.add(file);
    }

    public void removeFile(FileData file) {
        files.remove(file);
    }

    public void printInfo() {
        for (FileData file : files) {
            file.printInfo();
        }
    }

    public FileDataList filterBySize(int size) {
        FileDataList result = new FileDataList();
        for (FileData file : files) {
            if (file.getCapacity() <= size) {
                result.addFile(file);
            }
        }
        return result;
    }

    public void addFiles(FileDataList newFiles) {

        files.addAll(newFiles.getFiles());
    }

    public List<FileData> getFiles() {
        return files;
    }

    public void sortBySize() {

        FileData temp;

        for (int i = 0; i < files.size(); i++) {
            for (int j = 1; j < (files.size() - i); j++) {

                if (files.get(j - 1).getCapacity() > files.get(j).getCapacity()) {
                    temp = files.get(j - 1);
                    files.set(j - 1, files.get(j));
                    files.set(j, temp);
                }

            }
        }
    }

}
