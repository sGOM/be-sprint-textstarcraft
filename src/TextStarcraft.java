import java.util.Scanner;

public class TextStarcraft {
    public static void main(String[] args) {
        play();
    }

    static void play() {
        System.out.println(" [안내] TRPG 스타크래프트 시작합니다. ");
        Scanner sc = new Scanner(System.in);
        String name = "";    int atk = 0, def = 0, hp = 0;
        System.out.println(" [안내] 자신의 유닛 정보를 입력해 주세요. ");
        System.out.printf(" [시스템] 유닛 [이름] 을 입력해 주세요 : ");
        name = sc.nextLine();
        System.out.printf(" [시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50) ");
        atk = getIntInput(sc);
        System.out.printf(" [시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1) ");
        def = getIntInput(sc);
        System.out.printf(" [시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100) ");
        hp = getIntInput(sc);
        System.out.println();

        Unit friendly = new Unit(name, atk, def, hp);

        System.out.println("=".repeat(50));

        System.out.println(" [안내] 상대 유닛 정보를 입력해 주세요. ");
        System.out.printf(" [시스템] 유닛 [이름] 을 입력해 주세요 : ");
        name = sc.nextLine();
        System.out.printf(" [시스템] 유닛 [공격력] 을 입력해 주세요 : (Ex 50) ");
        atk = getIntInput(sc);
        System.out.printf(" [시스템] 유닛 [방어력] 을 입력해 주세요 : (Ex 1) ");
        def = getIntInput(sc);
        System.out.printf(" [시스템] 유닛 [체력] 을 입력해 주세요 : (Ex 100) ");
        hp = getIntInput(sc);
        System.out.println();

        Unit enemy = new Unit(name, atk, def, hp);

        System.out.println("=".repeat(50));
        while(friendly.atkUnit(enemy)){}
    }

    static int getIntInput(Scanner sc){
        while (!sc.hasNextInt()){
            System.out.println(" 0 이상의 정수를 입력해주세요. ");
            sc.nextLine();
        }
        int input = sc.nextInt();
        sc.nextLine();
        return input;
    }
}

class Unit {
    String  name = "";
    int     atk = 0;
    int     def = 0;
    int     hp  = 0;

    public Unit(String name, int atk, int def, int hp) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;

        System.out.println(" [안내] 생성된 유닛 정보는 다음과 같습니다. ");
        System.out.println(String.format(" [안내] %s 유닛이 게임에 참여하였습니다. ", this.name));
        System.out.println(String.format(" [공격력] : %d ", this.atk));
        System.out.println(String.format(" [방어력] : %d ", this.def));
        System.out.println(String.format(" [체력] : %d ", this.hp));
    }

    public String getName() { return name; }
    public int getAtk()     { return atk; }
    public int getDef()     { return def; }
    public int getHp()      { return hp; }

    public void setName(String name)    { this.name = name; }
    public void setAtk(int atk)         { this.atk = atk; }
    public void setDef(int def)         { this.def = def; }
    public void setHp(int hp)           { this.hp = hp; }

    public boolean atkUnit(Unit atkedUnit) {
        System.out.println("-".repeat(50));
        if (atkedUnit.hp == 0) {
            System.out.println(" [안내] 더 이상 공격할 수 없습니다. \n");
            System.out.println(" [안내] 상대 유닛이 제거되었습니다. ");
            return false;
        }
        else {
            int damge = (this.atk - atkedUnit.def);
            if (atkedUnit.hp < damge) atkedUnit.hp = 0;
            else atkedUnit.hp -= damge;
            System.out.println(String.format(" [안내] [%s]유닛이 [공격] 하였습니다. ", this.name));
            System.out.println(String.format(" [안내] 상대 유닛의 남은 [체력]은 %d 입니다. ", atkedUnit.hp));
            return true;
        }
    }
}


