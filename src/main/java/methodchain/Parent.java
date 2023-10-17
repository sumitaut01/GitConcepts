package methodchain;

public class Parent {


    public Parent method1(){

        System.out.println("parent code");
        return this;
    }


    class Child extends  Parent{


    }

}
