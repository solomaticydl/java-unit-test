package otp;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceTest {

    @Test
    public void is_valid_test() {
        IProfile profile = mock(ProfileDao.class);
        when(profile.getPassword("joey")).thenReturn("91");
        IToken token = mock(RsaTokenDao.class);
        when(token.getRandom(anyString())).thenReturn("000000");

        AuthenticationService target = new AuthenticationService(profile, token);
        boolean actual = target.isValid("joey", "91000000");
        assertTrue(actual);
    }
}