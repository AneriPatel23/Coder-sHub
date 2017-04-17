package mail;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class SessionIdentifierGenerator {
		  private SecureRandom random = new SecureRandom();
		  public String nextSessionId() {
		    return new BigInteger(80, random).toString(16);
		  }
}