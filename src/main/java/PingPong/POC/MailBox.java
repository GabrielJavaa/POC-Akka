package PingPong.POC;

import java.io.Serializable;

public class MailBox {


    public static class mailBox1 implements Serializable {

        private final String ping;

        public mailBox1(String ping) {
            this.ping = ping;
        }


        public String getPing(){
            return ping;
        }
    }

    public static class mailBox2 implements Serializable {

        private final String pong;

        public mailBox2(String pong) {
            this.pong = pong;
        }

        public String getPong(){
            return pong;
        }

    }

}
