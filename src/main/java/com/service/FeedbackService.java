package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.appexception.FeedbackNotFoundException;
import com.dao.AdminFeedbackDAO;
import com.dao.FeedbackDAO;
import com.model.AdminFeedback;
import com.model.Feedback;

@Service
public class FeedbackService {

	@Autowired
    FeedbackDAO feed;
    
    @Autowired
    AdminFeedbackDAO adminfeeddao;



   
    
    public void saveFeedback(Feedback f) {
        
        feed.save(f);
        
    }
    
    public List<Feedback> getFeedback() {
        return feed.findAll();
    }
    
    public ResponseEntity<String> adminfeedback(int feedbackid, AdminFeedback adminfeed) throws FeedbackNotFoundException {
        
        try {
        //Feedback f = feed.getById(feedbackid);
        Optional<Feedback> f1  = feed.findById(feedbackid);
        Feedback f = f1.get();



   
        if(feedbackid == f.getFeedbackId()) {
            
            adminfeeddao.save(adminfeed);
            return new ResponseEntity<String>("feedbacks by admin given", HttpStatus.OK);
            
        }
        
        else {
            //return new ResponseEntity("feedback by user not found", HttpStatus.OK);
            throw new FeedbackNotFoundException();
        }
        }catch(FeedbackNotFoundException e) {
            throw new FeedbackNotFoundException();
        }
        catch(Exception e) {
            throw new FeedbackNotFoundException();        }
        



       
        
        
    }
    
//    public void deleteFeedback(int feedid) {
//        feed.delete(feed.getById(feedid));
//    }
}
