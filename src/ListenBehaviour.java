import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import static java.lang.Integer.parseInt;

public class ListenBehaviour extends CyclicBehaviour {
    HelloAgent agent;

    ListenBehaviour(HelloAgent agent){
        super();
        this.agent = agent;
    }

    Integer [] neededMessages = {
            3,
            0,
            2,
            1,
            2,
            0,
            0,
            2,
            0,
            0,
            1,
            1,
            0
    };

    @Override
    public void action() {

        if (agent.getReceivedMessages() == neededMessages[parseInt(agent.getLocalName())]){
            agent.canSend = true;
            block();
        }
        else{
            ACLMessage msg = getAgent().receive();
            if (msg != null){
                agent.addMessage();
                String msgContent = msg.getContent();
                agent.setNumber(agent.getNumber() + parseInt(msgContent));
            }
        }
    }
}
