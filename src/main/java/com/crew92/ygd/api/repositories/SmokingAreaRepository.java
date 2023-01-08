package com.crew92.ygd.api.repositories;

import com.yugabyte.data.jdbc.repository.YsqlRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmokingAreaRepository extends YsqlRepository<SmokingArea, Long> {
}
