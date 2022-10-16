package models;

public class FileData {

    private String pathToFile;
    private String fileName;
    private int capacity;

    public FileData(String pathToFile, String fileName, int capacity) {
        this.pathToFile = pathToFile;
        this.fileName = fileName;
        this.capacity = capacity;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void showInfo() {
        System.out.println("Name: " + fileName + " Path: " + pathToFile + " Capacity: " + capacity);
    }
}
