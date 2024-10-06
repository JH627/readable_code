package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShot;

public interface CellSignProvidable {

    boolean supports(CellSnapShot snapShot);

    String provide(CellSnapShot cellSnapShot);

}
