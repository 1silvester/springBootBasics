package com.mySpringBuild.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("0", "name ", "desc"),
            new Topic("1", "name2", "decs2"),
            new Topic("2", "name3", "desc3")
    ));

    public List<Topic> getAllTopics(){
//        return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

//    public List<Topic> getAllTopics(){
//        List<Topic> topics = new ArrayList<>();
//        topicRepository.findAll().forEach(topics::add);
//        return topics;
//    }

    public Topic getTopic(String id)
    {

//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

//    public void addTopic(Topic topic) {
//
//        topicRepository.save(topic);
//    }

    public void updateTopic(String id, Topic topic) {
//        for(int i=0; i < topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }

    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}