package com.nichesoftware.controller;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.nichesoftware.gcm.GcmConstants;
import com.nichesoftware.gcm.GcmModel;
import com.nichesoftware.model.Note;
import com.nichesoftware.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by n_che on 14/04/2016.
 */
@Controller
public class RestController {

    /**
     * Service
     */
    private RestService restService;

    @Autowired
    public RestController(RestService restService) {
        this.restService = restService;
    }

    @RequestMapping("note/{id}")
    @ResponseBody
    public Note getNoteById(@PathVariable Long id) {
        return new Note("Note from REST", "Cette note est issues du serveur REST");
    }

    @RequestMapping("notes")
    @ResponseBody
    public List<Note> getNotes() {
        List<Note> retVal = new ArrayList<Note>();
        retVal.add(new Note("Note 1 from REST", "Note n°1 issue du serveur REST"));
        retVal.add(new Note("Note 2 from REST", "Note n°2 issue du serveur REST"));
        retVal.add(new Note("Note 3 from REST", "Note n°3 issue du serveur REST"));
        return retVal;
    }

    @RequestMapping("gcm/register/{registerId}")
    @ResponseBody
    public boolean registerDevice(@PathVariable final String registerId) {
        GcmModel gcmModel = GcmModel.getInstance();
        gcmModel.addRegistrationId(registerId);

        return true;
    }

    @RequestMapping("gcm/send/{message}")
    @ResponseBody
    public boolean sendMessage(@PathVariable final String message) {

        try {
            Sender sender = new Sender(GcmConstants.API_KEY);

            Message gcmMessage = new Message.Builder().timeToLive(30)
                    .delayWhileIdle(true).addData(GcmConstants.MESSAGE, message).build();

            MulticastResult result = sender.send(gcmMessage, GcmModel.getInstance().getRegistrationIds(), 1);

            return result.getSuccess() != 0;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    	/*
    	 * Create the POST request
    	 */
    	/*
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost("http://example.com/");
		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user", "Bob"));
		try {
    		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
    		// writing error to Log
    		e.printStackTrace();
		}*/
    	/*
    	 * Execute the HTTP Request
    	 */
    	/*
		try {
    		HttpResponse response = httpClient.execute(httpPost);
    		HttpEntity respEntity = response.getEntity();

    		if (respEntity != null) {
        	// EntityUtils to get the response content
        	String content =  EntityUtils.toString(respEntity);
    		}
		} catch (ClientProtocolException e) {
    		// writing exception to log
    		e.printStackTrace();
		} catch (IOException e) {
    		// writing exception to log
    		e.printStackTrace();
		}
    	 */
    }
}
