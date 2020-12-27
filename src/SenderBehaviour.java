import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import static java.lang.Integer.parseInt;

public class SenderBehaviour extends CyclicBehaviour {

    HelloAgent agent;

    SenderBehaviour(HelloAgent agent){
        super();
        this.agent = agent;
    }

    @Override
    public void action() {
        if (agent.canSend){
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            int senderId = parseInt(getAgent().getAID().getLocalName());
            for(int i = 0; i < agent.getEdges().length; i++){
                if (agent.getEdges()[i] > 0){
                    Integer receiverID = i;
                    AID receiver = new AID(receiverID.toString(), AID.ISLOCALNAME);
                    msg.setContent(agent.getNumber().toString());
                    msg.addReceiver(receiver);
                }
            }
            agent.send(msg);
            block();
        }
    }
}
