package innerclasses;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify interface/HorrorShow.java to implement Dangerousmonster and
 * Vampire using anonymous classes.
 **/
interface Monster{
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}
interface Lethal{
    void kill();
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VerybadVampire implements Vampire {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}
public class HorrorShow14 {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public DangerousMonster monsterMaker() {
        return new DangerousMonster() {
            @Override
            public void destroy() {
                print("DangerousMonster destory");
            }

            @Override
            public void menace() {
                print("DangerousMonster menace");
            }
        };
    }

    public Vampire vampireMaker() {
        return new Vampire() {
            @Override
            public void drinkBlood() {
                print("Vampire Menace");
            }

            @Override
            public void destroy() {
                print("Vampire Destroy");
            }

            @Override
            public void kill() {
                print("Vampire Kill");
            }

            @Override
            public void menace() {
                print("Vampire DrikBlood");
            }
        };
    }

    public static void main(String[] args) {
        HorrorShow14 show = new HorrorShow14();
        show.u(show.monsterMaker());
        show.v(show.monsterMaker());
        show.u(show.vampireMaker());
        show.v(show.vampireMaker());
        show.w(show.vampireMaker());

    }
}
