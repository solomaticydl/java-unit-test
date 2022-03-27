package otp;

public class AuthenticationService {

    private final IProfile profileDao;
    private final IToken rsaToken;
    private final INotification notification;

    public AuthenticationService(IProfile profileDao, IToken rsaToken, INotification notification) {
        this.profileDao = profileDao;
        this.rsaToken = rsaToken;
        this.notification = notification;
    }

    public boolean isValid(String account, String password) {
        // 根據 account 取得自訂密碼
        String passwordFromDao = profileDao.getPassword(account);

        // 根據 account 取得 RSA token 目前的亂數
        String randomCode = rsaToken.getRandom(account);

        // 驗證傳入的 password 是否等於自訂密碼 + RSA token亂數
        String validPassword = passwordFromDao + randomCode;
        boolean isValid = password.equals(validPassword);

        if (isValid) {
            return true;
        } else {
            notification.sendNotify(String.format("account:%s try to login failed", account));
            return false;
        }
    }
}
