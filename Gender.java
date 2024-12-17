/**
 * The Gender enum represents the gender of a person.
 * It includes two possible values: Male and Female.
 */
public enum Gender {
    /** Represents the male gender. */
    Male,

    /** Represents the female gender. */
    Female;

    /**
     * Overrides the default toString() method to provide a user-friendly string representation
     * of the gender enum values.
     *
     * @return A string representation of the gender (e.g., "Male" or "Female").
     */
    @Override
    public String toString() {
        switch (this) {
            case Male:
                return "Male";
            case Female:
                return "Female";
            default:
                return super.toString();
        }
    }
}
