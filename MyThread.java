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
                    if(Duck.ducksAlive<5) {


                        if ((counter%2==0)&&(Math.random()*10)<5){
                            Duck duck=new Duck(difficulty);
                            gameScene.createDuck(duck);
                            System.out.print("new duck");
                        }

                    }else{
                        System.out.println("too many ducks-> duck can't be created");
                    }

                    for (int i = 0; i < gameScene.buttonList.size(); i++) {
                        if (gameScene.buttonList.get(i).isEnabled()) {
                            Duck duck =Duck.find(Integer.parseInt(gameScene.buttonList.get(i).getName()));
                            duck.duckMove();
                            int x = duck.x;
                            int y = duck.y;
                            if (x==1250){
                                Duck.ducksAlive--;
                                gameScene.buttonList.get(i).setVisible(false);
                                duck.aliveList.remove(this);
                            }
                            gameScene.buttonList.get(i).setBounds(x,y,150, 150);
                            System.out.println("==================");
                        }
                    }

                    System.out.println(difficulty);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            gameScene.GamePanel.updateUI();
        }
    }
}
