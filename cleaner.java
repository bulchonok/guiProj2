public class cleaner {
    public static void clean() {
        Duck.ducklist.removeAll(Duck.ducklist);
        Duck.aliveList.removeAll(Duck.aliveList);
        gameScene.buttonList.removeAll(gameScene.buttonList);
        gameScene.heartlist.removeAll(gameScene.heartlist);
        Duck.indexCounter = 0;
        Duck.ducksAlive = 0;
        Duck.counter = 0;
        Duck.ducksKilled = 0;

        controller.gamescore = 0;
        controller.gameover = false;

        GameThreadTimer.Time = 0;

        player.HP = 10;
        player.MaxHP = 10;
        player.dmg = 1;
        player.money = 0;
        player.maxmoney = 0;
        player.score = 0;
        player.UpgradeCost=1;

        MyThread.difficulty = 1;
        System.out.println("succesful");
    }
}
