import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class PrintNBehaviour extends CyclicBehaviour {
    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if (msg != null){
            System.out.println(msg.getContent());
        }
        else{
            block();
        }
    }
}
