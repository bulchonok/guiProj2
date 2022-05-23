public class MyThread extends Thread {
    protected static int difficulty = 1;
    protected static int diffMultiplyer =1;
    protected boolean stop = false;

    public void changeDifficulty(int speed) {
        this.difficulty = speed;
    }
        public MyThread(int diff){
        diffMultiplyer=diff;
        }


    @Override
    public void run() {
        int counter=0;
        while (!Thread.interrupted()){
            if (player.HP<=0){
                controller.killGameThread(this);
            }
            try {

                Thread.sleep(200 / (difficulty));   //speed{1;7}

                counter++;
                if ((counter%(100/diffMultiplyer))==0&&difficulty<10)difficulty++;
                if(Duck.ducksAlive<5) {


                    if ((counter%(11-difficulty)==0)&&(Math.random()*17)<12/((diffMultiplyer+1)/2)){
                        Duck duck=new Duck( difficulty );
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

                return;
            }
            gameScene.GamePanel.updateUI();
        }
    }




}
