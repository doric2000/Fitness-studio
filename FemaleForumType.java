public class FemaleForumType implements ForumTypeStrategy{
    @Override
    public boolean checkFType(Client client){
        return client.getGender() == Gender.Female;
    }
}
