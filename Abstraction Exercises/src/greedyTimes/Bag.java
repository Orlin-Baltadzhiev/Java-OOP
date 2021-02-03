package greedyTimes;

public class Bag {
    private CashContainer cashContainer;
    private Gold gold;
    private GemContainer gemContainer;
    private long capacity;

    public Bag(long capacity) {
        this.cashContainer =new CashContainer();
        this.gold =new Gold();
        this.gemContainer = new GemContainer();
        this.capacity=capacity;
    }

    public boolean hasRoomFor(Long value) {
        return  value + this.getCurrentSize()  <=capacity;
    }

    private Long getCurrentSize() {
        long size = this.gold.getValue();
        size += this.cashContainer.getvalue();
        size += this.gemContainer.getSize();

        return size;
    }
    public void addGold(long value) {
    this.gold.addValue(value);
    }
    public void addCash(long value){
        if (this.gold.getValue() >= this.cashContainer.getvalue() + value );
    }
}
