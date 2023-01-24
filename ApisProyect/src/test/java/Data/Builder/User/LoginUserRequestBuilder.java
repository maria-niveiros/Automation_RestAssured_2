package Data.Builder.User;

import Data.Model.User.LoginUserRequest;
import org.apache.commons.lang3.StringUtils;

public class LoginUserRequestBuilder {

    private LoginUserRequest loginUserRequest;

    public static final String REGISTERED_USERNAME = "maria";
    public static final String REGISTERED_PASSWORD= "maria86";
    private static final String UNREGISTERED_USER = "pentacampeon";
    private static final String UNREGISTERED_PASSWORD= "brasil10";
    private LoginUserRequestBuilder(){loginUserRequest = new LoginUserRequest();}

    public static LoginUserRequestBuilder user(){return new LoginUserRequestBuilder();}

    public LoginUserRequestBuilder withRegisteredUsername(){
        this.loginUserRequest.setUsername(REGISTERED_USERNAME);
        return this;
    }

    public LoginUserRequestBuilder withRegisteredPassword(){
        this.loginUserRequest.setPassword(REGISTERED_PASSWORD);
        return this;
    }

    public LoginUserRequestBuilder withUnegisteredUsername(){
        this.loginUserRequest.setUsername(UNREGISTERED_USER);
        return this;
    }

    public LoginUserRequestBuilder withUnegisteredPassword(){
        this.loginUserRequest.setPassword(UNREGISTERED_PASSWORD);
        return this;
    }

    public LoginUserRequestBuilder withEmptyUsername(){
        this.loginUserRequest.setUsername(StringUtils.EMPTY);
        return this;
    }

    public LoginUserRequestBuilder withEmptyPassword(){
        this.loginUserRequest.setPassword(StringUtils.EMPTY);
        return this;
    }

    public LoginUserRequestBuilder withNullUsername(){
        this.loginUserRequest.setUsername(null);
        return this;
    }

    public LoginUserRequestBuilder withNullPassword(){
        this.loginUserRequest.setPassword(null);
        return this;
    }
    public static LoginUserRequest loginUser(){
        return  user().withRegisteredUsername().withRegisteredPassword().build();
    }

    public static LoginUserRequest unregisteredUsernameUser(){
        return user().withUnegisteredUsername().withRegisteredPassword().build();
    }

    public static LoginUserRequest unregisteredPasswordUser(){
        return user().withRegisteredUsername().withUnegisteredPassword().build();
    }

    public static LoginUserRequest unregisteredUser(){
        return user().withUnegisteredUsername().withUnegisteredPassword().build();
    }

    public static LoginUserRequest nullUsernameUser(){
        return user().withNullUsername().withRegisteredPassword().build();
    }

    public static LoginUserRequest nullPasswordUser(){
        return user().withRegisteredUsername().withNullPassword().build();
    }

    public static LoginUserRequest nullUser(){
        return user().withNullUsername().withNullPassword().build();
    }

    public static LoginUserRequest emptyUsernameUser(){
        return user().withEmptyUsername().withRegisteredPassword().build();
    }

    public static LoginUserRequest emptyPasswordUser(){
        return user().withRegisteredUsername().withEmptyPassword().build();
    }

    public static LoginUserRequest emptyUser(){
        return user().withEmptyUsername().withEmptyPassword().build();
    }
    public LoginUserRequest build(){
        return loginUserRequest;
    }

    public LoginUserRequestBuilder and(){return this;}

    public LoginUserRequestBuilder but(){return this;}
}
