public class AllForumType implements ForumTypeStrategy {

    // Always return true cause all genders are allowed
   @Override
    public boolean checkFType(Client client){
       return true;
   }

}
