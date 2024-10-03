package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.*;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();

        MineSweeper mineSweeper = new MineSweeper(gameLevel);
        mineSweeper.initialize();
        mineSweeper.run();
    }

}
