package TugasPemlan8;

public class Magician extends Character{

    Magician (){
        setHP(100);
        setAttack(60);
        setDefense(10);
    }

    @Override
    public boolean attack() {
        double chance = Math.random() * 10;
        if (chance > 0 && chance <= 3.5)
            return true;
        else
            return false;
    }

}
