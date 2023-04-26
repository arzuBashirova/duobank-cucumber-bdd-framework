@DB
Feature: As a user of Duobank Mortgage Application, I want to be able to sign up and log in securely using a  database
  system that protects my personal and financial information, so that I can complete the  mortgage application process with confidence.

  @firstDB
  Scenario Outline:Large number of Users should be able to signs up with
    Then User enter firstName "<firstName>" , lastName "<lastName>" , email "<email>" , password "<password>" and enter

    Examples:
      | firstName | lastName  | email                     | password       |
      | Johnny    | Deep      | johnnyde2@gmail.com       | tsfhdifnf76bs  |
      | Kaby      | Candle    | johnnycash22@gmail.com    | kdgcfxzv54gh   |
      | Quentin   | Tarantino | stevejobs482@gmail.com    | kjh243gbskiyfs |
      | Marlon    | Brando    | kulpasanto482@gmail.com   | gabsf5sgsds    |
      | Fantomas  | Somatos   | sfantomastom28@gmail.com  | kjh243gbskiyfs |
      | Kevin     | Shein     | skevinshein2@gmail.com    | kjh243gbskiyfs |
      | Katie     | Levin     | katialevin2@gmail.com     | ooopshd58dgdvv |
      | Sonic     | Faster    | sonicvan232@gmail.com     | udygv77stv     |
      | Willie    | Wonka     | choccolate2@gmail.com     | hsgffff3444    |


    @temp
    Scenario: verify if database handled it without slowing

    Then The database should be able to handle without slowing down  the system
      | Johnny   |
      | Gaby     |
      | Quentin  |
      | Marlon   |
      | Fantomas |
      | Kevin    |
      | Katie    |
      | Sonic    |
      | Willie   |




      @smoke
    Scenario: The database should have "tbl_users" table
     Then  DB should contain the following columns
       | email       |
       | password    |
       | first_name  |
       | last_name   |
       | phone       |
       | image       |
       | type        |
       | created_at  |
       | modified_at |
       | zone_id     |
       | church_id   |
       | country_id  |
       | active      |
       | id          |

        @db_only
        Scenario: The database should ensure that each user has a unique username associated  with their account.
          When  I send a request to retrieve duplicate usernames
          Then  The result should be empty

        @db_only
        Scenario: The database should ensure that each user has a unique email address associated  with their account.
          When  I send a request to retrieve duplicate emails
          Then  The result should be empty right away

        @db_only @RegressionAzi
        Scenario: The "tbl_users" table should store a timestamp of when the user account was created.
          When I send a request to retrieve created_at column
          Then result should not be null


          @smoke
         Scenario: The database should store and encrypt user passwords in an MD5 hash.
          When user enters following credentials to sign up
            | John              |
            | Doe               |
            | JohnDoe@gmail.com |
            | johndoetester123  |
           When I send a request to retrieve the password data from database
           Then the data must be encrypted version

              @dt @smoke
            Scenario: Upon successful submission of the sign up information,the "Sign Up" page form fields should be
            mapped to their corresponding columns in the “tbl_users” table in the database
              When user enters following credentials to sign up fields
                | first_name | last_name | email                 | password      |
                | Sheldon    | Cooper    | sheldoncoop@gmail.com | sheldoncoo123 |
              Then database should have corresponding column names and data
                | first_name | last_name | email                 | password      |
                | Sheldon    | Cooper    | sheldoncoop@gmail.com | sheldoncoo123 |



