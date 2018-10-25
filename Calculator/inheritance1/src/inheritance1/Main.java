package inheritance1;
class A{
    private int i;
    public int j;
    public A()
    {
        System.out.println("Class A default constructor is calling");
    }
    public A(int x)
    {
        i=x;
    }
    public void get()
    {
        System.out.println(i);
    }
}

class B extends A{   // attention: without declaring default constructor in Parent class you can not
                      //  define or inherit that class, if you delete the public A() constructor
                      // you will see an error in this line mentioned,"class B extends A".
    public int j;
    public B()
    {
        System.out.println("Class B default constructor is calling");
    }
    public B(int p,int q,int r)
    {
        super(p);  // number of parameters in Super() and number of parameters of parameterized
                    // constructor declared in Class A, "public A(int x)", must be same.
        super.j=q; // j is public variable of A class
        j=r; // this is local j of B class
    }
    public void getB()
    {
        System.out.println(j);
    }
}
class C extends A{
    public C()
    {
        super(100);
        System.out.println("Class C default constructor is calling");
    }
}
class D extends B{
    public D(){
        super.j=100; // father of D is B, so super will refer to the variable j declared in class B

    }
}

/************************ TREE REPRESENTATION *****************************/
/*                            A (super class of B and C)
                              /|\
 *                             |
 *                      ------------------------
 *                      |                      |
 *                      B(super class of D)    C(sub class of A, Sibling of B class)
 *                      /|\
 *                       |
 *                      D (subclass of B and A)
 */

/**************************************************************************/

public class Main {
    public static void main(String[] args) {
        D d=new D();
        d.getB();
        B b=new B(10,20,30); // it will set value of i in A class to 10 using super call in B class
        b.get();
        d.get();

    }

}
