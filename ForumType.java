public enum ForumType {
    /** Allows all clients to participate. */
    All(new AllForumType()),

    /** Restricts participation to female clients only. */
    Female(new FemaleForumType()),

    /** Restricts participation to senior clients (e.g., age 65 or older). */
    Seniors(new SeniorForumType()),

    /** Restricts participation to male clients only. */
    Male(new MaleForumType());

    private final ForumTypeStrategy strategy; // Strategy for validating clients

    /**
     * Constructs a ForumType with the specified validation strategy.
     *
     * @param strategy The strategy that defines validation rules for the forum type.
     */
    ForumType(ForumTypeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Retrieves the strategy associated with this forum type.
     *
     * @return The ForumTypeStrategy used for validation.
     */
    public ForumTypeStrategy getStrategy() {
        return strategy;
    }
}
