package io.login.step_definitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.login.FrequentFlyerMember;

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
    public void defineFrequentFlyerMember(String name, FrequentFlyerMember frequentFlyer) {
        frequentFlyer.setName(name); // İsmi adımda verilen değerden ayarlıyoruz
        System.out.println(name + " is a " + frequentFlyer.getLevel() + " Frequent Flyer member");

        // Örnek puan kazanımı
        frequentFlyer.earnPoints(100);
        System.out.println(name + " has earned points: " + frequentFlyer.getPoints());
    }
    /*
    Cucumber, step definition’daki {string} parametresi ile eşleşebilmesi için
    çift tırnak içine alınmış değerleri arar.
    Çift tırnak kullanılmazsa, undefined hatası verebilir.
     */
}
