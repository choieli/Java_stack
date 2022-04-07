package com.eli.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.dojooverflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository <Tag, Long> {
	Tag findBySubjectIgnoreCase(String subject);
}