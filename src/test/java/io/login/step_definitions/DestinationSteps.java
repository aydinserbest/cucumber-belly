package io.login.step_definitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.List;

public class DestinationSteps {
    @ParameterType(name = "string-cities",value = ".*")
    public List<String> stringValues(String destinationList) {
        //return Stream.of(destinationList.split(","))
        //      .map(String::trim)
          //      .collect(Collectors.toList());
        return Arrays.asList(destinationList.split(","));
        /*
        Stream.of() yerine Arrays.asList() kullanarak listeye dönüştürmeyi daha kısa hale getirdik.
        map(String::trim) ifadesini kaldırdık. Bu, liste öğelerini trimlemek yerine olduğu gibi alır;
        ancak boşlukları temizlemek gerekiyorsa yine de map(String::trim) kullanılabilir.
         */
    }

    @Then("the available destinations should be {string-cities}")
    public void availableDestinations(List<String> destinations) {
        for (String destination : destinations) {
            System.out.println(destination);
        }
        System.out.println(destinations.get(1));
    }
}
/*
feature dosyasındaki "Then the available destinations should be Berlin, Paris, New York" ifadesi
@ParameterType ile List<String> türüne dönüştürülmek isteniyor.
Ancak bu dönüşüm, stringValues metodu ile sağlanacak;
yani @ParameterType metodu destinationList adlı tek bir String parametresi alıyor
ve bunu virgül ile ayırıp List<String> haline getiriyor.

Adım Adım Ne İstiyoruz?
Feature Dosyasındaki İfade:
Feature dosyasında şu ifade var:
Then the available destinations should be Berlin, Paris, New York
Bu ifade, @ParameterType sayesinde bir String olarak alınıyor.
Yani "Berlin, Paris, New York" şeklinde tek bir String olarak geliyor.

@ParameterType ile Dönüştürme:
@ParameterType ile gelen String ifadeyi List<String> türüne dönüştürmek istiyoruz.
@ParameterType(".*")
public List<String> stringValues(String destinationList) {
    return Stream.of(destinationList.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
}
Bu stringValues metodu, gelen destinationList stringini virgüllere göre ayırarak
"Berlin", "Paris", "New York" gibi her bir öğeyi List<String> içine koyuyor.
["Berlin", "Paris", "New York"] şeklinde bir List<String> dönüyor.

Adım Tanımlaması (Step Definition): Adım tanımında artık doğrudan List<String> olarak destinations parametresini alabiliyoruz:

@Then("the available destinations should be {stringValues}")
public void availableDestinations(List<String> destinations) {
    for (String destination : destinations) {
        System.out.println(destination);
    }
}
Özetle Ne Elde Ediyoruz?
Feature dosyasındaki "Berlin, Paris, New York" ifadesi stringValues ile List<String> haline geliyor.
@ParameterType, gelen String değeri split ile ayırarak List<String> türüne dönüştürüyor,
böylece availableDestinations metodunda List<String> destinations parametresi olarak kullanabiliyoruz.
Yani amacımız, feature dosyasındaki metni @ParameterType aracılığıyla List<String> türüne dönüştürmek.
 */
