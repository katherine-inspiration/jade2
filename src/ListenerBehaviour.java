import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import static java.lang.Double.parseDouble;

public class ListenerBehaviour extends CyclicBehaviour {
    HelloAgent agent;

    ListenerBehaviour(HelloAgent agent) {
        super();
        this.agent = agent;
    }


    @Override
    public void action() {


        ACLMessage msg = getAgent().receive();
        if (msg != null) {
            agent.addMessage();
            String msgContent = msg.getContent();
            agent.setNumber((agent.getNumber() + parseDouble(msgContent)) / 2);


                System.out.println("Agent #" + agent.getLocalName() + " got the message " + msgContent +
                        " Agent #" + msg.getSender().getLocalName());

        }
        else{
            if (agent.getSentMessages() == 2 ){
                block();
            }
            else{
                ACLMessage outMsg = new ACLMessage(ACLMessage.INFORM);
                outMsg.setContent(agent.getNumber().toString());
                for (int i = 0; i < agent.getEdges().length; i++) {
                    if (agent.getEdges()[i] > 0) {
                        Integer randomEdge = 1 + (int)(Math.random() * agent.getEdges()[i]);
                        if (randomEdge == 1){
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
}
