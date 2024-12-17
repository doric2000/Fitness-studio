public class FemaleForumType implements ForumTypeStrategy {

    /**
     * Checks if the given client meets the "Female" forum type requirement.
     * A client qualifies if their gender is Female.
     *
     * @param client The Client object to validate.
     * @return True if the client's gender is Female, false otherwise.
     */
    @Override
    public boolean checkFType(Client client) {
        return client.getGender() == Gender.Female;
    }
}
