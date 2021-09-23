package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {
    public void getMovies(HashTable table) {
        Scanner File;
        Scanner in = new Scanner(System.in);
        System.out.println("Please type in the file name:");
        String input = in.nextLine();
        try {
            File = new Scanner(new File(input));
            try {
                while (true) {
                    String name = File.nextLine();
                    int year = File.nextInt();
                    int runTime = File.nextInt();
                    File.nextLine();
                    //table.addMovie(new Movie(name, year, runTime));
                }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static HashTable Movies;

    public static void main(String[] args) {
        Movies = new HashTable("Movies: \n");
        String command;
        String delete;
        String target;
        String title;
        int year;
        int runTime;

        Scanner scan = new Scanner(System.in);

        System.out.println("Movies Operation: ");
        System.out.println("A for add, L for list, G for get, F for find, O for occupancy, Q for quit");
        System.out.println("What is your command?");
        command = scan.nextLine();

        while (!command.equalsIgnoreCase("q")) {

            if (command.equalsIgnoreCase("a")) {
                System.out.println("Enter the title of the movie to be added: ");
                title = scan.nextLine();
                System.out.println("Enter the year released: ");
                year = scan.nextInt();
                System.out.println("Enter the running time: ");
                runTime = scan.nextInt();
                Movies.add(title, year, runTime);
            } else if (command.equalsIgnoreCase("l")) {
                Movies.list();
            } else if (command.equalsIgnoreCase("g")) {
                System.out.println("Enter the title of the movie to be deleted: ");
                delete = scan.nextLine();

                Movies.get(delete);

            } else if (command.equalsIgnoreCase("f")) {
                System.out.println("Enter the title of the movie to be found: ");
                target = scan.nextLine();

                if (Movies.find(target) != null) {

                }
            } else if (command.equalsIgnoreCase("o")) {
                Movies.occupancy();
            }

            System.out.println();
            command = scan.nextLine();
        }
    }
}
