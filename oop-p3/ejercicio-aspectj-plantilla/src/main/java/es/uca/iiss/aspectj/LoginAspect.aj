public aspect LoginAspect{
	pointcut loginRequired() : call(* Bank.makeTransaction()) || call(* Bank.takeMoneyOut());
	pointcut emptyDatabase() : call(* Bank.showUsers());
	
	before(): loginRequired() {
		System.out.println("Login required.");
	}
	
	after(): emptyDatabase() {
		System.out.println("Database is empty.");
	}
}
