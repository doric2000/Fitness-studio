// ForumType.java
public enum ForumType {
    All(new AllForumType()),
    Female(new FemaleForumType()),
    Seniors(new SeniorForumType()),
    Male(new MaleForumType());

    private final ForumTypeStrategy strategy;

    ForumType(ForumTypeStrategy strategy) {
        this.strategy = strategy;
    }

    public ForumTypeStrategy getStrategy() {
        return strategy;
    }
}