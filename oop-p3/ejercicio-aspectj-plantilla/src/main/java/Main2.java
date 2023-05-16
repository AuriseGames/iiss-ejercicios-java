import org.baeldung.aspectj.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main2 {

    private static final Logger logger = LoggerFactory.getLogger(Main2.class);
    
    public static void main(String args[]) {
        Account account;

        account = new Account(25);
        account.withdraw(80);
        logger.info( "{}: balance = {}", account.hashCode(), account.getBalance() );

        account = new Account(50);
        account.withdraw(23);
        logger.info( "{}: balance = {}" + account.hashCode(), account.getBalance() );
    }
}