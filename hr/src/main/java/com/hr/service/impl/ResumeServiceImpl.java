package com.hr.service.impl;

import com.hr.dao.RecruitDao;
import com.hr.dao.ResumeDao;
import com.hr.model.Account;
import com.hr.model.Resume;
import com.hr.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeDao resumeDao;

    @Override
    public boolean addRS(Resume resume) {
        if (resume!=null){
            return resumeDao.addResume(resume);
        }
        return false;
    }

    @Override
    public boolean updateRS(Resume resume) {
        if (resume.getId()!=null){
            return resumeDao.updateResume(resume);
        }
        return false;
    }

    @Override
    public boolean delRS(Resume resume) {
        if (resume.getId()!=null){
            return resumeDao.delResume(resume);
        }
        return false;
    }

    @Override
    public Resume getRS(Resume resume) {
        if (resume.getAccount().getId()!=null){
            return resumeDao.getRS(resume);
        }
        return null;
    }
}
