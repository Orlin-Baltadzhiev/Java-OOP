package military.entities;

import military.Interfaces.SpecialisedSoldier;
import military.enums.Corps;

public abstract class SpecialisedSoldierImpl extends PrivateImpl  implements SpecialisedSoldier {
    private Corps corps;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps=corps;
    }
}
