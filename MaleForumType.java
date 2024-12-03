public class MaleForumType implements ForumTypeStrategy {
    @Override
    public boolean checkFType(Client client){
        return client.getGender() == Gender.Male;
    }
}
