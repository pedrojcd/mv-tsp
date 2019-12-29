// class of edges used in cases with multiplicity
public class Edge_MVTSP{
  
  private int      startCity;
  private int      endCity;
  private int      multiplicity;
  
  // Method that creates an Edge
  public Edge_MVTSP(int v, int u, int multiplicity){
    this.startCity    = v;
    this.endCity      = u;
    this.multiplicity = multiplicity;
  }
  
  // Method that returns the start city of an Edge_MVTSP
  public int getStartCity(){
    return this.startCity;
  }
  
  // Method that returns the end city of an Edge_MVTSP
  public int getEndCity(){
    return this.endCity;
  }
  
  // Method that returns the multiplicity of an Edge_MVTSP
  public int getMultiplicity(){
    return this.multiplicity;
  }

  // Method that adds +1 to the multiplicity of an Edge_MVTSP
  public void addMultiplicity(){
    this.multiplicity++;
  }
  
  // Method that prints an Edge_MVTSP
  public void printEdgeMVTSP(){
    System.out.println("("+this.startCity+","+this.endCity+";"+this.multiplicity+")");
  }
  
  // Method that compares two Edge_MVTSP depending on their start and end city
  public boolean isSameEdge(Edge_MVTSP edge){
    if( (this.startCity == edge.getStartCity()) && (this.endCity == edge.getEndCity()) ){
      return true;
    }
    else{
      return false;
    }
  }
}
