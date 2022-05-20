import javax.swing.*;

public class Duck extends JButton {
    int HP;
    int money;
    enum color{yellow,orange,red,purple, blue, lightblue, silver};
    String DuckColor;

    JButton jButton=new JButton();



    public Duck(int difficulty){
        this.HP=difficulty*5;
        this.money=difficulty*(difficulty+15);
        switch(difficulty){//change jbutton icon
            case 1->{this.DuckColor="/src/ducks/yellowduck.png";}
            case 2->{this.DuckColor="/src/ducks/orangeduck.png";}
            case 3->{this.DuckColor="/src/ducks/redduck.png";}
            case 4->{this.DuckColor="/src/ducks/purpleduck.png";}
            case 5->{this.DuckColor="/src/ducks/blueduck.png";}
            case 6->{this.DuckColor="/src/ducks/lightblueduck.png";}
            case 7->{this.DuckColor="/src/ducks/silverduck.png";}
        }


    }
    public void Move(){
        //moves duck with speed + if x=end - die

    }
    public void getDamage(int dmg){
        this.HP-=dmg;
        if (HP<0)HP=0;
        remove(this);
    }
}
