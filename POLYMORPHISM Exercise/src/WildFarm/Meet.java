package WildFarm;

public class Meet extends Food {
    protected Meet(int quantity) {
        super(quantity);
    }
    @Override
    public  String getType(){
        return "Meat";
    }
}
