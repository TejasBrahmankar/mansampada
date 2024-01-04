package com.tableslearnedmapping.entitymapping.service;

import org.springframework.data.jpa.domain.Specification;

import com.tableslearnedmapping.entitymapping.entities.UserInfo;

public class UserInfoSpecifications {

    public static Specification<UserInfo> hasGotra(String gotra) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("gotra"), gotra);
    }

    public static Specification<UserInfo> hasYear(String year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("year"), String.valueOf(year));
    }

    public static Specification<UserInfo> hasOccupation(String occupation) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("occupation"), occupation);
    }

    // Add more specifications for other search criteria if needed
}
