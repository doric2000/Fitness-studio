public class SeniorForumType implements ForumTypeStrategy{
    @Override
    public boolean checkFType(Client client){
        return client.getAge() >= 65;
    }
}
