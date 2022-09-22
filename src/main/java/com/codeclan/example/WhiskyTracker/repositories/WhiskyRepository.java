package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(int year);

    List<Whisky> findByDistilleryNameAndAge(String distillery, int age);

    List<Whisky> findWhiskyByDistilleryRegion(String region);

}
