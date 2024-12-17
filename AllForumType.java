public class AllForumType implements ForumTypeStrategy {

    /**
     * Validates a client for the "All" forum type.
     * This method always returns true, as there are no restrictions on participation.
     *
     * @param client The Client object to validate.
     * @return True, indicating all clients are allowed.
     */
    @Override
    public boolean checkFType(Client client) {
        return true;
    }
}
