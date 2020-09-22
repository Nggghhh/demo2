package learn.java.classes;

public interface Manageable {
    public abstract void collectInput();

    public abstract boolean isSlotInListEmpty(int slotIndex);

    public abstract boolean isListFull();

    public abstract void expandList();

    public abstract int checkIfInputIsAInteger();

    public abstract long checkIfInputIsALong();
}
