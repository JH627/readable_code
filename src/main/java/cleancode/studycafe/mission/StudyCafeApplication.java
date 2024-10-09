package cleancode.studycafe.mission;

import cleancode.studycafe.mission.config.MachineConfig;
import cleancode.studycafe.mission.io.ConsoleInputHandler;
import cleancode.studycafe.mission.io.ConsoleOutputHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {

        MachineConfig machineConfig = new MachineConfig(
            new ConsoleInputHandler(),
            new ConsoleOutputHandler()
        );

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(machineConfig);
        studyCafePassMachine.run();
    }

}
