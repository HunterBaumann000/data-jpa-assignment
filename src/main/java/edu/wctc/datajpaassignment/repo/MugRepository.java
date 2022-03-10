package edu.wctc.datajpaassignment.repo;

import edu.wctc.datajpaassignment.entity.Mug;
import org.springframework.data.repository.CrudRepository;

public interface MugRepository extends CrudRepository<Mug, Integer> {
}
