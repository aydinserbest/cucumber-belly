package io.belly.skeleton.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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
    @Given("^the birthdate is (\\d{2})/(\\d{2})/(\\d{4})$")
    public void theBirthdateIs(String day, String month, String year) {
        System.out.println("The birthdate is: " + day + "/" + month + "/" + year);
    }
    //@Given("the file path is {word}")
    //@Given("^the file path is (.+)$")

    //@Given("^the file path is ([A-Za-z]:\\\\[\\w]+\\\\[\\w]+\\\\[\\w]+)$")
        //  \\w+ veya [\\w]+ kullanılabilir , köşelide, + dışarda olur

    //@Given("^the file path is ([A-Za-z]:\\\\\\w+\\\\\\w+\\\\\\w+)$")

    // alttaki yöntemde, variable'ı tek olarak almaz, ayrı ayrı alır, metoda 4 variable 'ı paramtre geçmemiz gerekir
    //@Given("^the file path is ([A-Za-z]):\\\\(\\w+)\\\\(\\w+)\\\\(\\w+)$")

    //@Given("^the file path is ([A-Za-z]:\\\\(?:[^\\\\]+\\\\)+[^\\\\]+)$")
    public void theFilePathIs(String filePath) {
        System.out.println("The file path is: " + filePath);
    }
    /*
    Regex'te (.+)$ ifadesi, dosya yolunun tamamını esnek bir şekilde yakalamak için kullanılan basit ve güçlü bir yapı. Şimdi bunu adım adım açıklayalım:

Regex Yapısı:
. (Nokta):

. regex'te, herhangi bir karakteri temsil eder.
Yani, bir harf, rakam, boşluk, nokta, özel karakter fark etmeksizin
herhangi bir karakteri yakalayabilir.
Bu nedenle, dosya yolunda yer alan her türlü karakteri
(örneğin, C, U, s, \, J, o, h, n, vs.) yakalayabilir.
+ (Artı):
+ işareti, bir veya daha fazla karakterin tekrarlanabileceğini belirtir.
Yani, . + ifadesi, herhangi bir karakterden bir veya daha fazlasını yakalar.
Bu, tek bir karakterli veya çok uzun bir metni de yakalayabilir.
Bu, dizinlerin isimlerinin uzunluğu veya dosya yolunun uzunluğu fark etmeksizin
tüm metni yakalamaya olanak tanır.
$ (Dolar İşareti):

$ işareti, satırın sonunu temsil eder.
Yani, dosya yolunun tamamı bu noktada sona erer ve regex,
metnin sonuna kadar olan kısmı yakalar.
Bu Regex'in Özelliği:
(.+)$: Bu ifade, herhangi bir uzunluktaki dosya yolunu
ve herhangi bir karakteri yakalar ve bunun satırın sonuna kadar olduğunu belirtir.
Örneğin, bu regex, dosya yolu fark etmeksizin
C:\Users\John\Documents,
D:\MyFiles\Report.txt
gibi dosya yollarını tamamen yakalayacaktır.

(.+)$ ifadesi ile herhangi bir dosya yolu (uzun veya kısa fark etmez) yakalanır
ve filePath değişkenine atanır.
Dosya yolu ne kadar karmaşık ya da uzun olursa olsun,
bu regex tüm karakterleri kapsar ve dosya yolunu sorunsuz şekilde yakalar.
Sonuç:
Bu regex oldukça esnektir ve herhangi bir dosya yolunu tamamen yakalayabilir.
Eğer dosya yolunun formatı çok karmaşık değilse
ve spesifik bir format doğrulaması yapmaya gerek yoksa,
bu gibi basit regex yapıları kullanışlıdır
     */

    ///
     /*
     iki versiyon arasında aslında teknik olarak fark yok, çünkü ikisi de aynı sonucu verir. Ancak fark şu şekildedir:

İlk versiyon:


@Given("^the file path is ([A-Za-z]:\\\\[\\w]+\\\\[\\w]+\\\\[\\w]+)$")
[\\w] ifadesi bir karakter sınıfı belirtir. Bu karakter sınıfı alfabedeki harfleri, rakamları ve alt çizgi (_) karakterini içerir. Köşeli parantezler içindeki \\w, aynı anlama gelir.
Köşeli parantezler kullanmak gereksizdir çünkü \\w zaten bir karakter sınıfıdır. Bu yüzden köşeli parantezlere gerek kalmaz, ancak yanlış da değildir.
İkinci versiyon:


@Given("^the file path is ([A-Za-z]:\\\\\\w+\\\\\\w+\\\\\\w+)$")
Bu versiyon daha sade bir yazımdır. Köşeli parantezleri kullanmak yerine doğrudan \\w+ kullanılır. Bu da harf, rakam veya alt çizgiden oluşan bir karakter dizisini yakalar.
Özet:
İşlevsel olarak fark yok. Her iki regex de aynı şeyi yapar.
İkinci versiyon, daha sade ve okunabilir bir yapı sunar çünkü \\w zaten bir karakter sınıfı olduğundan köşeli parantezlere gerek yoktur.
Tercih genellikle daha basit olanı seçmek yönünde olur, bu yüzden ikinci versiyon daha yaygın olarak tercih edilebilir.
Sonuç olarak, ikinci yapı daha sade ve tercih edilen bir yöntemdir.
    */
    @When("^I transfer \\$(\\d+) from my (\\w+) Account into my (\\w+) Account$")
    public void iTransferFromMyAccountIntoMyAccount(int amount, String sourceAccount, String targetAccount) {
        System.out.println("I transfer $" + amount + " from my " + sourceAccount + " Account into my " + targetAccount + " Account");
    }
}
