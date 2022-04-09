package exceptions;

public class ExistingEntityException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ExistingEntityException(String msg) {
		super(msg);
	}

}
