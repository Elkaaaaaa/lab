package fieldCr;

public class LabCreator extends ExitCreator {
    protected LabCreator(int height, int weight) {
        super(height, weight);
    }

    public static LabCreator create(int hight, int weight, int exit) {
        LabCreator lab = new LabCreator(hight, weight);
        lab.createEnterExit(lab, exit);
        return lab;
    }
}