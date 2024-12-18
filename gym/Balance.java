package gym;

/**
 * The gym.Balance class represents a financial balance for a client or any entity in the system.
 * It provides methods to get, set, and update the balance amount.
 * we have needed this class to create unity between
 * all the different classes that represent the same person.
 */
public class Balance {
    private int amount; // The current balance amount

    /**
     * Constructs a new gym.Balance with an initial amount.
     *
     * @param initialAmount The starting amount for the balance.
     */
    public Balance(int initialAmount) {
        this.amount = initialAmount;
    }

    /**
     * Retrieves the current balance amount.
     *
     * @return The current amount as an integer.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the balance to a specified amount.
     *
     * @param amount The new balance amount to set.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Adds a specified amount to the current balance.
     *
     * @param amount The amount to add to the balance. Can be positive or negative.
     */
    public void addAmount(int amount) {
        this.amount += amount;
    }
}
