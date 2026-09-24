package network.exception;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {

    public static void main(String[] args) throws IOException {
        /**
         * 없는 ip나 도메인에 접속 시도
         */
        unknownHostEx1(); // java.net.UnknownHostException: 999.999.999.999
        unknownHostEx2(); // java.net.UnknownHostException: google.gogo

        /**
         * 1. ip를 통한 서버 컴퓨터 접속 성공
         *
         * 그러나
         *  - 45678 포트 사용 x >> TCP 연결 거절
         *  - 방화벽의 무단 열결 차단
         *  - OS가 TCP RST(Reset) 패킷을 통한 거절
         *  - 클라이언트는 RST 패킷 >> ConnectException 발생
         */
        connectionRefused(); // java.net.ConnectException: Connection refused: connect



    }

    private static void unknownHostEx1() throws IOException {
        try {
            Socket socket = new Socket("999.999.999.999", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void unknownHostEx2() throws IOException {
        try {
            Socket socket = new Socket("google.gogo", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    private static void connectionRefused() throws IOException {
        try {
            Socket socket = new Socket("localhost", 45678);
        } catch (ConnectException e) {
            e.printStackTrace();
        }
    }
}
