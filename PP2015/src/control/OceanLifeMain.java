package control;

/**
 * Class which contains the main-method and is called when the program is started
 * 
 * @author Tobias Gartmann, Benjamin Suhr
 *
 */
public class OceanLifeMain {

    /**
     * main-method, creates an OceanLifeController and calling start()
     * @param args
     * 		not used
     * @throws InterruptedException -
     */
    public static void main(String[] args) throws InterruptedException {

	OceanLifeController controller = new OceanLifeController();
	controller.start();
    }

}
