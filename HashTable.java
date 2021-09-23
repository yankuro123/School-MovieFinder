package com.company;
public class HashTable {
    private int size = 256;
    protected String name;
    protected boolean found = false;
    LinkedList[] HashTable;

    public HashTable(String name) {
        this.name = name;
        HashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            HashTable[i] = new LinkedList();
        }
    }

    public LinkedList find(String target) {
        int position = stringToHash(getFirstLetter(target)) % size;
        LinkedList hashMovie = HashTable[position];

        if (hashMovie != null) {
            found = true;
        }
        return hashMovie;
    }

    public int stringToHash(String element) {
        int key1 = 0;
        for (int i = 0; i < element.length(); i++) {
            char c = element.charAt(i);
            key1 = key1 + (int) c;
        }

        return key1 % 256;
    }

    public String getFirstLetter(String text) {
        String firstLetters = "";
        for (String s : text.split(" ")) {
            firstLetters += s.charAt(0);
        }
        return firstLetters;
    }
    public void list() {
        for (int i = 0; i <= 255; i++) {

            LinkedList start = HashTable[i];

            if (start != null) {
                start.toString();
            }
        }
    }

    public void get(String element) {
        LinkedList targetList = find(element);
        if (targetList != null) {
            if (targetList.find(element) != null) {
                targetList.remove(targetList.find(element));
            } else {
                System.out.print("There is no such movie in the list");
            }

        } else {
            System.out.print("There is no such movie in the list");
        }
    }

    public void occupancy() {
        int numElements = 0;
        for (int i = 0; i < size; i++) {
            LinkedList start = HashTable[i];

            if (start != null) {
                numElements++;
            }
        }

        System.out.println("The occupancy is " + Integer.toString(numElements) + "/" + Integer.toString(size));

    }
    public void add(String element, int year, int time) {
        int hash = stringToHash(getFirstLetter(element)) % size;
        Movie targetMovie = new Movie(element, year, time);
        LinkedList targetList = find(element);
        if (targetList == null) {
            HashTable[hash] = new LinkedList();
            HashTable[hash].add(targetMovie);
        } else if (targetList != null) {
            if (targetList.find(element) == null) {
                targetList.add(targetMovie);
            } else {
                System.out.println("There is already a movie with this title in the list. Please try again!");
            }

        }
    }
}

