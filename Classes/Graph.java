import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Graph{
  
  private int         numberOfCities;
  private String[]    columns;
  private City[]      cityList;
  private double[][]  distances;
  
  // Method that creates a graph for our other methods
  public Graph(String filename) throws java.io.FileNotFoundException{
    File file = new File(filename);
    Scanner input = new Scanner (file);
    
    this.numberOfCities = input.nextInt();
    
    this.columns = new String[3];
    for(int i = 0; i<3; i++){
      this.columns[i] = input.next();
    }
    
    this.cityList = new City[this.numberOfCities]; 
    for(int i = 0; i<numberOfCities; i++){
      int        index = input.nextInt();
      double         x = input.nextDouble();
      double         y = input.nextDouble();
      this.cityList[i] = new City(index,x,y);
    }
    
    this.distances = new double[this.numberOfCities][this.numberOfCities];
    for(int i = 0; i<numberOfCities;i++){
      for(int j = i+1; j<numberOfCities; j++){
        double x1  = this.cityList[i].getX();
        double y1  = this.cityList[i].getY();
        double x2  = this.cityList[j].getX();   
        double y2  = this.cityList[j].getY();   
        
        this.distances[i][j] = euclideanDistance(x1,y1,x2,y2);
        this.distances[j][i] = this.distances[i][j];
      }
    }
    for(int i = 0; i<numberOfCities; i++){
      this.distances[i][i] = maxDistance(this.distances,i)*2;
    }
  }

  // Method that returns the maximum distance in a row of the distance matrix.
  public double maxDistance(double[][] distances,int startCity){
    double max = 0;
    for(int i = 0; i<distances.length; i++){
      if(max < distances[startCity][i]){
        max = distances[startCity][i];
      }
    }
    return max;
  }

  // Method that finds the Euclidean distance between two points.
  public double euclideanDistance(double x1, double y1, double x2, double y2) {
    double deltaX  = x1-x2;
    double deltaY  = y1-y2;
    double dist    = (Math.pow(deltaX,2)+Math.pow(deltaY,2));
    dist           = Math.sqrt(dist);
    
    return (dist);
  }
  
  
  // Method that returns the number of cities in the instance.
  public int getNumberOfCities(){
    return this.numberOfCities;
  }
  
  // Method that returns the names of the columns of the instance.
  public String[] getColumnNames(){
    return this.columns;
  }
  
  // Method that returns the list of cities of the instance.
  public City[] getCityList(){
    return this.cityList;
  }
  
  // Method that returns the distance between the cities of the instance.
  public double[][] getDistances(){
    return this.distances;
  }
  
  
  // Printing Methods //
  
  // Method that prints the distance matrix.
  public void printDistances(){
    for(int i = 0; i<this.numberOfCities; i++){
      for(int j = 0; j<this.numberOfCities; j++){
        System.out.print(this.distances[i][j]+"          ");
      }
      System.out.println();
    }
  }
  
  // Method that prints the City list.
  public void printCities(){
    for(int i = 0; i<this.numberOfCities;i++){
      this.cityList[i].printCity();
    }
  }

  // Method that prints the data of the graph.
  public void printGraph(){
    this.printCities();
    System.out.println();
    this.printDistances();
    System.out.println();
  }
}
