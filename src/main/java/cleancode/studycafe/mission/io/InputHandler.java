package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.pass.StudyCafePass;
import cleancode.studycafe.mission.model.pass.StudyCafePassType;

import java.util.List;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();

}
