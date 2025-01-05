package io.login.step_definitions.frequentflyer;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.login.frequentmembership.FrequentFlyerMember;

public class FrequentFlyerSteps {
    @ParameterType("(Gold|Silver) Frequent Flyer member")
    public FrequentFlyerMember frequentFlyer(String level) {

        // Seviyeye göre isimsiz bir FrequentFlyerMember nesnesi oluşturuyoruz
        return FrequentFlyerMember.withLevel(level);
    }
    /*
    Parametre Yakalama:
    @ParameterType içinde yalnızca (Gold|Silver) kısmı bir yakalama grubu olarak tanımlandığı için,
    frequentFlyer metodunun level parametresine yalnızca bu kısmın eşleşmesi aktarılır.
    Yani Frequent Flyer member ifadesi metot parametresine geçmez;
    sadece Gold veya Silver değeri level parametresine atanır.
    "Frequent Flyer member" kısmı ise @ParameterType ifadesinin geri kalan bir parçası olarak
    adımı tam olarak eşleştirmek için kullanılır
    ama level değişkenine aktarılmaz.
     */


    @Given("{string} is a {frequentFlyer}")
    public void defineFrequentFlyerMember(String name, FrequentFlyerMember member) {
        member.setName(name); // İsmi adımda verilen değerden ayarlıyoruz
        System.out.println(name + " is a " + member.getLevel() + " Frequent Flyer member");

        // Örnek puan kazanımı
        member.earnPoints(100);
        System.out.println(name + " has earned points: " + member.getPoints());
    }
    /*
    Cucumber, step definition’daki {string} parametresi ile eşleşebilmesi için
    çift tırnak içine alınmış değerleri arar.
    Çift tırnak kullanılmazsa, undefined hatası verebilir.
     */
    /*
    @ParameterType, feature dosyasındaki "Gold Frequent Flyer member"
    veya "Silver Frequent Flyer member" gibi ifadeleri tanır.
(Gold|Silver) kısmı yalnızca Gold veya Silver değerini yakalar
ve bu değeri level parametresi olarak frequentFlyer metoduna iletir.
frequentFlyer metodu bu level değerini kullanarak
bir FrequentFlyerMember nesnesi (domain object) oluşturur ve geri döndürür.
     */
    /*
    Step definition içinde {frequentFlyer} ile FrequentFlyerMember nesnesini (domain object)
    doğrudan alabiliyoruz.
Bu sayede feature dosyasındaki adım ("John is a Gold Frequent Flyer member")
doğrudan FrequentFlyerMember nesnesine dönüştürülmüş oluyor ve adımda parametre olarak kullanabiliyoruz.
FrequentFlyerMember nesnesine name ayarlanıyor, earnPoints ile puan kazanımı gibi işlemler yapılabiliyor.
     */
    /*
    Bu yapı ile @ParameterType sayesinde feature dosyasındaki ifadeleri
    FrequentFlyerMember domain nesnesine çevirmiş olduk.
    Bu yaklaşım, adım tanımlamaları sırasında feature dosyasındaki metinleri
    doğrudan anlamlı nesnelere dönüştürerek hem okunabilirliği artırır
    hem de işlemleri domain nesnesi ile doğrudan yapmamıza olanak tanır.
     */
}
