Feature: User login
    Background:
        Given the following users are registered:
            | username           | password    |
            | user1@example.com  | pass123     |
            | user2@example.com  | abc$1234    |
            | user3@example.com  | xyz!7890    |

    Scenario: Login with valid credentials
        When the user tries to login with username "user1@example.com" and password "pass123"
        Then the login should be successful

    Scenario: Login with invalid credentials
        When the user tries to login with username "user1@example.com" and password "wrongpass"
        Then the login should be unsuccessful