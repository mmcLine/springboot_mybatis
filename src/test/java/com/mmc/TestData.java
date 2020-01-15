package com.mmc;

import com.mmc.bean.Work;
import com.mmc.biz.WorkBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: mmc
 * @create: 2020-01-15 16:47
 **/
@RunWith(SpringRunner.class)
@tk.mybatis.spring.annotation.MapperScan("com.mmc.mapper")
@SpringBootTest
public class TestData {

    @Autowired
    private WorkBiz workBiz;

    @Test
    public void test(){
        Work work=new Work();
        work.setLayout("div布局");
        work.setSortNum(1);
        work.setTheme("个人博客");
        work.setWorkno("lsz2");
        work.setWorkSize(4);
        workBiz.insert(work);
    }
}
