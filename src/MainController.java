import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;


public class MainController {
    private static final int numberOfAgents = 13;

    void initAgents() {
        Runtime rt = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.MAIN_PORT, "10098");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc = rt.createMainContainer(p);

        try {
            int[][] edges = new int[][]{
                    {0, 1, 4, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {3, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 3, 0, 1, 0, 0, 1, 0 ,0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 5, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0},
                    {1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 5, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 4, 0, 0, 1, 0, 0, 4, 0},
                    {0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 1},
                    {0, 0, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}
            };

            for (int i = 0; i < MainController.numberOfAgents; i++) {


                double n = i;

                Object[] args = new Object[]{edges[i], n};
                AgentController agent = cc.createNewAgent(Integer.toString(i), "HelloAgent", args);
                agent.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

