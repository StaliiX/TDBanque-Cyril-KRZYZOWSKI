package factory;

public class ClientSingleFactory {

	private ClientSingleFactory() {

	}

	public static ClientSingleFactory getInstance() {
		return new ClientSingleFactory();
	}

}
