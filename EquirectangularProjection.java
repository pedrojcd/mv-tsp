// Packages to read data and use Lists
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

// run EquirectangularProjection djibouti
// run EquirectangularProjection quatar
// run EquirectangularProjection luxembourg
// run EquirectangularProjection rwanda
// run EquirectangularProjection belgium

// Program that transforms real coordinates to coordinates on a 2D plane
public class EquirectangularProjection{

  public static ArrayList<ArrayList<String>> reader(String filename)
    throws java.io.FileNotFoundException{
    ArrayList<ArrayList<String>> records = new ArrayList<>();
    
    try (Scanner scanner = new Scanner(new File(filename));) {
      while (scanner.hasNextLine()) {
        records.add(getRecordFromLine(scanner.nextLine()));
      }
    }
    return records;
  }
  
  public static ArrayList<String> getRecordFromLine(String line) {
    ArrayList<String> values = new ArrayList<String>();
    try (Scanner rowScanner = new Scanner(line)) {
      rowScanner.useDelimiter(",");
      while (rowScanner.hasNext()) {
        values.add(rowScanner.next());
      }
    }
    return values;
  }
  
  public static void print(ArrayList<ArrayList<String>> csvFile){
    for(int i = 0; i<csvFile.size(); i++){
      for(int j=0; j<csvFile.get(i).size(); j++){
        System.out.print(csvFile.get(i).get(j) + "    ");
      }
      System.out.println();
    }
  }
  

  public static void txtInputCreator(ArrayList<ArrayList<String>> csvFile, String filename)
    throws java.io.IOException{
    File output       = new File(filename+"_Input.txt");
    FileWriter fw     = new FileWriter(output,true);
    BufferedWriter bw = new BufferedWriter(fw);
    
    bw.write( (csvFile.size()-1) + "\r\n" );
    bw.write( "index   x            y" + "\r\n" );
    for (int i = 1;i<csvFile.size();i++){
      double r = 6371;

      double x  = r*degreeToRadian(Double.parseDouble(csvFile.get(i).get(2)) /1000);
      double y  = r*degreeToRadian(Double.parseDouble(csvFile.get(i).get(1)) /1000);

      bw.write( (i-1) + "       " + x + "     " + y + "\r\n" );
    }   
    
    bw.close ();  
  }

  // Transforms degrees into radians
  public static double degreeToRadian(double degree) {
    return (degree * Math.PI / 180.0);
  }

  // Method that rewrites the multiplicities as a vector in the form of a txt file
  public static void txtMultiplicityCreator(ArrayList<ArrayList<String>> csvFile, String filename)
    throws java.io.IOException{
    File output       = new File(filename+"_Multiplicities.txt");
    FileWriter fw     = new FileWriter(output,true);
    BufferedWriter bw = new BufferedWriter(fw);
    
    bw.write( "m" + "\r\n" );
    Random random = new Random(1234);
    for (int i = 0; i < (csvFile.size()-1) ;i++){
      int newRandom = random.nextInt(10)+1;

      bw.write( newRandom + "\r\n" );
    }   
    
    bw.close ();  
  }
  
  public static void main(String[] args) throws java.io.FileNotFoundException{
    String filename = args[0];
    
    ArrayList<ArrayList<String>> csvFileData = reader(filename+".txt");
    //print(csvFileData);
    
    try{
      txtInputCreator(csvFileData,filename);
      txtMultiplicityCreator(csvFileData,filename);
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}