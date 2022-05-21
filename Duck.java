import javax.swing.*;

public class Duck extends JButton {
    static int indexCounter=0;
    int HP;
    int money;
    enum color{yellow,orange,red,purple, blue, lightblue, silver};
    String DuckColor;
    int index;

    JButton jButton=new JButton();

    public void changeDuckProps(int HP, int money, String DuckColor ){
        this.DuckColor=DuckColor;
        this.HP=HP;
        this.money=money;
    }


    public Duck(int difficulty){
        this.index=indexCounter;
        System.out.println(index+"-- index");
        this.HP=difficulty*5;
        this.money=difficulty*(difficulty+15);
        switch(difficulty){//change jbutton icon
            case 1->{this.DuckColor="yellow";}
            case 2->{this.DuckColor="orange";}
            case 3->{this.DuckColor="red";}
            case 4->{this.DuckColor="purple";}
            case 5->{this.DuckColor="blue";}
            case 6->{this.DuckColor="lightblue";}
            case 7->{this.DuckColor="silver";}
        }

indexCounter++;
    }
    public void Move(){
        //moves duck with speed + if x=end - die

    }

    public int getIndex() {
        return index;
    }

    public boolean getDamage(int dmg){
        this.HP-=dmg;
        if (HP<=0){
            return false;
        }
        return true;

    }
}
