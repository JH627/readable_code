package cleancode.studycafe.mission.io;

import cleancode.studycafe.mission.model.Order;
import cleancode.studycafe.mission.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.pass.StudyCafePass;

import java.util.List;

public interface OutputHandler {

    void showWelcomeMessage();

    void showAnnouncement();

    void askPassTypeSelection();

    void showPassListForSelection(List<StudyCafePass> passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(Order order);

    void showSimpleMessage(String message);

}
