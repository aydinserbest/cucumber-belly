package io.login;

public class FrequentFlyerMember {
    private String name;
    private String level; // Gold, Silver gibi seviyeler
    private int points;

    public FrequentFlyerMember(String name, String level) {
        this.name = name;
        this.level = level;
    }
    /// Getter ve Setter metotları
    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {

        return "FrequentFlyerMember{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
