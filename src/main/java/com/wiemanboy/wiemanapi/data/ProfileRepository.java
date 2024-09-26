package com.wiemanboy.wiemanapi.data;

import com.wiemanboy.wiemanapi.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, UUID> {

    /**
     * <div>Find a profile by full name (no space) or username ignoring case</div>
     * examples:
     * <ul>
     *  <li>John, Doe, DoeJohn -> search: johndoe -> matches</li>
     *  <li>John, Doe, DoeJohn -> search: doejohn -> matches</li>
     *  <li>John, Doe, DoeJohn -> search: john doe -> no match</li>
     * </ul>
     */
    @Query("{$or: [{ $expr: { $eq: [ {$toLower: { $concat: [$firstName, $lastName] }}, {$toLower: ?0} ] } }, {$expr: { $eq:  [{$toLower: $username}, { $toLower:  ?0 }]}} ]}")
    Optional<Profile> findByFullNameOrUsername(String searchString);

    @Query("{$or: [{ $expr: { $eq: [ {$toLower: { $concat: [$firstName, $lastName] }}, {$toLower: ?0} ] } }, {$expr: { $eq:  [{$toLower: $username}, { $toLower:  ?0 }]}} ]}")
    boolean existsByFullNameOrUsername(String username);
}
