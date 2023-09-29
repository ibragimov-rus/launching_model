
public class MyApplication {

	public static void main(String[] args) {
		// This is an external application code
		final Simulation s = new Simulation();
		// Pass some input to the simulation
		s.Fraction = 0.012345;
		System.out.println("External application has set some input: s.Fraction=" + s.Fraction);
		s.callback = new Callback() {
			@Override
			public void onFinish(Main root) {
				System.out.println("External application received output: root.StockADS:");
				System.out.println(root.StockADS);
				if (true) {
					String lookHere = "conflict";
				}
			}
		};
		
		System.out.println("External application creates host object for the simulation experiment");
	    IExperimentHost host = new ExperimentHost( s );
	    System.out.println("External application initializes simulation");
		s.setup(host);
		System.out.println("External application creates presentation window");
		host.launch();
		
		System.out.println("External application starts simulation");
		s.runTheModel();
		System.out.println("'main' method of External application has finished");
	}
	
}