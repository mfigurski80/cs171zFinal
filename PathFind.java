import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PathFind {

  /**
   * Class to hold individual point (city) that can be traveled through
   * Constructor needs:
   * @param name
   * @param position-x
   * @param position-y
   */
  private static class City {
    public boolean isOpen = true;
    public String name = new String();
    public double x,y;
    public double cost;
    public Connection parent;
    public ArrayList connections = new ArrayList();

    public City (String _name, double _x, double _y) {
      name = _name;
      x = _x;
      y = _y;
    }

    public double distanceFrom(double targetX, double targetY) {
      double dX = x - targetX;
      double dY = y - targetY;
      return (Math.sqrt(dX*dX + dY*dY));
    }
    public double distanceFrom(City target) {
      return (distanceFrom(target.x, target.y));
    }

    public String toString() {
      return name + " -- x:" + x + "; y:" + y;
    }
  }

  /**
   * Class to hold connections between individual cities
   * Constructor needs:
   * @param name
   * @param city to begin at
   * @param city to end at
   */
  private static class Connection {
    public String name;
    public City[] connects = new City[2];

    public Connection (String _name, City a, City b) {
      name = _name;
      connects[0] = a;
      connects[1] = b;
    }
  }

  /**
   * MAIN CLASS BEGINS HERE
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("[Running...]");

    Scanner sc;
    try {
      sc = new Scanner(new File(args[0]));
    } catch(FileNotFoundException err) { // woot, file doesn't exist.
      System.out.println("[Couldn't find " + args[0] + ". You got some serious problems rn]");
      sc = new Scanner(System.in);
    }

    int citiesCount = sc.nextInt(); // get amount of cities
    sc.nextLine(); // clear rest of that line (it's empty)

    // TODO: GET CITY DATA
    String[] cityNames = new String[citiesCount]; // holds all the NAMES of the cities
    City[] cities = new City[citiesCount];        // hold all the city OBJECTS
    for (int i = 0; i < citiesCount; i++) { // divide string into these ^^
      String[] data = sc.nextLine().split("\\s+");
      cityNames[i] = data[0];
      cities[i] = new City(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }

    for (City i : cities) {
      System.out.println(i.toString());
    }

    // TODO: GET CONNECTION DATA

  }
}