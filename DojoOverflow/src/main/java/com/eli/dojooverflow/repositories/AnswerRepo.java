package com.eli.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eli.dojooverflow.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository <Answer, Long>{

}
