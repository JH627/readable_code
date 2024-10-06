package cleancode.minesweeper.tobe.io.sign;

import cleancode.minesweeper.tobe.cell.CellSnapShot;
import cleancode.minesweeper.tobe.cell.CellSnapshotStatus;

import java.util.Arrays;
import java.util.Optional;

public enum CellSignProvider implements CellSignProvidable{

    EMPTY(CellSnapshotStatus.EMPTY) {
        @Override
        public String provide(CellSnapShot cellSnapShot) {
            return EMPTY_SIGN;
        }
    },
    FLAG(CellSnapshotStatus.FLAG) {
        @Override
        public String provide(CellSnapShot cellSnapShot) {
            return FLAG_SIGN;
        }
    },
    LAND_MINE(CellSnapshotStatus.LAND_MINE) {
        @Override
        public String provide(CellSnapShot cellSnapShot) {
            return LAND_MINE_SIGN;
        }
    },
    NUMBER(CellSnapshotStatus.NUMBER) {
        @Override
        public String provide(CellSnapShot cellSnapShot) {
            return String.valueOf(cellSnapShot.getNearbyLandMineCount());
        }
    },
    UNCHECKED(CellSnapshotStatus.UNCHECKED) {
        @Override
        public String provide(CellSnapShot cellSnapShot) {
            return UNCHECKED_SIGN;
        }
    },
    ;

    private static final String EMPTY_SIGN = "■";
    private static final String FLAG_SIGN = "⚑";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String UNCHECKED_SIGN = "□";

    private final CellSnapshotStatus status;

    CellSignProvider(CellSnapshotStatus status) {
        this.status = status;
    }


    @Override
    public boolean supports(CellSnapShot snapShot) {
        return snapShot.isSameStatus(status);
    }

    public static String findCellSignFrom(CellSnapShot snapShot) {
        CellSignProvider cellSignProvider = findBy(snapShot);
        return cellSignProvider.provide(snapShot);
    }

    private static CellSignProvider findBy(CellSnapShot snapShot) {
        return Arrays.stream(values())
                .filter(provider -> provider.supports(snapShot))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("확인할 수 없는 셀입니다."));
    }
}
