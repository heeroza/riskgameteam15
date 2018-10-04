package Objects;

public class Continent {

        private String name;
        private Integer bonus;

    public Continent(String name, Integer bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }
    public String getName() {
        return name;
    }

    public void setBonus(Integer mbonus) {
        this.bonus = mbonus;
    }


    public void setName(String mname) {
        this.name = mname;
    }
}
