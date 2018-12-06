public class PathFind {

  /**
   * Class to hold individual point (city) that can be traveled through
   * Constructor needs:
   * @param x-position
   * @param y-position
   */
  private static class Node {
    public boolean isOpen = true;
    public int x,y;
    public int cost;
    public Node parent;

    public Node (int _x, int _y) {
      x = _x;
      y = _y;
    }

    public static double getDistanceFromPoint(int targetX, int targetY) {
      return(4.3); // TODO: write getDistanceFromPoint method
    }
  }


  /**
   * MAIN CLASS BEGINS HERE
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Edited from IntelliJ");
    Node n = new Node(1,1);
  }
}