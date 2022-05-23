

public class GameThreadTimer extends Thread {
    protected static int Time=0;

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
                Thread.sleep(1000);
                Time++;
                int seconds,minutes;
                seconds=Time%60;
                minutes=Time/60;
                String secs = null, mins = null;
                if (seconds<10)secs= "0" + seconds;
                else secs= String.valueOf(seconds);
                if (minutes<10)mins= "0" + minutes;
                else mins= String.valueOf(minutes);
                gameScene.Timer.setText("Time: 00:"+mins+":"+secs);

                player.updatescore();
                gameScene.Score.setText("SCORE:\n"+player.getScore());

            } catch (InterruptedException e) {

            }
        }
    }
}
