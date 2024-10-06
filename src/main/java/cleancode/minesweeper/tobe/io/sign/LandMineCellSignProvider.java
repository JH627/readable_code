package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShot;
import cleancode.minesweeper.tobe.cell.CellSnapshotStatus;

public class LandMineCellSignProvider implements CellSignProvidable {

    private static final String LAND_MINE_SIGN = "☼";

    @Override
    public boolean supports(CellSnapShot cellSnapShot) {
        return cellSnapShot.isSameStatus(CellSnapshotStatus.LAND_MINE);
    }

    @Override
    public String provide(CellSnapShot cellSnapShot) {
        return LAND_MINE_SIGN;
    }
}
