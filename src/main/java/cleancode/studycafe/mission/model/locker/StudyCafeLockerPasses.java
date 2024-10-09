package cleancode.studycafe.mission.model.locker;

import cleancode.studycafe.mission.model.pass.StudyCafePass;

import java.util.List;

public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> studyCafeLockerPasses;

    private StudyCafeLockerPasses(List<StudyCafeLockerPass> studyCafeLockerPasses) {
        this.studyCafeLockerPasses = studyCafeLockerPasses;
    }

    public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> studyCafeLockerPasses) {
        return new StudyCafeLockerPasses(studyCafeLockerPasses);
    }

    public StudyCafeLockerPass getSameTypeAndDurationPass(StudyCafePass selectedPass) {
        return studyCafeLockerPasses.stream()
            .filter(option -> option.isSamePassTypeAndDuration(selectedPass.getPassType(), selectedPass.getDuration()))
            .findFirst()
            .orElse(null);
    }
}
