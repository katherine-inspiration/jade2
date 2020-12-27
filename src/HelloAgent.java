import jade.core.Agent;

public class HelloAgent extends Agent {

    Integer n;
    Integer agentsCount = 13;
    Integer step;

    @Override
    protected void setup(){
        step = 0;
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

        int id = Integer.parseInt(getAID().getLocalName());
        n = 20 + (int)Math.round(Math.random() * 20);
        System.out.println("Agent #" + id + ", number is " + n);


        addBehaviour(new ListenBehaviour());
//        n = 10;
//        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//        msg.addReceiver(new AID("Printer", AID.ISLOCALNAME));
//        msg.setContent(n.toString());
//        send(msg);
    }
}
