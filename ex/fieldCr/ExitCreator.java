package fieldCr;

import java.util.Random;

abstract class ExitCreator extends LabRoadsCreator {
    protected ExitCreator(int height, int weight) {
        super(height, weight);
    }

    protected void createEnterExit(LabRoadsCreator lab, int count) {
        lab.create(lab);
        lab.field[1][1] = 0;
        int counter = 0;
        while (counter < count) {
            int i = new Random().nextInt(1, height - 1);
            int j = new Random().nextInt(1, weight - 1);
            if (lab.field[i][j] == -2) {
                lab.field[i][j] = -4;
                counter++;
            }
        }
    }
}
