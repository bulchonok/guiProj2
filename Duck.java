import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Duck extends JButton {
    static int indexCounter = 0, ducksAlive = 0, counter = 0;
    int HP, money, index, x, y, color;
     static int ducksKilled;
    int DuckColor;

    static List<Duck> ducklist = new ArrayList<>();
    static List<Duck> aliveList = new LinkedList<>();


    public Duck(int difficulty) {
        ducklist.add(this);
        aliveList.add(this);

        this.index = indexCounter;
        this.HP = difficulty * 5;
        this.money = difficulty * (difficulty + 15);

        counter++;
        ducksAlive++;
        indexCounter++;


        x = 0;
        y = (int)(counter*(Math.random()*5)) % 5 * 140;

        color=difficulty;
        switch (difficulty) {
            case 1 -> {
                this.DuckColor = 1;
            }
            case 2 -> {
                this.DuckColor = 2;
            }
            case 3 -> {
                this.DuckColor = 3;
            }
            case 4 -> {
                this.DuckColor = 4;
            }
            case 5 -> {
                this.DuckColor = 5;
            }
            case 6 -> {
                this.DuckColor = 6;
            }
            case 7,8,9,10-> {
                this.DuckColor = 7;
            }
        }
    }

    public void duckMove() {
        x = x + 10;
    }

    public static Duck find(int ID) {
        Duck duckFound = null;
            for (int i = 0; i < ducklist.size(); i++) {
                if (ID == ducklist.get(i).index) {
                    duckFound = ducklist.get(i);
                }
            }
        return duckFound;
    }

    public int getIndex() {
        return index;
    }

    public boolean getDamage(int dmg, JButton button) {
        this.HP -= dmg;
            if (HP <= 0) {
                player.moneyUp(this.color);
                ducksKilled++;
                ducksAlive--;
                button.setVisible(false);
                aliveList.remove(this);
                return false;
            }
        return true;

    }
}
