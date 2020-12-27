import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ListenBehaviour extends CyclicBehaviour {
    @Override
    public void action() {
        ACLMessage msg = getAgent().receive();
        if (msg != null){
            String msgContent = msg.getContent();
            System.out.println(msgContent);
        }
        else{
            block();
        }
    }
}
