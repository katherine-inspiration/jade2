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
            if (parseInt(agent.getLocalName()) == 0){
                System.out.println("Answer to the center: " + agent.getNumber() * 1.0 / agent.agentsCount);
                block();
            }
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            int senderId = parseInt(getAgent().getAID().getLocalName());
            for(int i = 0; i < agent.agentsCount; i++){
                if (agent.getEdges()[i][senderId] > 0){
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
