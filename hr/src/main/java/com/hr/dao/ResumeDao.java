package com.hr.dao;

import com.hr.model.Resume;

public interface ResumeDao {
    boolean addResume(Resume resume);
    boolean delResume(Resume resume);
    boolean updateResume(Resume resume);
    Resume getRS(Resume resume);
}
