package com.company.services_reservas_app.mapper;

import com.company.services_reservas_app.repositories.HotelRepository;
import springfox.documentation.swagger2.mappers.LicenseMapper;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);


}
