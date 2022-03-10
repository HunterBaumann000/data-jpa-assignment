package edu.wctc.datajpaassignment.service;

import edu.wctc.datajpaassignment.entity.Mug;
import edu.wctc.datajpaassignment.repo.MugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicMugService implements MugService{
    private MugRepository mugRepository;

    @Autowired
    public BasicMugService(MugRepository mr) {
        this.mugRepository = mr;
    }

    @Override
    public Mug getMug(int mugId) {
        Mug mug;
        Optional<Mug> m = mugRepository.findById(mugId);
        if (m.isPresent()) {
            return m.get();
        }
        else  {
            mug = new Mug();
            mug.setId(mugId);
        }
        return mug;
    }

    @Override
    public void updateMug(Mug mug) {
        mugRepository.save(mug);
    }

    @Override
    public List<Mug> getMugList() {
        List<Mug> list = new ArrayList<>();
        mugRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void decrementStock(Mug mug) {
        mug.setStock(mug.getStock() - 1);
    }
}
