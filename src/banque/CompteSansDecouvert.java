package banque;

public class CompteSansDecouvert extends Compte{
	
	public CompteSansDecouvert()
	{
		super();
	}
	
	public void debiter(double montant) {
		
	}

	@Override
	double getDecouvert() {
		// TODO Auto-generated method stub
		return 0;
	}

}
