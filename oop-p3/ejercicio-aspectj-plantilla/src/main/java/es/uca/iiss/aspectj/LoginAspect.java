package es.uca.iiss.aspectj;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoginAspect {
  // Mostramos el mensaje "The login is required" antes de la ejecución de las operaciones makeTransaction y takeMoneyOut
	@Before("execution(* Bank.makeTransaction()) || execution(* Bank.takeMoneyOut())")
    public void before(JoinPoint joinPoint){
      System.out.println("The login is required");
    }
	// Mostramos el mensaje "The database is empty" después de la ejecución de la operación showUsers.
	@After("execution(* Bank.showUsers())")
    public void after(JoinPoint joinPoint){
		  System.out.println("The database is empty");
    }
}
