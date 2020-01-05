public class CallByReference {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = animal;

        animal.age = 10;
        animal1.age = 20;

        System.out.println(animal.age);
        System.out.println(animal1.age);

    }

    public static class Animal{
        public int age;
    }
}
