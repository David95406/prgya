package org.example;

public class ComputerMemoryException extends Exception{
    //nem kell getter, setter mert van -> ososztalynak van
    public ComputerMemoryException(String errorMessage) {
        super(errorMessage);
    }

    public String toString() {
        return "ComputerMemoryException keletkezett: " + this.getMessage();
    }
}
