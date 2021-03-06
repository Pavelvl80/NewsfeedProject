package com.demidonko.newsfeed.repo;

import com.demidonko.newsfeed.model.Category;
import com.demidonko.newsfeed.model.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NewsCrudRepo extends CrudRepository<News, Long> {
    News findByName(String name);

    List<News> findByCategory(Category category);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM News c WHERE c.name = :name")
    boolean isExistsByName(@Param("name") String name);



}
