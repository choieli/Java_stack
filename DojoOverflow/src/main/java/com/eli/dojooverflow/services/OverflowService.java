package com.eli.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eli.dojooverflow.models.Answer;
import com.eli.dojooverflow.models.Question;
import com.eli.dojooverflow.models.Tag;
import com.eli.dojooverflow.models.TagQuestion;
import com.eli.dojooverflow.repositories.AnswerRepo;
import com.eli.dojooverflow.repositories.QuestionRepo;
import com.eli.dojooverflow.repositories.TagQuestionRepo;
import com.eli.dojooverflow.repositories.TagRepo;

@Service
public class OverflowService {
	private final AnswerRepo answerRepo;
	private final QuestionRepo questionRepo;
	private final TagRepo tagRepo;
	private final TagQuestionRepo tagQuestionRepo;
	
	public OverflowService(AnswerRepo answerRepo, QuestionRepo questionRepo, TagRepo tagRepo, TagQuestionRepo tagQuestionRepo) {
		this.answerRepo = answerRepo;
		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
		this.tagQuestionRepo = tagQuestionRepo;
	}
	
	
	public Question saveQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	public Tag saveTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Answer saveAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
	
	public TagQuestion saveTagQuestion(TagQuestion tagQuestion) {
		return tagQuestionRepo.save(tagQuestion);
	}
	
	public Tag findSpecificTagbyName(String name) {
		return tagRepo.findBySubjectIgnoreCase(name);
	}
	
	public List<Question> allQuestions() {
		return questionRepo.findAll();
		
	}
	
	public Question findQuestionById(Long id) {
		Optional<Question> check = questionRepo.findById(id);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}
	
	public void tagCheckAndSave(List<String> tags, Question question) {
		Question saveQuestion = saveQuestion(question);
		for(String check : tags) {
			if(findSpecificTagbyName(check) != null) {
				TagQuestion combine = new TagQuestion();
				combine.setTag(findSpecificTagbyName(check));
				combine.setQuestion(saveQuestion);
				saveTagQuestion(combine);
			}
			else {
				Tag newTag = new Tag();
				newTag.setSubject(check);
				Tag cTag = saveTag(newTag);
				TagQuestion combine = new TagQuestion();
				combine.setTag(cTag);
				combine.setQuestion(saveQuestion);
				saveTagQuestion(combine);
			}
		}
	}
}
