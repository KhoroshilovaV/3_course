interface Toy {
    void play();
}
class Ball implements Toy {
    @Override
    public void play() {
        System.out.println("Вы играете с мячом!");
    }
}
class Doll implements Toy {
    @Override
    public void play() {
        System.out.println("Вы играете с куклой!");
    }
}
class Constructor implements Toy {
    @Override
    public void play() {
        System.out.println("Вы играете с конструктором!");
    }
}
class ToyFactory {
    public static Toy createToy(String toyType) {
        switch (toyType.toLowerCase()) {
            case "мяч":
                return new Ball();
            case "кукла":
                return new Doll();
            case "конструктор":
                return new Constructor();
            default:
                throw new IllegalArgumentException("Unknown toy type: " + toyType);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Укажите тип игрушки, с которой вы хотите играть( мяч, кукла, конструктор): ");
        String toyType = scanner.nextLine().trim();

        try {
            Toy toy = ToyFactory.createToy(toyType);
            toy.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
