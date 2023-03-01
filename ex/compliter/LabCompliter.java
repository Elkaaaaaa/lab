package compliter;

import java.util.ArrayDeque;
import java.util.Deque;

import fieldCr.LabCreator;

public class LabCompliter {
    public static void complite(LabCreator lab) {
        Deque<Integer> coordsQueue = new ArrayDeque<>();
        int x = 1;
        int y = 1;
        int count = 1;
        lab.field[y][x] = 0;
        while (lab.field[y][x] != -4) {
            if (lab.field[y + 1][x] == -2) {
                lab.field[y + 1][x] = count;
                coordsQueue.addFirst(y + 1);
                coordsQueue.addFirst(x);
            }
            if (lab.field[y - 1][x] == -2) {
                lab.field[y - 1][x] = count;
                coordsQueue.addFirst(y - 1);
                coordsQueue.addFirst(x);
            }
            if (lab.field[y][x + 1] == -2) {
                lab.field[y][x + 1] = count;
                coordsQueue.addFirst(y);
                coordsQueue.addFirst(x + 1);
            }
            if (lab.field[y][x - 1] == -2) {
                lab.field[y][x - 1] = count;
                coordsQueue.addFirst(y);
                coordsQueue.addFirst(x - 1);
            }
            if (lab.field[y + 1][x] == -4) {
                coordsQueue.addFirst(y + 1);
                coordsQueue.addFirst(x);
            }
            if (lab.field[y - 1][x] == -4) {
                coordsQueue.addFirst(y - 1);
                coordsQueue.addFirst(x);
            }
            if (lab.field[y][x + 1] == -4) {
                coordsQueue.addFirst(y);
                coordsQueue.addFirst(x + 1);
            }
            if (lab.field[y][x - 1] == -4) {
                coordsQueue.addFirst(y);
                coordsQueue.addFirst(x - 1);
            }
            y = coordsQueue.pollLast();
            x = coordsQueue.pollLast();
            count++;
        }
        System.out.println("Количество ходов для выхода: " + count);
        count--;

        while (lab.field[y][x] != 0) {
            if (lab.field[y + 1][x] == count) {
                lab.field[y + 1][x] = -5;
                y = y + 1;
            }
            if (lab.field[y - 1][x] == count) {
                lab.field[y - 1][x] = -5;
                y = y - 1;
            }
            if (lab.field[y][x + 1] == count) {
                lab.field[y][x + 1] = -5;
                x = x + 1;
            }
            if (lab.field[y][x - 1] == count) {
                lab.field[y][x - 1] = -5;
                x = x - 1;
            }
            if (lab.field[y + 1][x] == 0) {
                y = y + 1;
            }
            if (lab.field[y - 1][x] == 0) {
                y = y - 1;
            }
            if (lab.field[y][x + 1] == 0) {
                x = x + 1;
            }
            if (lab.field[y][x - 1] == 0) {
                x = x - 1;
            }
            count--;
        }
    }
}