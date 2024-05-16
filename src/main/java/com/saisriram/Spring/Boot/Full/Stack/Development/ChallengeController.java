package com.saisriram.Spring.Boot.Full.Stack.Development;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/challenges")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if(isChallengeAdded)
            return new ResponseEntity("Challenge added successfully!", HttpStatus.OK);
        else
            return new ResponseEntity("Challenge not added successfully!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenges(month);
        if(challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Challenge> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
        boolean isChallengeUpdated = challengeService.updatedChallenge(id, updatedChallenge);
        if(isChallengeUpdated)
            return new ResponseEntity("Challenge updated successfully!", HttpStatus.OK);
        else
            return new ResponseEntity("Challenge not updated successfully!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id) {
        boolean isDeleted = challengeService.deletedChallenge(id);
        if(isDeleted)
            return new ResponseEntity("Challenge deleted Sucessfully!", HttpStatus.OK);
        else
            return new ResponseEntity("Challenge not deleted successfully!", HttpStatus.NOT_FOUND);
    }
}
