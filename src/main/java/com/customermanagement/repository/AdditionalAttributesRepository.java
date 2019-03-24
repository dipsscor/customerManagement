package com.customermanagement.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customermanagement.model.AdditionalAttributes;

public interface AdditionalAttributesRepository extends JpaRepository<AdditionalAttributes, Serializable>{

}
