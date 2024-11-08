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


    @Given("{string} is a {frequentFlyer}")
    public void defineFrequentFlyerMember(String name, FrequentFlyerMember member) {
        member.setName(name); // İsmi adımda verilen değerden ayarlıyoruz
        System.out.println(name + " is a " + member.getLevel() + " Frequent Flyer member.");

        // Örnek puan kazanımı
        member.earnPoints(100);
        System.out.println(name + " has earned points: " + member.getPoints());
    }
}
