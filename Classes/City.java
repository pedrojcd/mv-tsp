// Packages to read data and use Lists
import java.util.*;
import java.io.*;
import java.util.Scanner;

// class representing cities using their equirectagular projection
public class City{
 
  private int     index;
  private double  x;
  private double  y;
  private int     multiplicity;

  // Method that creates a City
  public City(int index, double x, double y){
    this.index        = index;
    this.x            = x;
    this.y            = y;
    this.multiplicity = multiplicity;
  }

  // Method that gets the index of a City
  public int getIndex(){
    return this.index;
  }

  // Method that gets the coordinate x of a City
  public double getX(){
    return this.x;
  }

  // Method that gets the coordinate y of a City
  public double getY(){
    return this.y;
  }
  
  // Method that prints a City
  public void printCity(){
    System.out.println("I" + this.index + ": (x=" + this.x + ",y=" + this.y + ",m=" + this.multiplicity + ")");
  }
}
