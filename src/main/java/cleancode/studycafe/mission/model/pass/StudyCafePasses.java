package cleancode.studycafe.mission.model.pass;

import java.util.List;

public class StudyCafePasses {

    private final List<StudyCafePass> studyCafePasses;

    private StudyCafePasses(List<StudyCafePass> studyCafePasses) {
        this.studyCafePasses = studyCafePasses;
    }

    public static StudyCafePasses of(List<StudyCafePass> studyCafePasses) {
        return new StudyCafePasses(studyCafePasses);
    }

    public List<StudyCafePass> filteredByStudyCafePassType(StudyCafePassType studyCafePassType) {
        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
            .toList();
    }
}
