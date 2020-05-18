package com.ln.girl.controller;

import com.ln.girl.entity.Girl;
import com.ln.girl.entity.Result;
import com.ln.girl.service.GirlService;
import com.ln.girl.service.GrilRepository;
import com.ln.girl.util.ResultUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GirlController {

    @Autowired
    private GrilRepository grilRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return girl实例
     */
    @GetMapping("/girls")
    public Result<Girl> getGirlList() {
        return ResultUitl.success(grilRepository.findAll());
    }

    /**
     * 添加女生信息
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping("/addGirl")
    public Result<Girl> addGirl(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) throws Exception {
        return girlService.addGirl(cupSize, age);
    }

    /**
     * 通过ID 查询信息
     * @param id
     * @return
     */
    @GetMapping("/getGirlById/{id}")
    public Result<Girl> findGirlById(@PathVariable("id") Integer id) {
        return ResultUitl.success(grilRepository.findOne(id));
    }

    /**
     * 编辑
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/girlUpdate/{id}")
    public Result<Girl> girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        return ResultUitl.success(girlService.girlUpdate(id, cupSize, age));
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/girlDelete/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        grilRepository.delete(id);
    }

    @GetMapping("/testTransaction")
    public void addTwo() {
        girlService.insertTwo();
    }

    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
