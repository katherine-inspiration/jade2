import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;


public class MainController {
    private static final int numberOfAgents = 13;

    void initAgents(){
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.MAIN_PORT, "10098");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);

        try{
            int [][] edges = new int[numberOfAgents][numberOfAgents];
            for (int i = 0; i < numberOfAgents; i++) {
                for (int j = 0; j < numberOfAgents; j++) {
                    if (i == 0) {
                        if (j == 1 || j == 2 || j == 7) {
                            edges[j][i] = 1;
                        }
                    } else if (i == 2) {
                        if (j == 3 || j == 11) {
                            edges[j][i] = 1;
                        }
                    } else if (i == 7) {
                        if (j == 6 || j == 10) {
                            edges[j][i] = 1;
                        }
                    } else if (i == 3 && j == 4 || i == 10 && j == 12 || i == 11 && j == 9) {
                        edges[j][i] = 1;
                    } else if (i == 4) {
                        if (j == 5 || j == 8) {
                            edges[j][i] = 1;
                        }
                    } else {
                        edges[j][i] = 0;
                    }

                }
            }
            Integer [] neededMessages = {
                    3,
                    0,
                    2,
                    1,
                    2,
                    0,
                    0,
                    2,
                    0,
                    0,
                    1,
                    1,
                    0
            };
            for (int i = 0; i < MainController.numberOfAgents; i++){
//                Object[] args = new Object[numberOfAgents];
//                for (int k = 0; k < numberOfAgents; k++){
//                    args[k] = new HashMap<String, Object>();
//                    args[k].put()
//                }

                int n = 20 + (int) Math.round(Math.random() * 20);

                Object[] args = new Object[]{null, edges[i], n, neededMessages[i]};
                AgentController agent;
                if (i == 0){
                    args[0] = numberOfAgents;
                    agent = cc.createNewAgent(Integer.toString(i), "ZeroHelloAgent", args);
                }
                else{
                    agent = cc.createNewAgent(Integer.toString(i), "HelloAgent", args);
                }
                agent.start();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}

