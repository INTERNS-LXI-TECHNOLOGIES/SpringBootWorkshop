package com.lxisoft.repository;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.*;

@Repository
public class MockRepository 
{
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addMockQuestion(MockModel mockMmodel)
	{
		this.sessionFactory.getCurrentSession().saveOrUpdate(mockMmodel);
	}
		
   @SuppressWarnings("unchecked")
   public List<MockModel> getAllQuestions() 
   	{
	   
        return sessionFactory.getCurrentSession().createQuery("from MockModel")
                .list();
    }

    public void deleteQuest(Integer questionId) 
    {
		
		MockModel mockModel = (MockModel) sessionFactory.getCurrentSession().load(
                MockModel.class, questionId);
        if (null != mockModel) 
        {
            this.sessionFactory.getCurrentSession().delete(mockModel);
     	}
	}
	

	public MockModel editQuestion(MockModel mockMmodel)
	{
		this.sessionFactory.getCurrentSession().update(mockMmodel);
		return mockMmodel;
	}
	public MockModel getQuestionId(int mockid) 
	{
		return (MockModel) sessionFactory.getCurrentSession().get(
                MockModel.class, mockid);
	}
}