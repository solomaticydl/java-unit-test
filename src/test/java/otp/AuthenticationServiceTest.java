package otp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    private final IProfile profile = mock(IProfile.class);
    private final IToken token = mock(IToken.class);
    private final INotification notification = mock(INotification.class);
    private final AuthenticationService target = new AuthenticationService(profile, token, notification);

    @Test
    public void is_valid() {
        givenPassword("joey", "91");
        givenToken(anyString(), "000000");

        shouldBeValid("joey", "91000000");
    }

    @Test
    public void should_notify_user_when_invalid() {
        givenPassword("joey", "91");
        givenToken(anyString(), "000000");

        shouldBeInvalid("joey", "wrong password");
    }

    private void shouldBeValid(String account, String password) {
        boolean actual = target.isValid(account, password);
        assertTrue(actual);
    }

    private void shouldBeInvalid(String account, String password) {
        boolean actual = target.isValid(account, password);
        assertFalse(actual);
        verify(notification, times(1)).sendNotify("account:joey try to login failed");
    }

    private void givenToken(String account, String password) {
        when(token.getRandom(account)).thenReturn(password);
    }

    private void givenPassword(String account, String password) {
        when(profile.getPassword(account)).thenReturn(password);
    }
}