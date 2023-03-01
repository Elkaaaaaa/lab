package fieldCr;

import java.util.Random;
import java.util.Stack;

public class LabRoadsCreator extends FieldCreator {
    private Stack<Integer> coords = new Stack<>();

    protected LabRoadsCreator(int height, int weight) {
        super(height, weight);
    }

    private boolean checkValue(LabRoadsCreator lab) {
        for (int i = 0; i < lab.height; i++) {
            for (int j = 0; j < lab.weight; j++) {
                if (lab.field[i][j] == -3) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkNeib(LabRoadsCreator lab, int x, int y) {
        if (y == 1 & x == 1) {
            return !(lab.field[y + 2][x] != -3 & lab.field[y][x + 2] != -3);
        } else if (y == lab.height - 2 & x == lab.weight - 2) {
            return !(lab.field[y - 2][x] != -3 & lab.field[y][x - 2] != -3);
        } else if (y == height - 2 & x == 1) {
            return !(lab.field[y - 2][x] != -3 & lab.field[y][x + 2] != -3);
        } else if (y == 1 & x == weight - 2) {
            return !(lab.field[y + 2][x] != -3 & lab.field[y][x - 2] != -3);
        } else if (y == 1) {
            return !(lab.field[y + 2][x] != -3 & lab.field[y][x + 2] != -3 & lab.field[y][x - 2] != -3);
        } else if (y == height - 2) {
            return !(lab.field[y][x + 2] != -3 & lab.field[y][x - 2] != -3 & lab.field[y - 2][x] != -3);
        } else if (x == 1) {
            return !(lab.field[y + 2][x] != -3 & lab.field[y][x + 2] != -3 & lab.field[y - 2][x] != -3);
        } else if (x == weight - 2) {
            return !(lab.field[y + 2][x] != -3 & lab.field[y][x - 2] != -3 & lab.field[y - 2][x] != -3);
        } else
            return !(x < weight - 2 & y < height - 2 & (lab.field[y + 2][x] != -3 & lab.field[y][x + 2] != -3
                    & lab.field[y - 2][x] != -3 & lab.field[y][x - 2] != -3));
    }

    private int switchX(LabRoadsCreator lab, int x, int y, int k) {
        for (int i = 0; i <= 2; i++) {
            lab.field[y][x + i * k] = -2;
        }
        this.coords.add(y);
        this.coords.add(x);
        x = x + 2 * k;
        return x;
    }

    private int switchY(LabRoadsCreator lab, int x, int y, int k) {
        for (int i = 0; i <= 2; i++) {
            lab.field[y + i * k][x] = -2;
        }
        this.coords.add(y);
        this.coords.add(x);
        y = y + 2 * k;
        return y;
    }

    public void create(LabRoadsCreator lab) {
        Random rand = new Random();
        int x = 1;
        int y = 1;
        int random;
        while (checkValue(lab)) {
            while (checkNeib(lab, x, y)) {
                random = rand.nextInt(5);
                switch (random) {
                    case 1:
                        if (y - 2 > 0) {
                            if (field[y - 2][x] == -3) {
                                y = switchY(lab, x, y, -1);
                                break;
                            }
                        }
                    case 2:
                        if (x + 2 < weight - 1) {
                            if (field[y][x + 2] == -3) {
                                x = switchX(lab, x, y, 1);
                                break;
                            }
                        }
                    case 3:
                        if (y + 2 < height - 1) {
                            if (field[y + 2][x] == -3) {
                                y = switchY(lab, x, y, 1);
                                break;
                            }
                        }
                    case 4:
                        if (x - 2 > 0) {
                            if (field[y][x - 2] == -3) {
                                x = switchX(lab, x, y, -1);
                                break;
                            }
                        }
                }
            }
            x = coords.pop();
            y = coords.pop();
        }
    }
}
