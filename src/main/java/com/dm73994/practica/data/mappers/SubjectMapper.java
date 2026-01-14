package com.dm73994.practica.data.mappers;

import com.dm73994.practica.data.dtos.req.SubjectReqDTO;
import com.dm73994.practica.data.dtos.res.SubjectResDTO;
import com.dm73994.practica.data.entities.SubjectEntity;

public class SubjectMapper {
    public static SubjectEntity toEntity(SubjectReqDTO request){
        return SubjectEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .code(request.getCode())
                .credits(request.getCredits())
                .build();
    }

    public static SubjectResDTO toResponse(SubjectEntity entity){
        return (SubjectResDTO) SubjectResDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .credits(entity.getCredits())
                .build();
    }
}
