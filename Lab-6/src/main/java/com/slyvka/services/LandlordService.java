package com.slyvka.services;

import com.slyvka.DTO.LandlordDTO;
import com.slyvka.mappers.LandlordMapper;
import com.slyvka.model.LandlordEntity;
import com.slyvka.repositories.LandlordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LandlordService {

    private final LandlordRepository landlordRepository;

    public List<LandlordEntity> findAll() {return landlordRepository.findAll();}

    public LandlordEntity findById(Integer id) {
        return landlordRepository.findById(id).orElse(null);
    }

    public LandlordEntity create(LandlordDTO landlordDTO) {
        return landlordRepository.save(LandlordMapper.mapDTOtoLandlord(landlordDTO));
    }

    public LandlordEntity update(LandlordDTO landlordDTO) {
        if (findById(landlordDTO.getId()) != null) {
            return landlordRepository.save(LandlordMapper.mapDTOtoLandlord(landlordDTO));
        }
        return null;
    }

    public LandlordEntity deleteById(Integer id) {
        LandlordEntity entity = findById(id);
        if (entity != null) {
            landlordRepository.deleteById(id);
            return entity;
        }
        return null;
    }
}
