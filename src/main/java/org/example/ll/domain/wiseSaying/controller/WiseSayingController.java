package org.example.ll.domain.wiseSaying.controller;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;
import org.example.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final WiseSayingService wiseSayingService;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionModify(Scanner sc, List<WiseSaying> wiseSayings) {
        System.out.print("?id=");
        int id = sc.nextInt();
        sc.nextLine();
        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        if (opWiseSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
        WiseSaying foundWiseSaying = opWiseSaying.get();

        System.out.println("명언(기존) : " + foundWiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가(기존) : " + foundWiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();
        wiseSayingService.modify(foundWiseSaying, content, author);
        System.out.println(id + "번 명언이 수정되었습니다.");
    }

    public void actionDelete(Scanner sc, List<WiseSaying> wiseSayings) {
        System.out.print("?id=");
        int id = sc.nextInt();
        sc.nextLine();
        boolean removed = wiseSayingService.removeByID(id);
        if (removed) System.out.println(id + "번 명언이 삭제되었습니다.");
        else System.out.println(id + "번 명언은 존재하지 않습니다.");

    }



    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------");
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();
        for (WiseSaying wiseSaying : wiseSayings.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " +
                    wiseSaying.getContent());
        }
    }

    public void actionAdd(Scanner sc, List<WiseSaying> wiseSayings) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        WiseSaying wiseSaying = wiseSayingService.addWiseSaying(content, author);
        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void actionExit() {
        System.out.println("시스템이 종료됩니다.");
    }
}
