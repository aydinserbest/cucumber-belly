package io.login.step_definitions;

import io.cucumber.java.en.Given;
import io.login.FrequentFlyerMember;

import java.util.List;
import java.util.Map;

public class FrequentFlyerSteps {

/*
    @Given("the following frequent flyer members exist:")
    public void defineFrequentFlyerMembers(DataTable members) {
        List<FrequentFlyerMember> frequentFlyerMemberStream = members.asMaps()
                .stream()
                .map(member -> new FrequentFlyerMember(member.get("name"), member.get("level")))
                .toList();
        // Oluşturulan nesneleri yazdır
        frequentFlyerMemberStream.forEach(System.out::println);

    }
    */


    @Given("the following frequent flyer members exist:")
    public void defineFrequentFlyerMembers(List<Map<String,String>> members) {
        List<FrequentFlyerMember> frequent = /*List.of(
                new FrequentFlyerMember("Alice", "Gold"),
                new FrequentFlyerMember("Bob", "Silver"),
                FrequentFlyerMember.withLevel("Gold"),
                FrequentFlyerMember.withLevel("Silver")
        );
        */
                members.stream()
                        .map(member -> new FrequentFlyerMember(member.get("name"), member.get("seviye")))
                        .toList();
                frequent.forEach(System.out::println);


    }

}



/*
feature dosyasındaki tabloyu @DataTableType kullanmadan
List<FrequentFlyerMember> türüne doğrudan çevirebilmemiz için
Cucumber’ın DataTable içindeki sütun isimlerini FrequentFlyerMember sınıfındaki alan isimleriyle
otomatik olarak eşleştirebilmesi gerekiyor.
Cucumber, bu eşleşmeyi DataTable sütunlarının FrequentFlyerMember sınıfındaki alan adlarıyla
birebir aynı olması durumunda otomatik olarak yapabilir.

Şu anda FrequentFlyerMember sınıfındaki alan adları name ve level olarak tanımlanmış durumda
ve feature dosyasındaki tablo başlıkları (name ve level) bunlarla birebir eşleşiyor.
Bu nedenle @DataTableType olmadan doğrudan List<FrequentFlyerMember> olarak alabiliriz.
 */
