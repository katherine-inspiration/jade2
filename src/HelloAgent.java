import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class HelloAgent extends Agent {

    Integer n;

    @Override
    protected void setup(){
        System.out.println("Hello, world!");

//        n = 10;
//        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//        msg.addReceiver(new AID("Printer", AID.ISLOCALNAME));
//        msg.setContent(n.toString());
//        send(msg);
    }
}
