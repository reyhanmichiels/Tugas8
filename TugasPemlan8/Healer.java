package TugasPemlan8;

public class Healer extends Character {
    Healer(){
        setHP(70);
        setAttack(10);
        setDefense(10);
    }

    void heal(){
        setHP(getHP() + 25);
    }

    @Override
    public boolean attack() {
        double chance = Math.random() * 10;
        if (chance > 0 && chance <= 8.5)
            return true;
        else
            return false;
    }
}
