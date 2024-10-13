

(?:she|he)   ---   (she|he)
1-

(she|he) gibi bir capturing group kullanarak, "she" veya "he" kelimelerinden birini yakalarız 
ve bu değeri bir değişken (variable) olarak step definition'a parametre olarak geçmemiz gerekir.


(she|he) ifadesi bir capturing group olduğundan, 
Cucumber bu ifadeyle eşleşen değeri (yani "she" veya "he") yakalar.
Yakalanan bu değer, step definition’a parametre olarak aktarılır.
Step definition içerisinde bu parametreyi (örneğin pronoun gibi bir değişken) kullanarak işlem yapabilirsiniz.
Örnek:
Step Tanımı:

@When("^(she|he) purchases a ticket$")
Step Definition:

@When("^(she|he) purchases a ticket$")
public void person_purchases_a_ticket(String pronoun) {
if (pronoun.equals("she")) {
System.out.println("She purchases a ticket.");
} else {
System.out.println("He purchases a ticket.");
}
}
Nasıl Çalışır?
(she|he): Bu ifade, "she" veya "he" kelimesiyle eşleşir ve bu değeri pronoun isimli değişkene atar.
String pronoun: Yakalanan "she" veya "he" kelimesi bu parametreye aktarılır.
Bu parametreyi kullanarak if-else yapısı gibi mantıklarla hangi kelimenin kullanıldığını kontrol edebiliriz.
Örnek Gherkin Senaryosu:

Scenario: Person purchases a ticket
When she purchases a ticket
When he purchases a ticket

Çalışma Mantığı:
İlk adımda, "she" kelimesi yakalanır ve pronoun değişkenine aktarılır. 
Step definition’da "She purchases a ticket" yazdırılır.
İkinci adımda, "he" kelimesi yakalanır ve pronoun değişkenine aktarılır. 
Step definition’da "He purchases a ticket" yazdırılır.
Sonuç:
Evet, (she|he) dediğinizde, "she" veya "he" kelimelerinden birini yakalamış oluyorsunuz 
ve bu yakalanan değeri metoda parametre olarak geçmelisiniz. 
Bu parametreyi step definition içerisinde kullanarak yakalanan değere göre işlem yapabilirsiniz.

/////////

(?:she|he) yapısında, bu bir non-capturing group olduğu için değeri yakalamıyoruz. Bu durumda sadece "she" veya "he" kelimesiyle eşleşme yapılır, ancak bu kelimeler step definition'a parametre olarak geçirilmez.

Farkın Özeti:
(she|he): Capturing group — Bu yapıyla eşleşen değeri (yani "she" veya "he") yakalarız ve bu değeri bir değişken olarak metoda geçeriz.
(?:she|he): Non-capturing group — Bu yapıda eşleşme yapılır, ancak eşleşen değer yakalanmaz ve metoda geçirilmez. Bu durumda, "she" veya "he" kelimelerinin varlığı kontrol edilir, ama bunları bir değişken olarak almayız.
Örnekler:
1. Capturing Group ((she|he)):
   java
   Copy code
   @When("^(she|he) purchases a ticket$")
   public void person_purchases_a_ticket(String pronoun) {
   // "she" veya "he" kelimesi yakalanır ve 'pronoun' parametresine aktarılır
   if (pronoun.equals("she")) {
   System.out.println("She purchases a ticket.");
   } else {
   System.out.println("He purchases a ticket.");
   }
   }
   Bu durumda:

Yakalanan "she" veya "he" kelimesi pronoun değişkenine aktarılır ve step definition'da kullanılabilir.

2. Non-capturing Group ((?:she|he)):
   
   @When("^Tara (?:she|he) purchases a ticket$")
   public void person_purchases_a_ticket() {
   // "she" veya "he" yakalanmaz, sadece varlığı kontrol edilir
   System.out.println("Tara purchases a ticket.");
   }
   Bu durumda:

"she" veya "he" kelimesi yakalanmaz, sadece eşleşir.
Step definition'a bir parametre aktarılmaz; sadece eşleşmenin doğru olup olmadığını kontrol ederiz.
Özet:
(she|he): Yakalanan değeri bir değişken olarak metoda geçeriz.
(?:she|he): Değer yakalanmaz, sadece eşleşir. Metoda hiçbir değişken geçmez.
Eğer sadece "she" ve "he" arasında bir seçim yapıp yakalamak istiyorsanız, 
capturing group kullanmalısınız: (she|he).
Eğer sadece eşleşme yapıp bu kelimelerle ilgili bir veri yakalamak istemiyorsanız, 
non-capturing group kullanmalısınız: (?:she|he)

3-
örnek:
When she purchases a ticket
When he purchases a ticket

adımını step definitionsa geçerken,
eğer (she|he) dersek, bu bir capturing group olur 
ve bu değeri bir değişken olarak step definition'a parametre olarak geçmemiz gerekir.
eğer (?:she|he) dersek, bu bir non-capturing group olur 
ve bu değeri bir değişken olarak step definition'a parametre olarak geçmemiz gerekmez.






