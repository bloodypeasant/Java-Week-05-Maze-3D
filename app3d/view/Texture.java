package app3d.view;

import java.util.ArrayList;
import app3d.utilities.Loader;

public class Texture {

  public static ArrayList<Texture> textures = new ArrayList<Texture>();

  static {
    textures.add(new Texture("app3d/resources/wood.png", 64));
    textures.add(new Texture("app3d/resources/redbrick.png", 64));
    textures.add(new Texture("app3d/resources/bluestone.png", 64));
    textures.add(new Texture("app3d/resources/greystone.png", 64));
    textures.add(new Texture("app3d/resources/newwood.png", 64));
    textures.add(new Texture("app3d/resources/newred.png", 64));
    textures.add(new Texture("app3d/resources/newtess.jpg", 64));
  }

  public final int[] pixels;
  public final int size;

  public Texture(String url, int size) {
    System.out.println("Constructing Texture from " + url);
    this.size = size;
    pixels = new int[size * size];
    Loader.loadAsBufferedImage(url).getRGB(0, 0, size, size, pixels, 0, size);
  }

}
