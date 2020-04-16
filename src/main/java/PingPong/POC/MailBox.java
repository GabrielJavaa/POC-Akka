package PingPong.POC;

import java.io.Serializable;

public class MailBox {


    public static class mensagemPing1 implements Serializable {



        private String ping;

        public mensagemPing1(String ping) {
            this.ping = ping;
        }
        public String getPing(){
            return ping;
        }
        public mensagemPing1(){

        }

    }public static class mensagemPing2 implements Serializable {



        private String ping;

        public mensagemPing2(String ping) {
            this.ping = ping;
        }
        public String getPing(){
            return ping;
        }
        public mensagemPing2(){

        }

    }
    public static class mensagemPing3 implements Serializable {



        private String ping;

        public mensagemPing3(String ping) {
            this.ping = ping;
        }
        public String getPing(){
            return ping;
        }
        public mensagemPing3(){

        }

    }

    public static class mensagemPong1 implements Serializable {

        private  String pong;

        public mensagemPong1(String pong) {
            this.pong = pong;
        }
        public String getPong(){
            return pong;
        }
        public mensagemPong1(){

        }

    }public static class mensagemPong2 implements Serializable {

        private  String pong;

        public mensagemPong2(String pong) {
            this.pong = pong;
        }
        public String getPong(){
            return pong;
        }
        public mensagemPong2(){

        }

    }public static class mensagemPong3 implements Serializable {

        private  String pong;

        public mensagemPong3(String pong) {
            this.pong = pong;
        }
        public String getPong(){
            return pong;
        }
        public mensagemPong3(){

        }

    }

}
