/*
Default Versus Parameterized Construction   [Output Prediction | Intermediate]
Compare a class with no explicit constructor, then add one parameterized 
constructor and predict whether new ClassName() still compiles. Test and explain.
Done when: The student correctly describes compiler-provided default constructors.
*/

class Item {
    String name = "unnamed";
}

class Gadget {
    String name;

    public Gadget(String name) {
        this.name = name;
    }
}


public class Ex105DefaultVersusParameterizedConstruction {
    public static void main(String[] args) {
        Item i = new Item();
        Gadget g = new Gadget("Phone");

        System.out.println(i.name);
        System.out.println(g.name);
    }
}
