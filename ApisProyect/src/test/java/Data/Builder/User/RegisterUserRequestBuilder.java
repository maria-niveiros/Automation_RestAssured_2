package Data.Builder.User;

import Data.Model.User.RegisterUserRequest;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterUserRequestBuilder {
    private RegisterUserRequest registerUserRequest;

    private static final String REGISTERED_FIRSTNAME = "Maria";
    private static final String REGISTERED_LASTNAME = "Lopez";
    private static final String REGISTERED_EMAIL = "maria@mail.com";
    private static final String REGISTERED_USER = "maria";
    private static final String REGISTERED_PHONE = "45420582";
    private static final String REGISTERED_PASSWORD= "maria86";

    private static final int USER_STATUS=1;
    private static final int USER_ID=23;



    private RegisterUserRequestBuilder(){
        registerUserRequest = new RegisterUserRequest();
    }

    public static RegisterUserRequestBuilder newUser(){
        return new RegisterUserRequestBuilder();
    }

    public RegisterUserRequestBuilder withFirstName(String firstName){
        this.registerUserRequest.setFirstName(firstName);
        return this;
    }

    public RegisterUserRequestBuilder withLastName(String lastName){
        this.registerUserRequest.setLastName(lastName);
        return this;
    }


    public RegisterUserRequestBuilder withPhone(String phoneNumber){
        this.registerUserRequest.setPhone(phoneNumber);
        return this;
    }

    public RegisterUserRequestBuilder withEmail(String email){
        this.registerUserRequest.setEmail(email);
        return this;
    }

    public RegisterUserRequestBuilder withUsername(String username){
        this.registerUserRequest.setUsername(username);
        return this;
    }

    public RegisterUserRequestBuilder withPassword(String password){
        this.registerUserRequest.setPassword(password);
        return this;
    }

    public RegisterUserRequestBuilder withUserStatus(int userStatus){
        this.registerUserRequest.setUserStatus(userStatus);
        return this;
    }
    public RegisterUserRequestBuilder withId(int id){
        this.registerUserRequest.setId(id);
        return this;
    }
    public RegisterUserRequestBuilder withEmptyFirstName(){
        this.registerUserRequest.setFirstName(StringUtils.EMPTY);
        return this;
    }

    public RegisterUserRequestBuilder withEmptyLastName(){
        this.registerUserRequest.setLastName(StringUtils.EMPTY);
        return this;
    }


    public RegisterUserRequestBuilder withEmptyPhone(){
        this.registerUserRequest.setPhone(StringUtils.EMPTY);
        return this;
    }

    public RegisterUserRequestBuilder withEmptyEmail(){
        this.registerUserRequest.setEmail(StringUtils.EMPTY);
        return this;
    }

    public RegisterUserRequestBuilder withEmptyUsername(){
        this.registerUserRequest.setUsername(StringUtils.EMPTY);
        return this;
    }

    public RegisterUserRequestBuilder withEmptyPassword(){
        this.registerUserRequest.setPassword(StringUtils.EMPTY);
        return this;
    }
    public RegisterUserRequest build(){
        return registerUserRequest;
    }



    public RegisterUserRequestBuilder withNullFirstName(){
        this.registerUserRequest.setFirstName(null);
        return this;
    }

    public RegisterUserRequestBuilder withNullLastName(){
        this.registerUserRequest.setLastName(null);
        return this;
    }



    public RegisterUserRequestBuilder withNullPhone(){
        this.registerUserRequest.setPhone(null);
        return this;
    }

    public RegisterUserRequestBuilder withNullEmail(){
        this.registerUserRequest.setEmail(null);
        return this;
    }

    public RegisterUserRequestBuilder withNullUsername(){
        this.registerUserRequest.setUsername(null);
        return this;
    }

    public RegisterUserRequestBuilder withNullPassword(){
        this.registerUserRequest.setPassword(null);
        return this;
    }

    public static RegisterUserRequest newUsers(){
        return newUser()
                .withUsername(REGISTERED_USER)
                .withFirstName(REGISTERED_FIRSTNAME)
                .withLastName(REGISTERED_LASTNAME)
                .withEmail(REGISTERED_EMAIL)
                .withPassword(REGISTERED_PASSWORD)
                .withPhone(REGISTERED_PHONE)
                .withId(USER_ID)
                .withUserStatus(USER_STATUS)
                .build();
    }

    public static RegisterUserRequest emptyUser(){
        return newUser()
                .withEmptyFirstName()
                .withEmptyLastName()
                .withEmptyEmail()
                .withEmptyPhone()
                .withEmptyUsername()
                .withEmptyPassword()
                .build();
    }

    public static RegisterUserRequest nullUser(){
        return newUser()
                .withNullFirstName()
                .withNullLastName()
                .withNullEmail()
                .withNullPhone()
                .withNullUsername()
                .withNullPassword()
                .build();
    }



}
