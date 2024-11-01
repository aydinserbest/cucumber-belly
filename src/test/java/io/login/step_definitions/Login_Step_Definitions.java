package io.login.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.login.AuthService;
import io.login.UserRepository;

import java.util.List;
import java.util.Map;

public class Login_Step_Definitions {
    private UserRepository userRepository;
    private AuthService authService;

    @Given("the following users are registered:")
    public void the_following_users_are_registered(DataTable dataTable) {
        userRepository = new UserRepository();
        authService = new AuthService(userRepository);
        List<Map<String, String>> users = dataTable.asMaps();
        for (Map<String, String> row : users) {
            String username = row.get("username");
            String password = row.get("password");
            userRepository.addUser(username, password);
        }


    }

    @When("the user tries to login with username {string} and password {string}")
    public void the_user_tries_to_login_with_username_and_password(String string, String string2) {

    }

    @Then("the login should be successful")
    public void the_login_should_be_successful() {

    }

    @Then("the login should be unsuccessful")
    public void the_login_should_be_unsuccessful() {

    }

}
