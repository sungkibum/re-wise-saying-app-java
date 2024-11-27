package org.example.ll;

import org.example.ll.domain.wiseSaying.controller.WiseSayingController;
import org.example.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner sc;
    WiseSayingController wiseSayingController;
    List<WiseSaying> wiseSayings;

    public App() {
        wiseSayings = new ArrayList<>();
        sc = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(sc);
    }

    void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령)");
            String cmd = sc.nextLine();
            if (cmd.equals("종료")) {
                wiseSayingController.actionExit();
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionAdd(sc, wiseSayings);
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList();
            } else if (cmd.equals("삭제")) {
                wiseSayingController.actionDelete(sc, wiseSayings);
            } else if (cmd.equals("수정")) {
                wiseSayingController.actionModify(sc, wiseSayings);
            }
        }

    }

}
