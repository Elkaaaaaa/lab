import compliter.LabCompliter;
import fieldCr.LabCreator;

public class UI {
    public static void main(String[] args) {
        LabCreator lab = LabCreator.create(15,75,2);
        LabCreator.print(lab);
        LabCompliter.complite(lab);
        LabCreator.print(lab);
    }
}
