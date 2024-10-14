Feature:

  @name_and_birth_asMaps
  Scenario:
    Given these users exist:
      | name            | date of birth   |
      | Michael Jackson | August 29, 1958 |
      | Elvis           | January 8, 1935 |
      | John Lennon     | October 9, 1940 |

  @name_and_birth_asMap
  Scenario:
    Given these users exist:
      | name          | Michael Jackson |
      | date of birth | August 29, 1958 |



