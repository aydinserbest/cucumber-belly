package io.belly.skeleton;

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
}
