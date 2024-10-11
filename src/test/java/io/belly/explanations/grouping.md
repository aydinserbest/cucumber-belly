1. Regex'te Parantezler ( ):
   Gruplama: Regex'te parantezler, bir metnin belirli bir kısmını yakalayıp gruplamak için kullanılır. Bu gruplar daha sonra tekrar kullanılabilir veya yakalanan metin step definition'a parametre olarak geçirilebilir.
   Örneğin:
   java
   Copy code
   @Given("^the flight ([A-Z]{1,3}\\d{3,6}) is leaving today$")
   public void theFlightIsLeavingToday(String flightCode) {
   System.out.println("Flight " + flightCode + " is leaving today.");
   }
   ([A-Z]{1,3}\\d{3,6}): Bu, uçuş kodunu yakalayan bir gruptur. "EZY4567" gibi bir değeri flightCode parametresine geçirir.
2. Cucumber Expressions'da Parantezler ( ):
   Yer tutucuya (placeholder) dönüştürme: Cucumber Expressions'da parantezler, regex'teki gibi kullanılmaz. Yerine, küçük süslü parantezler {} kullanılır ve Cucumber yer tutucular (placeholders) sağlar, örneğin {int}, {word} gibi. Bu yer tutucular, otomatik olarak bir grup yakalama gibi davranır.
   Örneğin:
   java
   Copy code
   @Given("the flight {word} is leaving today")
   public void theFlightIsLeavingToday(String flightCode) {
   System.out.println("Flight " + flightCode + " is leaving today.");
   }
   {word}: Bu yer tutucu bir kelimeyi yakalar ve flightCode parametresine geçirir.
   Farklar:
   Regex'te parantezler ile gruplama manuel yapılır ve gruplar yakalanan metinleri parametre olarak aktarır.
   Cucumber Expressions'da parantezler yerine {} kullanılır ve Cucumber yer tutucuları otomatik olarak gruplamayı sağlar.
