Scenario: I have a
Given I have a cucumber in my basket
When I have 256 cucumbers in my basket

Cucumber terminolojisinde, her bir Gherkin step'ini (adımını) işlemek için kullanılan kod bloğu 
"step definition" olarak adlandırılır. 
Yani senaryonun step'lerini tek bir method değil, tek bir "step definition" içinde yazmayı kastediyorsun.

Bu durumda, şöyle ifade edebilirsin:

"Bu senaryo adımlarını tek bir step definition içinde yazalım."

"Step definition" yazılıma adımları bağlayan kod bloklarını ifade eder ve burada uygun terimdir.

/////

Step'lerde yakalanacak değerler parantez içinde tanımlanmalıdır
(örneğin: (a|\\d+)).
Opsiyonel kısımlar ise s? gibi bir yapıyla belirtilmelidir.

Values to be captured in steps should be defined within parentheses (e.g., (a|\\d+)).
Optional parts should be written as s?