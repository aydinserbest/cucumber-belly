@selectedbooks
Feature: Library Management

  @runnerClassTag
  Scenario: User selects a book
    Given the selected book is "To Kill a Mockingbird" by Harper Lee

  @jvmTag
  Scenario: User searches for a book
    Given the selected book is "1984" by George Orwell

  @propertiesTag
  Scenario: User adds a new book
    Given the selected book is "The Great Gatsby" by F. Scott Fitzgerald

  @pomXmlTag
  Scenario: User removes a book
    Given the selected book is "Moby Dick" by Herman Melville
