package otp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AuthenticationServiceTest {

    @Test
    public void is_valid_test() {
        AuthenticationService target = new AuthenticationService(new FakeProfile(), new FakeToken());

        boolean actual = target.isValid("joey", "91000000");

        assertTrue(actual);
    }
}

class FakeProfile implements IProfile {

    @Override
    public String getPassword(String account) {
        if ("joey".equals(account)) {
            return "91";
        }
        return "";
    }
}

class FakeToken implements IToken {

    @Override
    public String getRandom(String account) {
        return "000000";
    }
}
