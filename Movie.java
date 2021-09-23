package com.company;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.io.*;
import java.util.*;
public class Movie {
    private String title;
    private int    yearReleased;
    private int    runningTime;
    private Movie prev;
    private Movie next;
    public Movie() {
        this.title = null;
        this.yearReleased = 0;
        this.runningTime = 0;

    }
    public Movie (String title, int yearReleased, int runningTime) {
        this.title        = title.trim();
        this.yearReleased = yearReleased;
        this.runningTime  = runningTime;
    }
    public Movie (Movie m) {
        title        = m.getTitle();
        yearReleased = m.getYearReleased();
        runningTime  = m.getRunningTime();
    }
    public int getYearReleased() {
        return yearReleased;
    }
    public int getRunningTime() {
        return runningTime;
    }
    public String getTitle() {
        return title;
    }
    public void setYear (int year){
        this.yearReleased = year;
    }
    public void setPrev(Movie prev){
        this.prev = prev;
    }
    public Movie getPrev(){
        return prev;
    }
    public void setNext(Movie next){
        this.next = next;
    }
    public Movie getNext(){
        return next;
    }
    public int[] getFirstLetterCodes() {
        String [] words;
        int [] result;
        words = title.split(" ");
        result = new int[words.length];
        for (int wordNbr = 0; wordNbr < words.length; wordNbr++) {
            if (words.length != 0 && words[wordNbr].length() > 0) {
                result[wordNbr] = Character.valueOf(words[wordNbr].charAt(0));
            }
        }
        return result;
    }
    public int getHashKey(int [] values) {
        int HashKey = 0;
        for(int i: values){
            HashKey = HashKey *128 +i;
        }
        return HashKey;
    }
    public String toString() {
        return "\""+title + "\" Released in : " + yearReleased + " Running Time : " + runningTime + " minutes";
    }

    /**
     * Main program.
     *
     * @param arguments  Not used in this program.
     */
    /*
    public static void main(String [] arguments) {

        Movie m1, m2, m3,m4;
        m1 = new Movie("While You Were Sleeping", 1990, 105);
        m2 = new Movie("D H W Y S", 0, 0);
        m3 = new Movie(m1);
        m4 = new Movie("Brave", 2000, 99);
        int [] codes;
        System.out.println(m1);
        codes = m1.getFirstLetterCodes();
        for (int k : codes)
            System.out.println(k);
        long HashKey = m1.getHashKey(m1.getFirstLetterCodes());
        System.out.println(HashKey);
        System.out.println(m2);
        codes = m2.getFirstLetterCodes();
        for (int k : codes)
            System.out.println(k);

        System.out.println(m3);
        codes = m3.getFirstLetterCodes();
        for (int k : codes)
            System.out.println(k);
        System.out.println(m4);
        codes = m4.getFirstLetterCodes();
        for (int k : codes)
            System.out.println(k);
        System.exit(0);
        }
    */
}