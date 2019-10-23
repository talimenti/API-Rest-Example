package com.comviva.domain.repositories;

import com.comviva.domain.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubscriberRepository extends JpaRepository<Subscriber, Integer> {}