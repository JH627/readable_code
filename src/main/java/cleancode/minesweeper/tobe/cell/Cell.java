package cleancode.minesweeper.tobe.cell;

public interface Cell {

    boolean isLandMine();

    boolean hasLandMineCount();

    CellSnapShot getSnapshot();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();

}