//package com.fd.admin.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.social.connect.ConnectionRepository;
//import org.springframework.social.twitter.api.CursoredList;
//import org.springframework.social.twitter.api.Tweet;
//import org.springframework.social.twitter.api.Twitter;
//import org.springframework.social.twitter.api.TwitterProfile;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.inject.Inject;
//import java.util.List;
//
//@Controller
//@RequestMapping("/")
//public class TwitterWebController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterWebController.class);
//
//    @Autowired
//    private Twitter twitter;
//
//    @Autowired
//    private ConnectionRepository connectionRepository;
//
//    @Inject
//    public TwitterWebController(Twitter twitter, ConnectionRepository connectionRepository) {
//        this.twitter = twitter;
//        this.connectionRepository = connectionRepository;
//    }
//
//    @RequestMapping(value = "/viewTwitterHome", method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloTwitter(Model model) {
//        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
//            return "connect/twitterConnect";
//        }
//
//        model.addAttribute(twitter.userOperations().getUserProfile());
//        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
//        model.addAttribute("friends", friends);
//
//        List<Tweet> tweets = twitter.timelineOperations().getHomeTimeline();
//        TwitterProfile profile = twitter.userOperations().getUserProfile();
//
//        model.addAttribute("tweets", tweets);
//        model.addAttribute("profile", profile);
//
//        return "viewTwitter";
//    }
//
//
//}
