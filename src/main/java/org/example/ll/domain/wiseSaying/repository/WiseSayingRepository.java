package org.example.ll.domain.wiseSaying.repository;

import org.example.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {

    boolean removeById(int id);

    List<WiseSaying> findAll();

    void add(WiseSaying wiseSaying);

    Optional<WiseSaying> findByID(int id);
}
