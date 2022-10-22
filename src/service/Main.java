package service;

import models.FileData;
import models.FileNavigator;
import models.api.SecureException;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNav = new FileNavigator();

        try {
            fileNav.add(
                    "src/myFolder",
                    new FileData("src/myFolder", "Test.txt", 900));
            fileNav.add(
                    "src/myFolder",
                    new FileData("src/myFolder", "MyFile.txt", 1900));
            fileNav.add(
                    "src/mySecondFolder",
                    new FileData("src/mySecondFolder", "Best.txt", 904));
            fileNav.add(
                    "src/mySecondFolder",
                    new FileData("src/mySecondFolder", "West.txt", 1200));
            fileNav.add(
                    "src/mySecondFolder",
                    new FileData("src/mySecondFolder", "Rest.txt", 900));
            fileNav.add(
                    "src/myFolder",
                    new FileData("src/myFolder", "Game.txt", 9050));
            fileNav.add(
                    "src/mySecondFolder",
                    new FileData("src/mySecondFolder", "Speech.txt", 9020));
            fileNav.add(
                    "src/myFolder",
                    new FileData("src/myFolder", "Homework.txt", 9100));

        }catch (SecureException e){
            e.printStackTrace();
        }
        fileNav.showAll();

        System.out.println("Поиск src/myFolder:");
        fileNav.find("src/myFolder").printInfo();
        System.out.println("Фильтр размера src/myFolder: размер 2000");
        fileNav.filterBySizeWithPath("src/myFolder", 2000).printInfo();
        System.out.println("Фильтр размера абсолютно всех файлов размер 2000");
        fileNav.filterBySize(2000).printInfo();
        System.out.println("Удаление директории src/mySecondFolder");
        fileNav.remove("src/mySecondFolder");
        fileNav.showAll();
        System.out.println("Сортировка оставшейся директории");
        fileNav.sortBySize().printInfo();

        System.out.println("7й пункт через исключение");

        try {
            fileNav.add(
                    "src/myFolder",
                    new FileData("src/myFoldфывer", "Homework.txt", 9100));
        } catch (SecureException e) {
            e.printStackTrace();
        }
    }
}