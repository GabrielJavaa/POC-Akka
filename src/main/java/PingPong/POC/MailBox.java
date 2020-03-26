package PingPong.POC;

public class MailBox {


    public static class mailBox1 {

        private final String txt;

        public mailBox1(String txt){
            this.txt = txt;
        }
        public String tomadora(){
            return txt;
        }
    }

}
