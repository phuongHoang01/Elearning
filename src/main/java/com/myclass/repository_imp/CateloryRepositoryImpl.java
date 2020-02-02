package com.myclass.repository_imp;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Categories;
import com.myclass.repository.CateloryRepository;
import com.myclass.repository.GenericsRepository;

@Repository
public class CateloryRepositoryImpl extends GenericsRepositoryImp<Categories, Integer> implements CateloryRepository{

}
