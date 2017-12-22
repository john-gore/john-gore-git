public class ProjectTest {
	public static void main(String[] args) {
        Portfolio port = new Portfolio();
        Project proj1 = new Project("Project 1", "Description 1");
        Project proj2 = new Project("Project 2", "Description 2");
        Project proj3 = new Project("Project 3", "Description 3");

        proj1.setInitialCost(10.0);
        proj2.setInitialCost(15.0);
        proj3.setInitialCost(35.0);

        proj1.elevatorPitch();
        proj2.elevatorPitch();
        proj3.elevatorPitch();

        port.addToPortfolio(proj1);
        port.addToPortfolio(proj2);
        port.addToPortfolio(proj3);
		
        System.out.println(port.getPortfolioCost());
		port.showPortfolio();
	}
}