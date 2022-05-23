public class player {
    static int HP = 5, MaxHP = 5, dmg = 1;

    public static void levelup() {
        dmg = dmg + 1;
    }

    public static void getDamage() {
        HP -= 1;
    }

}
