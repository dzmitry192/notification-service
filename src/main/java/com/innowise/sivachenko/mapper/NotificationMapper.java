package com.innowise.sivachenko.mapper;

import com.innowise.sivachenko.model.dto.response.NotificationDto;
import com.innowise.sivachenko.model.entity.NotificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    NotificationDto notificationEntityToNotificationDto(NotificationEntity notification);
}
