enum SessionType {
    Pilates(60, 30),
    ThaiBoxing(80,10),
    MachinePilates(100,20),
    Ninja(150,5);

    private final int price;
    private final int maxParticipants;

    SessionType(int price,int maxParticipants)
    {
        this.price = price;
        this.maxParticipants=maxParticipants;
    }

    public int getPrice() {
        return price;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }
}
