package cleancode.studycafe.mission.model;

import cleancode.studycafe.mission.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.pass.StudyCafePass;

public class Order {

    private final StudyCafePass studyCafePass;
    private final StudyCafeLockerPass studyCafeLockerPass;

    private Order(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        this.studyCafePass = studyCafePass;
        this.studyCafeLockerPass = studyCafeLockerPass;
    }

    public static Order of(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        return new Order(studyCafePass, studyCafeLockerPass);
    }

    public StudyCafePass getStudyCafePass() {
        return studyCafePass;
    }

    public StudyCafeLockerPass getStudyCafeLockerPass() {
        return studyCafeLockerPass;
    }
}
