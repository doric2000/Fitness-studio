public class SessionFactory {
    public Session createSession(SessionType sType, String date, ForumType fType, Instructor instructor){
        if(sType == null){
            return null;
        }
        if(sType.name().equals("Ninja")){
            return new NinjaSession(date,  fType,  instructor);

        } else if(sType.name().equals("MachinePilates")){
            return new MachinePilatesSession(date, fType, instructor);

        } else if(sType.name().equals("ThaiBoxing")){
            return new ThaiBoxingSession(date, fType, instructor);
        }
    else if(sType.name().equals("Pilates")){
        return new PilatesSession(date,  fType,  instructor);
    }

        return null;
    }

}
