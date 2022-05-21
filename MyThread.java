public class MyThread extends Thread {
    protected static int difficulty = 1;
    protected boolean stop = false;

    public void changeDifficulty(int speed) {
        this.difficulty = speed;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public void Stop(boolean stop){
        this.stop=stop;
    }

    @Override
    public void run() {
        int counter=0;
        while (!stop) {
                try {
                    Thread.sleep(500 / (difficulty));   //speed{1;7}
                    counter++;
                    if(counter%2==0) {

                        if ((Math.random()*10)<5){
                            Duck duck=new Duck(difficulty);
                            gameScene.createDuck(duck);
                            System.out.print("new duck");
                        }

                    }

                    System.out.println(difficulty);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
