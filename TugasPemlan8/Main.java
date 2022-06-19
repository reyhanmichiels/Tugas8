package TugasPemlan8;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Opening Program
        System.out.println("========================================");
        System.out.println("Selamat Datang di Game Defend Filkom");
        System.out.println("========================================");

        //Meminta data user dan role yang diinginkan
        System.out.print("Silahkan masukkan nama player : ");
        String name = scan.nextLine();

        System.out.println("Pilih role yang anda inginkan:");
        System.out.println("1. Magic\n2. Healer\n3. Warrior");

        System.out.print("Masukkan pilihan anda : ");

        //Exception untuk menghindari kesalahan input
        byte choice = 0;
        do {
            try {
                choice = scan.nextByte();
                if (choice != 1 && choice != 2 && choice != 3){
                    throw new IllegalArgumentException();
                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("WRONG INPUT !");
                System.out.println("----------------------------------------");
                System.out.println("Input harus berupa angka 1 atau 2 atau 3");
                System.out.print("Masukkan pilihan anda : ");
            }
            catch (IllegalArgumentException e){
                System.out.println();
                System.out.println("----------------------------------------");
                System.out.println("WRONG INPUT !");
                System.out.println("----------------------------------------");
                System.out.println("Input harus berupa angka 1 atau 2 atau 3");
                System.out.print("Masukkan pilihan anda : ");
            }
            scan.nextLine();
        }
        while (choice != 1 && choice != 2 && choice != 3);

        //membuat objek user and enemy
        ArrayList<Character> ch = new ArrayList<>();

        switch (choice){
            case 1: ch.add(new Magician());break;
            case 2: ch.add(new Healer());break;
            case 3: ch.add(new Warrior());break;
            default: throw new IllegalArgumentException();
        }

        ch.add(new Titan());

        //memulai permainan
        info(ch.get(0));
        info(ch.get(1));
        System.out.println("Selamat datang, " + name);
        fight(ch.get(0), ch.get(1));
    }

    static void info(Character ch){
        if (ch instanceof Titan){
            System.out.println("========================================");
            System.out.println("Enemy Status");
            System.out.println("========================================");
        }
        else{
            System.out.println("\n========================================");
            System.out.println("Your Status");
            System.out.println("========================================");
        }
        Class obj = ch.getClass();
        System.out.printf("%-20s: %s%n", "Role", obj.getSimpleName() );
        ch.info();
    }

    // Method untuk bertarung
    static void fight(Character user, Character enemy){
        int i = 1;

        do {
            //TURN 1 user menyerang
            System.out.println("\n========================================");
            System.out.println("TURN " + i);
            System.out.println("========================================");
            i++;

            //User mencoba menyerang
            if (user.attack()) {
                System.out.println("Anda berhasil menyerang");
                enemy.receiveDamage(user.getAttack());
            }

            // Status HP
            System.out.printf("%-20s: %d%n", "User HP", user.getHP());
            System.out.printf("%-20s: %d%n", "Enemy HP", enemy.getHP());

            //keluar dari looping ketika user HP sudah 0
            if (enemy.getHP() == 0)
                break;

            //TURN 2 enemy menyerang
            System.out.println("\n========================================");
            System.out.println("TURN " + i);
            System.out.println("========================================");
            i++;

            //User mendapatkan heal jika memiliki role healer
            if (user instanceof Healer) {
                System.out.println("Anda mendapatkan Heal !");
                ((Healer) user).heal();
            }

            //enemy mencoba menyerang
            if (enemy.attack()) {
                System.out.println("Anda telah diserang musuh");
                user.receiveDamage(enemy.getAttack());
            }

            // Status HP
            System.out.printf("%-20s: %d%n", "User HP", user.getHP());
            System.out.printf("%-20s: %d%n", "Enemy HP", enemy.getHP());
        }
        while (user.getHP() != 0 && enemy.getHP() != 0);

        if (user.getHP() == 0){
            System.out.println("\n----------------------------------------");
            System.out.println("Anda Kalah");
            System.out.println("----------------------------------------");
        }
        else if (enemy.getHP() == 0){
            System.out.println("\n----------------------------------------");
            System.out.println("Anda Menang");
            System.out.println("----------------------------------------");
        }
        info(user);
        info(enemy);
    }
}
