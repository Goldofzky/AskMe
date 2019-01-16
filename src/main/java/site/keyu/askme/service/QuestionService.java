package site.keyu.askme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.keyu.askme.dao.QuestionDao;
import site.keyu.askme.pojo.Question;

import java.util.List;

/**
 * @Author:Keyu
 */
@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    /**
     * 发布问题
     * @param question
     * @return
     */
    public int postQuestion(Question question){

        return  questionDao.insertQuestion(question) > 0 ? question.getId() : 0;
    }

    /**
     * 根据id查找问题
     * @param id
     * @return
     */
    public Question findQuestionById(int id){

        return  questionDao.getById(id);
    }

    /**
     * 查找一些问题
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    public List<Question> findLatestQuestion(int userId,int offset,int limit){

        return questionDao.selectLatestQuestions(userId,offset,limit);
    }

}