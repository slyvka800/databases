package com.slyvka.controllers;

import com.slyvka.DTO.LandlordDTO;
import com.slyvka.mappers.LandlordMapper;
import com.slyvka.model.LandlordEntity;
import com.slyvka.services.LandlordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/landlord")
public class LandlordController {

    private final LandlordService landlordService;

    @GetMapping
    public List<LandlordDTO> findAll() {
        return landlordService.findAll().stream()
                .map(LandlordMapper::mapLandlordToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LandlordDTO> findById(final @PathVariable("id") Integer id) {
        LandlordEntity entity = landlordService.findById(id);
        if (entity == null) {
            return new ResponseEntity<LandlordDTO>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<LandlordDTO>(LandlordMapper.mapLandlordToDTO(entity) ,HttpStatus.OK);
    }

    @PostMapping
    public LandlordDTO create(final @RequestBody LandlordDTO dto) {
        return LandlordMapper.mapLandlordToDTO(landlordService.create(dto));
    }

    @PutMapping
    public ResponseEntity<LandlordDTO> update(final @RequestBody LandlordDTO dto) {
        LandlordEntity entity = landlordService.findById(dto.getId());
        if (entity == null) {
            return new ResponseEntity<LandlordDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LandlordDTO>(LandlordMapper
                .mapLandlordToDTO(landlordService.update(dto)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LandlordDTO> delete(final @PathVariable("id") Integer id) {
        LandlordEntity entity = landlordService.findById(id);
        if (entity == null) {
            return new ResponseEntity<LandlordDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LandlordDTO>(LandlordMapper
                .mapLandlordToDTO(landlordService.deleteById(id)), HttpStatus.OK);
    }
}
