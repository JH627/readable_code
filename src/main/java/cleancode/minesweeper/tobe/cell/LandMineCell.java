package cleancode.minesweeper.tobe.cell;

public class LandMineCell implements Cell {

    private final CellState cellState = CellState.initialize();

    @Override
    public boolean isLandMine() {
        return true;
    }

    @Override
    public boolean hasLandMineCount() {
        return false;
    }

    @Override
    public CellSnapShot getSnapshot() {
        if (cellState.isOpened()) {
            return CellSnapShot.ofLandMine();
        }
        if (cellState.isFlagged()) {
            return CellSnapShot.ofFlag();
        }
        return CellSnapShot.ofUnchecked();
    }

    @Override
    public void flag() {
        cellState.flag();
    }

    @Override
    public void open() {
        cellState.open();
    }

    @Override
    public boolean isChecked() {
        return cellState.isChecked();
    }

    @Override
    public boolean isOpened() {
        return cellState.isOpened();
    }
}
