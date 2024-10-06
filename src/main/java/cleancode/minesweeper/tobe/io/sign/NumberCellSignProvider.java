package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShot;
import cleancode.minesweeper.tobe.cell.CellSnapshotStatus;

public class NumberCellSignProvider implements CellSignProvidable {

    @Override
    public boolean supports(CellSnapShot cellSnapShot) {
        return cellSnapShot.isSameStatus(CellSnapshotStatus.NUMBER);
    }

    @Override
    public String provide(CellSnapShot cellSnapShot) {
        return String.valueOf(cellSnapShot.getNearbyLandMineCount());
    }
}
