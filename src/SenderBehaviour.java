import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderBehaviour extends CyclicBehaviour {

    private HelloAgent agent;

    SenderBehaviour(HelloAgent agent) {
        this.agent = agent;
    }

    @Override
    public void action() {

    }
}
