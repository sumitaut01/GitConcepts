package methodchain;

public class ParentGeneric <T extends ParentGeneric<T>>{

    public  T method1(){

        System.out.println("code of parent");
        return (T) this;
    }

    public static void main(String[] args) {

        Childgeneric c=new Childgeneric();

        c.method1()
                .method2();
    }


}

class Childgeneric extends ParentGeneric<Childgeneric>{

    public Childgeneric method2(){
        System.out.println("code of child");
        return this;
    }

}
