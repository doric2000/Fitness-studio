public class SeniorForumType implements ForumTypeStrategy {

    /**
     * Checks if the given client meets the "Senior" forum type requirement.
     * A client qualifies if their age is 65 or older.
     *
     * @param client The Client object to validate.
     * @return True if the client's age is 65 or older, false otherwise.
     */
    @Override
    public boolean checkFType(Client client) {
        return client.getAge() >= 65;
    }
}