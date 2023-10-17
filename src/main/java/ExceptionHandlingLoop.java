public class ExceptionHandlingLoop {


    public static void main(String[] args) {

        boolean isDisplayed=false;
int counter=0;


            while(!isDisplayed) {
                try {
                    if(counter>5) break;
                    Thread.sleep(1000);
                    counter++;
                    throw new Exception("exx");

                } catch (Exception oex) {

                    System.out.println("insode ctahc");

                }
            }

        System.out.println("outside loop");

    }
}
