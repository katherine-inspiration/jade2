import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class SenderBehaviour extends CyclicBehaviour {

    HelloAgent agent;

    SenderBehaviour(HelloAgent agent){
        super();
        this.agent = agent;
    }

    Integer agentsCount = 13;

    int[][] getEdges(){
        int[][] edges = new int[agentsCount][agentsCount];
        for (int i = 0; i < agentsCount; i++){
            for (int j = 0; j < agentsCount; j++){
                if (i == 0){
                    if (j == 1 || j == 2 || j == 7){
                        edges[i][j] = 4;
                    }
                }
                else if (i == 2){
                    if (j == 3 || j == 11){
                        edges[i][j] = 3;
                    }
                }
                else if (i == 3 && j == 4 || i == 10 && j == 12 || i == 11 && j == 9){
                    edges[i][j] = 2;
                }
                else if (i == 4){
                    if (j == 5 || j == 8){
                        edges[i][j] = 1;
                    }
                }
                else{
                    edges[i][j] = 0;
                }

            }
        }
        return edges;
    }

    int[][] edges = getEdges();

    Integer finishedStep = 0;


    @Override
    public void action() {
        if (agent.getStep() == 5){
            System.out.println("The last step #" + getAgent().getAID().getLocalName());
            System.out.println("Agent #" + getAgent().getAID().getLocalName() + ", number is " + agent.getNumber());
            block();
        }
        else if (agent.getStep() > 5 || agent.getStep() == finishedStep){
            //block();
        }
        else{
            System.out.println("Agent #" + getAgent().getAID().getLocalName() + ", number is " + agent.getNumber());
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            int senderId = Integer.parseInt(getAgent().getAID().getLocalName());
            for(int i = 0; i < agentsCount; i++){
                if (edges[i][senderId] == agent.getStep()){
                    Integer receiverID = i;
                    AID receiver = new AID(receiverID.toString(), AID.ISLOCALNAME);
                    msg.setContent(agent.getNumber().toString());
                    msg.addReceiver(receiver);
                }
            }
            agent.send(msg);
            finishedStep = finishedStep + 1;

        }

    }

}
