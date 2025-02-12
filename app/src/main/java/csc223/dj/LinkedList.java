package csc223.dj;

public interface LinkedList {
    void insert(char item);
    void remove(char item);
    char getFirst();
    char getLast();
    char get(int index);
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(char item);
    int indexOf(char item);
    int lastIndexOf(char item);
    void reverse();
    String toString();
}


