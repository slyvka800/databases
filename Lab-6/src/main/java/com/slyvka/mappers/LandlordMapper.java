package com.slyvka.mappers;

import com.slyvka.DTO.LandlordDTO;
import com.slyvka.model.LandlordEntity;

public class LandlordMapper {
    public static LandlordDTO mapLandlordToDTO(LandlordEntity landlord) {
        return new LandlordDTO(
                landlord.getId(),
                landlord.getName(),
                landlord.getSurname(),
                landlord.getMoneyBalance()
        );
    }

    public static LandlordEntity mapDTOtoLandlord(LandlordDTO dto) {
        return new LandlordEntity(
                dto.getId(),
                dto.getName(),
                dto.getSurname(),
                dto.getMoneyBalance()
        );
    }
}
