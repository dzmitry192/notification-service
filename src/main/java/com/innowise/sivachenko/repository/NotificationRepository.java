package com.innowise.sivachenko.repository;

import com.innowise.sivachenko.model.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long>, JpaSpecificationExecutor<NotificationEntity> {

}
