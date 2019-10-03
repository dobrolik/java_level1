// Домашнее задание к уроку №7
class Cat {
    private String name;
    private int appetite;
    private boolean satiety; //сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        System.out.println(name + " пришёл поесть..." );
        satiety = plate.decreaseFood(appetite);
    }

    public void info() {
        System.out.println(name + " " + (satiety ? "сыт! " : "голоден:("));
    }
}

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int appetite) {
        if (food - appetite < 0) {
            return false;
        }
        else {
            food -= appetite;
            return true;
        }
    }

    public void info() {
        System.out.println("В тарелке: " + food);
    }
// метод добавления еды
    public void addFood(int food) {
        this.food += food;
    }

}

public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Пушок", 20),
                new Cat("Барсик", 25),
                new Cat("Мурзя", 25),
        };
        Plate plate = new Plate(50);
        plate.info();
        for(Cat itemCat:cats) {
            itemCat.eat(plate);
            itemCat.info();
            plate.info();
        }

    }
}