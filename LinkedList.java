package com.company;
public class LinkedList {
      Movie head;
    public void MovieList () {
        head  = null;
    }
    /*public void add(LinkedList list,String data){
       Node newNode = new Node(data);
       newNode.next = null;
        if(list.head == null){
            list.head = newNode;
        }
        else{
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }*/
    public void add(Movie movie){
      if(head == null){
          head = movie;
      }
      else{
          Movie last = head;
          while(last.getNext() != null){
              last = last.getNext();
          }
          last.setNext(movie);
          movie.setPrev(last);
      }
    }
    public Movie find(String data){
        if (head != null) {
            Movie headMovie = head;
            Movie targetMovie = null;
            if (data.equalsIgnoreCase(headMovie.getTitle())) {
                targetMovie = headMovie;
                return targetMovie;
            }
            while (headMovie.getNext() != null) {
                if (data.equalsIgnoreCase(headMovie.getTitle())) {
                    targetMovie = headMovie;
                }
                headMovie = headMovie.getNext();
                if (data.equalsIgnoreCase(headMovie.getTitle())) {
                    targetMovie = headMovie;
                }

            }

            return targetMovie;
        } else {
            return null;
        }
    }
    public void remove(Movie data){
        Movie headMovie = head;

        if (headMovie != null && headMovie == find(data.getTitle())) {
            head = null;
            return;
        }
        headMovie = headMovie.getNext();
        while (headMovie.getNext() != null) {
            if (headMovie == find(data.getTitle())) {
                headMovie.getPrev().setNext(headMovie.getNext());
                headMovie.getNext().setPrev(headMovie.getPrev());
            }
            headMovie = headMovie.getNext();
            if (headMovie == find(data.getTitle())) {
                headMovie.getPrev().setNext(headMovie.getNext());
                headMovie.getNext().setPrev(headMovie.getPrev());
            }
        }
    }

    public String toString() {
        String str = "";
        Movie headMovie = head;
        if (headMovie != null) {
            System.out.println("Title: " + headMovie.getTitle() + "- Year: " + headMovie.getYearReleased() + "- Time: "
                    + headMovie.getRunningTime() + "\n");
        }
        return str;
    }
}
