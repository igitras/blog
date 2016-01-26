package com.igitras.resources.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mason on 1/25/16.
 */
@RestController
public class ResourceController {

    private String message = "Hello World!";
    private List<Record> changes = new ArrayList<Record>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID()
                .toString());
        model.put("content", message);
        return model;
    }

    @RequestMapping(value = "/changes", method = RequestMethod.GET)
    public List<Record> changes() {
        return changes;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Map<String, String> map, Principal principal) {
        if (map.containsKey("content")) {
            message = map.get("content");

            Record record = new Record();
            record.setContent(map.get("content"));
            record.setUser(principal.getName());
            record.setTimestamp(new Date());
            changes.add(record);

            if (changes.size() > 10) {
                changes = changes.subList(0, 9);
            }
        }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID()
                .toString());
        model.put("content", message);
        return model;
    }

    class Record {
        private Date timestamp;
        private String user;
        private String content;

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
