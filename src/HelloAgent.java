import jade.core.Agent;


public class HelloAgent extends Agent {

    Integer agentsCount = 13;
    private Integer number;
    private int[][] edges;
    public boolean canSend = false;

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public int[][] getEdges() {
        return edges;
    }

    private Integer receivedMessages = 0;

    public void addMessage() {
        receivedMessages += 1;
    }

    public Integer getReceivedMessages() {
        return receivedMessages;
    }

    @Override
    protected void setup() {
        edges = new int[agentsCount][agentsCount];
        for (int i = 0; i < agentsCount; i++) {
            for (int j = 0; j < agentsCount; j++) {
                if (i == 0) {
                    if (j == 1 || j == 2 || j == 7) {
                        edges[i][j] = 1;
                    }
                } else if (i == 2) {
                    if (j == 3 || j == 11) {
                        edges[i][j] = 1;
                    }
                } else if (i == 7) {
                    if (j == 6 || j == 10) {
                        edges[i][j] = 1;
                    }
                } else if (i == 3 && j == 4 || i == 10 && j == 12 || i == 11 && j == 9) {
                    edges[i][j] = 1;
                } else if (i == 4) {
                    if (j == 5 || j == 8) {
                        edges[i][j] = 1;
                    }
                } else {
                    edges[i][j] = 0;
                }

            }
        }

        setNumber(20 + (int) Math.round(Math.random() * 20));
        System.out.println("Agent #" + getLocalName() + ", number is " + getNumber());

        addBehaviour(new ListenBehaviour(this));
        addBehaviour(new SenderBehaviour(this));
//        n = 10;
//        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//        msg.addReceiver(new AID("Printer", AID.ISLOCALNAME));
//        msg.setContent(n.toString());
//        send(msg);
    }
}
