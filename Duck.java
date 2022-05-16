import javax.swing.*;

public class Duck extends JButton {
    int HP;
    int money;
    enum color{yellow,orange,red,purple, blue, lightblue, silver};
    String DuckColor;

    public Duck(int color,int hp, int money){
        this.HP=hp;
        this.money=money;
        switch(color){
            case 1->{this.DuckColor="/ducks/yellowduck.png";}
            case 2->{this.DuckColor="/ducks/orangeduck.png";}
            case 3->{this.DuckColor="/ducks/redduck.png";}
            case 4->{this.DuckColor="/ducks/purpleduck.png";}
            case 5->{this.DuckColor="/ducks/blueduck.png";}
            case 6->{this.DuckColor="/ducks/lightblueduck.png";}
            case 7->{this.DuckColor="/ducks/silverduck.png";}
        }


    }
    public void getDamage(int dmg){
        this.HP-=dmg;
        if (HP<0)HP=0;
        remove(this);
    }
}
