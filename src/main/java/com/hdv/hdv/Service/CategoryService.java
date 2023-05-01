package com.hdv.hdv.Service;

import com.hdv.hdv.Entity.Category;
import com.hdv.hdv.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCate(Category cate)
    {
        this.categoryRepository.save(cate);
    }

    public void deleteCateByName(String name)
    {
        this.categoryRepository.deleteByName(name);
    }

    public void deletCateById(int id)
    {
        this.categoryRepository.deleteById((long) id);
    }
}
