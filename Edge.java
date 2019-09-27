// class of edges used in cases with no multiplicity
public class Edge{
  
 private int      startCity;
 private int      endCity;
 private double   distance;

 
 // Method that creates an Edge
 public Edge(int v, int u, double distance){
  this.startCity = v;
  this.endCity   = u;
  this.distance  = distance;
 }

 // Method that returns the start city of an Edge
 public int getStartCity(){
  return this.startCity;
 }

 // Method that returns the end city of an Edge
 public int getEndCity(){
  return this.endCity;
 }

 // Method that returns the distance/cost of an Edge
 public double getDistance(){
  return this.distance;
 }

 // Method that prints an Edge
 public void printEdge(){
  System.out.println("("+this.startCity+","+this.endCity+";"+this.distance+")");
 }
}