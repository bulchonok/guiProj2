public class player {
    static int HP = 5, MaxHP = 5, dmg = 1, money=0, maxmoney=0, score=0;

    public static void levelup() {
        dmg = dmg + 1;
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
