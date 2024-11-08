package io.login;

public class FrequentFlyerMember {
    private String name;
    private String level; // Gold, Silver gibi seviyeler
    private int points;

    public FrequentFlyerMember(String name, String level) {
        this.name = name;
        this.level = level;
        this.points = 0; // Başlangıç puanı
    }
    // withLevel metodu, isimsiz olarak sadece seviyeye göre nesne oluşturmamızı sağlar
    public static FrequentFlyerMember withLevel(String level) {
        return new FrequentFlyerMember(null, level); // İsimsiz bir nesne oluşturuyoruz
    }

    public void earnPoints(int basePoints) {
        // Seviyeye göre ekstra puan kazandırma
        switch (this.level) {
            case "Gold":
                this.points += (int) (basePoints * 1.5); // %50 daha fazla puan
                break;
            case "Silver":
                this.points += basePoints; // Normal puan
                break;
            default:
                throw new IllegalArgumentException("Geçersiz üyelik seviyesi: " + this.level);
        }
    }

    // Getter ve Setter metotları
    public int getPoints() {
        return points;
    }

    public String getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + level + ")";
    }
}
