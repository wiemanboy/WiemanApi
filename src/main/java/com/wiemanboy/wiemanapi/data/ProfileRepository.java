package com.wiemanboy.wiemanapi.data;

import com.wiemanboy.wiemanapi.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, UUID> {
}
