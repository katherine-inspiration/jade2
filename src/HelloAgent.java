import jade.core.Agent;


public class HelloAgent extends Agent {

    protected Double number;
    protected int[] edges;
    protected Integer receivedMessages = 0;
    protected Integer sentMessages = 0;

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getNumber() {
        return this.number;
    }

    public int[] getEdges() {
        return edges;
    }

    public void addMessage() {
        receivedMessages += 1;
    }

    public void addSentMessage(){
        sentMessages += 1;
    }

    public Integer getSentMessages() {
        return sentMessages;
    }

    public Integer getReceivedMessages() {
        return receivedMessages;
    }

    @Override
    protected void setup() {

        edges = (int[])getArguments()[0];
        setNumber((double)getArguments()[1]);


        System.out.println("Agent #" + getLocalName() + ", number is " + getNumber());

        addBehaviour(new ListenerBehaviour(this));
        addBehaviour(new SenderBehaviour(this));

    }
}
