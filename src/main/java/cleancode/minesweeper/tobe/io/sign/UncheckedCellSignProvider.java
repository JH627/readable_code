package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShot;
import cleancode.minesweeper.tobe.cell.CellSnapshotStatus;

public class UncheckedCellSignProvider implements CellSignProvidable {

    private static final String UNCHECKED_SIGN = "□";

    @Override
    public boolean supports(CellSnapShot cellSnapShot) {
        return cellSnapShot.isSameStatus(CellSnapshotStatus.UNCHECKED);
    }

    @Override
    public String provide(CellSnapShot cellSnapShot) {
        return UNCHECKED_SIGN;
    }
}
