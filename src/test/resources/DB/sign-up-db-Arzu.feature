@DB
Feature: As a user of Duobank Mortgage Application, I want to be able to sign up and log in securely using a  database
  system that protects my personal and financial information, so that I can complete the  mortgage application process with confidence.

  @firstDB
  Scenario Outline:Large number of Users should be able to signs up with
    Then User enter firstName "<firstName>" , lastName "<lastName>" , email "<email>" , password "<password>" and enter

    Examples:
      | firstName | lastName  | email                     | password       |
      | Johnny    | Deep      | johnnyde2@gmail.com       | tsfhdifnf76bs  |
      | Gaby      | Candle    | johnnycash22@gmail.com    | kdgcfxzv54gh   |
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