package com.slack.integration.service;

import java.io.IOException;
import java.util.Collections;

import org.springframework.stereotype.Service;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.model.Attachment;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SlackService {

	private static final String NEW_LINE = "\n";

	private String webhook = "https://hooks.slack.com/services/CHANGE_ME";

	public void sendMessageToSlack(String message) {

		StringBuilder messageBuider = new StringBuilder();
		messageBuider.append(message + NEW_LINE);
		process(messageBuider.toString());
	}

	private void process(String message) {

		Payload payload = Payload.builder().attachments(Collections.singletonList(Attachment.builder().channelName("#user-created").build()))
				.text(message).build();
		try {
			WebhookResponse webhookResponse = Slack.getInstance().send(webhook, payload);
			if (webhookResponse.getCode() == 200)
				log.info("Success send slack !");
			
			log.info(webhookResponse.getMessage());
		} catch (IOException e) {
			log.error("Unexpected Error! WebHook:" + webhook);

		}
	}

}
