import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import static java.lang.Integer.parseInt;

public class ListenBehaviour extends CyclicBehaviour {
    HelloAgent agent;

    ListenBehaviour(HelloAgent agent){
        super();
        this.agent = agent;
    }



    @Override
    public void action() {

        if (agent.getReceivedMessages() == agent.getNeededMessages()){
            agent.canSend = true;
            block();
        }
        else{
            ACLMessage msg = getAgent().receive();
            if (msg != null){
                agent.addMessage();
                String msgContent = msg.getContent();
                agent.setNumber(agent.getNumber() + parseInt(msgContent));

//                System.out.println("Agent #" + agent.getLocalName() + " got the message " + msgContent +
//                        " Agent #" + msg.getSender().getLocalName());
            }
        }
    }
}
