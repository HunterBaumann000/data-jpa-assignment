package edu.wctc.datajpaassignment.service;

import edu.wctc.datajpaassignment.entity.Mug;

import java.util.List;

public interface MugService {
    Mug getMug(int id);

    void updateMug(Mug mug);

    List<Mug> getMugList();

    void decrementStock(Mug mug);
}
