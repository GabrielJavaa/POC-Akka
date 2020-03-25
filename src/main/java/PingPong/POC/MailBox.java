package PingPong.POC;

public class MailBox {


    public static class mensagem1{

        private final String txt;

        public mensagem1(String txt){
            this.txt = txt;
        }
        public String tomadora(){
            return txt;
        }
    }
    public static class  mensagem2{
        private final String txt;


        public mensagem2(String txt) {
            this.txt = txt;
        }
        public String tomadora(){
            return txt;
        }
    }
}
