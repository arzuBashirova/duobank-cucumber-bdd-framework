@DB
Feature: As a user of Duobank Mortgage Application, I want to be able to sign up and log in securely using a  database
  system that protects my personal and financial information, so that I can complete the  mortgage application process with confidence.

  @firstDB
  Scenario Outline:Large number of Users should be able to signs up with
    Then User enter firstName "<firstName>" , lastName "<lastName>" , email "<email>" , password "<password>" and enter

    Examples:
      | firstName  | lastName  | email                   | password       |
      | Johnny     | Deep      | johnnyde@gmail.com      | tsfhdifnf76bs  |
      | johnnycash | candle    | johnnycash2@gmail.com   | kdgcfxzv54gh   |
      | Quentin    | Tarantino | stevejobs48@gmail.com   | kjh243gbskiyfs |
      | AL         | Pacino    | stevxsjhsej48@gmail.com | ssssssbskiyfs  |
      | Marlon     | Brando    | kulpasanto48@gmail.com  | gabsf5sgsds    |
      | fantomas   | tomatos   | sfantomastom8@gmail.com | kjh243gbskiyfs |
      | kevin      | shein     | skevinshein@gmail.com   | kjh243gbskiyfs |
      | katie      | levin     | katialevin@gmail.com    | ooopshd58dgdvv |
      | sonic      | faster    | sonicvan23@gmail.com    | udygv77stv     |
      | Willie     | Wonka     | choccolate@gmail.com    | hsgffff3444    |

    Scenario: verify database has last input
    Then The database should be able to handle without slowing down  the system

      @checkColumnNames
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