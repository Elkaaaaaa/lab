package fieldCr;


public class FieldCreator {
    public int height;
    public int weight;
    public int[][] field;

    public FieldCreator(int hight, int weight) {
        this.weight = weight;
        this.height = hight;
        this.field = new int[hight][weight];

        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < weight; j++) {
                if ((i % 2 != 0 && j % 2 != 0) && (i < hight - 1 && j < weight - 1)) {
                    field[i][j] = -3;
                } else {
                    field[i][j] = -1;
                }
            }
        }
    }

    public static void print(FieldCreator field) {
        for (int i = 0; i < field.height; i++) {
            for (int j = 0; j < field.weight; j++) {
                if (field.field[i][j] == -1) {
                    System.out.print("■ "); // wall
                } else if (field.field[i][j] == -2) {
                    System.out.print("  "); // road
                } else if (field.field[i][j] == -3) {
                    System.out.print("  "); // blanck space
                } else if (field.field[i][j] == -4) {
                    System.out.print("x "); // exit
                } else if (field.field[i][j] == 0) {
                    System.out.print("E "); // enter
                } else if (field.field[i][j] == -5) {
                    System.out.print("· ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
