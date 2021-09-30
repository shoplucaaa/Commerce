package com.bach.Commerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bach.Commerce.dao.TagDAO;
import com.bach.Commerce.entity.Tag;
import com.bach.Commerce.model.TagDTO;
import com.bach.Commerce.service.TagService;

@Transactional
@Service
public class TagServiceImpl implements TagService {
	
	@Autowired
	TagDAO tagDao;

	@Override
	public List<TagDTO> getAllTag() {
		List<Tag> listTag = tagDao.getAllTag();
		
		List<TagDTO> listTagDTO = new ArrayList<>();
		
		for(Tag t : listTag) {
			
			TagDTO tagDTO = new TagDTO();
			
			tagDTO.setId(t.getId());
			tagDTO.setType(t.getType());
			
			listTagDTO.add(tagDTO);
		}
		
		return listTagDTO;
	}

}
