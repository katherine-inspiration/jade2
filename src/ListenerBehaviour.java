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
            String msgContent = msg.getContent();
            Double msgNumber = parseDouble(msgContent);

//            System.out.println(agent.getNumber() +" " + msgNumber + " " + (agent.getNumber() + msgNumber) / 2);
            agent.setNumber(agent.getNumber() +(msgNumber - agent.getNumber()) * 0.2);

            System.out.println("Agent #" + agent.getLocalName() + " got the message " + msgContent +
                    " from Agent #" + msg.getSender().getLocalName());

        }

    }
}
