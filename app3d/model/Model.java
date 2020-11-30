package app3d.model;

import app3d.App3d;
import app3d.utilities.Loader;

public class Model {

  public final String MAP_URL = "app3d/resources/map.txt";

  public final Camera camera;

  public int[][] map = Loader.load2dIntegerArray(MAP_URL);
  public final int mapHeight = map.length;
  public final int mapWidth = map[0].length;

  public Model(App3d app) {
    System.out.println("Constructing Model");
    camera = new Camera(app, 4.5, 4.5, 1, 0, 0, -0.66);
  }

}
