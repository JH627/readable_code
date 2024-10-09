package cleancode.studycafe.mission;

import cleancode.studycafe.mission.config.MachineConfig;
import cleancode.studycafe.mission.exception.AppException;
import cleancode.studycafe.mission.io.InputHandler;
import cleancode.studycafe.mission.io.OutputHandler;
import cleancode.studycafe.mission.io.StudyCafeFileHandler;
import cleancode.studycafe.mission.model.Order;
import cleancode.studycafe.mission.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.mission.model.locker.StudyCafeLockerPasses;
import cleancode.studycafe.mission.model.pass.StudyCafePass;
import cleancode.studycafe.mission.model.pass.StudyCafePassType;
import cleancode.studycafe.mission.model.pass.StudyCafePasses;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final StudyCafeFileHandler studyCafeFileHandler;

    public StudyCafePassMachine(MachineConfig config) {
        this.inputHandler = config.getInputHandler();
        this.outputHandler = config.getOutputHandler();
        studyCafeFileHandler = new StudyCafeFileHandler();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            Order order = createOrder();
            outputHandler.showPassOrderSummary(order);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private Order createOrder() {
        StudyCafePassType selectedPassType = getSelectedPassType();
        StudyCafePass selectedPass = getSelectedPassFrom(selectedPassType);

        StudyCafeLockerPass lockerPass = null;
        if (doesUserChooseFixedCafeType(selectedPassType)) {
            lockerPass = getLockerPassBy(selectedPass);
            if (doesUserUseLocker(lockerPass)) {
                return Order.of(selectedPass, lockerPass);
            }
        }

        return Order.of(selectedPass, null);
    }

    private StudyCafePassType getSelectedPassType() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private StudyCafePass getSelectedPassFrom(StudyCafePassType selectedPassType) {
        List<StudyCafePass> passes = getPassesFilteredBy(selectedPassType);
        outputHandler.showPassListForSelection(passes);
        return inputHandler.getSelectPass(passes);
    }

    private List<StudyCafePass> getPassesFilteredBy(StudyCafePassType studyCafePassType) {
        StudyCafePasses studyCafePasses = StudyCafePasses.of(studyCafeFileHandler.readStudyCafePasses());
        return studyCafePasses.filteredByStudyCafePassType(studyCafePassType);
    }

    private boolean doesUserChooseFixedCafeType(StudyCafePassType studyCafePassType) {
        return studyCafePassType == StudyCafePassType.FIXED;
    }

    private StudyCafeLockerPass getLockerPassBy(StudyCafePass selectedPass) {
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(studyCafeFileHandler.readLockerPasses());
        return lockerPasses.getSameTypeAndDurationPass(selectedPass);
    }

    private boolean doesUserUseLocker(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
        return inputHandler.getLockerSelection();
    }

}
