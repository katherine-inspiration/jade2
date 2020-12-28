import jade.core.AID;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderBehaviour extends TickerBehaviour {

    private HelloAgent agent;
    private final Double noiseLimit = 0.1;
//    private final Double noiseLimit = 0.0;



    SenderBehaviour(HelloAgent agent, Integer tickTimeout) {
        super(agent, tickTimeout);
        this.agent = agent;
    }

    @Override
    protected void onTick() {

        if (agent.getSentMessages() == 50) {
            System.out.println("Agent #" + agent.getLocalName() + ", result number is " + agent.getNumber());
            this.stop();
        } else {
            ACLMessage outMsg = new ACLMessage(ACLMessage.INFORM);
            Double noise = 2 * Math.random() * noiseLimit - noiseLimit;
            System.out.println("Noise from Agent #" + agent.getLocalName() + " " + noise);

            outMsg.setContent(Double.toString(agent.getNumber() + noise));
            for (int i = 0; i < agent.getEdges().length; i++) {
                if (agent.getEdges()[i] > 0) {
                    Integer randomEdge = 1 + (int) (Math.random() * agent.getEdges()[i]);
                    if (randomEdge == 1) {
                        Integer receiverID = i;
                        AID receiver = new AID(receiverID.toString(), AID.ISLOCALNAME);
                        outMsg.addReceiver(receiver);
                    }
                }
            }
            agent.send(outMsg);
            agent.addSentMessage();

        }
    }
}
