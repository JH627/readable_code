package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShot;
import cleancode.minesweeper.tobe.cell.CellSnapshotStatus;

public class FlagCellSignProvider implements CellSignProvidable {

    private static final String FLAG_SIGN = "⚑";

    @Override
    public boolean supports(CellSnapShot cellSnapShot) {
        return cellSnapShot.isSameStatus(CellSnapshotStatus.FLAG);
    }

    @Override
    public String provide(CellSnapShot cellSnapShot) {
        return FLAG_SIGN;
    }
}
