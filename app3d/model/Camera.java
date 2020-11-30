package app3d.model;

import app3d.App3d;

public class Camera {

  public final double MOVE_SPEED = .08;
  public final double ROTATION_SPEED = .045;

  public double xPos, yPos, xDir, yDir, xPlane, yPlane;
  private App3d app;

  public Camera(App3d app, double xPos, double yPos, double xDir, double yDir, double xPlane, double yPlane) {
    System.out.println("Constructing Camera");
    this.app = app;
    this.xPos = xPos;
    this.yPos = yPos;
    this.xDir = xDir;
    this.yDir = yDir;
    this.xPlane = xPlane;
    this.yPlane = yPlane;
  }

  public void update() {
    if (app.controller.forward) {
      if (app.model.map[(int) (xPos + xDir * MOVE_SPEED)][(int) yPos] == 0) {
        xPos += xDir * MOVE_SPEED;
      }
      if (app.model.map[(int) xPos][(int) (yPos + yDir * MOVE_SPEED)] == 0) {
        yPos += yDir * MOVE_SPEED;
      }
    }
    if (app.controller.back) {
      if (app.model.map[(int) (xPos - xDir * MOVE_SPEED)][(int) yPos] == 0) {
        xPos -= xDir * MOVE_SPEED;
      }
      if (app.model.map[(int) xPos][(int) (yPos - yDir * MOVE_SPEED)] == 0) {
        yPos -= yDir * MOVE_SPEED;
      }
    }
    if (app.controller.right) {
      double oldxDir = xDir;
      xDir = xDir * Math.cos(-ROTATION_SPEED) - yDir * Math.sin(-ROTATION_SPEED);
      yDir = oldxDir * Math.sin(-ROTATION_SPEED) + yDir * Math.cos(-ROTATION_SPEED);
      double oldxPlane = xPlane;
      xPlane = xPlane * Math.cos(-ROTATION_SPEED) - yPlane * Math.sin(-ROTATION_SPEED);
      yPlane = oldxPlane * Math.sin(-ROTATION_SPEED) + yPlane * Math.cos(-ROTATION_SPEED);
    }
    if (app.controller.left) {
      double oldxDir = xDir;
      xDir = xDir * Math.cos(ROTATION_SPEED) - yDir * Math.sin(ROTATION_SPEED);
      yDir = oldxDir * Math.sin(ROTATION_SPEED) + yDir * Math.cos(ROTATION_SPEED);
      double oldxPlane = xPlane;
      xPlane = xPlane * Math.cos(ROTATION_SPEED) - yPlane * Math.sin(ROTATION_SPEED);
      yPlane = oldxPlane * Math.sin(ROTATION_SPEED) + yPlane * Math.cos(ROTATION_SPEED);
    }
  }

}
