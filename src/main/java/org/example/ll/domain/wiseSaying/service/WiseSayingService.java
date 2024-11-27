package org.example.ll.domain.wiseSaying.service;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;
import org.example.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;
    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public boolean removeByID(int id) {
        return wiseSayingRepository.removeById(id);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying addWiseSaying(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSayingRepository.add(wiseSaying);
        return wiseSaying;
    }

    public void modify(WiseSaying foundWiseSaying, String content, String author) {
        foundWiseSaying.setContent(content);
        foundWiseSaying.setAuthor(author);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findByID(id);
    }
}
