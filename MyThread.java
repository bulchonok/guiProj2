public class MyThread extends Thread {
    protected static int difficulty = 1;
    protected boolean stop = false;

    public void changeDifficulty(int speed) {
        this.difficulty = speed;
    }



    @Override
    public void run() {
        int counter=0;
        while (!stop) {
            if (player.HP<=0){
            GameEnd();
        }
                try {
                    Thread.sleep(200 / (difficulty));   //speed{1;7}

                    counter++;
                    if (counter%25==0&&difficulty<10)difficulty++;
                    if(Duck.ducksAlive<5) {


                        if ((counter%(11-difficulty)==0)&&(Math.random()*10)<5){
                            Duck duck=new Duck(difficulty);
                            gameScene.createDuck(duck);
                            System.out.print("new duck");
                        }

                    }
                    /*else{
                        System.out.println("too many ducks-> duck can't be created");
                    }*/

                    for (int i = 0; i < gameScene.buttonList.size(); i++) {
                        if (gameScene.buttonList.get(i).isEnabled()) {
                            Duck duck =Duck.find(Integer.parseInt(gameScene.buttonList.get(i).getName()));
                            duck.duckMove();
                            int x = duck.x;
                            int y = duck.y;
                            if (x==870){
                                Duck.ducksAlive--;
                                gameScene.buttonList.get(i).setVisible(false);
                                duck.aliveList.remove(this);
                                player.getDamage();

                                gameScene.deleteHP();
                                gameScene.showHP();
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

    private void GameEnd() {
        controller.killGameThread(this);
    }


}
