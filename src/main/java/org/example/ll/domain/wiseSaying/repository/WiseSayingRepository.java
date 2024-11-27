package org.example.ll.domain.wiseSaying.repository;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }


    public boolean removeById(int id) {
        return wiseSayings.removeIf(e ->e.getId() == id);
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public void add(WiseSaying wiseSaying) {
        ++lastId;
        wiseSaying.setId(lastId);
        wiseSayings.add(wiseSaying);
    }

    public Optional<WiseSaying> findByID(int id) {
        return wiseSayings.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
}
