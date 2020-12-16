import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class PrinterAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new PrintNBehaviour());

    }
}
