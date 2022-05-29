public class player {
    static int HP = 10, MaxHP = 10, dmg = 1, money=0, maxmoney=0, score=0, UpgradeCost=1;

    public static void levelup() {
        dmg = dmg + (MyThread.difficulty);
    }

    public static void moneyUp(int mon){
        money+=mon;
        maxmoney+=mon;
        gameScene.jTextArea.setText("your damage is:"+player.dmg+" your balance:"+player.money);
    }

    public static void spendMoney(){
        if (money>=UpgradeCost&&money!=0){
            money-=UpgradeCost;
        UpgradeCost= UpgradeCost*2;
        levelup();
        gameScene.jTextArea.setText("your damage is:"+player.dmg+" your balance:"+player.money);

        }

    }

    public static int getScore() {
        return score;
    }

    public static void updatescore(){
        score= (maxmoney + Duck.ducksKilled) * GameThreadTimer.getTime()*MyThread.diffMultiplyer;
    }

    public static void getDamage() {
        HP -= 1;
    }

}
