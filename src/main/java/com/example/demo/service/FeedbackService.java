package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Feedback;
import com.example.demo.repository.FeedbackRespository;

@Service
@Transactional
public class FeedbackService {

@Autowired
FeedbackRespository feedback;

//--------------------------allfeedback--------------------------
public List<Feedback> getfeedback()
{
	return feedback.findAll();
}


//--------------------------Registerfeedback--------------------------

public boolean registerfeedback( Feedback f)
{
	Feedback f1=feedback.save(f);
	if(f1!=null)
	{
		//return "Saved : feedbackid" + f.getFeedbackid();
		return true;
	}
	else
	{
		//return "Failed : feedbackid" + f.getFeedbackid();
		return false;
	}
}

//--------------------------UpdateFeedback--------------------------
public String updatefeedback( Feedback f)
{
	Feedback f1=feedback.save(f);
	if(f1!=null)
	{
		return "Saved : feedbackid" + f.getFeedbackid();
	}
	else
	{
		return "Failed : feedbackid" + f.getFeedbackid();

	}
}
//--------------------------------getfeedbackbyid----------------------

public Feedback getfeedbackbyid(int id)
{
	Optional<Feedback> feedbacko=feedback.findById(id);
	Feedback feedbackl=null;
	try {
		feedbackl=feedbacko.get();
	}
	catch(NoSuchElementException e)
	{
		return null;
	}
	return feedbackl;
	
}
}
