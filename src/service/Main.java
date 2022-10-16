package service;

import models.FileData;
import models.FileNavigator;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNav = new FileNavigator();

        fileNav.add(new FileData("src/myFolder", "Test.txt", 900));
        fileNav.add(new FileData("src/myFolder", "MyFile.txt", 1900));
        fileNav.add(new FileData("src/mySecondFolder", "Best.txt", 904));
        fileNav.add(new FileData("src/mySecondFolder", "West.txt", 1200));
        fileNav.add(new FileData("src/mySecondFolder", "Rest.txt", 900));
        fileNav.add(new FileData("src/myFolder", "Game.txt", 9050));
        fileNav.add(new FileData("src/mySecondFolder", "Speech.txt", 9020));
        fileNav.add(new FileData("src/myFolder", "Homework.txt", 9100));

        fileNav.showAll();

        System.out.println("Поиск src/myFolder:");
        fileNav.find("src/myFolder").showInfo();
        System.out.println("Фильтр размера src/myFolder: размер 2000");
        fileNav.filterBySizeWithPath("src/myFolder", 2000).showInfo();
        System.out.println("Фильтр размера абсолютно всех файлов размер 2000");
        fileNav.filterBySize(2000).showInfo();
        System.out.println("Удаление директории src/mySecondFolder");
        fileNav.remove("src/mySecondFolder");
        fileNav.showAll();
        System.out.println("Сортировка оставшейся директории");
        fileNav.sortBySize().showInfo();


    }
}