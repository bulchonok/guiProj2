
public class GameThreadTimer extends Thread {
     static int Time=0;

    public static int getTime() {
        return Time;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            if (player.HP<=0){
                controller.killGameThread(this);
            }
                try {
                    String secs = null, mins = null;
                    int seconds,minutes;

                    Thread.sleep(1000);

                    Time++;
                    seconds=Time%60;
                    minutes=Time/60;

                        if (seconds<10)secs= "0" + seconds;
                        else secs= String.valueOf(seconds);

                        if (minutes<10)mins= "0" + minutes;
                        else mins= String.valueOf(minutes);

                    player.updatescore();

                    gameScene.Timer.setText("Time: 00:"+mins+":"+secs);
                    gameScene.Score.setText("SCORE:\n"+player.getScore());

                } catch (InterruptedException e) {
                    return;//
                }
        }
    }
}
