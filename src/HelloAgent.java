import jade.core.Agent;


public class HelloAgent extends Agent {

    Integer agentsCount;
    protected Integer number;
    protected int[] edges;
    public boolean canSend = false;
    protected int neededMessages;
    protected Integer receivedMessages = 0;


    public int getNeededMessages() {
        return neededMessages;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public int[] getEdges() {
        return edges;
    }

    public void addMessage() {
        receivedMessages += 1;
    }

    public Integer getReceivedMessages() {
        return receivedMessages;
    }

    @Override
    protected void setup() {

        edges = (int[])getArguments()[1];
        setNumber((int)getArguments()[2]);
        neededMessages = (int)getArguments()[3];


        System.out.println("Agent #" + getLocalName() + ", number is " + getNumber());

        addBehaviour(new ListenBehaviour(this));

    }
}
