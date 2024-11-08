package io.login.step_definitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.login.FrequentFlyerMember;

import java.util.List;
import java.util.Map;

public class FrequentFlyerSteps {
    @DataTableType
    public FrequentFlyerMember convertToFrequentFlyerMember(Map<String, String> row) {
        // Tablo satırındaki 'name' ve 'level' alanlarını alarak bir FrequentFlyerMember nesnesi oluşturuyoruz
        String name = row.get("name");
        String level = row.get("level");
        return new FrequentFlyerMember(name, level);
    }
    @Given("the following frequent flyer members exist:")
    public void defineFrequentFlyerMembers(List<FrequentFlyerMember> members) {
        for (FrequentFlyerMember member : members) {
            System.out.println(member.getName() + " is a " + member.getLevel() + " Frequent Flyer member.");

            // Örnek puan kazanımı
            member.earnPoints(100);
            System.out.println(member.getName() + " has earned points: " + member.getPoints());
        }
    }
}
