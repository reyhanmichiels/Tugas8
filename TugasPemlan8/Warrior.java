package TugasPemlan8;

public class Warrior extends Character {

    Warrior(){
        setHP(80);
        setAttack(25);
        setDefense(30);
    }

    @Override
    public boolean attack() {
        double chance = Math.random() * 10;
        if (chance > 0 && chance <= 6.0)
            return true;
        else
            return false;
    }
}
