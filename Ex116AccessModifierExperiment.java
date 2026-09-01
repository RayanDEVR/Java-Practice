/*
Access Modifier Experiment   [Code Reading | Intermediate]
Create same-class, same-package child/non-child and different-package child/non-child access attempts for 
public, protected, default and private fields. Record compile results.
Done when: A matrix accurately summarizes the observed access rules.
*/

class Demo {
    private int a = 10;
    protected int b = 20;
    public int c = 30;
    int d = 40; //Default

    public void showFromSameClass() {
        System.out.println("pri = " + a);
        System.out.println("pro = " + b);
        System.out.println("pub = " + c);
        System.out.println("def = " + d);
    }
}

class SamePackageUser extends Demo {
    public void show() {
        // System.out.println("pri = " + a);    Not accessible
        System.out.println("pro = " + b);
        System.out.println("pub = " + c);
        System.out.println("def = " + d);
    }
}
public class Ex116AccessModifierExperiment {
    public static void main(String[] args) {
        SamePackageUser num = new SamePackageUser();
        num.showFromSameClass();
        System.out.println();
        num.show();
    }
}

/*
    Modifier  | Same class | Same package  | Different package(non- child) | Different package(child)
--------------|------------|---------------|-------------------------------|------------------------------
    Private   |     Yes    |      Yes      |              Yes              |            Yes
    Protected |     Yes    |      Yes      |              No               |            Yes (via inheritance)
    Public    |     Yes    |      No       |              No               |            No
    Default   |     Yes    |      Yes      |              No               |            No
*/