import jade.core.Agent;

import static java.lang.Integer.parseInt;

public class HelloAgent extends Agent {

    private Integer number;
    private Integer step = 1;
    public final Integer id = parseInt(getAID().getLocalName());

    public boolean canSend = false;

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber(){
        return this.number;
    }

    public Integer getStep(){
        return this.step;
    }

    public void setStep(Integer step){
        this.step = step;
    }

    private Integer receivedMessages = 0;
    public void addMessage(){
        receivedMessages += 1;
    }

    public void resetRecievedMessages(){
        receivedMessages = 0;
    }

    public Integer getReceivedMessages() {
        return receivedMessages;
    }

    @Override
    protected void setup(){

        setNumber(20 + (int)Math.round(Math.random() * 20));

        addBehaviour(new ListenBehaviour(this));
        addBehaviour(new SenderBehaviour(this));
//        n = 10;
//        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//        msg.addReceiver(new AID("Printer", AID.ISLOCALNAME));
//        msg.setContent(n.toString());
//        send(msg);
    }
}
