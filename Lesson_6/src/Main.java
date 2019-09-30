//Выполняем домашнее задание к уроку 6

abstract class Animal {
    protected int _length;
    protected double _height;
    protected int _lengthSwim;

    abstract void run(int length);

    abstract void jump(double height);

    abstract void swim(int lengthSwim);


    static void showResult(Object obj, boolean result) {
        System.out.println(obj.getClass().getName() + " : " + result);
    }
}

class Cat extends Animal {
    @Override
    void run(int length) {
        boolean result = length <= 200;
        if (result) {
            _length = length;
        }
        showResult(this, result);
    }

    @Override
    void jump(double height) {
        boolean result = height <= 2;
        if (result) {
            _height = height;
        }
        showResult(this, result);
    }

    @Override
    void swim(int length) {
        boolean result = length >= 0;
        if (result) {
            _lengthSwim = length;
        }
        System.out.println("Котик не плавает:(");

    }
}

class Dog extends Animal {
    private int maxLength;

    Dog() {
        maxLength = Math.random() > 0.5 ? 400 : 600;
    }

    int getMAxLengtx() {
        return maxLength;
    }

    void swim(int length) {
        boolean result = length <= 10;
        if (result) {
            _lengthSwim = length;
        }
        showResult(this, result);
    }

    @Override
    void run(int length) {
        boolean result = length <= maxLength;
        if (result) {
            _length = length;
        }
        showResult(this, result);
    }

    @Override
    void jump(double height) {
        boolean result = height <= 0.5;
        if (result) {
            _height = height;
        }
        showResult(this, result);
    }
}


public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal cat = new Cat();

        System.out.println("Бег:");
        dog.run(150);
        cat.run(5000);
        System.out.println();

        System.out.println("Прыжки:");
        dog.jump(10);
        cat.jump(11);
        System.out.println();

        System.out.println("Плавание:");
        dog.swim(3);
        cat.swim(10);
    }
}