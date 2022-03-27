package otp;

public class ProfileDao implements IProfile {
    @Override
    public String getPassword(String account) {
        return Context.getPassword(account);
    }
}
