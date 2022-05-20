public class MyThread extends Thread {
    protected int difficulty = 1;
    protected boolean stop = false;

    public void changeDifficulty(int speed) {
        this.difficulty = speed;
    }

    public void Stop(boolean stop){
        this.stop=stop;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(1000 / (difficulty));   //speed{1;7}
                Duck duck=new Duck(difficulty);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
