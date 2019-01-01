package com.hr.service;

import com.hr.model.Account;
import com.hr.model.Resume;

public interface ResumeService {
    boolean addRS(Resume resume);
    boolean updateRS(Resume resume);
    boolean delRS(Resume resume);
    Resume getRS(Resume resume);
}
