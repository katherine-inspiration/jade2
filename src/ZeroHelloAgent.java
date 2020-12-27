public class ZeroHelloAgent extends HelloAgent {
    private Integer agentsCount;

    public Integer getAgentsCount(){
        return agentsCount;
    }

    @Override
    protected void setup() {
        agentsCount = (int)getArguments()[0];
        edges = (int[])getArguments()[1];
        setNumber((int)getArguments()[2]);
        neededMessages = (int)getArguments()[3];


        System.out.println("Agent #" + getLocalName() + ", number is " + getNumber());

        addBehaviour(new ListenBehaviour(this));
        addBehaviour(new ZeroSenderBehaviour(this));
    }
}
