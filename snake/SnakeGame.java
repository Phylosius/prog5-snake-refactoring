package snake;

import java.util.List;
import java.util.Random;

public class SnakeGame {
  private final static int SCREEN_WIDTH = 20;
  private final static int SCREEN_HEIGHT = 40;

  private Snake snake;
  private Food food;
  private int score;

  public SnakeGame() {
    this.snake = new Snake(List.of(new Position(10, 10), new Positon(10, 9), new Position(10, 8)));
    this.food = Food.atRandomPosition(SCREEN_WIDTH, SCREEN_HEIGHT);
    this.score = 0;
  }
}

public record Position(int x, int y) {

  public Position add(int x, int y) {
    new Position(this.x + x, this.y + y);
  }
}

public enum Direction {
  UP(0, 1), DOWN(0, -1), LEFT(-1, 0), RIGHT(1, 0)

  private int vx;
  private int vy;

  public Direction(int vx, int vy) {
    this.vx = vx;
    this.vy = vy;
  }

  public Direction opposite() {
    return switch (this) {
      case UP -> DOWN;
      case DOWN -> UP;
      case LEFT -> RIGHT;
      case RIGHT -> LEFT;
    }
  }
}

public record Food(Position position) {

  public static Food atRandomPosition(int xMax, int yMax) {
    return new Food(
        Random random = new Random();
    new Position(random.nexInt(xMax - 2) + 1, random.nexInt(yMax - 2) + 1)
    )
  }
}

public class Snake {
  private List<Position> body;
  private Direction direction;

  public Snake(List<Position> body) {
    this.body = body;
    this.direction = Direction.RIGHT;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public List<Position> getBody() {
    return body;
  }

  public Position getHead() {
    return body.get(0);
  }

  public void move(Direction direction, boolean grow) {
    body.add(0, newHead);

    if (grow) return;
    body.remove(body.size() - 1);
  }
}