package cleancode.minesweeper.tobe.minesweeper.io.sign;

import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapShot;

public interface CellSignProvidable {

    boolean supports(CellSnapShot snapShot);

    String provide(CellSnapShot cellSnapShot);

}
