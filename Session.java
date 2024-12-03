import java.util.List;

public class Session {
    private SessionType sType;
    private String date;
    private ForumType fType;
    private Instructor instructor;
    private List<Client> registeredClients;

    public Session(SessionType sType,String date, ForumType fType,Instructor instructor)
    {
        this.sType = sType;
        this.date = date;
        this.fType = fType;
        this.instructor= instructor;
    }


}
enum SessionType{
    Pilates,
    ThaiBoxing,
    MachinePilates,
    Ninja;
}
enum ForumType {
    All,
    Female,
    Seniors,
    Male;

}
