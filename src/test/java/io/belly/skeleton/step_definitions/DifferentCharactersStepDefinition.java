package io.belly.skeleton.step_definitions;

import io.cucumber.java.en.Given;

public class DifferentCharactersStepDefinition {
   @Given("^the phone number \\((\\d{3})\\) (\\d{7}) belongs to John$")
    public void thePhoneNumberBelongsToJohn(String areaCode, String phoneNumber) {
        System.out.println("The phone number (" + areaCode + ") " + phoneNumber + " belongs to John");
    }
    /*
    ("^the phone number \\((\\d{3})\\) (\\d{7}) belongs to John$") de {3} kullandık ,
    ama ("^the flight ([A-Z]{1,3}\\d{3,6}) is leaving today$") de {1,3} kullandık
    fark:
    {3}:
    Tam olarak 3 kez tekrar anlamına gelir. Yani, regex bu noktada yalnızca 3 karakter yakalar.
    Örneğin, (\\d{3}) ifadesi, tam olarak 3 basamaklı bir rakamı yakalar (örneğin "123").

    {1,3}:
    1 ile 3 arasında karakter anlamına gelir. Yani, regex bu noktada en az 1, en fazla 3 karakter yakalar.
    Örneğin, ([A-Z]{1,3}) ifadesi, 1 ile 3 arasında büyük harf yakalar (örneğin "A", "AB", "ABC").

    [A-Z]{1,3}: 1 ila 3 büyük harf yakalar (örneğin, "A", "AB", "ABC").
    \d{3,6}: 3 ila 6 rakam yakalar (örneğin, "123", "12345", "123456")


     */
    @Given("^the email (\\w+@\\w+\\.\\w+) is registered$")
    public void theEmailUserExampleComIsRegistered(String emailAddress) {
        System.out.println("The email address is: " + emailAddress);}
    /*
    @Given("^the email (\\w+@\\w+\\.com) is registered$") de yazabilirdik

    . @Given("^the email (\\w+@\\w+\\.com) is registered$")
Bu regex yapısı, sadece ".com" uzantılı email adreslerini yakalar.

Örneğin: user@example.com gibi bir email adresini yakalar.
Ancak: Bu yapı, .net, .org veya başka bir uzantıya sahip email adreslerini yakalayamaz. Yani, email adresinin son kısmı kesinlikle "com" olmalıdır.
2. @Given("^the email (\\w+@\\w+\\.\\w+) is registered$")
Bu yapı daha esnektir ve herhangi bir uzantıya sahip email adreslerini yakalayabilir.

Örneğin: user@example.com, user@domain.org, user@service.net gibi farklı uzantıları olan email adreslerini yakalar.
\\w+: Bu, uzantının (örneğin, "com", "net", "org") herhangi bir kelime karakteri içerebileceği anlamına gelir.
Hangisini Almalısın?
Eğer yalnızca .com uzantılı email adreslerini yakalamak istiyorsan, ilk seçenek uygundur:


@Given("^the email (\\w+@\\w+\\.com) is registered$")
Eğer daha esnek bir çözüm istiyorsan ve farklı uzantılara sahip email adreslerini de yakalamak istiyorsan, ikinci seçenek daha uygun olacaktır:


@Given("^the email (\\w+@\\w+\\.\\w+) is registered$")
Sonuç:
İhtiyacına göre karar verebilirsin:

Sadece .com uzantıları yakalamak için birinci regex'i.
Herhangi bir uzantıyı yakalamak için ikinci regex'i kullanabilirsin.
     */
    @Given("^the server with IP (\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}) is active$")
    public void theServerWithIPIsActive(String ipAddress) {
        System.out.println("The server with IP " + ipAddress + " is active");
    }
    /*
    @Given("^the server with IP ((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)) is active$")

     */
}
