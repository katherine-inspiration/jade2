import jade.core.behaviours.CyclicBehaviour;

public class ZeroSenderBehaviour extends CyclicBehaviour {

    private ZeroHelloAgent agent;

    ZeroSenderBehaviour(ZeroHelloAgent agent){
        this.agent = agent;
    }

    @Override
    public void action() {
        if (agent.neededMessages == agent.receivedMessages){
            System.out.println("Answer to the center: " + agent.getNumber() * 1.0 / agent.getAgentsCount());
            block();
        }

    }
}
