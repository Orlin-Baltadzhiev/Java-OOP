package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class ReportCommand extends Command {
    public ReportCommand(String[] data, UnitFactory factory, Repository repository) {
        super(data, factory, repository);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        return this.getRepository().getStatistics();
    }
}
