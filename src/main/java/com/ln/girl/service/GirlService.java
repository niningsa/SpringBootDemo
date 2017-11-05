package com.ln.girl.service;

import com.ln.girl.entity.Girl;
import com.ln.girl.entity.Result;
import com.ln.girl.enums.ResultEnums;
import com.ln.girl.exception.GirlException;
import com.ln.girl.util.ResultUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GrilRepository grilRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(12);
        grilRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BB");
        girlB.setAge(13);
        grilRepository.save(girlB);
    }

    /**
     * 添加girl
     * @param cupSize
     * @param age
     * @return
     * @throws Exception
     */
    public Result<Girl> addGirl(String cupSize, Integer age) throws Exception {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        try {
            girl = grilRepository.save(girl);
        } catch(Exception e) {
            throw new GirlException(ResultEnums.ADD_ERROR);
        }
        return ResultUitl.success(girl);
    }

    /**
     * 编辑
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    public Result<Girl> girlUpdate(Integer id, String cupSize, Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        try {
            girl = grilRepository.save(girl);
        } catch(Exception e) {
            throw new GirlException(ResultEnums.ADD_ERROR);
        }
        return ResultUitl.success(girl);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = grilRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 12) {
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);
        } else if(age >= 12 && age <= 16) {
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id) {
        return grilRepository.findOne(id);
    }
}
