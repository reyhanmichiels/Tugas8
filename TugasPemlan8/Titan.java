package TugasPemlan8;

public class Titan extends Character{
    Titan(){
        setHP(200);
        setAttack(45);
        setDefense(0);
    }

    @Override
    public boolean attack() {
        double chance = Math.random() * 10;
        if (chance > 0 && chance <= 4.0)
            return true;
        else
            return false;
    }
}
