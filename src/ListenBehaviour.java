import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import static java.lang.Integer.parseInt;

public class ListenBehaviour extends CyclicBehaviour {
    HelloAgent agent;

    ListenBehaviour(HelloAgent agent) {
        super();
        this.agent = agent;
    }


    @Override
    public void action() {


        ACLMessage msg = getAgent().receive();
        if (msg != null) {
            agent.addMessage();
            String msgContent = msg.getContent();
            agent.setNumber(agent.getNumber() + parseInt(msgContent));


                System.out.println("Agent #" + agent.getLocalName() + " got the message " + msgContent +
                        " Agent #" + msg.getSender().getLocalName());

        }

        if (agent.getReceivedMessages() == agent.getNeededMessages()) {
            ACLMessage outMsg = new ACLMessage(ACLMessage.INFORM);

            for (int i = 0; i < agent.getEdges().length; i++) {
                if (agent.getEdges()[i] > 0) {
                    Integer receiverID = i;
                    AID receiver = new AID(receiverID.toString(), AID.ISLOCALNAME);
                    outMsg.setContent(agent.getNumber().toString());
                    outMsg.addReceiver(receiver);
                }
            }

            agent.send(outMsg);
            block();
        }
    }
}
