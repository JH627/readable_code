package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShot;
import cleancode.minesweeper.tobe.cell.CellSnapshotStatus;

public class EmptyCellSignProvider implements CellSignProvidable {

    private static final String EMPTY_SIGN = "■";

    @Override
    public boolean supports(CellSnapShot cellSnapShot) {
        return cellSnapShot.isSameStatus(CellSnapshotStatus.EMPTY);
    }

    @Override
    public String provide(CellSnapShot cellSnapShot) {
        return EMPTY_SIGN;
    }
}
